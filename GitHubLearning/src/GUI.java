import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUI implements ActionListener {
    JFrame frame;
    JPanel panel;

    JTextField textField;
    JButton button;

    String textString = "";
    GUI(){
        frame = new JFrame("GITHUB LEARNING");
        frame.setSize(650,300);
        panel = new JPanel();

        textField = new JTextField(textString);
        textField.setEditable(false);
        Font newFont = new Font("Serif", Font.BOLD, 40);
        textField.setFont(newFont);
        textField.setHorizontalAlignment(JTextField.CENTER);

        button = new JButton("Update Time.");
        button.addActionListener(this);
        panel.setLayout(new GridLayout(2,1));
        panel.setBorder(BorderFactory.createEmptyBorder(90, 170, 90, 170));
        panel.add(textField);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        textString = time.format(formatter);

        textField.setText(textString);
    }
}
