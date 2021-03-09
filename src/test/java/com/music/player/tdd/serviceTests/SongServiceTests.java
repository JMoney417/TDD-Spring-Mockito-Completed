package com.music.player.tdd.serviceTests;

import com.music.player.tdd.TestUtils.TestSongs;
import com.music.player.tdd.models.Song;
import com.music.player.tdd.repositories.SongRepository;
import com.music.player.tdd.services.SongService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class SongServiceTests {

    @Mock
    SongRepository songRepository;

    @InjectMocks
    SongService songService;

    @Test
    public void saveSong_callsRepo(){
        Song song = TestSongs.getSongs().get(0);
        songService.saveSong(song);

        verify(songRepository,times(1)).save(song);
    }

    @Test
    public void findSongByTitle_should_call_repo_with_title(){
        //testing to make sure service method is calling the appropriate repo method
        //with the correct arguments
        songService.findSongsByTitle("Africa");
        verify(songRepository,times(1)).findAllByTitle("Africa");
    }

}
