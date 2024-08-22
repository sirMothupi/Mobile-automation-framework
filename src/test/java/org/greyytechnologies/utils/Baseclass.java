package org.greyytechnologies.utils;

//import jdk.javadoc.internal.tool.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.InputStream;
import java.util.Properties;

public class Baseclass
{
    public static Properties properties;
    protected static WebDriver webDriver;
    
    public Baseclass()
    {
        PageFactory.initElements(webDriver,this);
    }
    public static Properties getProperties()
    {
        try
        {
            properties = new Properties();
            //InputStream inputStream = Files.newInputStream(Paths.get(System.getProperty("user.dir") + "\\src\\test\\resources\\application.properties"));
            //InputStream inputStream = new FileInputStream(System.getProperty("Users.dir") + "");
            InputStream inputStream = Baseclass.class.getResourceAsStream("/application.properties");
            properties.load(inputStream);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return properties;
    }

    public static void setDriver(WebDriver driver)
    {
        webDriver = driver;
    }

    public static WebDriver getWebDriver()
    {
        return webDriver;
    }
}
