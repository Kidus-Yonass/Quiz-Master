import java.util.ArrayList;

public class QuizSession {

    private String username;
    private String genre;

    private ArrayList<Question> questions = new ArrayList<>();
    private int index = 0;
    private int score = 0;

    public QuizSession(String username, String genre) {

        this.username = username;
        this.genre = genre;

        loadQuestions();
    }

    // temporary hardcoded questions
    private void loadQuestions() {

        questions.add(new Question(
                "Capital of Canada?",
                new String[]{"Toronto", "Ottawa", "Vancouver", "Montreal"},
                1,
                genre
        ));

        questions.add(new Question(
                "2 + 2 = ?",
                new String[]{"1", "2", "3", "4"},
                3,
                genre
        ));

        questions.add(new Question(
                "Sun rises from?",
                new String[]{"West", "East", "North", "South"},
                1,
                genre
        ));
    }

    public Question getCurrentQuestion() {
        return questions.get(index);
    }

    public void answer(int selected) {

        if (getCurrentQuestion().isCorrect(selected)) {
            score++;
        }

        index++;
    }

    public boolean isFinished() {
        return index >= questions.size();
    }

    public int getScore() {
        return score;
    }
}