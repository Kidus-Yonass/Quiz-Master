import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class QuizMasterApp extends JFrame implements ActionListener {

    private JLabel lblQuiz;
    private JLabel lblMaster;
    private JLabel lblTagline;
    private JTextField tfName;
    private JButton btnStart;
    private JButton btnHelp;
    private JButton btnAdmin;
    private JButton btnLeaderboard;

    private static final Color COLOR_BACKGROUND = Color.decode("#e8eafa");
    private static final Color COLOR_PURPLE = Color.decode("#4C3CEB");
    private static final Color COLOR_DARK = Color.decode("#171D2D");
    private static final Color COLOR_GRAY = Color.decode("#9CA3AF");

    public QuizMasterApp() {
        btnHelp = new JButton("Help");
        btnHelp.addActionListener(this);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setForeground(COLOR_GRAY);
        btnHelp.setFont(new Font("SansSerif", Font.PLAIN, 18));

        btnAdmin = new JButton("Admin");
        btnAdmin.addActionListener(this);
        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setForeground(COLOR_GRAY);
        btnAdmin.setFont(new Font("SansSerif", Font.PLAIN, 18));

        JPanel panelHelp = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelHelp.setBackground(COLOR_BACKGROUND);
        panelHelp.add(btnHelp);

        JPanel panelAdmin = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        panelAdmin.setBackground(COLOR_BACKGROUND);
        panelAdmin.add(btnAdmin);

        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(COLOR_BACKGROUND);
        panelTop.add(panelHelp, BorderLayout.WEST);
        panelTop.add(panelAdmin, BorderLayout.EAST);

        lblQuiz = new JLabel("Quiz");
        lblQuiz.setFont(new Font("SansSerif", Font.BOLD, 75));
        lblQuiz.setForeground(COLOR_DARK);

        lblMaster = new JLabel("Master");
        lblMaster.setFont(new Font("SansSerif", Font.BOLD, 75));
        lblMaster.setForeground(COLOR_PURPLE);

        JPanel panelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelTitle.setBackground(COLOR_BACKGROUND);
        panelTitle.add(lblQuiz);
        panelTitle.add(lblMaster);

        lblTagline = new JLabel("Test your knowledge. Prove your worth.");
        lblTagline.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblTagline.setForeground(COLOR_GRAY);
        lblTagline.setHorizontalAlignment(SwingConstants.CENTER);

        tfName = new JTextField(16);
        tfName.setFont(new Font("SansSerif", Font.PLAIN, 20));
        tfName.setBorder(new LineBorder(COLOR_PURPLE, 2, true));
        tfName.setHorizontalAlignment(JTextField.CENTER);
        tfName.setBackground(COLOR_BACKGROUND);

        btnStart = new JButton("Start Journey  ->");
        btnStart.addActionListener(this);
        btnStart.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnStart.setForeground(Color.WHITE);
        btnStart.setBackground(COLOR_PURPLE);
        btnStart.setOpaque(true);
        btnStart.setBorderPainted(false);
        btnStart.setFocusPainted(false);
        btnStart.setPreferredSize(new Dimension(220, 48));

        JPanel panelName = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelName.setBackground(COLOR_BACKGROUND);
        panelName.add(tfName);

        JPanel panelStart = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelStart.setBackground(COLOR_BACKGROUND);
        panelStart.add(btnStart);

        JPanel panelCenter = new JPanel(new GridLayout(4, 1, 0, 10));
        panelCenter.setBackground(COLOR_BACKGROUND);
        panelCenter.add(panelTitle);
        panelCenter.add(lblTagline);
        panelCenter.add(panelName);
        panelCenter.add(panelStart);

        JPanel panelCenterWrap = new JPanel(new BorderLayout());
        panelCenterWrap.setBackground(COLOR_BACKGROUND);
        panelCenterWrap.add(panelCenter, BorderLayout.CENTER);

        btnLeaderboard = new JButton("Leaderboard");
        btnLeaderboard.addActionListener(this);
        btnLeaderboard.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnLeaderboard.setForeground(COLOR_GRAY);
        btnLeaderboard.setBackground(COLOR_BACKGROUND);
        btnLeaderboard.setFocusPainted(false);

        JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        panelBottom.setBackground(COLOR_BACKGROUND);
        panelBottom.add(btnLeaderboard);

        setLayout(new BorderLayout());
        add(panelTop, BorderLayout.NORTH);
        add(panelCenterWrap, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        getContentPane().setBackground(COLOR_BACKGROUND);
        setTitle("QuizMaster");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            // Next screen and backend hook-up will be added here.
        } else if (e.getSource() == btnHelp) {
            // Help screen — coming next.
        } else if (e.getSource() == btnAdmin) {
            // Admin screen — coming next.
        } else if (e.getSource() == btnLeaderboard) {
            // Leaderboard screen — coming next.
        }
    }

    public static void main(String[] args) {
        new QuizMasterApp();
    }
}