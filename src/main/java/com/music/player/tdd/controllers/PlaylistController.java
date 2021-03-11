package com.music.player.tdd.controllers;

import com.music.player.tdd.models.Playlist;
import com.music.player.tdd.services.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    private PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService){

        this.playlistService = playlistService;
    }

    @PostMapping("/playlist")
    public ResponseEntity<Playlist> postPlaylist(@RequestBody Playlist playlist){
        Playlist savedPlaylist = playlistService.savePlaylist(playlist);

        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(savedPlaylist,status);

    }
}
