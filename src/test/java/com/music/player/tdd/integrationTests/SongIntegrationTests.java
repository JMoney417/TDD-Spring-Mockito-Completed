package com.music.player.tdd.integrationTests;

import com.music.player.tdd.TestUtils.TestSongs;
import com.music.player.tdd.models.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

}
