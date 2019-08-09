package vocabulary.enhancer.csv;

import vocabulary.enhancer.data.WordDefinitionPair;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReaderUtil {

    public static WordDefinitionPair getRandomWordAndDefinition() {
        int randomRow = (int)(Math.random()*CSVConstants.NUMBER_OF_ROWS) + 1;

        String line = getLine(randomRow);

        String word = parseCSVForWord(line);
        String definition = parseCSVForDefintion(line);


        return new WordDefinitionPair(word, definition);
    }

    private static String parseCSVForWord(String line) {
        final int START_OF_WORD_INDEX = 0;
        final int END_OF_WORD_INDEX = line.indexOf(CSVConstants.END_OF_WORD);

        String word = line.substring(START_OF_WORD_INDEX, END_OF_WORD_INDEX);

        return word;
    }

    private static String parseCSVForDefintion(String line) {
        final int START_OF_DEFINTION_INDEX = line.indexOf(CSVConstants.END_OF_WORD) + 1;
        final int END_OF_DEFINTION_INDEX = line.indexOf(CSVConstants.END_OF_DEFINITION) + 1;

        String definition = line.substring(START_OF_DEFINTION_INDEX, END_OF_DEFINTION_INDEX);

        return definition;
    }

    private static String getLine(int desiredRow) {
        System.out.println(desiredRow);
        String line = null;
        Scanner vocabTableScanner = getVocabTableScanner();

        for(int currentRow = 0; currentRow < desiredRow; ++currentRow) {
            line = vocabTableScanner.nextLine();
        }

        return line;
    }

    private static Scanner getVocabTableScanner() {
        try {
            return new Scanner(CSVConstants.WORDS_AND_DEFINITIONS);
        } catch (FileNotFoundException e) {
            return null;
        }
    }


}
