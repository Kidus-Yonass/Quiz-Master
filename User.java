import java.time.LocalDate;

/**
 * Stores a quiz player's score information for the leaderboard.
 */
public class User {
    private String name;
    private int score;
    private String grade;
    private String date;

    public User(String name) {
        this(name, 0, "N/A", LocalDate.now().toString());
    }

    public User(String name, int score, String grade, String date) {
        this.name = name;
        this.score = score;
        this.grade = grade;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String calculateGrade(int totalQuestions) {
        if (totalQuestions <= 0) {
            grade = "N/A";
            return grade;
        }

        int percentage = (int) Math.round((score * 100.0) / totalQuestions);
        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }

    public String calculateGrade() {
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }

    public String toFileLine() {
        return name + "|" + score + "|" + grade + "|" + date;
    }

    public String toString() {
        return name + " - Score: " + score + ", Grade: " + grade + ", Date: " + date;
    }
}
