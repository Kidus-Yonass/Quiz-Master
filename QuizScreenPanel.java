//Filename: QuizScreenPanel.java
//Purpose: Builds and returns the quiz question screen panel.

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class QuizScreenPanel {

    private JLabel    lblQuestionCounter;
    private JLabel    lblScore;
    private JLabel    lblGenreTag;
    private JLabel    lblQuestionText;
    private JButton[] answerButtons;

    private QuizSession session;
    private boolean     answered;

    private QuizMasterApp app;

    public QuizScreenPanel(QuizMasterApp app) {
        this.app = app;
    }

    public JPanel build() {
        Color white  = AppColors.WHITE;
        Color dark   = AppColors.DARK;
        Color gray   = AppColors.GRAY;
        Color purple = AppColors.PURPLE;

        JPanel screen = new JPanel(new BorderLayout(0, 0));
        screen.setBackground(white);

        JPanel panelTopBar = new JPanel(new BorderLayout());
        panelTopBar.setBackground(white);
        panelTopBar.setBorder(new EmptyBorder(20, 30, 10, 30));

        lblQuestionCounter = new JLabel("Question 1 of 5");
        lblQuestionCounter.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblQuestionCounter.setForeground(gray);

        JLabel lblScoreTitle = new JLabel("SCORE");
        lblScoreTitle.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblScoreTitle.setForeground(gray);
        lblScoreTitle.setHorizontalAlignment(SwingConstants.RIGHT);

        lblScore = new JLabel("0");
        lblScore.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblScore.setForeground(purple);
        lblScore.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panelScoreBox = new JPanel(new GridLayout(2, 1));
        panelScoreBox.setBackground(white);
        panelScoreBox.add(lblScoreTitle);
        panelScoreBox.add(lblScore);

        panelTopBar.add(lblQuestionCounter, BorderLayout.WEST);
        panelTopBar.add(panelScoreBox,      BorderLayout.EAST);
        screen.add(panelTopBar, BorderLayout.NORTH);

        lblGenreTag = new JLabel("SCIENCE");
        lblGenreTag.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblGenreTag.setForeground(purple);
        lblGenreTag.setHorizontalAlignment(SwingConstants.CENTER);
        lblGenreTag.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.decode("#c7d2fe"), 1, true),
            new EmptyBorder(4, 12, 4, 12)
        ));
        lblGenreTag.setOpaque(true);
        lblGenreTag.setBackground(Color.decode("#eef2ff"));

        JPanel panelTagWrap = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTagWrap.setBackground(white);
        panelTagWrap.add(lblGenreTag);

        lblQuestionText = new JLabel("<html><div style='text-align:center;width:500px'>Question text here</div></html>");
        lblQuestionText.setFont(new Font("SansSerif", Font.BOLD, 26));
        lblQuestionText.setForeground(dark);
        lblQuestionText.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelQuestion = new JPanel(new BorderLayout(0, 12));
        panelQuestion.setBackground(white);
        panelQuestion.setBorder(new EmptyBorder(20, 60, 20, 60));
        panelQuestion.add(panelTagWrap,    BorderLayout.NORTH);
        panelQuestion.add(lblQuestionText, BorderLayout.CENTER);

        JPanel panelAnswers = new JPanel(new GridLayout(2, 2, 16, 16));
        panelAnswers.setBackground(white);
        panelAnswers.setBorder(new EmptyBorder(10, 60, 30, 60));

        String[] optionLabels = {"A", "B", "C", "D"};
        answerButtons = new JButton[4];

        for (int i = 0; i < 4; i++) {
            JButton btn = new JButton();
            btn.setLayout(new FlowLayout(FlowLayout.LEFT, 14, 0));
            btn.setBackground(Color.decode("#f8f9ff"));
            btn.setBorder(new LineBorder(Color.decode("#e0e0f0"), 2, true));
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(340, 60));
            btn.setActionCommand(optionLabels[i]);
            btn.addActionListener(app);

            JLabel lblLetter = new JLabel(optionLabels[i]);
            lblLetter.setFont(new Font("SansSerif", Font.BOLD, 14));
            lblLetter.setForeground(gray);
            lblLetter.setOpaque(true);
            lblLetter.setBackground(Color.decode("#e8eafa"));
            lblLetter.setBorder(new EmptyBorder(4, 8, 4, 8));

            JLabel lblText = new JLabel("Option " + optionLabels[i]);
            lblText.setFont(new Font("SansSerif", Font.PLAIN, 15));
            lblText.setForeground(dark);
            lblText.setName("optionText");

            btn.add(lblLetter);
            btn.add(lblText);

            answerButtons[i] = btn;
            panelAnswers.add(btn);
        }

        JPanel panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBackground(white);
        panelCenter.add(panelQuestion, BorderLayout.CENTER);
        panelCenter.add(panelAnswers,  BorderLayout.SOUTH);
        screen.add(panelCenter, BorderLayout.CENTER);

        return screen;
    }

    public void startQuiz(String genre) {
        ArrayList<Question> allQuestions   = FileHandler.loadQuestions();
        ArrayList<Question> genreQuestions = Search.searchByGenre(allQuestions, genre);

        if (genreQuestions.isEmpty()) {
            JOptionPane.showMessageDialog(app,
                "No questions found for " + genre + ".\nPlease add questions in the Admin Panel.",
                "No Questions", JOptionPane.WARNING_MESSAGE);
            return;
        }

        session  = new QuizSession(genre, genreQuestions);
        answered = false;
        loadQuestion();
        app.showScreen(QuizMasterApp.SCREEN_QUIZ);
    }

    private void loadQuestion() {
        Question q = session.getCurrentQuestion();
        answered   = false;

        lblQuestionCounter.setText(
            "Question " + (session.getCurrentIndex() + 1) + " of " + session.getTotalQuestions());
        lblScore.setText(String.valueOf(session.getScore()));
        lblGenreTag.setText(session.getGenre().toUpperCase());
        lblQuestionText.setText(
            "<html><div style='text-align:center;width:500px'>" + q.getText() + "</div></html>");

        String[] options = {q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD()};

        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i].setBackground(Color.decode("#f8f9ff"));
            answerButtons[i].setBorder(new LineBorder(Color.decode("#e0e0f0"), 2, true));
            for (Component c : answerButtons[i].getComponents()) {
                if (c instanceof JLabel && "optionText".equals(((JLabel) c).getName())) {
                    ((JLabel) c).setText(options[i]);
                }
            }
        }
    }

    private void handleAnswer(String selectedOption) {
        if (answered) return;
        answered = true;

        boolean correct    = session.submitAnswer(selectedOption);
        String  correctAns = session.getCurrentQuestion().getCorrectAnswer();
        String[] labels    = {"A", "B", "C", "D"};

        for (int i = 0; i < answerButtons.length; i++) {
            if (labels[i].equals(correctAns)) {
                answerButtons[i].setBackground(Color.decode("#dcfce7"));
                answerButtons[i].setBorder(new LineBorder(AppColors.GREEN, 2, true));
            } else if (labels[i].equals(selectedOption) && !correct) {
                answerButtons[i].setBackground(Color.decode("#fee2e2"));
                answerButtons[i].setBorder(new LineBorder(AppColors.RED, 2, true));
            }
        }

        Timer timer = new Timer(1000, ev -> {
            if (session.hasNextQuestion()) {
                session.nextQuestion();
                loadQuestion();
            } else {
                finishQuiz();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void finishQuiz() {
        app.getResultsScreen().showResults(app.getPlayerName(), session);
        app.showScreen(QuizMasterApp.SCREEN_RESULTS);
    }

    public boolean handleAction(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd != null && (cmd.equals("A") || cmd.equals("B") || cmd.equals("C") || cmd.equals("D"))) {
            handleAnswer(cmd);
            return true;
        }

        return false;
    }

    public JLabel    getQuestionCounter() { return lblQuestionCounter; }
    public JLabel    getScoreLabel()      { return lblScore; }
    public JLabel    getGenreTag()        { return lblGenreTag; }
    public JLabel    getQuestionText()    { return lblQuestionText; }
    public JButton[] getAnswerButtons()   { return answerButtons; }
}
