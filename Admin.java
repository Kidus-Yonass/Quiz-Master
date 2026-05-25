/**
 * Represents an administrator account. Milestone A validates login credentials;
 * later milestones can connect these methods to a full CRUD screen.
 */
public class Admin extends User {
    private String username;
    private String password;

    public Admin(String username, String password) {
        super(username);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(FileHandler fileHandler) {
        return fileHandler.authenticateAdmin(username, password);
    }

    public Question[] addQuestion(FileHandler fileHandler, Question question) {
        Question[] questions = fileHandler.readQuestions();
        Question[] updated = new Question[questions.length + 1];

        for (int i = 0; i < questions.length; i++) {
            updated[i] = questions[i];
        }
        updated[updated.length - 1] = question;
        fileHandler.writeQuestions(updated);
        return updated;
    }

    public Question[] deleteQuestion(FileHandler fileHandler, int id) {
        Question[] questions = fileHandler.readQuestions();
        int keepCount = 0;

        for (int i = 0; i < questions.length; i++) {
            if (questions[i].getId() != id) {
                keepCount++;
            }
        }

        Question[] updated = new Question[keepCount];
        int index = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i].getId() != id) {
                updated[index] = questions[i];
                index++;
            }
        }

        fileHandler.writeQuestions(updated);
        return updated;
    }

    public Question[] updateQuestion(FileHandler fileHandler, Question updatedQuestion) {
        Question[] questions = fileHandler.readQuestions();

        for (int i = 0; i < questions.length; i++) {
            if (questions[i].getId() == updatedQuestion.getId()) {
                questions[i] = updatedQuestion;
            }
        }

        fileHandler.writeQuestions(questions);
        return questions;
    }
}
