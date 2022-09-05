import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 und 100 ein!");
    static JTextField textField = new JTextField();

    public static void main(String[] args) {
        openUI();
        // nextRound();
    }
    public static void openUI() {
        JFrame frame = new JFrame("Rate die Zahl");
        frame.setSize(400, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        text.setBounds(50,50,350,30);

        textField.setBounds(50,100,200,30);

        JButton Button = new JButton("Raten!");
        Button.setBounds(50,150,200,30);

        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textFromTextfield = textField.getText();
                    Integer number = Integer.parseInt(textFromTextfield);
                    guess(number);
                } catch (Exception error){
                    text.setText("Bitte gebe eine Zahl.. Du Loser");
                }
            }
        });

        frame.add(text);
        frame.add(textField);
        frame.add(Button);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void guess(Integer number) {
        if (number == myNumber) {
            text.setText("Richtig, du hast " +tries + " versuche gebraucht! :)");
        } else {
            tries++;


            if(number < myNumber){
                text.setText("Leider falsch, deine Zahl ist zu klein. :)");
            }
            else {
                text.setText("Leider falsch, deine Zahl ist zu groß.");
            }
            textField.setText("");
        }
    }
}