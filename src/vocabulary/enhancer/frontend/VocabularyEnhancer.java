package vocabulary.enhancer.frontend;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import vocabulary.enhancer.csv.CSVReaderUtil;
import vocabulary.enhancer.data.WordDefinitionPair;
import java.util.List;

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
    }


    private void setUpNextRound() {
        WordDefinitionPair nextWordAndDefinition = CSVReaderUtil.getRandomWordAndDefinition();

        String word = nextWordAndDefinition.getWord();
        String definition = nextWordAndDefinition.getDefinition();

        System.out.println(word);
        System.out.println(definition);
        System.out.println();

        setUpAnswerChoices(nextWordAndDefinition);

        currentCorrectAnswer = word;
        defintionDisplay.setText(definition);
    }

    private void setUpAnswerChoices(WordDefinitionPair nextWordAndDefinition) {
        List<String> answerChoice = CSVReaderUtil.getAnswerChoices(nextWordAndDefinition);

        for(String e : answerChoice) {
            System.out.println(e);
        }
    }
}
