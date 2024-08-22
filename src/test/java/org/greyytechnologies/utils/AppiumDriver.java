package org.greyytechnologies.utils;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class AppiumDriver
{
    AndroidDriver driver;

    public void setUp() throws MalformedURLException, URISyntaxException
    {
        URL appiumUrl = new URL("http://localhost:4723/wd/hub");
        URL resource = getClass().getClassLoader().getResource("/Users/mac/AndroidStudioProjects/ProjectX_702/app.apk");
        File app = Paths.get(resource.toURI()).toFile();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "sdk_gphone64_x86_64");
        caps.setCapability("app", app);
        driver = new AndroidDriver(appiumUrl, caps);
    }
    @After
    public void tearDown()
    {
        try
        {
            driver.quit();
        }
        catch (Exception exc)
        {

        }

    }
}
