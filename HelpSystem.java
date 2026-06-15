import java.awt.*;
import javax.swing.*;

public class HelpSystem extends JFrame {

    public HelpSystem() {
        setTitle("Help");
        setSize(520, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color bg = AppColors.BACKGROUND;
        Color dark = AppColors.DARK;
        Color gray = AppColors.GRAY;
        Color purple = AppColors.PURPLE;

        JPanel main = new JPanel();
        main.setBackground(bg);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel title = new JLabel("Help System");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(dark);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        main.add(title);
        main.add(Box.createVerticalStrut(20));

        addSection(main, "How to Play",
                "1. Enter your name\n2. Select a category\n3. Answer questions\n4. View your score",
                purple, dark, gray);

        addSection(main, "Rules",
                "• One answer per question\n• Questions are random",
                purple, dark, gray);

        addSection(main, "Admin",
                "• View questions\n• Add questions\n• Edit questions",
                purple, dark, gray);

        addSection(main, "About",
                "QuizMaster was made for our computer science project.",
                purple, dark, gray);

        add(new JScrollPane(main));
        setVisible(true);
    }

    private void addSection(JPanel main, String heading, String body,
                            Color purple, Color dark, Color gray) {

        JLabel sectionTitle = new JLabel(heading);
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        sectionTitle.setForeground(purple);
        sectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea sectionText = new JTextArea(body);
        sectionText.setFont(new Font("SansSerif", Font.PLAIN, 15));
        sectionText.setForeground(dark);
        sectionText.setBackground(Color.WHITE);
        sectionText.setEditable(false);
        sectionText.setLineWrap(true);
        sectionText.setWrapStyleWord(true);
        sectionText.setBorder(BorderFactory.createEmptyBorder(12, 15, 12, 15));
        sectionText.setAlignmentX(Component.LEFT_ALIGNMENT);

        main.add(sectionTitle);
        main.add(Box.createVerticalStrut(8));
        main.add(sectionText);
        main.add(Box.createVerticalStrut(18));
    }
}