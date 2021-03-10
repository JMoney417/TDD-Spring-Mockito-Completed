package com.music.player.tdd.services;

import com.music.player.tdd.models.Playlist;
import com.music.player.tdd.repositories.PlaylistRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    public Playlist savePlaylist(Playlist testPlaylist) {
        return playlistRepository.save(testPlaylist);
    }
}
