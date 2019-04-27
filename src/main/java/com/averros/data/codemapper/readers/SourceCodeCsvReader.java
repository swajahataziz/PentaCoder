package com.averros.data.codemapper.readers;

import com.averros.data.codemapper.model.SourceData;
import com.averros.data.codemapper.readers.processors.FmtPair;
import com.averros.data.codemapper.readers.processors.StringSplitter;
import org.springframework.data.util.Pair;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrNotNullOrEmpty;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SourceCodeCsvReader {

    private Set<String> sourceConceptIds = new HashSet<>();
    private CsvPreference csvPreference;
    private String[] nameMapping;

    public SourceCodeCsvReader(char delimiter) {
        this(delimiter, '"');
    }

    public SourceCodeCsvReader(char delimiter, char quoteChar) {
        this(delimiter, quoteChar, "\r\n");
    }

    public SourceCodeCsvReader(char delimiter, char quoteChar, String eolSymbols) {
        this(delimiter, quoteChar, eolSymbols, "UTF-8");
    }

    public SourceCodeCsvReader(char delimiter, char quoteChar, String eolSymbols, String chartSet) {
        this.csvPreference = new CsvPreference.Builder(quoteChar,delimiter,eolSymbols).build();
        this.nameMapping = new String[]{"Source Name", "Source Code", "Record Frequency", "Concept IDs", "Additional Source Info"};
    }

    public List<SourceData> read(String fileName) {

        List<SourceData> sourceCodeList = new ArrayList<>();
        try {
            String[] headers;
            ICsvMapReader mapReader = new CsvMapReader(new FileReader(fileName), csvPreference);
            headers = mapReader.getHeader(true);
            int variableColumnLength = headers.length - 4;
            Map<String, Object> sourceDataMap;
            while(
                    (sourceDataMap =
                            mapReader.read(headers,
                                    buildProcessor(variableColumnLength, headers))) != null) {
                SourceData sourceData = mapToObject(sourceDataMap);
                sourceCodeList.add(sourceData);
            }
        } catch (FileNotFoundException e) {
            System.out.println("SourceCodeCsvReader Could not locate file: "+ e);
        } catch (IOException e) {
            System.out.println("SourceCodeCsvReader failed with IOException: "+ e);
        }
        return sourceCodeList;
    }

    public SourceData mapToObject(Map<String, Object> map) {
        SourceData sourceData = new SourceData();
        sourceData.setSourceName(map.remove("SourceName").toString());
        sourceData.setSourceCode(map.remove("SourceCode").toString());
        sourceData.setRecordFrequency(map.remove("RecordFrequency").toString());
        sourceData.setSourceAutoAssignedConceptIds((Set<String>)map.remove("ConceptIDs"));

        List<Pair<String, String>> additionalSourceInfo = new ArrayList<>();
        map.forEach((k,v) -> additionalSourceInfo.add((Pair)v));
        sourceData.setAdditionalSourceInfo(additionalSourceInfo);
        return sourceData;
    }

    /*
    public List<SourceData> read(String fileName) {

        List<SourceData> sourceCodeList = new ArrayList<>();
        try {
            String[] headers;
            ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(fileName), csvPreference);

            //ICsvListReader listReader = new CsvListReader(new FileReader(fileName), csvPreference);
            headers = beanReader.getHeader(true);
            int variableColumnLength = headers.length - 4;
            SourceData sourceData;
            while(
                    (sourceData =
                            beanReader.read(SourceData.class,
                                    headers,
                                    buildProcessor(variableColumnLength, headers))) != null) {
                sourceCodeList.add(sourceData);
            }
        } catch (FileNotFoundException e) {
            System.out.println("SourceCodeCsvReader Could not locate file: "+ e);
        } catch (IOException e) {
            System.out.println("SourceCodeCsvReader failed with IOException: "+ e);
        }
        return sourceCodeList;
    }
    */

    private CellProcessor[] buildProcessor(int variableColumnLength, String[] headers) {
        List<CellProcessor> cellProcessorsList = new ArrayList<>();
        cellProcessorsList.add(new StrNotNullOrEmpty());
        cellProcessorsList.add(new StrNotNullOrEmpty());
        cellProcessorsList.add(new NotNull());
        cellProcessorsList.add(new StringSplitter(sourceConceptIds, ";"));
        for(int i = 0; i < variableColumnLength; i++) {
            cellProcessorsList.add(new FmtPair(headers[i+4]));
        }

        int size = cellProcessorsList.size();
        CellProcessor[] cellProcessors = new CellProcessor[size];
        for(int i = 0; i< size; i++) {
            cellProcessors[i] = cellProcessorsList.get(i);
        }
        return cellProcessors;
    }
}