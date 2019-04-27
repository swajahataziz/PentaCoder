package com.averros.data.codemapper.readers.processors;


import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.*;
import org.supercsv.util.CsvContext;

import java.util.Collection;
import java.util.Collections;

public class StringSplitter extends CellProcessorAdaptor implements BoolCellProcessor, DateCellProcessor,
        DoubleCellProcessor, LongCellProcessor, StringCellProcessor {

    private final Collection<String> collection;
    private final String stringSplitter;

    public StringSplitter(final Collection<String> collection, String stringSplitter) {
        super();
        checkPreconditions(collection);
        this.collection = collection;
        this.stringSplitter = stringSplitter;
    }

    private static void checkPreconditions(final Collection<String> collection) {
        if (collection == null) {
            throw new NullPointerException("collection should not be null");
        }
    }

    public Object execute(final Object value, final CsvContext csvContext) {
        validateInputNotNull(value,csvContext);
        Collections.addAll(collection, value.toString().split(stringSplitter));
        return next.execute(collection, csvContext);
    }
}
