/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mib_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
//import javax.swing.Timer;

/**
 *
 * @author anton
 */
public class MIB_Project {
    
    ChangePasswordHandeler changePassHandeler = new ChangePasswordHandeler();
    LoginHandeler loginHandeler = new LoginHandeler();
    ExeNewPassword exeNewPasswordHandeler = new ExeNewPassword();
    //TimerHandler timerHandler = new TimerHandler();
    
    
    //Timer timer;
    //double perSecond;
    //boolean timerOn;
    //int timerSpeed, sessionTimerCounter;
    
    boolean inloggningsStatus = false;

    boolean agentinloggad = false;
    boolean alieninloggad = false;

    private static InfDB idb;
    private static JLabel userLabel, sessionTimerLabel, perSecLabel;
    private static JTextField userText;
    private static JLabel passwordLabel, cPasswordLabel, nPasswordLabel;
    private static JPasswordField passwordText, cPasswordText, nPasswordText;
    private static JButton inloggButton, changePassButton, exeNewPasswordButton, buttonSet1, buttonSet2, buttonSet3, buttonSet4;
    private static JLabel success;
    private static Font fontHeadliner, fontHeadliner1, fontHeadliner2, fontBread;
    
    

    /**
     * @param args the command line arguments
     * @throws oru.inf.InfException
     */
    //Koden för att logga in till databasen. Körs direkt per auto (riktiga mainen).
    public static void main(String[] args) throws InfException {
        // TODO code application logic here
        
        try 
        {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        }
        catch (InfException ex)
        {
            Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Om try-catchen funkar och vi loggas in på oru databasen så öppnar våran riktiga main våran "fake"-main MIB_Project.
        new MIB_Project();
        
    }
    
    //Våran "fake"-main. Det som körs när vi loggats in på oru databas tack vare metodanropet i slutet på riktiga mainen.
    public MIB_Project()
    {
        
        //timerOn = false;
        //perSecond = 1;
        //sessionTimerCounter = 0;
        
        passwordWindow();
        createFont();
    }
    
    //Här kan vi skapa en metod vi åkallar när vi vill att ett fönster ska stängas utan att behöva klicka på krysset i programmfönstret.
    public void closeWindow()
    {
        

    }
    
    //Här har vi en metod för att skapa typsnitt som används i programmet. Dessa deklareras som fält längst upp i MIB_Project-classen.
    public void createFont() 
    {
        fontHeadliner = new Font("Papyrus",Font.LAYOUT_NO_START_CONTEXT, 45);
        fontHeadliner1 = new Font("Courier New", Font.BOLD, 70 );
        fontHeadliner2 = new Font("Desdemona", Font.BOLD, 55 );
        fontBread = new Font("Calibri Brödtext", Font.LAYOUT_NO_START_CONTEXT, 18);
    }
    

//______________________________________________________________________________________________________
// Koden för GUIn till när man ändrar lösenord
    public void changePasswordWindow()
    {
        JPanel panel = new JPanel();
        
        JFrame frame = new JFrame();
        frame.setSize(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        
        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);
        
        cPasswordLabel = new JLabel("Current Password");
        cPasswordLabel.setBounds(10,50,120,25);
        panel.add(cPasswordLabel);
        
        nPasswordLabel = new JLabel("New Password");
        nPasswordLabel.setBounds(10,80,120,25);
        panel.add(nPasswordLabel);
        
        cPasswordText = new JPasswordField();
        cPasswordText.setBounds(120, 50, 185, 25);
        panel.add(cPasswordText);
        
        nPasswordText = new JPasswordField();
        nPasswordText.setBounds(120, 80, 185, 25);
        panel.add(nPasswordText);
        
        userText = new JTextField(20);
        userText.setBounds(120, 20, 185, 25);
        panel.add(userText);
        
        exeNewPasswordButton = new JButton("Ändra lösenord");
        exeNewPasswordButton.setBounds(10, 120, 185, 25);
        exeNewPasswordButton.addActionListener(exeNewPasswordHandeler);
        panel.add(exeNewPasswordButton);
        
        success = new JLabel("");
        success.setBounds(10,100,300,25);
        panel.add(success);
        
        frame.setVisible(true);
        
    }
    // Koden för metoden getNamn från Agent tabellen
    public String getNamn() throws InfException 
    {
        try
        {
        String username = userText.getText();
        String frågaNamn = "SELECT Namn FROM Agent WHERE Namn =" + "'" + username + "'";
        String svarNamn = idb.fetchSingle(frågaNamn);
        String user = svarNamn;
        
        return user;
        }
        
        catch (InfException c)
                {
                       JOptionPane.showMessageDialog(null, "Login failed");
                }
        return getNamn();
    }
    
    
//______________________________________________________________________________________________________
// Koden för metoden getNamn från Alien tabellen
    public String getNamnAlien() throws InfException 
    {
        try
        {
        String username = userText.getText();
        String frågaNamn = "SELECT Namn FROM Alien WHERE Namn =" + "'" + username + "'";
        String svarNamn = idb.fetchSingle(frågaNamn);
        String user = svarNamn;
        
        return user;
        }
        
        catch (InfException c)
                {
                       JOptionPane.showMessageDialog(null, "Login failed");
                }
        return getNamnAlien();
    }
    
    public String getIDAgent(String namn) throws InfException
    {
        String fråga = "Select Agent_ID from Agent where Namn = '" + namn + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }
    
    public String getIDAlien(String namn) throws InfException
    {
        String fråga = "Select Alien_ID from Alien where Namn = '" + namn + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }
    
    public String getLosenAgentByID(String id) throws InfException
    {
        String fråga = "Select Losenord from Agent where id = " + id;
        String svar = idb.fetchSingle(fråga);
        return svar;
    }
    
    public String getLosenAgentByName(String name) throws InfException
    {
        String fråga = "Select Losenord from Agent where namn = '" + name + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }
    
    public String getLosenAlienByID(String id) throws InfException
    {
        String fråga = "Select Losenord from Alien where id = " + id;
        String svar = idb.fetchSingle(fråga);
        return svar;
    }
    
    public String getLosenAlienByName(String name) throws InfException
    {
        String fråga = "Select Losenord from Alien where Namn = '" + name + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }
    
    // Koden för Agent Menyn som öppnas efter inlogg som agent    
    public void GUIMeny() throws InfException
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.pink);
        
