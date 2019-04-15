package com.averros.data.codemapper.reader;

import com.averros.data.codemapper.readers.CsvReader;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.nio.file.*;
import java.util.List;

@SpringBootTest
public class CsvReaderTest {

    @Test
    public void testReadFile() {

        Path path = Paths.get("/Users/wajahat/test.csv");

        Flux<List<String>> flux = CsvReader.readFile(path,',');
        Assert.assertNotNull(flux);

    }
}
