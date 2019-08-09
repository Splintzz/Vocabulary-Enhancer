package vocabulary.enhancer.database;

import vocabulary.enhancer.csv.CSVReaderUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseFetcher {
    public static void main(String[] args) {
        CSVReaderUtil.getRandomWordAndDefintion();
    }
}
