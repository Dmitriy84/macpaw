package game2048.jbehave;

import game2048.steps.EndUserSteps;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.Keys;

public class DefinitionSteps {
	@Given("player in on the home page")
	public void openHomePage() {
		endUser.is_the_home_page();
	}

	@Given("stop playing criteria is '$criteria'")
	public void setStopPlayingCriteria(final String criteria) {
		_criteria = criteria;
	}

	@Then("start random play with '$keys' keys")
	public void useKeysForPlaying(final List<Keys> keys) {
		endUser.play_game_with_keys_until_criteria(_criteria, keys);
	}

	@Then("show scores")
	public void showScores() {
		endUser.show_scores();
	}

	@Steps
	EndUserSteps endUser;
	private String _criteria;
}