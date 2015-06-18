package game2048.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.NoSuchElementException;

public class HomePage extends PageObject {
	@FindBy(css = "body")
	public WebElementFacade body;
	@FindBy(css = ".tile-container")
	private WebElementFacade tableNumbers;
	@FindBy(css = ".score-container")
	public WebElementFacade scores;

	public int getNumberInCell(final int row, final int column) {
		try {
			final WebElementFacade el = tableNumbers
					.then("div[contains(@class, 'tile-position-" + row + "-"
							+ column + "')][last()]");
			waitFor(driver -> el.getText().length() > 0);
			return Integer.parseInt(el.getText());
		} catch (final NoSuchElementException nsee) {
			return 0;
		}
	}

	public boolean isGameOverMessagePresent(final String text) {
		try {
			$("//div[@class='game-message game-over']/p[text()='" + text + "']");
			return true;
		} catch (final NoSuchElementException nsee) {
			return false;
		}
	}
}