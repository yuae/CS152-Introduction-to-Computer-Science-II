
/**
 * class MyPanel - the panel actually visulize the wondow for the host
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.28, 2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MyPanel extends JPanel
{
    // instance variables for this class
    private ArrayList<Question> list = new ArrayList<Question>();//question list
    private int aScore = 0;//times of team A correct
    private int bScore = 0;//times of team B correct
    private int number = 1;//number of question
    private final int COUNTDOWN = 5000;//how long timer's going to last
    
    //instance objects for this class
    private JButton timer, aCount, bCount, next, quit;
    private JLabel question, answer, score1, score2;
    private Timer time = new Timer(COUNTDOWN, new RevealListener());
    
    public MyPanel() throws IOException
    {
        //creat arraylist
        setQuestionList();
        
        //creat panels for different uses
        JPanel questionPane = new JPanel();
        JPanel timerPane = new JPanel();
        JPanel answerPane = new JPanel();
        JPanel aTeamPane = new JPanel();//display team a correct button and score
        JPanel bTeamPane = new JPanel();//display team b correct button and score
        JPanel buttonPane = new JPanel();//display next and quit button
        
        //creat buttons
        question = new JLabel("Q"+number+": "+list.get(number-1).getQuestion());//set label text
        question.setForeground(new Color(93,172,179));//set the color of questions
        question.setFont(new Font("Serief",1,16));//set the font of questions
        answer = new JLabel("");
        answer.setForeground(new Color(150,90,130));//set the color of the answers
        answer.setFont(new Font("Serief",1,16));//set the font of the answers
        score1 = new JLabel("Score: "+ aScore);
        score1.setForeground(Color.BLUE);
        score2 = new JLabel("Score: "+ bScore);
        score2.setForeground(Color.BLUE);
        
        //add button listeners
        timer = new JButton("Start Timer");
        timer.addActionListener(new TimerListener());
        aCount = new JButton("Team A Correct");
        aCount.addActionListener(new ACListener());
        bCount = new JButton("Team B Correct");
        bCount.addActionListener(new BCListener());
        next = new JButton("Next");
        next.addActionListener(new NextListener());
        quit = new JButton("Quit");
        quit.addActionListener(new QuitListener());
        
        //set layout of this main JPanel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //set layout of  the sub panels
        aTeamPane.setLayout(new BoxLayout(aTeamPane, BoxLayout.X_AXIS));
        bTeamPane.setLayout(new BoxLayout(bTeamPane, BoxLayout.X_AXIS));
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
        
        //add buttons to Panel and set layout form
        add(Box.createVerticalGlue());//adding space between each objects
        questionPane.add(question);
        add(questionPane);
        add(Box.createVerticalGlue());//adding space between each objects
        timerPane.add(timer);
        add(timerPane);
        add(Box.createVerticalGlue());//adding space between each objects
        answerPane.add(answer);
        add(answerPane);
        add(Box.createVerticalGlue());//adding space between each objects
        
        //add objects to aTeamPane
        aTeamPane.add(aCount);
        aTeamPane.add(Box.createRigidArea(new Dimension(10,0)));//adding space between button and scores
        aTeamPane.add(score1);
        add(aTeamPane);//add bTeamPane to main panel
        
        //adding space between each panels
        add(Box.createVerticalGlue());
        
        //add objects to bTeamPane
        bTeamPane.add(bCount);
        bTeamPane.add(Box.createRigidArea(new Dimension(10,0)));//adding space between button and scores
        bTeamPane.add(score2);
        add(bTeamPane);//add bTeamPane to main panel
        
        //adding space between each panels
        add(Box.createVerticalGlue());
        
        //add objects to buttonPane
        buttonPane.add(next);
        buttonPane.add(Box.createHorizontalGlue());//adding space between buttons
        buttonPane.add(quit);
        add(buttonPane);//add bTeamPane to main panel
        
        //set main panel size and background color
        setPreferredSize(new Dimension(800,250));
        setBackground(Color.WHITE);
        
        //set sub panels background color
        questionPane.setBackground(Color.WHITE);
        timerPane.setBackground(Color.WHITE);
        answerPane.setBackground(Color.WHITE);
        aTeamPane.setBackground(Color.WHITE);
        bTeamPane.setBackground(Color.WHITE);
        buttonPane.setBackground(Color.WHITE);
    }
    
    //helper method to store questions and answers
    private void setQuestionList() throws IOException
    {
        JFileChooser fc = new JFileChooser(".");//creat filechooser object
        fc.setDialogTitle("Choose Question File");
        fc.showOpenDialog(null);
        String question = "";//initializing variables
        String answer = "";
        Scanner fileScan = new Scanner(fc.getSelectedFile());//scan file
        for(int i = 0;fileScan.hasNext();i++)
        {
            if(i%2 == 0)//determine whether it's the question or the answer currently being scanned
                question = fileScan.nextLine();
            else
            {    
                answer = fileScan.nextLine();
                Question qa = new Question(question,answer);//creat question object
                list.add(qa);//add to arraylist
            }
        }
        fileScan.close();//close scanner
    }
    
    //impliment actions to every button
    private class TimerListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            time.start();//start timer when button clicked
        }
    }
    private class ACListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            aScore++;
            score1.setText("Score: "+ aScore);//reset scores of team A
        }
    }
    private class BCListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            bScore++;
            score2.setText("Score: "+ bScore);//reset scores of team B
        }
    }
    private class NextListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            if(number<10)//stop doing anything when question reaches to 10
            {
                number++;
                question.setText("Q"+number+": "+list.get(number-1).getQuestion());//reset question
                answer.setText("");//reset answer to blank
            }
        }
    }
    private class QuitListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            System.exit(0);//quit the program
        }
    }
    
    //set action when timer end 
    private class RevealListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            time.stop();//stop timer
            answer.setText("A: "+list.get(number-1).getAnswer());//reveal answer when times up
        }
    }
}
