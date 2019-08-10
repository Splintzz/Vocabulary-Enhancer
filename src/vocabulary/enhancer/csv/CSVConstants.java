package vocabulary.enhancer.csv;

import java.io.File;

public class CSVConstants {

    public final static int NUMBER_OF_ROWS = 10;
    public final static int NUMBER_OF_ANSWER_CHOICES = 8;

    public final static String FILE_DIRECTORY = "src/vocabulary/enhancer/csv/VocabTable.txt";
    public final static String END_OF_WORD = ":";
    public final static String END_OF_DEFINITION = ".";

    public final static File WORDS_AND_DEFINITIONS = new File(FILE_DIRECTORY);
}
