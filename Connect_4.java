import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Connect_4 implements ActionListener{

    private JFrame frame=new JFrame("CONNECT-4-GAME");;
    private JPanel  panel=new JPanel();
    private JButton[] buttons=new JButton[16];
    private boolean X_turn=true;

    public Connect_4(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(4, 4));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        for(int i=0;i<16;i++){
            buttons[i] =new JButton();
            buttons[i].setFont(new Font("Arial",Font.PLAIN,60));
            buttons[i].addActionListener(this);
            
            panel.add(buttons[i]);
        
        }

        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        JButton button=(JButton) e.getSource();
        if(X_turn){
            button.setText("X");
        }
        else{
            button.setText("O");
        }
        button.setEnabled(false);
        X_turn = !X_turn;

        winner();
    }


    /**
     * 
     */
    public void winner(){
        
    
// 1st row
            if(buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText()) && buttons[2].getText().equals(buttons[3].getText())  && !buttons[0].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[0].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;
            }
        
// 2nd row
       

            if(buttons[4].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[6].getText()) && buttons[6].getText().equals(buttons[7].getText()) && !buttons[4].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[4].getText()+"  "+ "Hurray!!! WIN");
                reset();
                return;
            }
        

//  3rd row
            if(buttons[8].getText().equals(buttons[9].getText()) && buttons[9].getText().equals(buttons[10].getText()) &&  buttons[10].getText().equals(buttons[11].getText())  && !buttons[8].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[8].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            } 

// 4th row
             if(buttons[12].getText().equals(buttons[13].getText()) && buttons[13].getText().equals(buttons[14].getText()) &&  buttons[14].getText().equals(buttons[15].getText())  && !buttons[12].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[12].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            }

//left vertical

             if(buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText()) &&  buttons[8].getText().equals(buttons[12].getText())  && !buttons[0].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[0].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            }
// 2nd left vertical
             if(buttons[1].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[9].getText()) &&  buttons[9].getText().equals(buttons[13].getText())  && !buttons[1].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[1].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            }
//2nd right vertical
             if(buttons[2].getText().equals(buttons[6].getText()) && buttons[6].getText().equals(buttons[10].getText()) &&  buttons[10].getText().equals(buttons[14].getText())  && !buttons[2].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[2].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            }
//right vertical

            if(buttons[3].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[11].getText()) &&  buttons[11].getText().equals(buttons[15].getText())  && !buttons[3].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[3].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            }
//top-left to bottom-right diagonal victory

            if(buttons[0].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[10].getText()) &&  buttons[10].getText().equals(buttons[15].getText())  && !buttons[0].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[0].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            }

//top-right to bottom-left diagonal

            if(buttons[3].getText().equals(buttons[6].getText()) && buttons[6].getText().equals(buttons[9].getText()) &&  buttons[9].getText().equals(buttons[12].getText())  && !buttons[3].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[3].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            }
            

            // match tie

            boolean tie=true;
            for(int i=0;i<16;i++){

                if(buttons[i].isEnabled()){
                    tie=false;
                    break;
                }
            }

            if(tie){

                JOptionPane.showMessageDialog(frame, "Its a TIE  !!!");
                reset();
            }
    }


    public void reset(){

        for(int i=0;i<16;i++){

            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        X_turn=true;
    }


    public static void main(String[] args){
        new Connect_4();
    }
}