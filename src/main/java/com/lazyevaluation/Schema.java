package com.lazyevaluation;

import java.util.List;

public class Schema {
    private List<String> fields;

    public Schema(List<String> fields) {
        this.fields = fields;
    }

    public int size() {
        return fields.size();
    }

    public String getFieldNameByIndex(int index) {
        return fields.get(index);
    }

}
