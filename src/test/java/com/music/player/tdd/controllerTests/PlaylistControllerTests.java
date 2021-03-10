package com.music.player.tdd.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.music.player.tdd.TestUtils.TestPlaylists;
import com.music.player.tdd.controllers.PlaylistController;
import com.music.player.tdd.services.PlaylistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@WebMvcTest(PlaylistController.class)
public class PlaylistControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper  objectMapper;

    @MockBean
    private PlaylistService playlistService;

    @Test
    public void postPlaylist_calls_service() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/playlist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(TestPlaylists.getTestPlaylist()))
        );
        verify(playlistService,times(1)).savePlaylist(TestPlaylists.getTestPlaylist());
    }

}