        JFrame frame = new JFrame();
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        
        JLabel headliner = new JLabel("MIB HUB");
        headliner.setBounds(625,80,300,80);
        headliner.setForeground(Color.black);
        headliner.setFont((fontHeadliner1));
        panel.add(headliner);
        
        JLabel welcomeLabel = new JLabel("Welcome back " + getNamn());
        welcomeLabel.setBounds(625, 130,450,50);
        welcomeLabel.setForeground(Color.red);
        welcomeLabel.setFont(fontBread);
        panel.add(welcomeLabel);
        
        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(1020,580,200,200);
        ImageIcon logo = new ImageIcon("Images/bildlogga(3).png");
       // ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(bildtest1.png));
        logoLabel.setIcon(logo);
        panel.add(logoLabel);
        
       /** JPanel listPanel = new JPanel();
        * 
        listPanel.setBounds(500,170,250,250);
        listPanel.setBackground(Color.DARK_GRAY);
        listPanel.setLayout(new GridLayout (4,1));
        frame.add(listPanel);
        
        buttonSet1 = new JButton ("name function1");
        buttonSet1.setFont(fontBread);
        //buttonSet1.setFocusPainted(true);
        //buttonSet1.addActionListener();
        //buttonSet1.setActionCommand(" ");
        listPanel.add(buttonSet1);
        
        buttonSet2 = new JButton ("name function2");
        buttonSet2.setFont(fontBread);
        buttonSet2.setFocusPainted(true);
        //buttonSet1.addActionListener();
        //buttonSet1.setActionCommand(" ");
        listPanel.add(buttonSet2);
        
        buttonSet3 = new JButton ("name function3");
        buttonSet3.setFont(fontBread);
        buttonSet3.setFocusPainted(true);
        //buttonSet1.addActionListener();
        //buttonSet1.setActionCommand(" ");
        listPanel.add(buttonSet3);
        
        buttonSet4 = new JButton ("name function4");
        buttonSet4.setFont(fontBread);
        buttonSet4.setFocusPainted(true);
        //buttonSet1.addActionListener();
        //buttonSet1.setActionCommand(" ");
        listPanel.add(buttonSet4);
        listPanel.add(buttonSet4);*/

        
       /** JPanel timerPanel = new JPanel();
        timerPanel.setBounds(100,100,200,100);
        timerPanel.setBackground(Color.pink);
        timerPanel.setLayout(new GridLayout(2,1));
        frame.add(timerPanel);
        
        sessionTimerLabel = new JLabel(sessionTimerCounter + " sekunder");
        sessionTimerLabel.setForeground(Color.white);
        sessionTimerLabel.setFont(fontBread);
        timerPanel.add(sessionTimerLabel);
        
        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(fontBread);
        timerPanel.add(perSecLabel);
        */
        
        
        frame.setVisible(true);
        

        /**
         * JPanel timerPanel = new JPanel();
         * timerPanel.setBounds(100,100,200,100);
         * timerPanel.setBackground(Color.pink); timerPanel.setLayout(new
         * GridLayout(2,1)); frame.add(timerPanel);
         *
         * sessionTimerLabel = new JLabel(sessionTimerCounter + " sekunder");
         * sessionTimerLabel.setForeground(Color.white);
         * sessionTimerLabel.setFont(fontBread);
         * timerPanel.add(sessionTimerLabel);
         *
         * perSecLabel = new JLabel(); perSecLabel.setForeground(Color.white);
         * perSecLabel.setFont(fontBread); timerPanel.add(perSecLabel);
         */

