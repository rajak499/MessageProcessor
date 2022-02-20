package com.rishabh.generic;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.rishabh.modal.MessageProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

public class WriteCsv {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsv.class);

    public static void writeTransactions(PrintWriter writer, List<MessageProcessor> transactions) {

        try {

            ColumnPositionMappingStrategy<MessageProcessor> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(MessageProcessor.class);

            String[] columns = new String[]{"transactionId", "clientId", "transactionType","transactionDate","notional","sourceSystem","priorityFlag"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<MessageProcessor> btcsv = new StatefulBeanToCsvBuilder<MessageProcessor>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(transactions);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    public static void writeTransactions(PrintWriter writer, MessageProcessor MessageProcessor) {

        try {

            ColumnPositionMappingStrategy<MessageProcessor> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(MessageProcessor.class);

            String[] columns = new String[]{"TransactionID", "clientId", "transactionType","transactionDate","notional","sourceSystem","priorityFlag"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<MessageProcessor> btcsv = new StatefulBeanToCsvBuilder<MessageProcessor>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(MessageProcessor);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }
}