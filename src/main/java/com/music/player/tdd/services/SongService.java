package com.music.player.tdd.services;

import com.music.player.tdd.models.Song;
import com.music.player.tdd.repositories.SongRepository;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    SongRepository songRepository;

    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }
}
