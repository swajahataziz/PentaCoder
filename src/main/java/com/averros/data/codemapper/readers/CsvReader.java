package com.averros.data.codemapper.readers;

import com.averros.data.codemapper.utils.StringUtils;
import lombok.Data;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.BaseStream;
@Data
public class CsvReader {

    private Flux<String> fileContent;
    public boolean eof = false;
    private char delimiter = ',';
    private String charset = "UTF-8";
    private Path path;

    public CsvReader(String fileName, char delimiter) {
        this.path = Paths.get(fileName);
        this.delimiter = delimiter;
    }

    private static Flux<String> fromPath(Path path) {
        return Flux.using(() -> Files.lines(path),
                Flux::fromStream,
                BaseStream::close);
    }

    public static Flux<Flux<String>> readFile(Path path, char delimiter) {

        return fromPath(path)
                .handle((s, sink) -> {
                    Flux<String> str = StringUtils.split(s, delimiter);
                    sink.next(str);
                });
    }

/*
    private Flux<List<String>> text2Columns() {
        Flux<List<String>> flux = fileContent.map(s -> s.split(delimiter))

    }
    */
}
