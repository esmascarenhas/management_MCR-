package com.maximo.esm.apimcr;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
class ApimcrApplicationTests {

	@Test
	void contextLoads() {
	}

}
