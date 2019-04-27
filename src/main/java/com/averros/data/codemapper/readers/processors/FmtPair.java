package com.averros.data.codemapper.readers.processors;

import org.springframework.data.util.Pair;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.*;
import org.supercsv.util.CsvContext;
import java.util.Collections;

public class FmtPair extends CellProcessorAdaptor implements BoolCellProcessor, DateCellProcessor,
        DoubleCellProcessor, LongCellProcessor, StringCellProcessor {

    private final String cellHeader;
    private Pair<String, Object> pair;

    public FmtPair(final String cellHeader) {
        super();
        this.cellHeader = cellHeader;
    }

    private static void checkPreconditions(final String cellHeader) {
        if (cellHeader == null) {
            throw new NullPointerException("collection should not be null");
        }
    }

    public Object execute(final Object value, final CsvContext csvContext) {
        validateInputNotNull(value,csvContext);
        Pair<String, Object> pair = Pair.of(cellHeader, value);
        return next.execute(pair, csvContext);
    }
}
