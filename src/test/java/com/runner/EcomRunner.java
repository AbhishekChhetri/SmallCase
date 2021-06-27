package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class EcomRunner {


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/javaFeatures",
            glue= {"seleniumgluecode"},
            tags = "@Test"
    )

    public class testrunner {

    }
}
