package com.music.player.tdd.TestUtils;

import com.music.player.tdd.models.Song;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestSongs {

    public static List<Song> getSongs(){
        List<Song> songs = new ArrayList();
        songs.add(new Song("Africa","Weezer", 243));
        songs.add(new Song("Africa","Toto", 274));
        songs.add(new Song("Billie Jean","Michael Jackson", 210));
        songs.add(new Song("I Would Do Anything for Love","Meatloaf",756));
        songs.add(new Song("Closer","The Chainsmokers",244));
        return songs;
    }
}
