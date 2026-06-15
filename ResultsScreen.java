//Filename: ResultsScreen.java
//Purpose: Builds and returns the results/certificate screen panel.

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.*;

public class ResultsScreen {

    private JLabel  lblFinalGrade;
    private JLabel  lblGradeMessage;
    private JLabel  lblCertName;
    private JLabel  lblCertScore;
    private JLabel  lblCertGenre;
    private JLabel  lblCertMsg;
    private JButton btnPlayAgain;
    private JButton btnExitHome;

    private QuizMasterApp app;

    public ResultsScreen(QuizMasterApp app) {
        this.app = app;
    }

    public JPanel build() {
        Color bg     = AppColors.BACKGROUND;
        Color purple = AppColors.PURPLE;
        Color dark   = AppColors.DARK;
        Color gray   = AppColors.GRAY;
        Color white  = AppColors.WHITE;

        JPanel screen = new JPanel(new BorderLayout());
        screen.setBackground(bg);
        screen.setBorder(new EmptyBorder(30, 60, 30, 60));

        JLabel lblFinalGradeTitle = new JLabel("FINAL GRADE");
        lblFinalGradeTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblFinalGradeTitle.setForeground(gray);
        lblFinalGradeTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblFinalGrade = new JLabel("A+");
        lblFinalGrade.setFont(new Font("SansSerif", Font.BOLD, 72));
        lblFinalGrade.setForeground(purple);
        lblFinalGrade.setHorizontalAlignment(SwingConstants.CENTER);

        lblGradeMessage = new JLabel("Outstanding Performance!");
        lblGradeMessage.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblGradeMessage.setForeground(gray);
        lblGradeMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelGrade = new JPanel(new GridLayout(3, 1, 0, 6));
        panelGrade.setBackground(bg);
        panelGrade.add(lblFinalGradeTitle);
        panelGrade.add(lblFinalGrade);
        panelGrade.add(lblGradeMessage);
        screen.add(panelGrade, BorderLayout.NORTH);

        JPanel certificate = new JPanel();
        certificate.setLayout(new BoxLayout(certificate, BoxLayout.Y_AXIS));
        certificate.setBackground(white);
        certificate.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.decode("#e0e0e0"), 1, true),
            new EmptyBorder(30, 40, 30, 40)
        ));

        JLabel lblCertTitle = new JLabel("Certificate of Achievement");
        lblCertTitle.setFont(new Font("Serif", Font.BOLD, 22));
        lblCertTitle.setForeground(dark);
        lblCertTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblCertifiesThat = new JLabel("THIS CERTIFIES THAT");
        lblCertifiesThat.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblCertifiesThat.setForeground(gray);
        lblCertifiesThat.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblCertName = new JLabel("Player Name");
        lblCertName.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblCertName.setForeground(purple);
        lblCertName.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblCertMsg = new JLabel("has completed the QuizMaster challenge.");
        lblCertMsg.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblCertMsg.setForeground(gray);
        lblCertMsg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelStats = new JPanel(new GridLayout(1, 2, 20, 0));
        panelStats.setBackground(white);
        panelStats.setMaximumSize(new Dimension(300, 60));
        panelStats.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelScoreStat = new JPanel(new BorderLayout());
        panelScoreStat.setBackground(white);
        lblCertScore = new JLabel("0/5");
        lblCertScore.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblCertScore.setForeground(dark);
        lblCertScore.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblScoreLabel = new JLabel("SCORE");
        lblScoreLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblScoreLabel.setForeground(gray);
        lblScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelScoreStat.add(lblCertScore,  BorderLayout.CENTER);
        panelScoreStat.add(lblScoreLabel, BorderLayout.SOUTH);

        JPanel panelGenreStat = new JPanel(new BorderLayout());
        panelGenreStat.setBackground(white);
        lblCertGenre = new JLabel("Science");
        lblCertGenre.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblCertGenre.setForeground(dark);
        lblCertGenre.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblGenreLabel = new JLabel("CATEGORY");
        lblGenreLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblGenreLabel.setForeground(gray);
        lblGenreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelGenreStat.add(lblCertGenre,  BorderLayout.CENTER);
        panelGenreStat.add(lblGenreLabel, BorderLayout.SOUTH);

        panelStats.add(panelScoreStat);
        panelStats.add(panelGenreStat);

        certificate.add(lblCertTitle);
        certificate.add(Box.createVerticalStrut(6));
        certificate.add(lblCertifiesThat);
        certificate.add(Box.createVerticalStrut(8));
        certificate.add(lblCertName);
        certificate.add(Box.createVerticalStrut(14));
        certificate.add(lblCertMsg);
        certificate.add(Box.createVerticalStrut(20));
        certificate.add(panelStats);

        JPanel panelCertWrap = new JPanel(new GridBagLayout());
        panelCertWrap.setBackground(bg);
        panelCertWrap.setBorder(new EmptyBorder(20, 0, 20, 0));
        panelCertWrap.add(certificate);
        screen.add(panelCertWrap, BorderLayout.CENTER);

        btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.addActionListener(app);
        btnPlayAgain.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnPlayAgain.setForeground(white);
        btnPlayAgain.setBackground(purple);
        btnPlayAgain.setOpaque(true);
        btnPlayAgain.setBorderPainted(false);
        btnPlayAgain.setFocusPainted(false);
        btnPlayAgain.setPreferredSize(new Dimension(160, 46));

        btnExitHome = new JButton("Exit to Home");
        btnExitHome.addActionListener(app);
        btnExitHome.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnExitHome.setForeground(dark);
        btnExitHome.setBackground(white);
        btnExitHome.setOpaque(true);
        btnExitHome.setBorder(new LineBorder(dark, 2, true));
        btnExitHome.setFocusPainted(false);
        btnExitHome.setPreferredSize(new Dimension(160, 46));

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelButtons.setBackground(bg);
        panelButtons.add(btnPlayAgain);
        panelButtons.add(btnExitHome);
        screen.add(panelButtons, BorderLayout.SOUTH);

        return screen;
    }

    public void showResults(String playerName, QuizSession session) {
        String grade   = session.calculateGrade();
        String message = session.getGradeMessage();
        String certMsg = getCertMessage(grade);

        update(playerName, grade, message, certMsg,
            session.getScore(), session.getTotalQuestions(), session.getGenre());

        FileHandler.saveScore(playerName, session.getScore(), grade, LocalDate.now().toString());
    }

    private String getCertMessage(String grade) {
        if (grade.equals("A+")) return "has completed the QuizMaster challenge with exceptional knowledge and skill.";
        if (grade.equals("A"))  return "has completed the QuizMaster challenge with excellent performance.";
        if (grade.equals("B"))  return "has completed the QuizMaster challenge with great effort.";
        if (grade.equals("C"))  return "has completed the QuizMaster challenge with satisfactory performance.";
        if (grade.equals("D"))  return "has attempted the QuizMaster challenge. Keep practicing!";
        return                         "has attempted the QuizMaster challenge. Better luck next time!";
    }

    public void update(String name, String grade, String message, String certMessage, int score, int total, String genre) {
        lblFinalGrade.setText(grade);
        lblGradeMessage.setText(message);
        lblCertName.setText(name);
        lblCertMsg.setText(certMessage);
        lblCertScore.setText(score + "/" + total);
        lblCertGenre.setText(genre);
    }

    public boolean handleAction(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnPlayAgain) {
            app.showScreen(QuizMasterApp.SCREEN_GENRE);
            return true;
        }

        if (src == btnExitHome) {
            app.showScreen(QuizMasterApp.SCREEN_WELCOME);
            return true;
        }

        return false;
    }

    public JButton getBtnPlayAgain() { return btnPlayAgain; }
    public JButton getBtnExitHome()  { return btnExitHome; }
}
