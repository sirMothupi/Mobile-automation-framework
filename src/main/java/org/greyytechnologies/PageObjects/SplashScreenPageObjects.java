package org.greyytechnologies.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.greyytechnologies.android_utils.AppiumAction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SplashScreenPageObjects
{
    static WebDriverWait wait;
    static AppiumAction appiumAction;

    public SplashScreenPageObjects(AndroidDriver androidDriver) {
        wait = new WebDriverWait(androidDriver, Duration.ofSeconds(200));
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        appiumAction = new AppiumAction();
    }
    @AndroidFindBy(xpath = "//*[@id=\"mount_0_0_L0\"]/div/div/div[1]/div/div[2]/div[1]/a/svg/path[1]")
    public AndroidElement btnLogin;

    @AndroidFindBy(xpath = "//*[@id=\"mount_0_0_L0\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div/div/label/input")
    public AndroidElement btnSearch;
}
