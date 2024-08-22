package org.greyytechnologies.global_variables;

import net.serenitybdd.screenplay.ui.Select;
import org.greyytechnologies.utils.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;


public class global_pageobjects extends Baseclass
{
    //global_pageobjects gbPageObject;
    global_pageobjects gb_PageObject;

    public global_pageobjects(WebDriver driver) {
    }

    public static void sendKeys(WebElement webElement, String inputText, String fieldName) throws Exception
    {
        System.out.println("input keys:" + inputText);
        try
        {
            if(!inputText.trim().isEmpty())
            {
                waitUntilVisibilityOfElement(webElement);
                webElement.clear();
                webElement.sendKeys(inputText);
            }
        }
        catch (Exception exc)
        {
            System.out.println("Input Error:" + exc.getMessage());
            throw exc;
        }
        Thread.sleep(2000);
    }

    private static void waitUntilVisibilityOfElement(WebElement webElement)
    {
       // V until = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10)).until(ExpectedCondition.visibilityOf(webElement));
    }

    public static void selectTextKeys(WebElement webElement, String textToSelect, String fieldName) throws Exception
    {
        if (textToSelect.length() > 0)
        {
            waitUntilVisibilityOfElement(webElement);
            if (webElement.isEnabled())
            {
                webElement.clear();
                Thread.sleep(2000);
                webElement.sendKeys(textToSelect);
                Thread.sleep(2000);
                webElement.click();
                if (webElement.getAttribute("title").contains("Didn't match any item"))
                {
                    throw new Exception(textToSelect + "is not on the drop down list for"+ fieldName);
                }

                List<WebElement> rows = webElement.findElements(By.xpath("//*[contains(text(),'" +textToSelect + "')]"));
                for (WebElement row : rows)
                {
                    if (row.getText().contains(textToSelect))
                    {
                        row.click();
                        Thread.sleep(2000);
                        break;
                    }
                }
            }
            else
            {
                throw new Exception(webElement + "is NOT enabled for editing");
            }
        }
    }
    public static void selectKeys (WebElement webElement, String inputText, String fieldName)
    {
        System.out.println("input Keys :  "+ inputText);
        try
        {
            waitUntilVisibilityOfElement(webElement);
            if(!inputText.isEmpty())
            {
                Select drop = new Select();
                drop.equals(inputText);
                System.out.println("Text selected : " + inputText);
            }
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }
    //On Click method
    public static String clickElement(String xpathElements, String fieldName) throws Exception
    {
        System.out.println("----------------On click function for site web elemments----------------|" + xpathElements + " | " + fieldName + "------------");
        System.out.println(xpathElements);

        WebElement item = getWebDriver().findElement(net.serenitybdd.core.annotations.findby.By.xpath(xpathElements));
        
        System.out.println("Item name :" + fieldName);
        int Counter = 0;
        do {
            try
            {
                item.click();
                break;
            }
            catch (Exception exc)
            {
                System.out.println("Count :" + Counter +"::");
                System.out.println("Click element error:" + exc.getMessage());
                Counter = Counter + 1;
            }
        }
        while (Counter <=5);
        return xpathElements;
    }
    
    //Switch frame method
    public static int switchFrameByNumber(String frameHeaderName)
    {
        System.out.println("Frame data by text :" + frameHeaderName);
        int size = 30;
        System.out.println("Frame count :" + size);
        int currentFrame = 0;
        for (int i = 0;  i < size; i++)
        {
            System.out.println("frame count:" + i);
            try {
                System.out.println("frame number to view :"+ frameHeaderName);
                getWebDriver().switchTo().frame(i);
                if (getWebDriver().findElement(net.serenitybdd.core.annotations.findby.By.xpath("//*contains(text()'"+ frameHeaderName+ "')]")).getText().equalsIgnoreCase(frameHeaderName))
                {
                    System.out.println("Opened frame number:"+ i);
                    System.out.println("Frame found :"+ frameHeaderName);
                    currentFrame = i;
                    break;
                    }
                //else
                {
                    SwitchToDefault();
                }
            }
            catch (Exception exc)
            {
                System.err.println("Frame Error :"+ exc.getMessage());
                SwitchToDefault();
            }
            
        }
        return currentFrame;
    }
    
    //Scroll up function
   /* public static void scrollUp() throws Exception
    {
        JavaScriptExecutor js = (JavaScriptExecutor) getWebDriver();
        js.executeScript("window.scrollTo(document.body.scrollHieght,0)");
        Thread.sleep(2000);
    }*/

   /* public static void scrollUp() throws Exception
    {
        JavaScriptExecutor js = (JavaScriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0,-250)","");
        Thread.sleep(2000);
    }*/

    /*public static void scrollDownTo(String yCoordinates) throws Exception
    {
        JavaScriptExecutor js = (JavaScriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0," + yCoordinates + ")","");
        Thread.sleep(2000);
    }*/
    
    private static void SwitchToDefault()
    {
        getWebDriver().switchTo().defaultContent();
        System.out.println("--Switched to default content");
    }
    
    public static void switchToActiveElement()
    {
        getWebDriver().switchTo().activeElement();
        System.out.println("--Switched to default content");
    }

    public static void closeBrowserWindow()
    {
        try
        {
            getWebDriver().close();
        }
        catch (Exception exc) 
        {
            System.out.println("Browser closed successfully"+ exc.getMessage());
        }
    }

    public static void selectYear(String Xpath, String fieldName) throws Exception 
    {
        System.out.println("Item name"+ fieldName);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        System.out.println("get instance" + calendar);
        int yearInt = calendar.get(Calendar.YEAR);
        System.out.println("Year :" + yearInt);
        global_pageobjects.clickElement(Xpath,"Calendar Icon");
        global_pageobjects.clickElement("//span[text()=\"" + yearInt + "\"]", "select year");
    }
    
    public static void switchFrameToAny(String frameHeader)
    {
        System.out.println("----------------witness the magic of switching to multiple frames----------------" + frameHeader + "Test i frame");
        System.out.println("iFrame data  :" + frameHeader);
        int size = getWebDriver().findElements(net.serenitybdd.core.annotations.findby.By.tagName("iframe")).size();
            System.out.println("Frame Count :" + size);
            int currentFrame = 0;
            for (int i = 0; i < size; i++);
            
        int i = 0;
        
        System.out.println("---------" + i);
            try
            {
                System.out.println("iFrame to view  :" + i);
                if  (getWebDriver().findElement(net.serenitybdd.core.annotations.findby.By.xpath("//*[contains(text(),'" + frameHeader + "')]")).getText().equalsIgnoreCase(frameHeader))
                {
                    System.out.println("----------------iFrame is found...---------------- " + i);
                    System.out.println("----------------ans iFrame found is:----------------" + frameHeader);
                    currentFrame = i;
                    //break;
                }
                
                else 
                    SwitchToDefault();
            }catch (Exception exc)
            {
                System.err.println("Frame Error : " + exc.getMessage());
            }
            
        }
    public static WebDriver getWebDriver()

    {
        WebDriver webdriver;
        webdriver = webDriver;
        return webdriver;
    }

}
    


