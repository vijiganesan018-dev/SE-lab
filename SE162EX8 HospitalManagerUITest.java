import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class HospitalManagerUITest {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        // Selenium 4.46 automatically manages the correct ChromeDriver
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void testAddPatient() {

        driver.get("file:///home/student/Desktop/Ram%20CSE/exp8.html");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait for the form elements to be available
        WebElement nameField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("name")));

        WebElement ageField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("age")));

        WebElement diseaseField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("disease")));

        WebElement submitButton =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("submit")));

        // Enter patient details
        nameField.sendKeys("John");
        ageField.sendKeys("30");
        diseaseField.sendKeys("Flu");

        // Submit
        submitButton.click();

        // Check patient count
        WebElement patientCount =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("patientcount")));

        assertTrue(
                patientCount.getText().contains("1"),
                "Patient was not added successfully"
        );

        System.out.println("Patient added successfully");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
