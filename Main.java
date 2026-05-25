/**
 * Entry point for the Quiz Master application.
 *
 * Milestone A supports both a Swing GUI and a small console check. Run with
 * "--console" to prove that questions are loading from the external text file.
 */
public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("data/questions.txt", "data/scores.txt", "data/users.txt");
        fileHandler.ensureDataFilesExist();

        if (args.length > 0 && args[0].equalsIgnoreCase("--console")) {
            runConsolePreview(fileHandler);
            return;
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                QuizMasterApp app = new QuizMasterApp(fileHandler);
                app.initGUI();
            }
        });
    }

    private static void runConsolePreview(FileHandler fileHandler) {
        Question[] questions = fileHandler.readQuestions();
        System.out.println("Quiz Master - Milestone A Console Preview");
        System.out.println("Loaded questions: " + questions.length);
        System.out.println();

        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
        }
    }
}
