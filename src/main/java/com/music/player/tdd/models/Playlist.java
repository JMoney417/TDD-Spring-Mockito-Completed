package com.music.player.tdd.models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Playlist {
	private String name;
	private List<Song> songlist;
	
	public Playlist() {
		songlist = new ArrayList<Song>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSonglist() {
		return songlist;
	}

	public void addSong(Song song) {
		songlist.add(song);
	}

	public void removeSong(Song song) {
		songlist.remove(song);
	}

	public void moveSong(int currentIndex, int newIndex) {
		Song songToMove = songlist.get(currentIndex);
		songlist.remove(songToMove);
		songlist.add(newIndex,songToMove);
	}
}
