package com.music.player.tdd.repositoryTests;

import com.music.player.tdd.TestUtils.TestSongs;
import com.music.player.tdd.models.Song;
import com.music.player.tdd.repositories.SongRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest//creates H2 database for testing
public class SongRepositoryTests {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    SongRepository songRepository;

    @Test
    public void repo_save_saves_song(){
        Long id = testEntityManager.persistAndGetId(TestSongs.getSongs().get(0), Long.class);
        //Song savedSong = songRepository.save(TestSongs.getSongs().get(0));
        //Song foundSong = songRepository.findById(savedSong.getId()).orElse(null);
        Song song = songRepository.findById(id).orElse(null);

        assertAll("Song is saved under generated id",
                ()->assertEquals(song.getArtist(),TestSongs.getSongs().get(0).getArtist()),
                ()->assertEquals(song.getTitle(),TestSongs.getSongs().get(0).getTitle()));
    }

    @Test
    public void findByTitle_findsSongsInRepository(){
        //arrange
        Long id0 = testEntityManager.persistAndGetId(TestSongs.getSongs().get(0), Long.class);
        Long id1 = testEntityManager.persistAndGetId(TestSongs.getSongs().get(1), Long.class);
        Long id2 = testEntityManager.persistAndGetId(TestSongs.getSongs().get(2), Long.class);
        //act
        List<Song> songs = songRepository.findAllByTitle("Africa");
        //assert
        assertEquals(2, songs.size());
        songs.forEach(song->assertEquals("Africa",song.getTitle()));
    }
}
