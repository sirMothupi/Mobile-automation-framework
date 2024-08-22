package org.greyytechnologies.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;
import java.util.HashMap;

import static io.github.bonigarcia.wdm.WebDriverManager.*;


public class DriverManager
{
    private WebDriver webDriver;
    private DesiredCapabilities desiredCapabilities;
    private static DriverManager driverManager = null;

    public DriverManager()

    {
        webDriver = getBrowserDriver();
    }

    private WebDriver getBrowserDriver()
    {
        String driverType = "chrome";
        switch (driverType)
        {
            case "firefox":
                firefoxdriver().setup();
                        return new FirefoxDriver();
            case "edge":
                edgedriver().setup();
                return new EdgeDriver();
            case "safari":
                safaridriver().setup();
                return new SafariDriver();
            default:
                    return createChromeDriver();
        }
    }

    public WebDriver createChromeDriver()
    {
        WebDriver driver = new ChromeDriver();

        desiredCapabilities = desiredCapabilities != null ? desiredCapabilities : new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();

        String switches = "--ignore-certificate-errors," +
                "--disable-popup-blocking," +
                "--disable-translate," +
                "--incognito, --disable-extensions";

        String[] switchList = switches.split(",");
        options.setCapability("chrome.seitches", Arrays.asList(switchList));
        options.addArguments("test-type");
        options.addArguments("--remote-allow-origins");

        HashMap<String, Object> chromePref = new HashMap<>();
        chromePref.put("profile.default_content_setting.popups", 0);
        //options.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
        options.setExperimentalOption("prefs", chromePref);

        chromedriver().setup();
        return new ChromeDriver(options);

    }

}
