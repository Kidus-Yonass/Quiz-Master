//Filename: AdminPanelScreen.java
//Purpose: Builds and returns the admin panel screen with question management table.

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class AdminPanelScreen {

    private JTable             questionTable;
    private DefaultTableModel  tableModel;
    private JButton            btnAddQuestion;
    private JButton            btnEditQuestion;
    private JButton            btnDeleteQuestion;
    private JButton            btnSortGenre;
    private JButton            btnSortDifficulty;
    private JButton            btnSaveChanges;
    private JButton            btnAdminLogout;
    private JTextField         tfSearch;
    private JButton            btnSearch;

    private ArrayList<Question> questions;
    private QuizMasterApp app;

    public AdminPanelScreen(QuizMasterApp app) {
        this.app = app;
    }

    public JPanel build() {
        Color bg     = AppColors.BACKGROUND;
        Color purple = AppColors.PURPLE;
        Color dark   = AppColors.DARK;
        Color gray   = AppColors.GRAY;
        Color red    = AppColors.RED;
        Color white  = AppColors.WHITE;
        Color rowAlt = AppColors.ROW_ALT;

        JPanel screen = new JPanel(new BorderLayout(0, 10));
        screen.setBackground(bg);
        screen.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel lblPanelTitle = new JLabel("Admin Panel");
        lblPanelTitle.setFont(new Font("SansSerif", Font.BOLD, 26));
        lblPanelTitle.setForeground(dark);

        btnAdminLogout = new JButton("Logout");
        btnAdminLogout.addActionListener(app);
        btnAdminLogout.setBorderPainted(false);
        btnAdminLogout.setContentAreaFilled(false);
        btnAdminLogout.setForeground(gray);
        btnAdminLogout.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnAdminLogout.setFocusPainted(false);

        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(bg);
        panelHeader.add(lblPanelTitle,  BorderLayout.WEST);
        panelHeader.add(btnAdminLogout, BorderLayout.EAST);
        screen.add(panelHeader, BorderLayout.NORTH);

        String[] columns = {"#", "Question", "Opt A", "Opt B", "Opt C", "Opt D", "Answer", "Genre", "Difficulty"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int col) { return false; }
        };

        questionTable = new JTable(tableModel);
        questionTable.setFont(new Font("SansSerif", Font.PLAIN, 13));
        questionTable.setRowHeight(28);
        questionTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        questionTable.getTableHeader().setBackground(purple);
        questionTable.getTableHeader().setForeground(white);
        questionTable.setSelectionBackground(Color.decode("#c7d2fe"));
        questionTable.setSelectionForeground(dark);
        questionTable.setGridColor(Color.decode("#e0e0f0"));
        questionTable.setShowGrid(true);

        questionTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable t, Object v, boolean sel, boolean foc, int row, int col) {
                super.getTableCellRendererComponent(t, v, sel, foc, row, col);
                if (!sel) setBackground(row % 2 == 0 ? white : rowAlt);
                setBorder(new EmptyBorder(0, 6, 0, 6));
                return this;
            }
        });

        questionTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        questionTable.getColumnModel().getColumn(1).setPreferredWidth(260);
        questionTable.getColumnModel().getColumn(6).setPreferredWidth(55);
        questionTable.getColumnModel().getColumn(7).setPreferredWidth(80);
        questionTable.getColumnModel().getColumn(8).setPreferredWidth(80);

        JScrollPane scrollPane = new JScrollPane(questionTable);
        scrollPane.setBorder(new LineBorder(Color.decode("#c7c7e0"), 1));
        screen.add(scrollPane, BorderLayout.CENTER);

        btnAddQuestion = new JButton("+ Add");
        btnAddQuestion.addActionListener(app);
        btnAddQuestion.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnAddQuestion.setForeground(white);
        btnAddQuestion.setBackground(purple);
        btnAddQuestion.setOpaque(true);
        btnAddQuestion.setBorderPainted(false);
        btnAddQuestion.setFocusPainted(false);

        btnEditQuestion = new JButton("Edit");
        btnEditQuestion.addActionListener(app);
        btnEditQuestion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnEditQuestion.setForeground(purple);
        btnEditQuestion.setBackground(white);
        btnEditQuestion.setOpaque(true);
        btnEditQuestion.setBorder(new LineBorder(purple, 1, true));
        btnEditQuestion.setFocusPainted(false);

        btnDeleteQuestion = new JButton("Delete");
        btnDeleteQuestion.addActionListener(app);
        btnDeleteQuestion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnDeleteQuestion.setForeground(white);
        btnDeleteQuestion.setBackground(red);
        btnDeleteQuestion.setOpaque(true);
        btnDeleteQuestion.setBorderPainted(false);
        btnDeleteQuestion.setFocusPainted(false);

        btnSortGenre = new JButton("Sort: Genre");
        btnSortGenre.addActionListener(app);
        btnSortGenre.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnSortGenre.setForeground(purple);
        btnSortGenre.setBackground(white);
        btnSortGenre.setOpaque(true);
        btnSortGenre.setBorder(new LineBorder(purple, 1, true));
        btnSortGenre.setFocusPainted(false);

        btnSortDifficulty = new JButton("Sort: Difficulty");
        btnSortDifficulty.addActionListener(app);
        btnSortDifficulty.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnSortDifficulty.setForeground(purple);
        btnSortDifficulty.setBackground(white);
        btnSortDifficulty.setOpaque(true);
        btnSortDifficulty.setBorder(new LineBorder(purple, 1, true));
        btnSortDifficulty.setFocusPainted(false);

        btnSaveChanges = new JButton("Save Changes");
        btnSaveChanges.addActionListener(app);
        btnSaveChanges.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnSaveChanges.setForeground(white);
        btnSaveChanges.setBackground(purple);
        btnSaveChanges.setOpaque(true);
        btnSaveChanges.setBorderPainted(false);
        btnSaveChanges.setFocusPainted(false);

        tfSearch = new JTextField(14);
        tfSearch.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tfSearch.setBorder(new LineBorder(purple, 1, true));

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(app);
        btnSearch.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnSearch.setForeground(purple);
        btnSearch.setBackground(white);
        btnSearch.setOpaque(true);
        btnSearch.setBorder(new LineBorder(purple, 1, true));
        btnSearch.setFocusPainted(false);

        JPanel panelToolbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        panelToolbar.setBackground(bg);
        panelToolbar.add(btnAddQuestion);
        panelToolbar.add(btnEditQuestion);
        panelToolbar.add(btnDeleteQuestion);
        panelToolbar.add(btnSortGenre);
        panelToolbar.add(btnSortDifficulty);
        panelToolbar.add(tfSearch);
        panelToolbar.add(btnSearch);

        JPanel panelBottomRight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        panelBottomRight.setBackground(bg);
        panelBottomRight.add(btnSaveChanges);

        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.setBackground(bg);
        panelBottom.setBorder(new EmptyBorder(8, 0, 0, 0));
        panelBottom.add(panelToolbar,      BorderLayout.WEST);
        panelBottom.add(panelBottomRight,  BorderLayout.EAST);
        screen.add(panelBottom, BorderLayout.SOUTH);

        return screen;
    }

    public void loadQuestions() {
        questions = FileHandler.loadQuestions();
        refreshTable();
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            tableModel.addRow(new Object[]{
                i + 1,
                q.getText(), q.getOptionA(), q.getOptionB(),
                q.getOptionC(), q.getOptionD(),
                q.getCorrectAnswer(), q.getGenre(), q.getDifficulty()
            });
        }
    }

    private void showAddDialog() {
        showQuestionDialog(null, -1);
    }

    private void showEditDialog() {
        int row = questionTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(app, "Please select a question to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        showQuestionDialog(questions.get(row), row);
    }

    private void showQuestionDialog(Question existing, int index) {
        boolean isEdit = (existing != null);
        JDialog dialog = new JDialog(app, isEdit ? "Edit Question" : "Add Question", true);
        dialog.setSize(520, 500);
        dialog.setLocationRelativeTo(app);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.getContentPane().setBackground(AppColors.WHITE);

        JPanel form = new JPanel(new GridLayout(8, 2, 10, 10));
        form.setBackground(AppColors.WHITE);
        form.setBorder(new EmptyBorder(20, 20, 10, 20));

        String[] labels = {"Question Text:", "Option A:", "Option B:", "Option C:", "Option D:",
                           "Correct Answer (A/B/C/D):", "Genre:", "Difficulty (Easy/Medium/Hard):"};
        JTextField[] fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setFont(new Font("SansSerif", Font.BOLD, 13));
            lbl.setForeground(AppColors.DARK);
            form.add(lbl);
            fields[i] = new JTextField();
            fields[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
            fields[i].setBorder(new LineBorder(Color.decode("#cccccc"), 1, true));
            form.add(fields[i]);
        }

        if (isEdit) {
            fields[0].setText(existing.getText());
            fields[1].setText(existing.getOptionA());
            fields[2].setText(existing.getOptionB());
            fields[3].setText(existing.getOptionC());
            fields[4].setText(existing.getOptionD());
            fields[5].setText(existing.getCorrectAnswer());
            fields[6].setText(existing.getGenre());
            fields[7].setText(existing.getDifficulty());
        }

        dialog.add(form, BorderLayout.CENTER);

        JButton btnConfirm = new JButton(isEdit ? "Save Changes" : "Add Question");
        btnConfirm.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnConfirm.setForeground(AppColors.WHITE);
        btnConfirm.setBackground(AppColors.PURPLE);
        btnConfirm.setOpaque(true);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setFocusPainted(false);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnCancel.setForeground(AppColors.PURPLE);
        btnCancel.setBackground(AppColors.WHITE);
        btnCancel.setOpaque(true);
        btnCancel.setBorder(new LineBorder(AppColors.PURPLE, 1, true));
        btnCancel.setFocusPainted(false);

        btnConfirm.addActionListener(ev -> {
            for (JTextField f : fields) {
                if (f.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Please fill in all fields.", "Incomplete", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            Question q = new Question(
                fields[0].getText().trim(), fields[1].getText().trim(),
                fields[2].getText().trim(), fields[3].getText().trim(),
                fields[4].getText().trim(), fields[5].getText().trim().toUpperCase(),
                fields[6].getText().trim(), fields[7].getText().trim()
            );
            if (isEdit) questions.set(index, q);
            else        questions.add(q);
            refreshTable();
            dialog.dispose();
        });

        btnCancel.addActionListener(ev -> dialog.dispose());

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelButtons.setBackground(AppColors.WHITE);
        panelButtons.add(btnCancel);
        panelButtons.add(btnConfirm);
        dialog.add(panelButtons, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private void deleteSelectedQuestion() {
        int row = questionTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(app, "Please select a question to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(app,
            "Delete this question?\n\n\"" + questions.get(row).getText() + "\"",
            "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            questions.remove(row);
            refreshTable();
        }
    }

    private void searchQuestions() {
        String query = tfSearch.getText().trim();
        if (query.isEmpty()) {
            refreshTable();
            return;
        }
        ArrayList<Question> results = Search.searchByGenre(questions, query);
        if (results.isEmpty()) results = Search.searchByDifficulty(questions, query);
        tableModel.setRowCount(0);
        for (int i = 0; i < results.size(); i++) {
            Question q = results.get(i);
            tableModel.addRow(new Object[]{
                i + 1, q.getText(), q.getOptionA(), q.getOptionB(),
                q.getOptionC(), q.getOptionD(),
                q.getCorrectAnswer(), q.getGenre(), q.getDifficulty()
            });
        }
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(app, "No questions found for: \"" + query + "\"", "No Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean handleAction(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnAdminLogout) {
            int confirm = JOptionPane.showConfirmDialog(app,
                "Logout? Any unsaved changes will be lost.",
                "Confirm Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                app.showScreen(QuizMasterApp.SCREEN_WELCOME);
            }
            return true;
        }

        if (src == btnAddQuestion) {
            showAddDialog();
            return true;
        }

        if (src == btnEditQuestion) {
            showEditDialog();
            return true;
        }

        if (src == btnDeleteQuestion) {
            deleteSelectedQuestion();
            return true;
        }

        if (src == btnSortGenre) {
            Sort.sortQuestionsByGenre(questions);
            refreshTable();
            return true;
        }

        if (src == btnSortDifficulty) {
            Sort.sortQuestionsByDifficulty(questions);
            refreshTable();
            return true;
        }

        if (src == btnSearch) {
            searchQuestions();
            return true;
        }

        if (src == btnSaveChanges) {
            FileHandler.saveQuestions(questions);
            JOptionPane.showMessageDialog(app, "All changes saved to questions.txt!", "Saved", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        return false;
    }

    public JTable            getTable()              { return questionTable; }
    public DefaultTableModel getTableModel()         { return tableModel; }
    public JButton           getBtnAdd()             { return btnAddQuestion; }
    public JButton           getBtnEdit()            { return btnEditQuestion; }
    public JButton           getBtnDelete()          { return btnDeleteQuestion; }
    public JButton           getBtnSortGenre()       { return btnSortGenre; }
    public JButton           getBtnSortDifficulty()  { return btnSortDifficulty; }
    public JButton           getBtnSave()            { return btnSaveChanges; }
    public JButton           getBtnLogout()          { return btnAdminLogout; }
    public JTextField        getSearchField()        { return tfSearch; }
    public JButton           getBtnSearch()          { return btnSearch; }
}
