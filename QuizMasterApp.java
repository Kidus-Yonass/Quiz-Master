//Filename: QuizMasterApp.java
//Authors: Kidus, Nebiy, Andy
//Date Created: May 2026
//Purpose: Main application window. Uses CardLayout to switch between all screens.
//         Each screen's UI and logic live in its own dedicated class.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizMasterApp extends JFrame implements ActionListener {

    public static final String SCREEN_WELCOME    = "welcome";
    public static final String SCREEN_ADMINLOGIN = "adminLogin";
    public static final String SCREEN_ADMINPANEL = "adminPanel";
    public static final String SCREEN_GENRE      = "genre";
    public static final String SCREEN_QUIZ       = "quiz";
    public static final String SCREEN_RESULTS    = "results";

    private CardLayout cardLayout;
    private JPanel     cardPanel;

    private WelcomeScreen      welcomeScreen;
    private AdminLoginScreen   adminLoginScreen;
    private AdminPanelScreen   adminPanelScreen;
    private GenreScreen        genreScreen;
    private QuizScreenPanel    quizScreenPanel;
    private ResultsScreen      resultsScreen;

    private String playerName;

    public QuizMasterApp() {
        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);
        cardPanel.setBackground(AppColors.BACKGROUND);

        welcomeScreen    = new WelcomeScreen(this);
        adminLoginScreen = new AdminLoginScreen(this);
        adminPanelScreen = new AdminPanelScreen(this);
        genreScreen      = new GenreScreen(this);
        quizScreenPanel  = new QuizScreenPanel(this);
        resultsScreen    = new ResultsScreen(this);

        cardPanel.add(welcomeScreen.build(),    SCREEN_WELCOME);
        cardPanel.add(adminLoginScreen.build(), SCREEN_ADMINLOGIN);
        cardPanel.add(adminPanelScreen.build(), SCREEN_ADMINPANEL);
        cardPanel.add(genreScreen.build(),      SCREEN_GENRE);
        cardPanel.add(quizScreenPanel.build(),  SCREEN_QUIZ);
        cardPanel.add(resultsScreen.build(),    SCREEN_RESULTS);

        setContentPane(cardPanel);
        setTitle("QuizMaster");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        showScreen(SCREEN_WELCOME);
    }

    public void showScreen(String name) {
        cardLayout.show(cardPanel, name);
    }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String name) { playerName = name; }

    public WelcomeScreen      getWelcomeScreen()    { return welcomeScreen; }
    public AdminLoginScreen   getAdminLoginScreen() { return adminLoginScreen; }
    public AdminPanelScreen   getAdminPanelScreen() { return adminPanelScreen; }
    public GenreScreen        getGenreScreen()      { return genreScreen; }
    public QuizScreenPanel    getQuizScreen()       { return quizScreenPanel; }
    public ResultsScreen      getResultsScreen()    { return resultsScreen; }

    public void actionPerformed(ActionEvent e) {
        if (welcomeScreen.handleAction(e)) return;
        if (adminLoginScreen.handleAction(e)) return;
        if (adminPanelScreen.handleAction(e)) return;
        if (genreScreen.handleAction(e)) return;
        if (quizScreenPanel.handleAction(e)) return;
        if (resultsScreen.handleAction(e)) return;
    }

    public static void main(String[] args) {
        new QuizMasterApp();
    }
}
