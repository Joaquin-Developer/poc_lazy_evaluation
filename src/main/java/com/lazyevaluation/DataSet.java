package com.lazyevaluation;

import com.lazyevaluation.Row;
import com.lazyevaluation.Schema;
import com.lazyevaluation.LazyEvaluationExecutionsOrchestrator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class DataSet {
    private List<Row> dataSet;
    private Schema schema;
    private LazyEvaluationExecutionsOrchestrator orchestrator = null;

    public DataSet(Schema schema) {
        this.dataSet = new ArrayList<>();
        this.schema = schema;
        this.orchestrator = LazyEvaluationExecutionsOrchestrator.getInstance();
    }

    public List<Row> getData() {
        return this.dataSet;
    }

    public void createDataSet(Object[][] data, String path) {
        if (data != null)
            orchestrator.transformation(() -> this.createDataSetTransformation(data));
        else
            orchestrator.transformation(() -> this.createDataSetByFileTransformation(path));

    }

    private void createDataSetTransformation(Object[][] data) {
        for (Object[] dataRow : data) {
            Row row = new Row(schema);

            for (int index = 0; index < dataRow.length; index++) {
                row.setValue(index, dataRow[index]);
            }
            dataSet.add(row);
        }
        System.out.println("createDataSetLazyLoad");
    }

    private void createDataSetByFileTransformation(String path) {
        // crea el dataSet leyendo un archivo
        // similar al spark.read()
    }

    public void filter(Predicate<Row> condition) {
        orchestrator.transformation(() -> this.filterTransformation(condition));
    }

    private void filterTransformation(Predicate<Row> condition) {
        Iterator<Row> iterator = dataSet.iterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (!condition.test(row)) {
                iterator.remove();
            }
        }
        System.out.println("filterLazyLoad");
    }

    public void show() {
        orchestrator.action(() -> showAction());
    }

    private void showAction() {
        for (Row row : this.getData()) {
            String str = "";

            for (int index = 0; index < row.getSizeValues(); index++) {
                str += row.getValue(index).toString() + "   ";
            }
            System.out.println(str);
        }
    }

}