        frame.setVisible(true);
        

        
    }
    

//______________________________________________________________________________________________________
// Koden för Alien Meny som kommer upp direkt efter inlogg som Alien
    public void GUIMeny_alien() throws InfException
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.pink);
        
        JFrame frame = new JFrame();
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        
        JLabel headliner = new JLabel("Alien HUB");
        headliner.setBounds(625,80,300,80);
        headliner.setForeground(Color.black);
        headliner.setFont((fontHeadliner1));
        panel.add(headliner);
        
        JLabel welcomeLabel = new JLabel("Welcome back " + getNamnAlien());
        welcomeLabel.setBounds(625, 130,450,50);
        welcomeLabel.setForeground(Color.red);
        welcomeLabel.setFont(fontBread);
        panel.add(welcomeLabel);
        
        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(1020,580,200,200);
        ImageIcon logo = new ImageIcon("Images/bildlogga(3).png");
        logoLabel.setIcon(logo);
        panel.add(logoLabel);
       
        
        frame.setVisible(true);
    }
    
    
    // Koden för knappen man trycker på för att logga in
    public class LoginHandeler implements ActionListener
    {
        @Override
    public void actionPerformed(ActionEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet.");
        try {
        String username = userText.getText();
        String password = passwordText.getText();

        
        //Hämta lösen agent
        String frågaAgentLosen = "Select Losenord from Agent where Namn =" + "'" + username + "'";
        String svarAgentLosen = idb.fetchSingle(frågaAgentLosen);
        String resultatAgentLosen = svarAgentLosen;
        //Hämta namn agent
        String frågaAgentNamn = "Select namn from agent where namn =" + "'" + username + "'";
        String svarAgentNamn = idb.fetchSingle(frågaAgentNamn);
        String resultatAgentNamn = svarAgentNamn;
        //Hämta namn alien
        String frågaAlienNamn = "SELECT Namn FROM Alien WHERE Namn =" + "'" + username + "'"; 
        String svarAlienNamn = idb.fetchSingle(frågaAlienNamn);
        String resultatAlienNamn = svarAlienNamn;
        //Hämta lösen alien
        String frågaAlienLosen = "SELECT Losenord FROM Alien WHERE Namn =" + "'" + username + "'";
        String svarAlienLosen = idb.fetchSingle(frågaAlienLosen);
        String resultatAlienLosen = svarAlienLosen;
              
        if(resultatAgentNamn!=null)
        {
            if(resultatAgentLosen.equals(password))           
            {
                success.setText("Login successfull!");
                inloggningsStatus = true;
                
                GUIMeny();
               // timerUpdate();
                //sessionTimer();
            }
            else
            {
                success.setText("Login failed");
            }
        }
        else if(resultatAlienNamn!=null)
        {
            if(resultatAlienLosen.equals(password))
            {
                success.setText("Login successfull!");
                inloggningsStatus = true;
                GUIMeny_alien();
               // timerUpdate();
                //sessionTimer();
            }
        }
        else
        {
            success.setText("Username doesn´t exist in database");
        }
 
        }
        catch (InfException e)
        {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
        
       
        
        
        
    }
    }

//______________________________________________________________________________________________________
// Koden för GUIn till inloggningsfönstret
    public void passwordWindow()
    {
       JPanel panel = new JPanel();
      
       JFrame frame = new JFrame();
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
        inloggButton = new JButton("Login");
        inloggButton.setBounds(10, 80, 80, 25);
        inloggButton.addActionListener( loginHandeler);
        //inloggButton.addActionListener(timerHandler);
        //inloggButton.setActionCommand("Login");
        panel.add(inloggButton);
        
        changePassButton = new JButton("Ändra lösenord");
        changePassButton.setBounds(100,80,165,25);
        changePassButton.addActionListener(changePassHandeler);
        panel.add(changePassButton);
        
        success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);
        
        //Om inloggningsStatus = false så ska fönstret förbli öppet när man klickar på login.
        if(!inloggningsStatus)
        {
        frame.setVisible(true);
        }
        
        //Om inloggningsstatus = true ska fönstret stängas när man klickar på login. Inte fått denna att funka än. 
        if(inloggningsStatus)
        {
        WindowEvent windowClosing = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosing);
        frame.dispatchEvent(windowClosing);
        
        }
        
    }
    
    // Koden för knappen som instansierar GUIn ändra lösenord
    public class ChangePasswordHandeler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent a)
        {
            changePasswordWindow();
        }
    }
    
