package com.lazyevaluation;

import com.lazyevaluation.Schema;

public class Row {
    private Object[] values;
    private Schema schema;

    public Row(Schema schema) {
        this.values = new Object[schema.size()];
        this.schema = schema;
    }

    public void setValue(int index, Object value) {
        values[index] = value;
    }

    public Object getValue(int index) {
        return values[index];
    }

    public Object getValues() {
        return this.values;
    }

    public int getSizeValues() {
        return this.values.length;
    }

    public Schema getSchema() {
        return this.schema;
    }
}
