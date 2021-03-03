package com.music.player.tdd.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistTest {
	
	private static Playlist myPlaylist;
	private static List<Song> songs = new ArrayList<Song>(Arrays.asList(
			new Song("Billie Jean","Michael Jackson",Duration.ofSeconds(210)),
			new Song("I Would Do Anything for Love","Meatloaf",Duration.ofSeconds(756)),
			new Song("Closer","The Chainsmokers",Duration.ofSeconds(244))));

	@BeforeEach
	public void addSongs(){
		myPlaylist = new Playlist();
		songs.stream().forEach(song->myPlaylist.addSong(song));
	}

	@Test
	public void addSongToPlaylistTest() {
		myPlaylist.addSong(songs.get(0));

		int expectedSize = 4;
		int actualSize = myPlaylist.getSonglist().size();
		Song actualAddedSong = myPlaylist.getSonglist().get(3);
		Song expectedAddedSong = songs.get(0);

		assertEquals(expectedSize,actualSize, "Adding a song should increase the songList by 1");
		assertEquals(expectedAddedSong,actualAddedSong);
	}
	

	@Test
	public void removeSongFromPlaylistTest() {
		myPlaylist.removeSong(myPlaylist.getSonglist().get(1));

		int expectedPlaylistSize = 2;
		Song expectedSong1 = songs.get(0);
		Song expectedSong2 = songs.get(2);

		assertEquals(expectedPlaylistSize,myPlaylist.getSonglist().size());
		assertEquals(expectedSong1,myPlaylist.getSonglist().get(0));
		assertEquals(expectedSong2,myPlaylist.getSonglist().get(1));
	}

	@Test
	public void moveSongTest() {
		myPlaylist.moveSong(2,0);

		Song actualSong0 = myPlaylist.getSonglist().get(0);
		Song actualSong1 = myPlaylist.getSonglist().get(1);
		Song actualSong2 = myPlaylist.getSonglist().get(2);

		Song expectedSong0 = songs.get(2);
		Song expectedSong1 = songs.get(0);
		Song expectedSong2 = songs.get(1);

		assertEquals(expectedSong0,actualSong0);
		assertEquals(expectedSong1,actualSong1);
		assertEquals(expectedSong2,actualSong2);
	}
	

	public void getPrettyPlaylistDurationTest() {

	}
	

	public void showPlaylistTest() {

	}

}
