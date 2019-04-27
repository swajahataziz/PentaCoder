package com.averros.data.codemapper.service;

import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.ift.CellProcessor;

@Service
public interface CsvProcessor {

    public CellProcessor[] createBeanProcessor();
}
