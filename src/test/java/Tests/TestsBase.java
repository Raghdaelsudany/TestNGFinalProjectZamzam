package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class TestsBase {

    WebDriver driver;
    String url = "https://zamzam.com/";


    protected static ExtentReports report;
    protected static ExtentTest reportTest;

    @BeforeSuite
    public void setUp(){
        report =  new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/report.html");
        report.attachReporter(spark);
    }

    @BeforeTest
    public void preCondition() throws InterruptedException {
        //ChromeOptions options = new ChromeOptions();
        //options.addExtensions(new File("src/main/resources/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_6_7_0_0.crx"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(url);
//        Thread.sleep(3000);
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        driver.close();
//        driver.switchTo().window(tabs.get(0));
    }


    @AfterTest
    public void AfterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterSuite
    public void tearDown() throws IOException {
        report.flush();
        Desktop.getDesktop().open(new File("Reports/report.html"));
    }
}
