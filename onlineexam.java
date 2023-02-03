package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.util.Scanner;
class OnlineTest extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    // create jFrame with radioButton and JButton
    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        //radioButton[0].setBounds(50, 80, 200, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    // handle all actions based on event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 4) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 4)
                btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct answers= " + count);
            System.exit(0);
        }
    }

    // SET Questions with options
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Que1:  Which environment variable is used to set the java path?");
            radioButton[0].setText("MAVEN_Path");
            radioButton[1].setText("JavaPATH");
            radioButton[2].setText("JAVA");
            radioButton[3].setText("JAVA_HOME");
        }
        if (current == 1) {
            label.setText("Que2:   Which of the following is not an OOPS concept in Java?");
            radioButton[0].setText("Polymorphism");
            radioButton[1].setText("Inheritance");
            radioButton[2].setText("Compilation");
            radioButton[3].setText("Encapsulation");
        }
        if (current == 2) {
            label.setText("Que3: Which exception is thrown when java is out of memory?");
            radioButton[0].setText("MemoryError");
            radioButton[1].setText("OutOfMemoryError");
            radioButton[2].setText("MemoryOutOfBoundsException");
            radioButton[3].setText("MemoryFullException");
        }
        if (current == 3) {
            label.setText("Que4: Which of these are selection statements in Java?");
            radioButton[0].setText("break");
            radioButton[1].setText("continue");
            radioButton[2].setText("for()");
            radioButton[3].setText("if()");
        }
        if (current == 4) {
            label.setText("Que5: Which of these keywords is used to define interfaces in Java?");
            radioButton[0].setText(" intf");
            radioButton[1].setText("Intf");
            radioButton[2].setText("interface");
            radioButton[3].setText("Interface");
        }
       
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    // declare right answers.
    boolean check() {
        if (current == 0)
            return (radioButton[1].isSelected());
        if (current == 1)
            return (radioButton[1].isSelected());
        if (current == 2)
            return (radioButton[0].isSelected());
        if (current == 3)
            return (radioButton[2].isSelected());
        if (current == 4)
            return (radioButton[0].isSelected());
        if (current == 5)
            return (radioButton[0].isSelected());
        if (current == 6)
            return (radioButton[0].isSelected());
        if (current == 7)
            return (radioButton[0].isSelected());
        if (current == 8)
            return (radioButton[0].isSelected());
        if (current == 9)
            return (radioButton[0].isSelected());
       
        return false;
    }
}



public class onlineexam {

  
    public static void main(String[] args) {
       String username, password;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username:");//username:user
        username = s.nextLine();
        System.out.print("Enter password:");//password:user
        password = s.nextLine();
        if(username.equals("shubhamkate") && password.equals("0000"))
        {
            System.out.println("Authentication Successful");
            new OnlineTest("Online Test App");
    }
        else
        {
            System.out.println("Authentication Failed");
        }
    
}
}
