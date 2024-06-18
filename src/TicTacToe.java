import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    //Attributes
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] button = new JButton[9];
    boolean ;


    //Constructor
    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25, 25, 25));
        text_field.setForeground(new Color(0, 146, 167));
        text_field.setFont(new Font("Ink Free", Font.BOLD, 80));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe Game");
        //text_field.setText("By Iky");
        text_field.setOpaque(true);//we will add this entire text_field to the title panel

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 50);

        button_panel.setLayout(new GridLayout(3, 3));
        //button_panel.setBackground(new Color(51,165,15));

        //Button Loop for traversal
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton(); //initiate button at index i (for loop)
            button_panel.add(button[i]); //add button to button panel
            button[i].setFont(new Font("Times New Roman", Font.BOLD, 0x5a)); //set button font
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        //add all components together, then to Frame
        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        first_turn(); //call first_turn method (player 1's turn)

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {//each play will cycle through each of the nine buttons to get response
            if (e.getSource() == button[i]) {//if button is selected
                if (player1_turn) {//player 1, action occurs with button selection of X
                    if (button[i].getText() == "") {//first selections is blank
                        button[i].setForeground(new Color(250, 126, 0));
                        button[i].setText("X");
                        player1_turn = false;//after X's turn it becomes false
                        text_field.setText("O turn");
                        check_status();
                    }

                        }
                else {//O is picked
                    if (button[i].getText() == "") {//first selections is blank
                        button[i].setForeground(new Color(0, 125, 202));
                        button[i].setText("O");
                        player1_turn = true;//after O's turn it becomes false
                        text_field.setText("X turn");
                        check_status();
                    }
                }
            }

        }

    }

    //(All Methods)

    //Method to assign first turn
    public void first_turn() {

        try { //delays the title, before indicator to start play
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2) == 0) { //random class will pick # between 0 & 1. notice bound 2 for (0 or 1)
            player1_turn = true; //if 0 pick player 1 with use of boolean
            text_field.setText("X turn");
        } else {
            player1_turn = false;
            text_field.setText("O turn");
        }
    }

    //Method to check status (player win/losses)
    private void check_status() {

        //check X win conditions
        if(
                (button[0].getText()=="X")&&
                (button[1].getText()=="X")&&
                (button[2].getText()=="X")
                ){
            X_wins(0,1,2);
        }
        if(
                (button[3].getText()=="X")&&
                (button[4].getText()=="X")&&
                (button[5].getText()=="X")
        ){
            X_wins(3,4,5);
        }
        if(
                (button[6].getText()=="X")&&
                (button[7].getText()=="X")&&
                (button[8].getText()=="X")
        ){
            X_wins(6,7,8);
        }
        if(
                (button[0].getText()=="X")&&
                (button[3].getText()=="X")&&
                (button[6].getText()=="X")

        ){
            X_wins(0,3,6);
        }
        if(
                (button[1].getText()=="X")&&
                (button[4].getText()=="X")&&
                (button[7].getText()=="X")
        ){
            X_wins(1,4,7);
        }
        if(
                (button[2].getText()=="X")&&
                (button[5].getText()=="X")&&
                (button[8].getText()=="X")
        ){
            X_wins(2,5,8);
        }
        if(
                (button[0].getText()=="X")&& //winning combo, diagonally
                (button[4].getText()=="X")&&
                (button[8].getText()=="X")
        ){
            X_wins(0,4,8);
        }
        if(
                (button[2].getText()=="X")&& //winning combo, diagonally
                (button[4].getText()=="X")&&
                (button[6].getText()=="X")
        ){
            X_wins(2,4,6);
        }


        //check O win condition
        if(
                (button[0].getText()=="O")&&
                (button[1].getText()=="O")&&
                (button[2].getText()=="O")
        ){
            O_wins(0,1,2);
        }
        if(
                (button[3].getText()=="O")&&
                (button[4].getText()=="O")&&
                (button[5].getText()=="O")
        ){
            O_wins(3,4,5);
        }
        if(
                (button[6].getText()=="O")&&
                (button[7].getText()=="O")&&
                (button[8].getText()=="O")
        ){
            O_wins(6,7,8);
        }
        if(
                (button[0].getText()=="O")&&
                (button[3].getText()=="O")&&
                (button[6].getText()=="O")

        ){
            O_wins(0,3,6);
        }
        if(
                (button[1].getText()=="O")&&
                (button[4].getText()=="O")&&
                (button[7].getText()=="O")
        ){
            O_wins(1,4,7);
        }
        if(
                (button[2].getText()=="O")&&
                (button[5].getText()=="O")&&
                (button[8].getText()=="O")
        ){
            O_wins(2,5,8);
        }
        if(
                (button[0].getText()=="O")&& //winning combo, diagonally
                (button[4].getText()=="O")&&
                (button[8].getText()=="O")
        ){
            O_wins(0,4,8);
        }
        if(
                (button[2].getText()=="O")&& //winning combo, diagonally
                (button[4].getText()=="O")&&
                (button[6].getText()=="O")
        ){
            O_wins(2,4,6);
        }
        
       
    }

    //Method to check if X wins
    public void X_wins(int a, int b, int c) {
        button[a].setBackground(new Color(51,165,15));//winning combo changes color to indicate win
        button[b].setBackground(new Color(51, 165,15));
        button[c].setBackground(new Color(51, 165,15));

        for(int i = 0; i < 9; i++){ //loop to traverse all buttons to disable them after player win
            button[i].setEnabled(false);//disable all 9 buttons in the Frame
        }

        text_field.setText("X wins, Good Job!!");//Change text_field to display win msg

    }

    //Method to check if O wins
    public void O_wins(int a, int b, int c) {
        for (int j : new int[]{a, b, c}) {
            button[j].setBackground(new Color(51, 165,15));//winning combo changes color to indicate win
        }

        for(int i = 0; i < 9; i++){ //loop to traverse all buttons to disable them after player win
            button[i].setEnabled(false);//disable all 9 buttons in the Frame
        }

        text_field.setText("O wins, Good Job!!");//Change text_field to display win ms

    }

}

