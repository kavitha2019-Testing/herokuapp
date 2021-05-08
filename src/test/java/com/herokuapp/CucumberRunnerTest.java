package com.herokuapp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"}, tags = {"@login"}, plugin = {
        "pretty", "html:target/reports/html",
        "junit:target/reports/junitReports.xml"})
public class CucumberRunnerTest {
}
