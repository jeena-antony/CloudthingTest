package com.example.tests;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/cucumber/cloudthing.feature",
        glue = {"com.example.cucumber.steps"},
        plugin = {"pretty","json:Report/jsonreport.json"}
       // dryRun = true,
      //  monochrome = true
)

public class CloudthingTest extends AbstractTestNGCucumberTests {


}
