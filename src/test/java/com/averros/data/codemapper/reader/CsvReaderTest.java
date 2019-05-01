package com.averros.data.codemapper.reader;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.*;

@SpringBootTest
public class CsvReaderTest {

    @Test
    public void testReadFile() {
        Path path = Paths.get("/Users/wajahat/test.csv");
    }
}
