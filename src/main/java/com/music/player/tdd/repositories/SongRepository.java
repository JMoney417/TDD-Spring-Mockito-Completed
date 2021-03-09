package com.music.player.tdd.repositories;

import com.music.player.tdd.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByTitle(String africa);
    Song findByArtist(String author);
}
