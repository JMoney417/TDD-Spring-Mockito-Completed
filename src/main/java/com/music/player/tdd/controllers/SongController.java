package com.music.player.tdd.controllers;

import com.music.player.tdd.models.Song;
import com.music.player.tdd.repositories.SongRepository;
import com.music.player.tdd.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private SongService songService;


    public SongController(SongService songService){
        this.songService = songService;
    }

    @PostMapping("/song")
    public ResponseEntity<Song> postSong(@RequestBody Song song){
        Song savedSong = this.songService.saveSong(song);
        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(savedSong,status);
    }

    @GetMapping("/byTitle/{title}")
    public List<Song> getSongsByTitle(@PathVariable String title){
        return this.songService.findSongsByTitle(title);
    }
}
