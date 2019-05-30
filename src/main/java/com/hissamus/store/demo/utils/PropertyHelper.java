package com.hissamus.store.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "classpath:/sql/sql.properties" })
public class PropertyHelper {
	
	@Autowired
    private Environment env;
	
	public String getProperty(String key) {
		return env.getProperty(key);
	}

}
