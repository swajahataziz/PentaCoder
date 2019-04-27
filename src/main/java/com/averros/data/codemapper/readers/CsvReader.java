package com.averros.data.codemapper.readers;

import com.averros.data.codemapper.service.CsvProcessor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

@Data
public class CsvReader<T>{

    private char quoteChar;
    private char delimiter;
    private String eolSymbols;
    public boolean eof = false;
    private String charset;
    private Path path;
    private T bean;
    private CsvPreference csvPreference;
    @Autowired
    private CsvProcessor csvProcessor;

    final FileSystem fs = FileSystems.getDefault();

    public CsvReader(T bean) {
        this(bean, ',');
    }

    public CsvReader(T bean, char delimiter) {
        this(bean, delimiter, '"');
    }

    public CsvReader(T bean, char delimiter, char quoteChar) {
        this(bean, delimiter, quoteChar, "\r\n");
    }

    public CsvReader(T bean, char delimiter, char quoteChar, String eolSymbols) {
        this(bean, delimiter, quoteChar, eolSymbols, "UTF-8");
    }

    public CsvReader(T bean, char delimiter, char quoteChar, String eolSymbols, String chartSet) {
        this.bean = bean;
        this.delimiter = delimiter;
        this.quoteChar = quoteChar;
        this.eolSymbols = eolSymbols;
        this.charset = chartSet;

        this.csvPreference = new CsvPreference.Builder(quoteChar,delimiter,eolSymbols).build();
    }

    private List<T> readFile(String fileName) {
        List<T> beanList = new ArrayList<>();

        try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(fileName), csvPreference)) {
            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = csvProcessor.createBeanProcessor();

            while ((bean = beanReader.read(bean, headers, processors)) != null) {
                beanList.add(bean);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: Error: " + e);
        } catch (IOException e) {
            System.out.println("Csv Parser Failed with IO exception: " + e);
        }
        return beanList;
    }
}