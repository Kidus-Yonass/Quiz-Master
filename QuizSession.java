import java.util.ArrayList;

public class QuizSession {

    private String username;
    private String genre;

    private ArrayList<Question> questions;
    private int index;
    private int score;

    public QuizSession(String username, String genre) {

        this.username = username;
        this.genre = genre;

        questions = new ArrayList<>();
        index = 0;
        score = 0;

        loadQuestions();
    }

   
    private void loadQuestions() {

        ArrayList<Question> allQuestions =
                FileHandler.loadQuestions();

        for (Question q : allQuestions) {

            if (q.getGenre().equalsIgnoreCase(genre)) {
                questions.add(q);
            }
        }
    }

    
    public Question getCurrentQuestion() {

        if (isFinished()) {
            return null;
        }

        return questions.get(index);
    }

    
    public void answer(char selectedAnswer) {

        if (isFinished()) {
            return;
        }

        if (getCurrentQuestion().isCorrect(selectedAnswer)) {
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


    public int getTotalQuestions() {
        return questions.size();
    }


    public int getCurrentQuestionNumber() {
        return index + 1;
    }

  
    public String getUsername() {
        return username;
    }

   
    public String getGenre() {
        return genre;
    }
}