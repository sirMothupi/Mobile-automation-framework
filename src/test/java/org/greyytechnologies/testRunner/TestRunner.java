package org.greyytechnologies.testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
        plugin = {"pretty","html:target/automation/assessment-report.html",
                "json:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        tags = "@SpotifyAPI_Test"
)
public class TestRunner
{

}
