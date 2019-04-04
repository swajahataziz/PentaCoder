package com.averros.data.codemapper.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;


@SpringBootTest
public class SpringUtilsTest {

    @Test
    public void testSplitWithCommaSeparator() {
        String testString = "This is a test,it has three columns,this is the third column";
        List<String> result = StringUtils.split(testString, ',');
        List<String> expected = Arrays.asList("This is a test","it has three columns","this is the third column");

        Assert.assertThat(result, is(expected));

        Assert.assertThat(result, hasItems("This is a test"));
    }

    @Test
    public void testSplitWithPipeSeparator() {
        String testString = "This is a test|it has three columns|this is the third column";
        List<String> result = StringUtils.split(testString, '|');
        List<String> expected = Arrays.asList("This is a test","it has three columns","this is the third column");

        Assert.assertThat(result, is(expected));

        Assert.assertThat(result, hasItems("This is a test"));
    }

    @Test
    public void testSplitWithEscapeCharacters() {
        String testString = "This is a test|it has \"three\" columns|this is the third column";
        List<String> result = StringUtils.split(testString, '|');
        List<String> expected = Arrays.asList("This is a test","it has three columns","this is the third column");

        Assert.assertThat(result, is(expected));

        Assert.assertThat(result, hasItems("This is a test"));
    }
}
