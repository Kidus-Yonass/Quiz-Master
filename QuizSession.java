//Filename: QuizSession.java
//Authors: Andy, Kidus
//Date Created: May 2026
//Purpose: Manages the quiz logic - tracks current question, score, and answer checking.

import java.util.ArrayList;

public class QuizSession {

    private ArrayList<Question> questions;
    private int currentIndex;
    private int score;
    private String genre;

    public QuizSession(String genre, ArrayList<Question> questions) {
        this.genre = genre;
        this.questions = questions;
        this.currentIndex = 0;
        this.score = 0;
    }

    //Returns the current question
    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    //Moves to the next question
    public void nextQuestion() {
        currentIndex++;
    }

    //Returns true if there are more questions left
    public boolean hasNextQuestion() {
        return currentIndex < questions.size() - 1;
    }

    //Checks if the given answer is correct and increments score if so
    public boolean submitAnswer(String answer) {
        boolean correct = answer.equalsIgnoreCase(getCurrentQuestion().getCorrectAnswer());
        if (correct) score++;
        return correct;
    }

    public int getScore() { return score; }
    public String getGenre() { return genre; }
    public int getCurrentIndex() { return currentIndex; }
    public int getTotalQuestions() { return questions.size(); }

    //Calculates and returns the letter grade based on score
    public String calculateGrade() {
        int percentage = (int) Math.round((score * 100.0) / questions.size());
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }

    //Returns a message based on the grade
    public String getGradeMessage() {
        String grade = calculateGrade();
        if (grade.equals("A+")) return "Outstanding Performance!";
        if (grade.equals("A"))  return "Excellent Work!";
        if (grade.equals("B"))  return "Great Job!";
        if (grade.equals("C"))  return "Good Effort!";
        if (grade.equals("D"))  return "Keep Practicing!";
        return "Better Luck Next Time!";
    }
}
