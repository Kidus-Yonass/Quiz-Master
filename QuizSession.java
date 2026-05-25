/**
 * Tracks a basic quiz session. Milestone A uses this class to filter questions
 * by genre and prepare the quiz flow for Milestone B.
 */
public class QuizSession {
    private Question[] allQuestions;
    private Question[] questions;
    private int currentIndex;
    private int score;
    private String genre;
    private int timeLimit;

    public QuizSession(Question[] questions) {
        this.allQuestions = questions;
        this.questions = questions;
        this.currentIndex = 0;
        this.score = 0;
        this.genre = "All";
        this.timeLimit = 0;
    }

    public void startQuiz(String genre) {
        this.genre = genre;
        this.questions = filterByGenre(genre);
        this.currentIndex = 0;
        this.score = 0;
    }

    public Question getCurrentQuestion() {
        if (currentIndex < 0 || currentIndex >= questions.length) {
            return null;
        }
        return questions[currentIndex];
    }

    public Question nextQuestion() {
        currentIndex++;
        return getCurrentQuestion();
    }

    public boolean submitAnswer(char answer) {
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion == null) {
            return false;
        }

        boolean correct = currentQuestion.isCorrect(answer);
        if (correct) {
            score++;
        }
        return correct;
    }

    public User endQuiz(String playerName) {
        User user = new User(playerName, score, "N/A", java.time.LocalDate.now().toString());
        user.calculateGrade(questions.length);
        return user;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getScore() {
        return score;
    }

    public String getGenre() {
        return genre;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    private Question[] filterByGenre(String genre) {
        int count = 0;
        for (int i = 0; i < allQuestions.length; i++) {
            if (allQuestions[i].getGenre().equalsIgnoreCase(genre)) {
                count++;
            }
        }

        Question[] filtered = new Question[count];
        int index = 0;
        for (int i = 0; i < allQuestions.length; i++) {
            if (allQuestions[i].getGenre().equalsIgnoreCase(genre)) {
                filtered[index] = allQuestions[i];
                index++;
            }
        }
        return filtered;
    }
}