//______________________________________________________________________________________________________    
// Koden för knappen som exikverar nytt lösenord
    public class ExeNewPassword implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent b)
        {
            try {

                String username = userText.getText();
                String currentPassword = passwordText.getText();

        
        //Hämta lösen agent
        String frågaAgentLosen = "Select Losenord from Agent where Namn =" + "'" + username + "'";
        String svarAgentLosen = idb.fetchSingle(frågaAgentLosen);
        String resultatAgentLosen = svarAgentLosen;
        //Hämta namn agent
        String frågaAgentNamn = "Select namn from agent where namn =" + "'" + username + "'";
        String svarAgentNamn = idb.fetchSingle(frågaAgentNamn);
        String resultatAgentNamn = svarAgentNamn;
        //Hämta namn alien
        String frågaAlienNamn = "SELECT Namn FROM Alien WHERE Namn =" + "'" + username + "'"; 
        String svarAlienNamn = idb.fetchSingle(frågaAlienNamn);
        String resultatAlienNamn = svarAlienNamn;
        //Hämta lösen alien
        String frågaAlienLosen = "SELECT Losenord FROM Alien WHERE Namn =" + "'" + username + "'";
        String svarAlienLosen = idb.fetchSingle(frågaAlienLosen);
        String resultatAlienLosen = svarAlienLosen;

               
                if (resultatAgentNamn != null) 
                {
                    if (resultatAgentLosen.equals(currentPassword)) 
                    {
                        inloggningsStatus = true;
                        agentinloggad = true;
                    } 
                   else 
                    {
                        success.setText("Password and username does not match");
                        inloggningsStatus = false;
                    }
                } 
                else if(resultatAlienNamn != null)
                {
                    if(resultatAlienLosen.equals(currentPassword))
                    {
                        inloggningsStatus = true;
                        alieninloggad = true;
                    }
                    else
                    {
                        success.setText("Password and username does not match");
                        inloggningsStatus = false;
                    }
                }
                else {
                    success.setText("Username doesn´t exist in database");
                    inloggningsStatus = false;
                }
                
                
                if (agentinloggad) {
                    String newPassword = nPasswordText.getText();
                    String frågaChange = "UPDATE Agent SET Losenord =" + "'" + newPassword + "'" + "WHERE Namn =" + "'" + username + "'";
                    String svarChange = idb.fetchSingle(frågaChange);
                    String nyttPassword = svarChange;
                    success.setText("Password updated");
                }
                else if(alieninloggad)
                {
                    String newPassword = nPasswordText.getText();
                    String frågaChange = "UPDATE Alien SET Losenord =" + "'" + newPassword + "'" + "WHERE Namn =" + "'" + username + "'";
                    String svarChange = idb.fetchSingle(frågaChange);
                    String nyttPassword = svarChange;
                    success.setText("Password updated");
                }

            } 
            
            catch (InfException e) 
            {
                JOptionPane.showMessageDialog(null, "Login failed"); 
            }
    }
    
    


//______________________________________________________________________________________________________
    
//______________________________________________________________________________________________________

//______________________________________________________________________________________________________

    
/** public void sessionTimer()
{
    
    timer = new Timer(timerSpeed, new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent f)
        {
            sessionTimerCounter++;
            sessionTimerLabel.setText(sessionTimerCounter + " sekunder");
        }
    });
}


public void timerUpdate()
{
    if (timerOn== false)
    {
        timerOn = true;
    }
    else if (timerOn== true)
    {
        timer.stop();
    }
    
    double speed = 1/perSecond*1000;
    timerSpeed = (int)Math.round(speed);
    
    String s = String.format("%.1f", perSecond);
    //perSecLabel.setText(s + " sekunder");
    
    sessionTimer();
    timer.start();
    
}

public class TimerHandler implements ActionListener
{
    
    public void actionPerformed(ActionEvent g)
    {
        
        {
        String action = g.getActionCommand();
        
        switch(action)
          {
            case "Login":
                perSecond = perSecond + 0.1;
                timerUpdate();
          }
        }
        
}*/


//getNamnAgent-metod    KLART
//getNamnAlien-metod     KLART
//createFont-metod             KLART
//GUI_AGENT-metod       KLART
//GUI_ALIEN-metod        KLART
//Lösenordsfönstermetod  KLART
//ÄndraLösenFönster        KLART
//skapa meny alien           KLART
//skapa meny agent          KLART
//skapa en menypanelmetod
//sessiontimer
//finslipa meny alien
//finslipa meny agent
//ÄndraLösenMetod(?)                        Återkommande?  if(samma kod dyker upp för både alien och agent.){do} else{ ignore();}
//getIdAgent-metod      KLART
//getIdAlien-metod      KLART
//getLosenAgent-metod       KLART
//getLosenAlien-metod       KLART
//getKonAlien-metod
//closeWindow-metod       



//}
}
}



    
    



