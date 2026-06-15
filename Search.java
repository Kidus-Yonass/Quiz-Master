import java.util.ArrayList;

public class Search {
    public static ArrayList<User> searchByName(ArrayList<User> users, String name) {
    ArrayList<User> results = new ArrayList<>();
    for (User u : users) {
        if (u.getName().equalsIgnoreCase(name)) {
            results.add(u);
        }
    }
        return results;
    }


    public static ArrayList<Question>searchByGenre(ArrayList<Question> questions, String genre) {
        ArrayList<Question> results = new ArrayList<>();
        for (Question u : questions) {
            if (u.getGenre().equalsIgnoreCase(genre)) {
                results.add(u);
            }
    }
        return results;
    }

    public static ArrayList<Question> searchByDifficulty (ArrayList<Question> questions, String difficulty) {
        ArrayList<Question> results = new ArrayList<>();
        for (Question u : questions) {
            if (u.getDifficulty().equalsIgnoreCase(difficulty)) {
                results.add(u);
            }
    }
            return results;
    }
}