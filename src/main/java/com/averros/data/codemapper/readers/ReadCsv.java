package com.averros.data.codemapper.readers;

import lombok.Data;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.BaseStream;
@Data
public class ReadCsv {

    private Flux<String> fileContent;
    public boolean eof = false;
    private char delimiter = ',';
    private String charset = "UTF-8";

    public ReadCsv(String fileName, char delimiter) {
        Path path = Paths.get(fileName);
        this.delimiter = delimiter;
        fileContent= Flux.using(() -> Files.lines(path),
                Flux::fromStream,
                BaseStream::close);
    }

/*
    private Flux<List<String>> text2Columns() {
        Flux<List<String>> flux = fileContent.map(s -> s.split(delimiter))

    }
    */
}
