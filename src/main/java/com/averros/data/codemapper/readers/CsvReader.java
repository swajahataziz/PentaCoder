package com.averros.data.codemapper.readers;

import com.averros.data.codemapper.model.Row;
import com.averros.data.codemapper.utils.StringUtils;
import lombok.Data;
import reactor.core.publisher.Flux;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;

@Data
public class CsvReader {

    private Flux<String> fileContent;
    public boolean eof = false;
    private char delimiter = ',';
    private String charset = "UTF-8";
    private Path path;

    final FileSystem fs = FileSystems.getDefault();

    public CsvReader(String fileName, char delimiter) {
        this.path = Paths.get(fileName);
        this.delimiter = delimiter;
    }

    private static Flux<String> fromPath(Path path) {
        return Flux.using(() -> Files.lines(path),
                Flux::fromStream,
                BaseStream::close);
    }

    public static Flux<Row> readFile(Path path, char delimiter) {

        return fromPath(path)
                .map(s -> text2Columns(s, delimiter))
                .map((s) -> {
                    Row row = new Row();
                    row.setCells(s);
                    return row;
                });
    }


    private static List<String> text2Columns(String input, char delimiter) {
        List<String> columns = StringUtils.split(input, delimiter);
        List<String> formattedColumns = new ArrayList<>();

        columns.forEach(c -> {
            if (c.startsWith("\"") && c.endsWith("\"") && c.length() > 1)
                c = c.substring(1,c.length()-1);
            c = c.replace("\\\"", "\"");
            c = c.replaceAll("\\\\\\\\", "\\\\");
            formattedColumns.add(c);
        });
        return formattedColumns;
    }
}
