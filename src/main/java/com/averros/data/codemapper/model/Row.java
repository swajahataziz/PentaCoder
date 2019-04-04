package com.averros.data.codemapper.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Row {
    private List<String> cells;
    private Columns columns;

    public Row() {
        cells = new ArrayList<>();
        columns = new Columns();
    }

    public Row(List<String> cells, Columns columns) {
        this.cells = cells;
        this.columns = columns;
    }

    public String getCellByName(String fieldName) {

        int index;
        try {
            index = columns.getColumnName2Index().get(fieldName);
        } catch (NullPointerException e) {
            throw new RuntimeException("Field \"" + fieldName + "\" not found");
        }
        if (cells.size() <= index) {
            return "";
        } else return cells.get(index);
    }

    public List<String> getFieldNames() {
        List<String> names = new ArrayList<>(columns.getColumnSize());
        for (Map.Entry<String,Integer> entry: columns.getColumnName2Index().entrySet()) {
            names.set(entry.getValue(), entry.getKey());
        }
        return names;
    }
}
