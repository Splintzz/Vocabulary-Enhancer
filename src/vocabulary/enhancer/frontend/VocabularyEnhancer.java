package vocabulary.enhancer.frontend;

import vocabulary.enhancer.database.DatabaseFetcher;
import javax.swing.*;   //TODO:fix

public class VocabularyEnhancer {
    private JLabel defintionDisplay;
    private JButton[] answerChoices;
    private JPanel answersDisplay;
    private String currentCorrectAnswer;
    private DatabaseFetcher databaseFetcher;

    public VocabularyEnhancer() {
        defintionDisplay = new JLabel();
        answerChoices = new JButton[VocabularyEnhancerConstants.NUMBER_OF_ANSWER_CHOICES];
        answersDisplay = new JPanel();

        setUpDisplayComponents();
    }

    private void setUpDisplayComponents() {
        setCurrentCorrectAnswer();
        setUpDefinitionDisplay();
        setUpAnswerChoices();
    }

    private void setCurrentCorrectAnswer() {
        //currentCorrectAnswer = databaseFetcher.fetchRandomWord();
    }

    private void setUpDefinitionDisplay() {
        //String definition = databaseFetcher.getDefinitionForWord(currentCorrectAnswer);

        //defintionDisplay.setText(definition);
    }

    private void setUpAnswerChoices() {
        //String[] answers = databaseFetcher.getAnswerChoices(
           //currentCorrectAnswer, VocabularyEnhancerConstants.NUMBER_OF_ANSWER_CHOICES);
    }



}
