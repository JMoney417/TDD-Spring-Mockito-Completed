package com.music.player.tdd.TestUtils;

import com.music.player.tdd.models.Song;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestSongs {

    public static List<Song> getSongs(){
        List<Song> songs = new ArrayList();
        songs.add(new Song("Africa","Weezer", Duration.ofSeconds(243)));
        songs.add(new Song("Africa","Toto", Duration.ofSeconds(274)));
        songs.add(new Song("Billie Jean","Michael Jackson", Duration.ofSeconds(210)));
        songs.add(new Song("I Would Do Anything for Love","Meatloaf",Duration.ofSeconds(756)));
        songs.add(new Song("Closer","The Chainsmokers",Duration.ofSeconds(244)));
        return songs;
    }
}
