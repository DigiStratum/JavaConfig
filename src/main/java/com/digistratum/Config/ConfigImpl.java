package com.digistratum.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigImpl implements Config {
	protected Map<String, String> config;

	/**
	 * Default constructor
	 */
	public ConfigImpl() {
		config = new HashMap<>();
	}

	/**
	 * Props loading constructor
	 *
	 * @param path String path to the properties file we want to load from
	 */
	public ConfigImpl(String path) {
		this();
		loadProperties(path);
	}

	/**
	 * Load properties from a specified path
	 *
	 * ref: https://www.mkyong.com/java/java-properties-file-examples/
	 *
	 * @param path String path to the properties file we want to load from
	 */
	protected void loadProperties(String path) {
		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream(path);

			// load a properties file
			prop.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Missing properties file: '" + path + "'");
		} catch (IOException e) {
			System.out.println("Error reading properties file: '" + path + "' - " + e.getMessage());
		}

		// Move our props into a Map<String, String> for config
		// ref: https://coderanch.com/t/599586/java/Properties-Class
		for (Map.Entry<Object, Object> e : prop.entrySet()) {
			config.put(e.getKey().toString(), e.getValue().toString());
		}
	}

	@Override
	public String get(String name, String def) {
		if (! config.containsKey(name)) return def;
		String value = config.get(name);
		return (null == value) ? def : value;
	}

	@Override
	public Boolean get(String name, Boolean def) {
		if (! config.containsKey(name)) return def;
		String value = config.get(name);
		return (null == value) ? def : Boolean.parseBoolean(value);
	}

	@Override
	public Integer get(String name, Integer def) {
		if (! config.containsKey(name)) return def;
		String value = config.get(name);
		return (null == value) ? def : Integer.parseInt(value);
	}

	@Override
	public ConfigImpl set(String name, String value) {
		if (null == value) {
			config.put(name, null);
		}
		else {
			config.put(name, value);
		}
		return this;
	}

	@Override
	public ConfigImpl set(String name, Boolean value) {
		if (null == value) {
			config.put(name, null);
		}
		else {
			config.put(name, (value ? "true" : "false"));
		}
		return this;
	}

	@Override
	public ConfigImpl set(String name, Integer value) {
		if (null == value) {
			config.put(name, null);
		}
		else {
			config.put(name, "" + value);
		}
		return this;
	}
}
