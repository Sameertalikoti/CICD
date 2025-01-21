package stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

public class step {

    WebDriver driver = new ChromeDriver();

    @Given("I am on the Google homepage")
    public void iAmOnGoogleHomepage() {
        // Navigate to google.com
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        // Find the search box, enter the search term, and submit the search
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsFor(String searchTerm) {
        // Wait for results to load and verify the title or results text
        String title = driver.getTitle();
        assertTrue(title.contains(searchTerm), "The page title does not contain the search term.");
    }

    @Then("I should see no results for {string}")
    public void iShouldSeeNoResultsFor(String searchTerm) {
        // Verifying if "No results found" message or similar is displayed
        WebElement noResultsMessage = driver.findElement(By.id("topstuff"));
        assertTrue(noResultsMessage.getText().contains("did not match any documents"), 
            "Expected no results message but found results.");
    }
    
    // After the test is finished, quit the browser
    @io.cucumber.java.After
    public void tearDown() {
        driver.quit();
    }
}
