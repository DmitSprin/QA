package FeatureRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureStory",glue = "Steps",
plugin = "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm")
public class FeatureRunner {

}