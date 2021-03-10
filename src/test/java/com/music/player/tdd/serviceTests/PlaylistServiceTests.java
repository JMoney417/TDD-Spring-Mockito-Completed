package com.music.player.tdd.serviceTests;

import com.music.player.tdd.TestUtils.TestPlaylists;
import com.music.player.tdd.models.Playlist;
import com.music.player.tdd.repositories.PlaylistRepository;
import com.music.player.tdd.services.PlaylistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class PlaylistServiceTests {

    @Mock
    PlaylistRepository playlistRepository;

    @InjectMocks
    PlaylistService playlistService;

    @Test
    public void savePlaylist_calls_Repo_Save(){
        Playlist myPLaylist = TestPlaylists.getTestPlaylist();
        playlistService.savePlaylist(myPLaylist);
        verify(playlistRepository,times(1)).save(myPLaylist);
    }
}
