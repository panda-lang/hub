package org.panda_lang.reposilite.utils;

public final class StringsUtils {

    public static int lastIndexOf(String text, String element, int toIndex) {
        if (toIndex < 0) {
            return -1;
        }

        return text.substring(0, toIndex).lastIndexOf(element);
    }

    private StringsUtils() { }

}
