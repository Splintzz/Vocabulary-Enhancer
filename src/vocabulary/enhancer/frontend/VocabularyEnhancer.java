package vocabulary.enhancer.frontend;

import javax.swing.*;   //TODO:fix
import vocabulary.enhancer.csv.CSVReaderUtil;
import vocabulary.enhancer.data.WordDefinitionPair;

public class VocabularyEnhancer {
    private JLabel defintionDisplay;
    private JButton[] answerChoices;
    private JPanel answersDisplay;
    private String currentCorrectAnswer;

    public VocabularyEnhancer() {
        defintionDisplay = new JLabel();
        answerChoices = new JButton[VocabularyEnhancerConstants.NUMBER_OF_ANSWER_CHOICES];
        answersDisplay = new JPanel();

        setUpDisplayComponents();
    }

    private void setUpDisplayComponents() {
        setUpNextRound();
        setUpAnswerChoices();
    }


    private void setUpNextRound() {
        WordDefinitionPair nextWordAndDefinition = CSVReaderUtil.getRandomWordAndDefinition();

        String word = nextWordAndDefinition.getWord();
        String definition = nextWordAndDefinition.getDefinition();

        currentCorrectAnswer = word;
        defintionDisplay.setText(definition);
    }

    private void setUpAnswerChoices() {

    }



}
