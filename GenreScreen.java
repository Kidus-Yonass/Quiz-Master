import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GenreScreen {

    public static final String[] GENRES = {"Science", "History", "Sports", "Technology"};

    private JButton   btnGenreBack;
    private JButton[] genreButtons;

    private QuizMasterApp app;

    public GenreScreen(QuizMasterApp app) {
        this.app = app;
    }

    public JPanel build() {
        Color bg     = AppColors.BACKGROUND;
        Color dark   = AppColors.DARK;
        Color gray   = AppColors.GRAY;
        Color purple = AppColors.PURPLE;

        JPanel screen = new JPanel(new BorderLayout());
        screen.setBackground(bg);

        btnGenreBack = new JButton("<- Back");
        btnGenreBack.addActionListener(app);
        btnGenreBack.setBorderPainted(false);
        btnGenreBack.setContentAreaFilled(false);
        btnGenreBack.setForeground(gray);
        btnGenreBack.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnGenreBack.setFocusPainted(false);

        JPanel panelBackWrap = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelBackWrap.setBackground(bg);
        panelBackWrap.add(btnGenreBack);

        JLabel lblGenreTitle = new JLabel("Select a Genre");
        lblGenreTitle.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblGenreTitle.setForeground(dark);
        lblGenreTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblGenreSub = new JLabel("Choose your battlefield of knowledge");
        lblGenreSub.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblGenreSub.setForeground(gray);
        lblGenreSub.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelTitles = new JPanel(new GridLayout(2, 1, 0, 4));
        panelTitles.setBackground(bg);
        panelTitles.add(lblGenreTitle);
        panelTitles.add(lblGenreSub);

        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(bg);
        panelTop.setBorder(new EmptyBorder(15, 20, 0, 20));
        panelTop.add(panelBackWrap, BorderLayout.WEST);
        panelTop.add(panelTitles,   BorderLayout.CENTER);
        screen.add(panelTop, BorderLayout.NORTH);

        JPanel panelCards = new JPanel(new GridLayout(2, 2, 20, 20));
        panelCards.setBackground(bg);
        panelCards.setBorder(new EmptyBorder(30, 60, 60, 60));

        Color[] cardColors   = {
            Color.decode("#e6f4ea"),
            Color.decode("#fff3e0"),
            Color.decode("#e3f2fd"),
            Color.decode("#dfe6ff")
        };
        Color[] borderColors = {
            Color.decode("#81c784"),
            Color.decode("#ffb74d"),
            Color.decode("#64b5f6"),
            Color.decode("#7986cb")
        };
        Color[] iconColors   = {
            Color.decode("#2e7d32"),
            Color.decode("#e65100"),
            Color.decode("#1565c0"),
            Color.decode("#4431bc")
        };

        genreButtons = new JButton[GENRES.length];

        for (int i = 0; i < GENRES.length; i++) {
            JButton card = new JButton();
            card.setLayout(new BorderLayout());
            card.setBackground(cardColors[i]);
            card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColors[i], 2, true),
                new EmptyBorder(30, 20, 30, 20)
            ));

            card.setFocusPainted(false);
            card.setActionCommand(GENRES[i]);
            card.addActionListener(app);

            JLabel lblName = new JLabel(GENRES[i]);
            lblName.setFont(new Font("SansSerif", Font.BOLD, 36));
            lblName.setForeground(iconColors[i]);
            lblName.setHorizontalAlignment(SwingConstants.CENTER);

            card.add(lblName, BorderLayout.CENTER);

            genreButtons[i] = card;
            panelCards.add(card);
        }

        screen.add(panelCards, BorderLayout.CENTER);
        return screen;
    }

    public boolean handleAction(ActionEvent e) {
        Object src = e.getSource();
        String cmd = e.getActionCommand();

        if (src == btnGenreBack) {
            app.showScreen(QuizMasterApp.SCREEN_WELCOME);
            return true;
        }

        if (cmd != null && isGenre(cmd)) {
            app.getQuizScreen().startQuiz(cmd);
            return true;
        }

        return false;
    }

    private boolean isGenre(String cmd) {
        for (int i = 0; i < GENRES.length; i++) {
            if (GENRES[i].equals(cmd)) return true;
        }
        return false;
    }

    public JButton   getBtnBack()      { return btnGenreBack; }
    public JButton[] getGenreButtons() { return genreButtons; }
}
