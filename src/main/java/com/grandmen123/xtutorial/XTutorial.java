package com.grandmen123.xtutorial;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XTutorial implements ModInitializer {

	public static final String MOD_ID = "xtutorial";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + ": Loading");
		LOGGER.info(MOD_ID + ": Loaded");
	}
}