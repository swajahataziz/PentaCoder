package com.averros.data.codemapper.reader;

import com.averros.data.codemapper.model.SourceData;
import com.averros.data.codemapper.readers.SourceCodeCsvReader;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
public class SourceCodingSystemReaderTest {

    @Test
    public void readVariableCsvTest() {

        String fileName = "/Users/wajahat/test.csv";
        SourceCodeCsvReader sourceCodeReader = new SourceCodeCsvReader(',');
        List<SourceData> sourceDataList = sourceCodeReader.read(fileName);
        Assert.assertNotNull(sourceCodeReader);

        SourceData sourceData = new SourceData();
        sourceData.sourceName = "test";
        sourceData.sourceCode = "ICD-10";
        sourceData.sourceAutoAssignedConceptIds = new HashSet<String>();
        sourceData.sourceAutoAssignedConceptIds.add("12");
        sourceData.sourceAutoAssignedConceptIds.add("14");
        sourceData.recordFrequency = "10";
        sourceData.additionalSourceInfo = new ArrayList<>();
        Pair<String, String> additionalInfo = Pair.of("strength", "high");
        sourceData.additionalSourceInfo.add(additionalInfo);

        Assert.assertEquals(sourceData,sourceDataList.get(0));
    }
}
