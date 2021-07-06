package com.init;


public class Configuration extends SeleniumInit{
	
	
	public static String getEmail()
	{
		return config_properties.getProperty("email").trim();
	}
	
	public static String getPassword()
	{
		return config_properties.getProperty("password").trim();
	}

	
}
