package game2048.steps;

import game2048.pages.HomePage;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

public class EndUserSteps extends ScenarioSteps {
	@Step
	public void is_the_home_page() {
		homePage.open();
	}

	@Step
	public void play_game_with_keys_until_criteria(final String criteria,
			final List<Keys> keys) {
		Keys key;
		while (!homePage.isGameOverMessagePresent(criteria)) {
			key = keys.get(_random.nextInt(keys.size()));
			_log.info("... sending key: " + key.name());
			homePage.body.sendKeys(key);
			_log.info("current state: " + _get_numbers_in_cells());
		}
	}

	@Step
	public void show_scores() {
		_log.info("SCORES: " + homePage.scores.getText());
	}

	HomePage homePage;
	private static final Random _random = new Random();
	private static final long serialVersionUID = -1754084714242343916L;
	private final Logger _log = Logger.getLogger(getClass());

	private List<List<Integer>> _get_numbers_in_cells() {
		return IntStream
				.rangeClosed(1, 4)
				.mapToObj(
						i -> IntStream.rangeClosed(1, 4)
								.map(j -> homePage.getNumberInCell(j, i))
								.boxed().collect(Collectors.toList()))
				.collect(Collectors.toList());
	}
}