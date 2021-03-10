package com.music.player.tdd.integrationTests;

import com.music.player.tdd.TestUtils.TestSongs;
import com.music.player.tdd.models.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SongIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void posting_a_song_saves_the_song(){
        ResponseEntity<Song> response = restTemplate.postForEntity("/songs/song", TestSongs.getSongs().get(0),
                Song.class);

        Song postedSong  = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertAll("song posted",
                ()->assertNotNull(postedSong.getId()),
                ()->assertEquals(postedSong.getTitle(),TestSongs.getSongs().get(0).getTitle()),
                ()->assertEquals(postedSong.getArtist(),TestSongs.getSongs().get(0).getArtist()));

    }

    @Test
    public void getAllSongs_returnsAllSongs(){
        ResponseEntity<Song[]> response = restTemplate.getForEntity("/songs",Song[].class);
        Song[] songs = response.getBody();

    }

    @Test
    public void getAllSongsByTitle_endpoint_returns_songs_with_that_title(){
        //arrange
        TestSongs.getSongs().forEach(song->restTemplate.postForEntity("/songs/song",song,Song.class));

        //act
        ResponseEntity<List<Song>> response = restTemplate.exchange(
                "/songs/byTitle/Africa",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Song>>() {
                }
        );

        List<Song> songs = response.getBody();
        //assert
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(2,songs.size());
        songs.forEach(song-> assertEquals(song.getTitle(),"Africa"));
    }

}
