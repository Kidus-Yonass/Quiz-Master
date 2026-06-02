import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private static final String SCORE_FILE = "scores.txt";

    // save score to file
    public static void saveScore(String name, int score) {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(SCORE_FILE, true));
            pw.println(name + "," + score);
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

                if (data.length == 2) {
                    users.add(new User(data[0], Integer.parseInt(data[1])));
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error loading scores");
        }

        return users;
    }
}