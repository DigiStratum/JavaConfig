package com.digistratum.Config;

public interface Config {

	/**
	 * Get the named config entry (String), and supply default if undefined
	 *
	 * @param name String name of the config entry that we want
	 * @param def String default to use if the entry is not found (optional)
	 */
	String get(String name, String def);

	/**
	 * Get the named config entry (Integer), and supply default if undefined
	 *
	 * @param name String name of the config entry that we want
	 * @param def Integer default to use if the entry is not found (optional)
	 */
	Integer get(String name, Integer def);

	/**
	 * Get the named config entry (boolean), and supply default if undefined
	 *
	 * @param name String name of the config entry that we want
	 * @param def Boolean default to use if the entry is not found (optional)
	 */
	Boolean get(String name, Boolean def);

	/**
	 * Set the named config entry to the supplied String value
	 *
	 * @param name String name of the config entry we want to set
	 * @param value String value we want to set it to
	 *
	 * @return this for chaining...
	 */
	Config set(String name, String value);

	/**
	 * Set the named config entry to the supplied Boolean value
	 *
	 * @param name String name of the config entry we want to set
	 * @param value Boolean value we want to set it to
	 *
	 * @return this for chaining...
	 */
	Config set(String name, Boolean value);

	/**
	 * Set the named config entry to the supplied Integer value
	 *
	 * @param name String name of the config entry we want to set
	 * @param value Integer value we want to set it to
	 *
	 * @return this for chaining...
	 */
	Config set(String name, Integer value);
}
