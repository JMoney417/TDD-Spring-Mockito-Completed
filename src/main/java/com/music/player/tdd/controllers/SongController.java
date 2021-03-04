package com.music.player.tdd.controllers;

import com.music.player.tdd.models.Song;
import com.music.player.tdd.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongController {

    private SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    @PostMapping("/song")
    private ResponseEntity<Song> postSong(@RequestBody Song song){
        Song savedSong = this.songService.saveSong(song);
        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(savedSong,status);
    }
}
