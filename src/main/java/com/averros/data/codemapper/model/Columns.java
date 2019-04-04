package com.averros.data.codemapper.model;

import lombok.Data;

import java.util.Map;

@Data
public class Columns {

    private Map<String, Integer> columnName2Index;
    private int columnSize;
}
