import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton add,sub,mul,div,negate;
    JButton decimal,equal,delete,clear;
    JPanel panel;
    JTextField R;

    Font f = new Font(null, Font.BOLD, 50);
    Font f1 = new Font(null, Font.PLAIN, 30);
    Font f2 = new Font("Monospaced",Font.ITALIC,40);

    Double num1 = 0.0,num2 = 0.0,result = 0.0;
    char operator;

    public Calculator(){

        //FRAME:
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810,900);
        frame.setLayout(null);
        frame.setBackground(Color.LIGHT_GRAY);

        //TEXT_FIELD:
        textField = new JTextField();
        // textField.setBounds(50, 25, 300, 50);
        textField.setBounds(150, 100, 500, 75);
        textField.setFont(f);
        // textField.setBackground(Color.lightGray);
        textField.setBorder (BorderFactory. createLineBorder (new Color (0, 0, 0, 0), 2));
        // textField.setEditable(false);
        JTextField t = new JTextField();
        t.setFont(f2);
        t.setBounds(50, 100, 100, 75);
        t.setBorder (BorderFactory. createLineBorder (new Color (0, 0, 0, 0), 2));
        t.getCaret().setVisible(false);
        t.setFocusable(false);
        t.setEditable(false);
        t.setText("Ans: ");
        frame.add(t);

        //BUTTONS:
        negate = new JButton("(-)");
        negate.addActionListener(this);
        negate.setFont(f);
        negate.setFocusable(false);
        negate.setBackground(Color.white);

        add = new JButton("+");
        add.addActionListener(this);
        add.setFont(f);
        add.setFocusable(false);
        add.setBackground(Color.white);

        sub = new JButton("-");
        sub.addActionListener(this);
        sub.setFont(f);
        // sub.setBounds(530, 201, 117, 117);
        sub.setFocusable(false);
        sub.setBackground(Color.white);
        frame.add(sub);

        mul = new JButton("*");
        mul.addActionListener(this);
        mul.setFont(f);
        mul.setFocusable(false);
        mul.setBackground(Color.white);

        div = new JButton("/");
        div.addActionListener(this);
        div.setFont(f);
        div.setFocusable(false);
        div.setBackground(Color.white);

        

        equal = new JButton("=");
        equal.addActionListener(this);
        equal.setFont(f);
        equal.setFocusable(false);
        equal.setBackground(Color.YELLOW);

        delete = new JButton("del");
        delete.addActionListener(this);
        delete.setFont(f);
        delete.setFocusable(false);
        delete.setBackground(Color.red);

        

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(f);
            numbers[i].setBackground(Color.gray);
            numbers[i].setFocusable(false);
        }

        numbers[0].setBounds(150, 710, 246, 110);
        numbers[0].setBackground(Color.WHITE);
        frame.add(numbers[0]);

        decimal = new JButton(".");
        decimal.addActionListener(this);
        decimal.setFont(f);
        decimal.setBounds(405, 710, 117, 110);
        decimal.setFocusable(false);
        decimal.setBackground(Color.gray);
        frame.add(decimal);

        clear = new JButton("C");
        clear.addActionListener(this);
        clear.setFont(f);
        clear.setFocusable(false);
        clear.setBackground(Color.orange);
        clear.setBounds(532, 710, 117, 110);

        panel = new JPanel();
        panel.setBounds(150, 200, 500, 500);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        

	    R = new JTextField();
        R.setFont(f1);
        // R.setBackground(Color.lightGray );
        R.setBounds(150, 40, 410, 75);
        R.setFocusable(false);
        R.setBorder (BorderFactory. createLineBorder (new Color (0, 0, 0, 0), 2));

        panel.add(negate);
        panel.add(div);
        panel.add(mul);
        panel.add(delete);

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(add);
        
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);
        
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(equal);


        
        
        // frame.setBackground(Color.BLACK);
        // panel.setBackground(Color.gray);
        textField.setEditable(false);
        R.setEditable(false);

        frame.add(panel);
        frame.add(clear);

        frame.add(textField);
        frame.add(R);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i < 10; i++){
            if(e.getSource() == numbers[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimal)
            textField.setText(textField.getText().concat("."));
        else if(e.getSource() == add){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            R.setText(textField.getText()+"+");
            textField.setText("");
        }else if(e.getSource() == sub){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            R.setText(textField.getText()+"-");
            textField.setText("");
        }else if(e.getSource() == mul){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            R.setText(textField.getText()+"*");
            textField.setText("");
        }else if(e.getSource() == div){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            R.setText(textField.getText()+"/");
            textField.setText("");
        }else if(e.getSource() == equal){
            num2 = Double.parseDouble(textField.getText());
            R.setText(R.getText()+textField.getText());
            result = calc(num1, num2, operator);
            if(result == result.intValue())
                textField.setText(String.valueOf(result.intValue()));
            else
                textField.setText(String.valueOf(result));
            num1 = result;
        }else if(e.getSource() == clear){
            textField.setText("");
            R.setText("");
        }else if(e.getSource() == delete){
            textField.setText(textField.getText().substring(0, textField.getText().length()-1));
        }else if(e.getSource() == negate){
            String currentText = textField.getText();
            if (currentText.startsWith("-")) 
                textField.setText(currentText.substring(1));
            else 
                textField.setText("-" + currentText);
        }
            
        
    }
    Double calc(Double num1,Double num2,char operator){
        switch(operator){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0.0;
            }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    
}
