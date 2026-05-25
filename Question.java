/**
 * Represents one multiple-choice quiz question.
 */
public class Question {
    private int id;
    private String genre;
    private String questionText;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private char correctAnswer;
    private String difficulty;

    public Question(int id, String genre, String questionText, String optA, String optB,
                    String optC, String optD, char correctAnswer, String difficulty) {
        this.id = id;
        this.genre = genre;
        this.questionText = questionText;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.correctAnswer = Character.toUpperCase(correctAnswer);
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(char correctAnswer) {
        this.correctAnswer = Character.toUpperCase(correctAnswer);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }

    public String toFileLine() {
        return id + "|" + genre + "|" + questionText + "|" + optA + "|" + optB + "|"
                + optC + "|" + optD + "|" + correctAnswer + "|" + difficulty;
    }

    public String toString() {
        return "[" + id + "] " + genre + " - " + questionText + " (Answer: " + correctAnswer + ")";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Question)) {
            return false;
        }
        Question other = (Question) obj;
        return id == other.id;
    }

    public int hashCode() {
        return id;
    }
}
