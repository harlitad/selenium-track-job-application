import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerBlibliTest {

    protected WebDriver driver = new ChromeDriver();
    private String email = "harlitad@gmail.com";
    private String application_id = "9716d502-c4a8-41e7-8583-b0d2c1ac1964";

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://careers.blibli.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testTrackApplication() {
        WebElement track_form = driver.findElement(By.xpath("//div[contains(@class, 'track-form')]"));

        WebElement track_form_input_email = track_form.findElements(By.xpath(".//input[contains(@id, 'bli-input-')]")).get(0);
        track_form_input_email.sendKeys(email);

        WebElement track_form_application_id = track_form.findElements(By.xpath(".//input[contains(@id, 'bli-input')]")).get(1);
        track_form_application_id.sendKeys(application_id);

        WebElement track_button = track_form.findElement(By.xpath(".//div[contains(@class, 'track__button')]//button[1]"));
        track_button.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement track_card =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'card-track')]//h3[1]")));
        Assert.assertEquals("Track your application progress", track_card.getText());
    }


}
