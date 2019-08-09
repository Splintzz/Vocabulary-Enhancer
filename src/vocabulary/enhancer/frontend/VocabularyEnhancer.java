package vocabulary.enhancer.frontend;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import vocabulary.enhancer.csv.CSVReaderUtil;
import vocabulary.enhancer.data.WordDefinitionPair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//TODO: Set up score counter on UI and clean up UI
public class VocabularyEnhancer extends JFrame {
    private JLabel definitionDisplay;
    private List<JButton> answerChoices;
    private JPanel answersDisplay;
    private String currentCorrectAnswer;
    private int score;

    public VocabularyEnhancer() {
        definitionDisplay = new JLabel();
        answerChoices = new ArrayList<>(VocabularyEnhancerConstants.NUMBER_OF_ANSWER_CHOICES);
        answersDisplay = new JPanel();
        score = 0;

        setUp();
    }

    private void setUp() {
        setUpButtons();
        setUpNextRound();
        setUpDisplay();
    }

    private void setUpDisplay() {
        setVisible(true);
        setResizable(true);
        setSize(VocabularyEnhancerConstants.JFRAME_DIMENSION);
        add(answersDisplay);
    }

    private void setUpNextRound() {
        WordDefinitionPair nextWordAndDefinition = CSVReaderUtil.getRandomWordAndDefinition();

        String word = nextWordAndDefinition.getWord();
        String definition = nextWordAndDefinition.getDefinition();

        currentCorrectAnswer = word;
        definitionDisplay.setText(definition);

        setUpAnswerChoices(nextWordAndDefinition);
    }

    private void setUpAnswerChoices(WordDefinitionPair nextWordAndDefinition) {
        List<String> answerChoices = CSVReaderUtil.getAnswerChoices(nextWordAndDefinition);

        answersDisplay.add(definitionDisplay);

        int choice = 0;
        for(String answerChoice : answerChoices) {
            this.answerChoices.get(choice).setText(answerChoice);
            answersDisplay.add(this.answerChoices.get(choice));
            ++choice;
        }
    }

    private void setUpButtons() {
        for(int button = 0; button < VocabularyEnhancerConstants.NUMBER_OF_ANSWER_CHOICES; ++button) {
            this.answerChoices.add(new JButton());
            this.answerChoices.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer(((JButton) e.getSource()).getText());
                }
            });
        }
    }

    private void checkAnswer(String chosenAnswer) {
        boolean theCorrectAnswerWasChosen = chosenAnswer.equals(currentCorrectAnswer);

        if(theCorrectAnswerWasChosen) {
            ++score;
        }

        setUpNextRound();
    }
}
