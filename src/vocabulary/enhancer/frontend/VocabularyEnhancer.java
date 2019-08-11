package vocabulary.enhancer.frontend;

import vocabulary.enhancer.csv.CSVReaderUtil;
import vocabulary.enhancer.data.WordDefinitionPair;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

public class VocabularyEnhancer extends JFrame {
    private JLabel definitionDisplay;
    private List<JButton> answerChoices;
    private JButton scoreboard;
    private JPanel displayPanel, definitionDisplayPanel, answerChoicesDisplayPanel, scoreDisplayPanel;
    private String currentCorrectAnswer;
    private int score, roundsPlayed;

    public VocabularyEnhancer() {
        definitionDisplay = new JLabel();
        answerChoices = new ArrayList<>(VocabularyEnhancerConstants.NUMBER_OF_ANSWER_CHOICES);

        scoreboard = new JButton();

        displayPanel = new JPanel();
        definitionDisplayPanel = new JPanel();
        answerChoicesDisplayPanel = new JPanel();
        scoreDisplayPanel = new JPanel();

        score = 0;

        setUp();
    }

    private void setUp() {
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        setUpButtons();
        setUpNextRound();
        setUpDisplay();
        setUpScoreDisplay();

        displayPanel.add(definitionDisplayPanel);
        displayPanel.add(answerChoicesDisplayPanel);
        displayPanel.add(scoreDisplayPanel);
    }

    private void setUpScoreDisplay() {
        scoreDisplayPanel.setLayout(new GridLayout(
            VocabularyEnhancerConstants.NUMBER_OF_ROWS_FOR_SCORE_LAYOUT, VocabularyEnhancerConstants.NUMBER_OF_COLUMNS_FOR_SCORE_LAYOUT));

        scoreboard.setText(getScoreDisplay());
        scoreboard.setOpaque(true);

        scoreDisplayPanel.add(scoreboard);
    }

    private void setUpDisplay() {
        setVisible(true);
        setResizable(true);
        setSize(VocabularyEnhancerConstants.JFRAME_DIMENSION);
        add(displayPanel);
    }

    private void setUpNextRound() {
        WordDefinitionPair nextWordAndDefinition = CSVReaderUtil.getRandomWordAndDefinition();

        String word = nextWordAndDefinition.getWord();
        String definition = nextWordAndDefinition.getDefinition();

        currentCorrectAnswer = word;
        definitionDisplay.setText(definition);
        definitionDisplayPanel.add(definitionDisplay);

        setUpAnswerChoices(nextWordAndDefinition);
    }

    private void setUpAnswerChoices(WordDefinitionPair nextWordAndDefinition) {
        answerChoicesDisplayPanel.setLayout(new GridLayout(
            VocabularyEnhancerConstants.NUMBER_OF_ROWS_FOR_BUTTON_LAYOUT, VocabularyEnhancerConstants.NUMBER_OF_COLUMNS_FOR_BUTTON_LAYOUT));

        List<String> answerChoices = CSVReaderUtil.getAnswerChoices(nextWordAndDefinition);

        int choice = 0;
        for(String answerChoice : answerChoices) {
            this.answerChoices.get(choice).setText(answerChoice);
            answerChoicesDisplayPanel.add(this.answerChoices.get(choice));
            ++choice;
        }
    }

    private void setUpButtons() {
        for(int button = 0; button < VocabularyEnhancerConstants.NUMBER_OF_ANSWER_CHOICES; ++button) {
            this.answerChoices.add(new JButton());
            this.answerChoices.get(button).addActionListener(e -> checkAnswer(((JButton) e.getSource()).getText()));
        }
    }

    private void checkAnswer(String chosenAnswer) {
        boolean theCorrectAnswerWasChosen = chosenAnswer.equals(currentCorrectAnswer);

        ++roundsPlayed;

        if(theCorrectAnswerWasChosen) {
            ++score;
            scoreboard.setBackground(Color.GREEN);
        }else {
            scoreboard.setBackground(Color.RED);
        }

        scoreboard.setText(getScoreDisplay());
        setUpNextRound();
    }

    private String getScoreDisplay() {
        boolean atLeastOneRoundHasBeenPlayed = (roundsPlayed != 0);

        double scorePercentage =
            ( (atLeastOneRoundHasBeenPlayed) ? (((double)score) / roundsPlayed * 100) : (0.00) );

        String scoreDisplay =
            (score + "/" + roundsPlayed)
                + (" (" +VocabularyEnhancerConstants.decimalFormatter.format(scorePercentage) + "%)");

        return scoreDisplay;
    }
}
