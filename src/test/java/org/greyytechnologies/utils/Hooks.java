package org.greyytechnologies.utils;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Hooks extends Baseclass
{
    DriverManager driverManager = new DriverManager();

    private Set<String> failedSteps = new HashSet<>();
    //static ExcelReportWriter reportWriter = new ExcelReportWriter();
    //static String sheetName = getProperties().getProperty("sheetName");
    static String date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
    //static String fileName = ".src\\test\\resources" + getProperties().getProperty("sheetName") + date + ".xls";

    @BeforeAll
    public static void BeforeSteps() throws Exception
    {
        /*WebDriver driver = new ChromeDriver();
        driver.get("https://www.greyytechnologies.co.za/ ");
        driver.manage().window().maximize();*/

        switch (getProperties().getProperty("browser"))
        {
            case "firefox":
            case "gecko":
                //WebdriverManager.firefox driver().setup();
                setDriver(new FirefoxDriver());
                break;

            case "edge":
            case "mse":
                setDriver(new EdgeDriver());
                break;

            default:
                setDriver(new ChromeDriver());
                break;
        }
    }


    @After
    public void AfterStep()
    {
        webDriver.close();
    }

    public void excludeFailedSteps(Scenario scenario) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
    {
        Set<String> scenarioSteps = new HashSet<>();

        Field delegateField = scenario.getClass().getDeclaredField("delegate");
        delegateField.setAccessible(true);
        TestCaseState testCaseState =(TestCaseState) delegateField.get(scenario);
        Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
        testCaseField.setAccessible(true);
        TestCase testCase = (TestCase) testCaseField.get(testCaseState);

    }

    public void TakeScreenShot(Scenario scenario) throws IOException
    {
        File sourcePath = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent,"image/png","image");
    }


}
