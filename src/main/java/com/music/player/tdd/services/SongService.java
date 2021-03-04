package com.music.player.tdd.services;

import com.music.player.tdd.models.Song;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    public Song saveSong(Song any) {
        return any;
    }
}
