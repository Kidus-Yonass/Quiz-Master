//Filename: WelcomeScreen.java
//Purpose: Builds and returns the welcome/home screen panel.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class WelcomeScreen {

    private JTextField tfName;
    private JButton btnStart;
    private JButton btnHelp;
    private JButton btnAdmin;

    private QuizMasterApp app;

    public WelcomeScreen(QuizMasterApp app) {
        this.app = app;
    }

    public JPanel build() {
        Color bg     = AppColors.BACKGROUND;
        Color purple = AppColors.PURPLE;
        Color dark   = AppColors.DARK;
        Color gray   = AppColors.GRAY;

        btnHelp = new JButton("Help");
        btnHelp.addActionListener(app);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setForeground(gray);
        btnHelp.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnHelp.setFocusPainted(false);

        btnAdmin = new JButton("Admin");
        btnAdmin.addActionListener(app);
        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setForeground(gray);
        btnAdmin.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnAdmin.setFocusPainted(false);

        JPanel panelHelp = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelHelp.setBackground(bg);
        panelHelp.add(btnHelp);

        JPanel panelAdmin = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        panelAdmin.setBackground(bg);
        panelAdmin.add(btnAdmin);

        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(bg);
        panelTop.add(panelHelp,  BorderLayout.WEST);
        panelTop.add(panelAdmin, BorderLayout.EAST);

        JLabel lblQuiz = new JLabel("Quiz");
        lblQuiz.setFont(new Font("SansSerif", Font.BOLD, 75));
        lblQuiz.setForeground(dark);

        JLabel lblMaster = new JLabel("Master");
        lblMaster.setFont(new Font("SansSerif", Font.BOLD, 75));
        lblMaster.setForeground(purple);

        JPanel panelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelTitle.setBackground(bg);
        panelTitle.add(lblQuiz);
        panelTitle.add(lblMaster);

        JLabel lblTagline = new JLabel("Test your knowledge. Prove your worth.");
        lblTagline.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblTagline.setForeground(gray);
        lblTagline.setHorizontalAlignment(SwingConstants.CENTER);

        tfName = new JTextField(16);
        tfName.setFont(new Font("SansSerif", Font.PLAIN, 20));
        tfName.setBorder(new LineBorder(purple, 2, true));
        tfName.setHorizontalAlignment(JTextField.CENTER);
        tfName.setBackground(bg);

        JPanel panelName = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelName.setBackground(bg);
        panelName.add(tfName);

        btnStart = new JButton("Start Journey  ->");
        btnStart.addActionListener(app);
        btnStart.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnStart.setForeground(Color.WHITE);
        btnStart.setBackground(purple);
        btnStart.setOpaque(true);
        btnStart.setBorderPainted(false);
        btnStart.setFocusPainted(false);
        btnStart.setPreferredSize(new Dimension(220, 48));

        JPanel panelStart = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelStart.setBackground(bg);
        panelStart.add(btnStart);

        JPanel panelCenter = new JPanel(new GridLayout(4, 1, 0, 10));
        panelCenter.setBackground(bg);
        panelCenter.add(panelTitle);
        panelCenter.add(lblTagline);
        panelCenter.add(panelName);
        panelCenter.add(panelStart);

        JPanel panelCenterWrap = new JPanel(new BorderLayout());
        panelCenterWrap.setBackground(bg);
        panelCenterWrap.add(panelCenter, BorderLayout.CENTER);

        JPanel screen = new JPanel(new BorderLayout());
        screen.setBackground(bg);
        screen.add(panelTop,         BorderLayout.NORTH);
        screen.add(panelCenterWrap,  BorderLayout.CENTER);
        return screen;
    }

    public boolean handleAction(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnAdmin) {
            AdminLoginScreen login = app.getAdminLoginScreen();
            login.getUsernameField().setText("");
            login.getPasswordField().setText("");
            login.getErrorLabel().setText(" ");
            app.showScreen(QuizMasterApp.SCREEN_ADMINLOGIN);
            return true;
        }

        if (src == btnStart) {
            String name = tfName.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(app,
                    "Please enter your name to start!", "Name Required", JOptionPane.WARNING_MESSAGE);
            } else {
                app.setPlayerName(name);
                app.showScreen(QuizMasterApp.SCREEN_GENRE);
            }
            return true;
        }

        if (src == btnHelp) {
            new HelpSystem();
            return true;
        }

        return false;
    }

    public JTextField getNameField()        { return tfName; }
    public JButton    getBtnStart()         { return btnStart; }
    public JButton    getBtnHelp()          { return btnHelp; }
    public JButton    getBtnAdmin()         { return btnAdmin; }
}
