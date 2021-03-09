package com.music.player.tdd.controllerTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.music.player.tdd.TestUtils.TestSongs;
import com.music.player.tdd.controllers.SongController;
import com.music.player.tdd.models.Song;
import com.music.player.tdd.services.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(SongController.class)
public class SongControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private SongService songService;

    @Test
    public void postSong_endpoint_Posts_the_song() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/songs/song")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(TestSongs.getSongs().get(1)))
        );

        verify(songService, times(1)).saveSong(any(Song.class));

    }

    @Test
    public void getSongsByTitle_returns_songs_with_that_title() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/songs/byTitle/Tadow"));
        verify(songService, times(1)).findSongsByTitle("Tadow");
    }


}
