package com.averros.data.codemapper.reader;

import com.averros.data.codemapper.readers.CsvReader;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.*;
import java.util.List;

@SpringBootTest
public class CsvReaderTest {

    @Test
    public void testReadFile() {

        Path path = Paths.get("/Users/wajahat/test.csv");

    }
}
