package com.pingplusplus.util;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class StringUtils {
    private static Pattern whitespacePattern = Pattern.compile("\\s");

    /**
     * Checks whether a string contains any whitespace characters or not.
     *
     * @param str the string to check.
     * @return {@code true} if the string contains any whitespace characters; otherwise, {@code
     *     false}.
     */
    public static boolean containsWhitespace(String str) {
        requireNonNull(str);
        return whitespacePattern.matcher(str).find();
    }

    public static String join(String separator, List<String> input) {
        if (input == null || input.size() <= 0) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.size(); i++) {
            sb.append(input.get(i));

            // if not the last item
            if (i != input.size() - 1) {
                sb.append(separator);
            }
        }

        return sb.toString();
    }
}
