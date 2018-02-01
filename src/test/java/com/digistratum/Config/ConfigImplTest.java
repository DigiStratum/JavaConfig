package com.digistratum.Config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigImplTest {
	ConfigImpl sut;

	@BeforeEach
	public void setup() throws Exception {
		sut = new ConfigImpl();
	}

	@Test
	public void testThat_setters_chainProperly() {

		// Attempt
		ConfigImpl res = sut
				.set("stringProp", "string")
				.set("boolProp", true)
				.set("intProp", 333);

		// Verify
		assertTrue(sut.equals(res));
	}

	@Test
	public void testThat_stringGetter_returnsDefaultForMissingName() {

		// Setup
		String defaultValue = "defaultValue";

		// Attempt
		String res = sut.get("missingName", defaultValue);

		// Verify
		assertEquals(defaultValue, res);
	}

	@Test
	public void testThat_stringGetter_returnsDefaultForNullValue() {

		// Setup
		String name = "nullName";
		String value = null;
		String defaultValue = "defaultValue";

		// Attempt
		String res = sut.set(name, value).get(name, defaultValue);

		// Verify
		assertEquals(defaultValue, res);
	}

	@Test
	public void testThat_stringGetter_returnsSetValueNotDefault() {

		// Setup
		String name = "setName";
		String value = "setValue";
		String defaultValue = "defaultValue";

		// Attempt
		String res = sut.set(name, value).get(name, defaultValue);

		// Verify
		assertEquals(value, res);

	}

	@Test
	public void testThat_intGetter_returnsDefaultForMissingName() {

		// Setup
		Integer defaultValue = 333;

		//  Attempt
		Integer res = sut.get("missingName", defaultValue);

		// Verify
		assertEquals(defaultValue, res);
	}

	@Test
	public void testThat_intGetter_returnsDefaultForNullValue() {

		// Setup
		String name = "nullName";
		Integer value = null;
		Integer defaultValue = 333;

		// Attempt
		Integer res = sut.set(name, value).get(name, defaultValue);

		// Verify
		assertEquals(defaultValue, res);
	}

	@Test
	public void testThat_intGetter_returnsSetValueNotDefault() {

		// Setup
		String name = "setName";
		Integer value = 111;
		Integer defaultValue = 333;

		// Attempt
		Integer res = sut.set(name, value).get(name, defaultValue);

		// Verify
		assertEquals(value, res);

	}

	@Test
	public void testThat_boolGetter_returnsDefaultForMissingName() {

		// Setup
		Boolean defaultValue = true;

		// Attempt
		Boolean res = sut.get("missingName", defaultValue);

		// Verify
		assertEquals(defaultValue, res);
	}

	@Test
	public void testThat_boolGetter_returnsDefaultForNullValue() {

		// Setup
		String name = "nullName";
		Boolean value = null;
		Boolean defaultValue = true;

		// Attempt
		Boolean res = sut.set(name, value).get(name, defaultValue);

		// Verify
		assertEquals(defaultValue, res);
	}

	@Test
	public void testThat_boolGetter_returnsSetValueNotDefault() {

		// Setup
		String name = "setName";
		Boolean value = false;
		Boolean defaultValue = true;

		// Attempt
		Boolean res = sut.set(name, value).get(name, defaultValue);

		// Verify
		assertEquals(value, res);
	}

	@Test
	public void testThat_altConstructor_loadsProperties() {

		// Setup
		URL propsUrl = ConfigImplTest.class
				.getClassLoader().getResource("ConfigImplTest.properties");

		// Attempt
		sut = new ConfigImpl(propsUrl.getPath());

		// Verify
		assertEquals("stringValue", sut.get("stringProp", "defaultValue"));
		Integer intExpected = 111;
		assertTrue(intExpected.equals(sut.get("intProp", 333)));
		assertEquals(true, sut.get("boolProp", false));
	}
}
