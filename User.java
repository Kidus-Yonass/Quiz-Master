import java.time.LocalDate;

public class User {
    private String name;
    private int score;
    private String grade;
    private String date;

    public User(String name, int score, String grade, String date) {
        this.name = name;
        this.score = score;
        this.grade = grade;
        this.date = LocalDate.now().toString();
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
}
