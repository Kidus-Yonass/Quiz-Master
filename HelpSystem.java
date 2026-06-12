import javax.swing.*;

public class HelpSystem extends JFrame
{
    JTextArea helpText;

    public HelpSystem()
    {
        setTitle("Help");

        setSize(500,400);

        // center window
        setLocationRelativeTo(null);

        helpText = new JTextArea();

        helpText.setEditable(false);

        helpText.setText(

                "HELP SYSTEM\n\n" +

                // how to use quiz
                "How to Play\n\n" +

                "1. Enter your name\n" +
                "2. Select a category\n" +
                "3. Answer questions\n" +
                "4. View your score\n\n" +

                "Rules\n" +
                "- One answer per question\n" +
                "- Questions are random\n\n" +

                "Admin\n" +
                "- View questions\n" +
                "- Add questions\n" +
                "- Edit questions\n\n" +

                "About\n" +
                "QuizMaster was made for our\n" +
                "computer science project."
        );

        add(new JScrollPane(helpText));

        setVisible(true);
    }
}