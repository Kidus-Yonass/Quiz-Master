//Filename: FileHandler.java
//Author: Andy
//Date Created: May 2026
//Purpose: Handles all reading and writing of external text files (questions.txt, scores.txt, users.txt).

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private static final String QUESTION_FILE = "questions.txt";
    private static final String SCORE_FILE    = "scores.txt";
    private static final String USERS_FILE    = "users.txt";

    //Appends a player's result to scores.txt
    public static void saveScore(String name, int score, String grade, String date) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(SCORE_FILE, true));
            pw.println(name + "," + score + "," + grade + "," + date);
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    //Reads all scores from scores.txt and returns them as an ArrayList of User objects
    public static ArrayList<User> loadScores() {
        ArrayList<User> users = new ArrayList<>();
        try {
            File file = new File(SCORE_FILE);
            if (!file.exists()) return users;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data.length == 4) {
                    users.add(new User(data[0], Integer.parseInt(data[1].trim()), data[2], data[3]));
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading scores: " + e.getMessage());
        }
        return users;
    }

    //Reads all questions from questions.txt and returns them as an ArrayList of Question objects
    public static ArrayList<Question> loadQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            File file = new File(QUESTION_FILE);
            if (!file.exists()) return questions;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length == 8) {
                    questions.add(new Question(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]));
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading questions: " + e.getMessage());
        }
        return questions;
    }

    //Overwrites questions.txt with the updated list of questions
    public static void saveQuestions(ArrayList<Question> questions) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(QUESTION_FILE, false));
            for (Question q : questions) {
                pw.println(q.toString());
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving questions: " + e.getMessage());
        }
    }

    //Reads admin credentials from users.txt and returns them as a 2D String array
    public static String[][] loadUsers() {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            File file = new File(USERS_FILE);
            if (!file.exists()) return new String[0][0];
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    list.add(parts);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return list.toArray(new String[0][0]);
    }
}
