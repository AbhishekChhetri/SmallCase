package com.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features={"src//test//java//resources"},
            glue= {"com.stepdefinations"},
            tags = {"@Test"}
    )

    public class EcomRunner {

    }

