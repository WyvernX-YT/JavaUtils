package me.wyvernx.javaUtils.utils.webUtils;

import me.wyvernx.javaUtils.types.booleans.Bool;

import java.awt.*;
import java.net.URI;
import java.net.URL;

public class Web {
    public static boolean openWebpage(URI uri) {
        Bool value = Bool.False;
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                value = value.not();
                return value.toBoolean();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value.toBoolean();
    }
    public static boolean openWebpage(URL uri) {
        Bool value = Bool.False;
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri.toURI());
                value = value.not();
                return value.toBoolean();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value.toBoolean();
    }
}
