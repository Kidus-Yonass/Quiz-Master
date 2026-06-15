import java.util.ArrayList;

public class Sort {
    private static int difficultyRank(String d) {
        if (d.equals("Easy")) return 1;
        if (d.equals("Medium")) return 2;
        return 3;
    }

    public static void sortQuestionsByDifficulty(ArrayList<Question> questions) {
        int n = questions.size();

        for(int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (difficultyRank(questions.get(j).getDifficulty()) > difficultyRank(questions.get(j+1).getDifficulty())) {
                    Question temp = questions.get(j);
                    questions.set(j, questions.get(j + 1));
                    questions.set(j + 1, temp);
                }
            }
        }
    }

    public static void sortQuestionsByGenre(ArrayList<Question> questions) {
        int n = questions.size();

        for(int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (questions.get(j).getGenre().compareTo(questions.get(j + 1).getGenre()) > 0) {
                    Question temp = questions.get(j);
                    questions.set(j, questions.get(j + 1));
                    questions.set(j + 1, temp);
                }
            }
        }
    }
}
