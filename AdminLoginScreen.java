//Filename: AdminLoginScreen.java
//Purpose: Builds and returns the admin login panel.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AdminLoginScreen {

    private JTextField     tfAdminUsername;
    private JPasswordField pfAdminPassword;
    private JButton        btnAdminLogin;
    private JButton        btnAdminBack;
    private JLabel         lblLoginError;

    private QuizMasterApp app;

    public AdminLoginScreen(QuizMasterApp app) {
        this.app = app;
    }

    public JPanel build() {
        Color bg     = AppColors.BACKGROUND;
        Color purple = AppColors.PURPLE;
        Color dark   = AppColors.DARK;
        Color gray   = AppColors.GRAY;
        Color red    = AppColors.RED;
        Color white  = AppColors.WHITE;

        JPanel screen = new JPanel(new BorderLayout());
        screen.setBackground(bg);

        btnAdminBack = new JButton("<- Back");
        btnAdminBack.addActionListener(app);
        btnAdminBack.setBorderPainted(false);
        btnAdminBack.setContentAreaFilled(false);
        btnAdminBack.setForeground(gray);
        btnAdminBack.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnAdminBack.setFocusPainted(false);

        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelTop.setBackground(bg);
        panelTop.add(btnAdminBack);
        screen.add(panelTop, BorderLayout.NORTH);

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(white);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.decode("#dddddd"), 1, true),
            new EmptyBorder(40, 50, 40, 50)
        ));
        card.setMaximumSize(new Dimension(500, 420));

        JLabel lblTitle = new JLabel("Admin Login");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblTitle.setForeground(dark);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSub = new JLabel("Enter your credentials to continue");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblSub.setForeground(gray);
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblUser.setForeground(dark);

        tfAdminUsername = new JTextField(25);
        tfAdminUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfAdminUsername.setBorder(new LineBorder(purple, 2, true));

        JPanel panelUser = new JPanel(new BorderLayout());
        panelUser.setBackground(white);
        panelUser.add(lblUser,          BorderLayout.NORTH);
        panelUser.add(tfAdminUsername,  BorderLayout.CENTER);

        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblPass.setForeground(dark);

        pfAdminPassword = new JPasswordField(25);
        pfAdminPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
        pfAdminPassword.setBorder(new LineBorder(purple, 2, true));

        JPanel panelPass = new JPanel(new BorderLayout());
        panelPass.setBackground(white);
        panelPass.add(lblPass,          BorderLayout.NORTH);
        panelPass.add(pfAdminPassword,  BorderLayout.CENTER);

        lblLoginError = new JLabel(" ");
        lblLoginError.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblLoginError.setForeground(red);
        lblLoginError.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAdminLogin = new JButton("Login");
        btnAdminLogin.addActionListener(app);
        btnAdminLogin.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnAdminLogin.setForeground(white);
        btnAdminLogin.setBackground(purple);
        btnAdminLogin.setOpaque(true);
        btnAdminLogin.setBorderPainted(false);
        btnAdminLogin.setFocusPainted(false);
        btnAdminLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        btnAdminLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(lblTitle);
        card.add(Box.createVerticalStrut(6));
        card.add(lblSub);
        card.add(Box.createVerticalStrut(28));
        card.add(panelUser);
        card.add(Box.createVerticalStrut(16));
        card.add(panelPass);
        card.add(Box.createVerticalStrut(10));
        card.add(lblLoginError);
        card.add(Box.createVerticalStrut(10));
        card.add(btnAdminLogin);

        JPanel centerWrap = new JPanel(new GridBagLayout());
        centerWrap.setBackground(bg);
        centerWrap.add(card);
        screen.add(centerWrap, BorderLayout.CENTER);

        return screen;
    }

    public boolean handleAction(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnAdminBack) {
            app.showScreen(QuizMasterApp.SCREEN_WELCOME);
            return true;
        }

        if (src == btnAdminLogin) {
            String user = tfAdminUsername.getText().trim();
            String pass = new String(pfAdminPassword.getPassword()).trim();
            if (Admin.login(user, pass)) {
                lblLoginError.setText(" ");
                app.getAdminPanelScreen().loadQuestions();
                app.showScreen(QuizMasterApp.SCREEN_ADMINPANEL);
            } else {
                lblLoginError.setText("Incorrect username or password. Try again.");
            }
            return true;
        }

        return false;
    }

    public JTextField     getUsernameField()  { return tfAdminUsername; }
    public JPasswordField getPasswordField()  { return pfAdminPassword; }
    public JButton        getBtnLogin()       { return btnAdminLogin; }
    public JButton        getBtnBack()        { return btnAdminBack; }
    public JLabel         getErrorLabel()     { return lblLoginError; }
}
