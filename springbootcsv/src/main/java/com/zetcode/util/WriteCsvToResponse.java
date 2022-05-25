package com.zetcode.util;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.zetcode.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

public class WriteCsvToResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

    public static void writeCities(PrintWriter writer, List<City> cities) {

        try {

            var builder = getStatefulBean(writer);
            builder.write(cities);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    public static void writeCity(PrintWriter writer, City city) {

        try {

            var builder = getStatefulBean(writer);
            builder.write(city);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    private static StatefulBeanToCsv<City> getStatefulBean(PrintWriter writer) {

        ColumnPositionMappingStrategy<City> mapStrategy
                = new ColumnPositionMappingStrategy<>();

        mapStrategy.setType(City.class);

        String[] columns = new String[]{"id", "name", "population"};
        mapStrategy.setColumnMapping(columns);

        StatefulBeanToCsv<City> builder = new StatefulBeanToCsvBuilder<City>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withMappingStrategy(mapStrategy)
                .withSeparator(',')
                .build();

        return builder;
    }
}