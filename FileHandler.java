import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles all external text files used by Quiz Master.
 */
public class FileHandler {
    private String questionsFile;
    private String scoresFile;
    private String usersFile;

    public FileHandler(String questionsFile, String scoresFile, String usersFile) {
        this.questionsFile = questionsFile;
        this.scoresFile = scoresFile;
        this.usersFile = usersFile;
    }

    public String getQuestionsFile() {
        return questionsFile;
    }

    public String getScoresFile() {
        return scoresFile;
    }

    public String getUsersFile() {
        return usersFile;
    }

    public void ensureDataFilesExist() {
        ensureParentFolder(questionsFile);
        ensureParentFolder(scoresFile);
        ensureParentFolder(usersFile);

        createFileIfMissing(questionsFile);
        createFileIfMissing(scoresFile);
        createFileIfMissing(usersFile);
    }

    public Question[] readQuestions() {
        ensureDataFilesExist();
        ArrayList<Question> questions = new ArrayList<Question>();

        try (BufferedReader reader = new BufferedReader(new FileReader(questionsFile))) {
            String line = reader.readLine();
            while (line != null) {
                Question question = parseQuestion(line);
                if (question != null) {
                    questions.add(question);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Could not read questions file: " + e.getMessage());
        }

        return questions.toArray(new Question[questions.size()]);
    }

    public void writeQuestions(Question[] questions) {
        ensureDataFilesExist();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(questionsFile))) {
            for (int i = 0; i < questions.length; i++) {
                writer.write(questions[i].toFileLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write questions file: " + e.getMessage());
        }
    }

    public User[] readScores() {
        ensureDataFilesExist();
        ArrayList<User> users = new ArrayList<User>();

        try (BufferedReader reader = new BufferedReader(new FileReader(scoresFile))) {
            String line = reader.readLine();
            while (line != null) {
                User user = parseScore(line);
                if (user != null) {
                    users.add(user);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Could not read scores file: " + e.getMessage());
        }

        return users.toArray(new User[users.size()]);
    }

    public void writeScores(User[] users) {
        ensureDataFilesExist();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scoresFile))) {
            for (int i = 0; i < users.length; i++) {
                writer.write(users[i].toFileLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write scores file: " + e.getMessage());
        }
    }

    public String[][] readUsers() {
        ensureDataFilesExist();
        ArrayList<String[]> users = new ArrayList<String[]>();

        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line = reader.readLine();
            while (line != null) {
                if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 3) {
                        users.add(new String[] {parts[0].trim(), parts[1].trim(), parts[2].trim()});
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Could not read users file: " + e.getMessage());
        }

        return users.toArray(new String[users.size()][]);
    }

    public void writeUsers(String[][] users) {
        ensureDataFilesExist();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
            for (int i = 0; i < users.length; i++) {
                writer.write(users[i][0] + "|" + users[i][1] + "|" + users[i][2]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write users file: " + e.getMessage());
        }
    }

    public boolean authenticateAdmin(String username, String password) {
        String[][] users = readUsers();

        for (int i = 0; i < users.length; i++) {
            boolean usernameMatches = users[i][0].equalsIgnoreCase(username);
            boolean passwordMatches = users[i][1].equals(password);
            boolean isAdmin = users[i][2].equalsIgnoreCase("admin");

            if (usernameMatches && passwordMatches && isAdmin) {
                return true;
            }
        }
        return false;
    }

    private Question parseQuestion(String line) {
        if (line.trim().isEmpty() || line.trim().startsWith("#")) {
            return null;
        }

        String[] parts = line.split("\\|");
        if (parts.length != 9) {
            System.out.println("Skipping invalid question line: " + line);
            return null;
        }

        try {
            int id = Integer.parseInt(parts[0].trim());
            char answer = parts[7].trim().charAt(0);
            return new Question(
                    id,
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim(),
                    parts[4].trim(),
                    parts[5].trim(),
                    parts[6].trim(),
                    answer,
                    parts[8].trim());
        } catch (NumberFormatException e) {
            System.out.println("Skipping question with invalid id: " + line);
            return null;
        }
    }

    private User parseScore(String line) {
        if (line.trim().isEmpty() || line.trim().startsWith("#")) {
            return null;
        }

        String[] parts = line.split("\\|");
        if (parts.length != 4) {
            System.out.println("Skipping invalid score line: " + line);
            return null;
        }

        try {
            int score = Integer.parseInt(parts[1].trim());
            return new User(parts[0].trim(), score, parts[2].trim(), parts[3].trim());
        } catch (NumberFormatException e) {
            System.out.println("Skipping score with invalid value: " + line);
            return null;
        }
    }

    private void ensureParentFolder(String path) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
    }

    private void createFileIfMissing(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Could not create file " + path + ": " + e.getMessage());
            }
        }
    }
}
