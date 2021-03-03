package com.music.player.tdd.models;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {

	@Test
	public void getPrettyDurationTest() {
		//Arrange
		Song mySong = new Song("Tadow","FKJ and Masego", Duration.ofSeconds(205));
		//Act
		String prettyResult  = mySong.getDurationPretty();
		String expectedResult = String.format("%d:%02d:%02d",0,3,25);
		//Assert
		assertEquals(expectedResult,prettyResult, "Pretty duration -> HH:mm:ss" );
	}
}
