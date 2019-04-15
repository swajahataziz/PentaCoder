package com.averros.data.codemapper.utils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {


    public static List<String> split(String string, char delimiter) {
        final boolean[] escape = {false};
        final boolean[] literal = {false};
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        asCharList(string)
                .forEach(c ->
                {
                    if (c =='"' && !escape[0]) {
                        literal[0] = !literal[0];
                    } else
                    if (!literal[0] && (c == delimiter && !escape[0])) {
                        output.add(sb.toString());
                        sb.setLength(0);
                    } else
                    if (c == '\\') {
                        escape[0] = !escape[0];
                    } else {
                        escape[0] = false;
                        sb.append(c);
                    }
                });
        output.add(sb.toString());
        return (output);
    }


    public static List<Character> asCharList(final String string) {
        return new AbstractList<Character>() {
            public int size() { return string.length(); }
            public Character get(int index) { return string.charAt(index); }
        };
    }
}
