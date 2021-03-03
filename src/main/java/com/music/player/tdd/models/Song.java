package com.music.player.tdd.models;

import java.time.Duration;

public class Song {
	private String title;
	private String artist;
	private Duration length;
	
	public Song() {
		
	}
	
	public Song(String title, String artist, Duration length) {
		super();
		this.title = title;
		this.artist = artist;
		this.length = length;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return this.artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Duration getDuration() {
		return length;
	}
	public void setDuration(Duration length) {
		this.length = length;
	}

	public String getDurationPretty() {
		long ts = length.getSeconds();
		return String.format("%d:%02d:%02d",ts/3600,(ts-(ts/3600))/60, ts%60);
	}

}