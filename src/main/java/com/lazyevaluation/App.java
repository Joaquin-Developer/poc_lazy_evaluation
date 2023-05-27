package com.lazyevaluation;

import com.lazyevaluation.QueueExecutions;
import com.lazyevaluation.DataSet;
import java.util.List;

public class App {

    public static void main(String[] args) {
        DataSet ds = new DataSet(new Schema(List.of("nombre", "edad")));

        Object[][] data = {
                { "Juan", 21, },
                { "Sofía", 28, },
                { "Pedro", 25, },
                { "Ana", 33, }
        };

        // creo el dataset
        System.out.println("Creando dataSet...");
        ds.createDataSet(data, null);

        // aplico una transformacion
        System.out.println("Aplico un filtro al dataset...");
        ds.filter(row -> (Integer) row.getValue(1) > 25);

        // llamo al método show que es una acción
        // acá recien voy a necesitar realmente los datos
        System.out.println("Show del dataset...");
        ds.show();
    }
}
