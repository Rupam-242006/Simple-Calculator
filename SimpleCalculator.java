import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class SimpleCalculator implements ActionListener {
    JFrame f;
    JTextField tf;
    JPanel p;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    String operator = "";
    double num1 = 0;
    boolean startNewNumber = false;
    public SimpleCalculator(){

        f = new JFrame("Simple Calculator"); 
        f.setSize(300,400 );
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(240, 240, 240));
      
        tf = new JTextField();
        tf.setEditable(false);
        tf.setFont(new Font("Arial", Font.PLAIN, 24));
        tf.setHorizontalAlignment(SwingConstants.RIGHT);
        tf.setBackground(Color.WHITE);
        f.add(tf,BorderLayout.NORTH);
        
        p = new JPanel();
        p.setLayout(new GridLayout(4,4,10,10));
        p.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Keypad"));
        p.setBackground(new Color(220, 220, 220));
        f.add(p,BorderLayout.CENTER);
        f.setVisible(true);

        b1 = new JButton("1");      
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("+");     
        b5 = new JButton("4");      
        b6 = new JButton("5");       
        b7 = new JButton("6");
        b8 = new JButton("-");
        b9 = new JButton("7");        
        b10 = new JButton("8");        
        b11 = new JButton("9");        
        b12 = new JButton("*");      
        b13 = new JButton(".");       
        b14 = new JButton("0");       
        b15 = new JButton("=");
        b16 = new JButton("/");
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
       
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        p.add(b13);
        p.add(b14);
        p.add(b15);
        p.add(b16);

        b1.setBackground(new Color(200, 230, 201));
        b2.setBackground(new Color(200, 230, 201));
        b3.setBackground(new Color(200, 230, 201));
        b4.setBackground(new Color(187, 222, 251));
        b5.setBackground(new Color(200, 230, 201));
        b6.setBackground(new Color(200, 230, 201));
        b7.setBackground(new Color(200, 230, 201));
        b8.setBackground(new Color(187, 222, 251));
        b9.setBackground(new Color(200, 230, 201));
        b10.setBackground(new Color(200, 230, 201));
        b11.setBackground(new Color(200, 230, 201));
        b12.setBackground(new Color(187, 222, 251));
        b13.setBackground(new Color(200, 230, 201));
        b14.setBackground(new Color(200, 230, 201));
        b15.setBackground(new Color(200, 230, 201));
        b16.setBackground(new Color(187, 222, 251));

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
        if (startNewNumber) {
            tf.setText("");
            startNewNumber = false;
        }
        tf.setText(tf.getText() + command);
    } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
        try {
            num1 = Double.parseDouble(tf.getText());
            operator = command;
            startNewNumber = true;
        } catch (NumberFormatException ex) {
            tf.setText("Error");
        }
    } else if (command.equals("=")) {
        try {
            double num2 = Double.parseDouble(tf.getText());
            double result = 0;
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        tf.setText("Cannot divide by 0");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default: return;
            }
            tf.setText(String.valueOf(result));
            startNewNumber = true;
        } catch (NumberFormatException ex) {
            tf.setText("Error");
        }
    }
}
    public static void main(String args[]){
        SimpleCalculator sc = new SimpleCalculator();
    }
}
