import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

// The Answer class extends JFrame and implements ActionListener to handle button events.
public class Answer extends JFrame implements ActionListener {
    int i;

    JFrame frame;
    JPanel panel;
    JTextField textField;
    JTextField textField2;
    JButton button, button1, button2, button3, button4, nextButton;
    JButton[] variants = new JButton[4];

    Font myFont = new Font("Segoe UI", Font.BOLD, 30);
    Font myFont2 = new Font("Segoe UI", Font.BOLD, 20);

    // Defining questions with their possible answers and the index of the correct answer.
    Question question1 = new Question("Which of the following works is not written by Ion Creangă?",
            new ArrayList<>(List.of("Childhood Memories", "The Story of the Pig", "The Lucky Mill", "The Goat with Three Kids")),
            2);

    Question question2 = new Question("Who is the author of the work \"Otilia's Enigma\"?",
            new ArrayList<>(List.of("Mihai Eminescu", "Ion Creangă", "Liviu Rebreanu", "George Călinescu")),
            3);

    Question[] questions = {question1, question2};

    // Constructor for the Answer class
    Answer() {
    }

    // Method to set up the initial game interface
    public void game() {
        textField = new JTextField();
        textField.setBounds(450, 200, 400, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setText("Welcome to our game!");

        frame = new JFrame("Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1340, 720);
        frame.setLayout(null);

        button = new JButton("Start");
        button.setBounds(540, 350, 200, 80);
        button.setFocusable(false);
        button.setFont(myFont);
        button.addActionListener(this);

        frame.add(button);
        frame.add(textField);
        frame.setVisible(true);
    }

    // Event handling method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            frame.getContentPane().removeAll();
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();

            if (i < questions.length) {
                gameInterface();
                frame.add(textField2);
                frame.add(panel);
            } else {
                textField2.setText("The game has ended!");
            }
        }

        for (int j = 0; j < 4; j++) {
            if (e.getSource() == variants[j]) {
                if (i < questions.length) {
                    if (questions[i].getCorrectAnswer() == j) {
                        textField2.setText("Correct!");

                        // Disable buttons after answering
                        for (int k = 0; k < 4; k++) {
                            variants[k].setEnabled(false);
                        }

                    } else {
                        textField2.setText("Wrong!");

                        // Disable buttons after answering
                        for (int k = 0; k < 4; k++) {
                            variants[k].setEnabled(false);
                        }
                    }

                    // Set all buttons' background color to red
                    for (int k = 0; k < 4; k++) {
                        variants[k].setBackground(Color.red);
                    }

                    // Set correct answer button's background color to green
                    variants[questions[i].getCorrectAnswer()].setBackground(Color.green);
                }
            }
        }

        if (e.getSource() == nextButton) {
            i++;
            frame.getContentPane().removeAll();
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();

            if (i < questions.length) {
                gameInterface();
                frame.add(textField2);
                frame.add(panel);
            } else {
                frame.add(textField2);
                textField2.setText("The game has ended!");
            }
        }
    }

    // Method to set up the interface for each question
    public void gameInterface() {
        button1 = new JButton(questions[i].getVariants().get(0));
        button2 = new JButton(questions[i].getVariants().get(1));
        button3 = new JButton(questions[i].getVariants().get(2));
        button4 = new JButton(questions[i].getVariants().get(3));
        button1.setFocusable(false);
        button1.setFont(myFont2);
        button2.setFocusable(false);
        button2.setFont(myFont2);
        button3.setFocusable(false);
        button3.setFont(myFont2);
        button4.setFocusable(false);
        button4.setFont(myFont2);
        variants[0] = button1;
        variants[1] = button2;
        variants[2] = button3;
        variants[3] = button4;
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(50, 200, 1200, 150);
        panel.setLayout(new GridLayout(1, 4, 10, 10));
        panel.add(variants[0]);
        panel.add(variants[1]);
        panel.add(variants[2]);
        panel.add(variants[3]);

        textField2 = new JTextField();
        textField2.setBounds(100, 100, 1150, 50);
        textField2.setFont(myFont);
        textField2.setEditable(false);
        textField2.setText(questions[i].getQuestion());

        nextButton = new JButton("Next");
        nextButton.setBounds(1020, 530, 130, 60);
        nextButton.setFocusable(false);
        nextButton.setFont(myFont);
        nextButton.addActionListener(this);

        frame.add(nextButton);
        frame.add(textField2);
        frame.add(panel);
    }
}
