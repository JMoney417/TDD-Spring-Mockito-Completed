package com.music.player.tdd.repositories;

import com.music.player.tdd.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
