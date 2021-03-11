package com.music.player.tdd.integrationTests;

import com.music.player.tdd.TestUtils.TestPlaylists;
import com.music.player.tdd.TestUtils.TestSongs;
import com.music.player.tdd.models.Playlist;
import com.music.player.tdd.models.Song;
import com.music.player.tdd.repositories.SongRepository;
import com.music.player.tdd.services.SongService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PlaylistIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private Playlist playlist;

    @Before
    public void postSongsAndCreatePlaylist(){
      ResponseEntity<Song> response = restTemplate.postForEntity("/song",TestSongs.getSongs().get(0),Song.class);
      Song song = response.getBody();
      playlist = new Playlist();
      playlist.setName("My Top 20");
      playlist.addSong(song);

    }

    @Test
    public void postingAPlaylist_savesThePlaylist(){
        ResponseEntity<Playlist> response = restTemplate.postForEntity("/playlist",
                playlist, Playlist.class);

        Playlist playlist = response.getBody();
        assertAll("Playlist posted successfully",
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertNotNull(playlist.getId()),
                ()->assertEquals(TestPlaylists.getTestPlaylist().getName(),playlist.getName()),
                ()->assertEquals(TestPlaylists.getTestPlaylist().getSonglist().size(),playlist.getSonglist().size())
        );
    }
}
