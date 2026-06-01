import javax.swing.*;
import java.awt.*;

public class WelcomeGenrePanel extends JPanel {

    private CardLayout layout = new CardLayout();

    private JTextField nameField;

    public WelcomeGenrePanel(QuizMaster main) {

        setLayout(layout);

        add(buildWelcome(main), "WELCOME");
        add(buildGenre(main), "GENRE");

        layout.show(this, "WELCOME");
    }

    // ---------------- WELCOME SCREEN ----------------
    private JPanel buildWelcome(QuizMaster main) {

        JPanel p = new JPanel(null);
        p.setBackground(new Color(186, 85, 211));

        JLabel title = new JLabel("QUIZ MASTER");
        title.setBounds(320, 100, 300, 50);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        p.add(title);

        nameField = new JTextField();
        nameField.setBounds(340, 200, 200, 30);
        p.add(nameField);

        JButton start = new JButton("START");
        start.setBounds(370, 260, 120, 40);
        p.add(start);

        JButton help = new JButton("HELP");
        help.setBounds(20, 520, 100, 30);
        p.add(help);

        JButton admin = new JButton("ADMIN");
        admin.setBounds(120, 520, 100, 30);
        p.add(admin);

        start.addActionListener(e -> {

            String name = nameField.getText().trim();

            if (name.isEmpty()) return;

            main.setPlayerName(name);
            layout.show(this, "GENRE");
        });

        help.addActionListener(e -> main.showHelp());
        admin.addActionListener(e -> main.showAdmin());

        return p;
    }

    // ---------------- GENRE SCREEN ----------------
    private JPanel buildGenre(QuizMaster main) {

        JPanel p = new JPanel(new GridLayout(2, 3, 20, 20));
        p.setBackground(new Color(186, 85, 211));
        p.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        String[] genres = {
                "SCIENCE", "HISTORY", "SPORTS",
                "GEOGRAPHY", "MOVIES", "MUSIC"
        };

        for (String g : genres) {

            JButton btn = new JButton(g);

            btn.addActionListener(e -> {

                main.startQuiz(g);
            });

            p.add(btn);
        }

        return p;
    }
}