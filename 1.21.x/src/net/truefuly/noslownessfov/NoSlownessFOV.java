/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package net.truefuly.noslownessfov;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSlownessFOV
implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger((String)"noslownessfov");

    public void onInitializeClient() {
        LOGGER.info("NoSlownessFOV initialized! Removing slowness FOV effect.");
    }
}

