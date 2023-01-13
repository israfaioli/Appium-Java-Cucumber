package com.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features/",
        glue = {"com.test"}
)

public class RunTest {
    @AfterClass
    public static void stop() {
        Hooks.quitDriver();
    }

}
