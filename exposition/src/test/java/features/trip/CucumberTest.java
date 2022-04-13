package features.trip;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:build/cucumber/TripAgency.json, html:build/cucumber/TripAgency.html, pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "features.trip")
public class CucumberTest {
}