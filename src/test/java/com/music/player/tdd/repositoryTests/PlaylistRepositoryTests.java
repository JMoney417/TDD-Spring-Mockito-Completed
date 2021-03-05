package com.music.player.tdd.repositoryTests;

import com.music.player.tdd.models.Playlist;
import com.music.player.tdd.repositories.PlaylistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class PlaylistRepositoryTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Test
    public void findByid_findsInRepo(){
        Long id = testEntityManager.persistAndGetId()
    }
}
