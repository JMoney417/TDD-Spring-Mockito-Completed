package com.music.player.tdd.TestUtils;

import com.music.player.tdd.models.Playlist;

public class TestPlaylists {

    private static Playlist playlist;

    public static Playlist getTestPlaylist(){
        playlist = new Playlist();
        playlist.setName("Jason's Top 20");

        TestSongs.getSongs().forEach(song->playlist.addSong(song));
        return playlist;
    }
}
