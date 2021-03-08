package cucumber.songStepDefs;

import com.music.player.tdd.TestUtils.TestSongs;
import com.music.player.tdd.models.Song;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class SongsAPIStepdefs {

    Song song;

    @Autowired
    TestRestTemplate restTemplate;
    ResponseEntity<Song> response;

    @Given("I have a <song>")
    public void iHaveASong() {
        song = TestSongs.getSongs().get(0);
    }

    @When("I post that <song> to the app")
    public void iPostThatSongToTheApp() {
        response = restTemplate.postForEntity("/songs/song",song,Song.class);
    }

    @Then("the <song> should be stored in the database")
    public void theSongShouldBeStoredInTheDatabase() {
        Song actualSong = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertAll("Song was posted and reflected back with id",
                ()->assertNotNull(actualSong.getId()),
                ()->assertEquals(actualSong.getTitle(),song.getTitle()),
                ()->assertEquals(actualSong.getArtist(),song.getArtist()));
    }
}
