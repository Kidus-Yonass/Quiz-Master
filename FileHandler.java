import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private static final String QUESTION_FILE = "question.txt";
    private static final String SCORE_FILE = "scores.txt";

    // save score to file
    public static void saveScore(String name, int score, String grade, String date) {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(SCORE_FILE, true));
            pw.println(name + "," + score + "," + grade + "," + date);
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving score");
        }
    }

    // load all scores
    public static ArrayList<User> loadScores() {

        ArrayList<User> users = new ArrayList<>();

        try {

            File file = new File(SCORE_FILE);
            if (!file.exists()) return users;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String[] data = sc.nextLine().split(",");

                if (data.length == 4) {
                    users.add(new User(data[0], Integer.parseInt(data[1]), data[2], data[3]));
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error loading scores");
        }

        return users;
    }



    public static ArrayList<Question> loadQuestions() {
        ArrayList<Question> questions = new ArrayList<>();

        try {

            File file = new File(QUESTION_FILE);
            if (!file.exists()) return questions;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String[] data = sc.nextLine().split(",");

                if (data.length == 8) {
                    questions.add(new Question(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7] ));
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error loading scores");
        }

        return questions;
    }


    public static void saveQuestions(ArrayList<Question> questions) {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(QUESTION_FILE, false));
            for (Question q : questions) {
                pw.println(q.toString());
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving questions");
        }
    }
}