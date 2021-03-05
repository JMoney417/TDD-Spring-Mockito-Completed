package cucumber;

import com.music.player.tdd.TddApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {TddApplication.class, SongAPITestSuite.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(features = "src/test/resources/features")
public class SongAPITestSuite {
}
