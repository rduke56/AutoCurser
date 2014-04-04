package com.rduke;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rduke on 4/4/14.
 */
public class Utils {
    public static void log(Level level, String msg) {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(level, "[aCurse] " + msg);
    }
}
