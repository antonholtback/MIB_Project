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
import javax.swing.Timer;

/**
 *
 * @author anton
 */
public class MIB_Project {
    
    ChangePasswordHandeler changePassHandeler = new ChangePasswordHandeler();
    LoginHandeler loginHandeler = new LoginHandeler();
    ExeNewPassword exeNewPasswordHandeler = new ExeNewPassword();
<<<<<<< Updated upstream
    TimerHandler timerHandler = new TimerHandler();
    
    
    Timer timer;
    double perSecond;
    boolean timerOn;
    int timerSpeed, sessionTimerCounter;
    
=======
    RegistreraAlien registreraAlienHandler = new RegistreraAlien();
    InstansieraNyAlien instansieraNyAlien = new InstansieraNyAlien();
    RegistreraUtrustning registreraUtrustningHandler = new RegistreraUtrustning();
    InstansieraNyUtrustning instansieraNyUtrustning = new InstansieraNyUtrustning();
    UppdateraAlien uppdateraAlienHandler = new UppdateraAlien();
    UppdateraAgentHandler uppdateraAgentHandler = new UppdateraAgentHandler();
    ValjAlienHandler valjAlienHandler = new ValjAlienHandler();
    ÄndraAlienHandler ändraAlienHandler = new ÄndraAlienHandler();
    LetaAlienID letaAlienID = new LetaAlienID();
    HanteraAgentHandler hanteraAgentHandler = new HanteraAgentHandler();
    VisaAlienInfo visaAlienInfo = new VisaAlienInfo();
    HamtaAlienInfo hamtaAlienInfo = new HamtaAlienInfo();
    PlatsAllaAliens platsAllaAliens = new PlatsAllaAliens();
    PlatsAllaAliensWindow platsAllaAliensWindow = new PlatsAllaAliensWindow();
    AlienAvRas alienAvRas = new AlienAvRas();
    AlienAvRasWindow alienAvRasWindow = new AlienAvRasWindow();
    OmradeschefInfo omradeschefInfo = new OmradeschefInfo();
    OmradeschefInfoWindow omradeschefInfoWindow = new OmradeschefInfoWindow();
    HamtaAgentInfo hamtaAgentInfo = new HamtaAgentInfo();
    HamtaAgentInfoWindow hamtaAgentInfoWindow = new HamtaAgentInfoWindow();
    AndraOmradeschef andraOmradeschef = new AndraOmradeschef();
    AndraOmradeschefWindow andraOmradeschefWindow = new AndraOmradeschefWindow();
    AndraKontorschef andraKontorschef = new AndraKontorschef();
    AndraKontorschefWindow andraKontorschefWindow = new AndraKontorschefWindow();
    AlienMellanDatumHandler alienMellanDatum = new AlienMellanDatumHandler();
    AlienMellanDatumWindow alienMellanDatumWindow = new AlienMellanDatumWindow();
    DropAgent dropAgent = new DropAgent();
    DropUtrustning dropUtrustning = new DropUtrustning();
    RegistreraAgent registreraAgent = new RegistreraAgent();
    InstansieraNyAgent instansieraNyAgent = new InstansieraNyAgent();
    DropAlien dropAlien = new DropAlien();
    DropAlienExe dropAlienExe = new DropAlienExe();
    AddAlienKön alienKön = new AddAlienKön();

    //TimerHandler timerHandler = new TimerHandler();
    //Timer timer;  
    //double perSecond;
    //boolean timerOn;
    //int timerSpeed, sessionTimerCounter;
    boolean admin = false;
>>>>>>> Stashed changes
    boolean inloggningsStatus = false;
    
    private static InfDB idb;
    private static JLabel userLabel, sessionTimerLabel, perSecLabel;
    private static JTextField userText;
    private static JLabel passwordLabel, cPasswordLabel, nPasswordLabel;
    private static JPasswordField passwordText, cPasswordText, nPasswordText;
    private static JButton inloggButton, changePassButton, exeNewPasswordButton, buttonSet1, buttonSet2, buttonSet3, buttonSet4;
    private static JLabel success;
<<<<<<< Updated upstream
    private static Font fontHeadliner, fontHeadliner1, fontHeadliner2, fontBread;
    
    
=======
    private static Font fontHeadliner, fontHeadliner1, fontHeadliner2, fontBread, fontBreadLiten;
    private static JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    private static JLabel idLabel, registreringsdatumLabel, losenordsLabel, platsLabel, ansvarigAgentLabel, telefonLabel, namnLabel, rastillhörighetsLabel;
    private static JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;
>>>>>>> Stashed changes

    /**
     * @param args the command line arguments
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
        timerOn = false;
        perSecond = 1;
        sessionTimerCounter = 0;
        
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
<<<<<<< Updated upstream
        
=======

    }

    /**
     * public boolean getStatus() throws InfException {
     *
     * //String username = userText.getText(); String username = getNamn();
     * String frågaAdmin = "SELECT Administrator FROM Agent WHERE Namn =" + "'"
     * + username + "'"; String svarAdmin = idb.fetchSingle(frågaAdmin); String
     * adminStatus = svarAdmin;
     *
     *
     * if(adminStatus.equals("J")) {
     *
     * return true; } else { return false; }
     *
     * }
     */
    // Koden för metoden getNamn från Agent tabellen
    public String getNamn() throws InfException {
        try {
            String username = userText.getText();
            String frågaNamn = "SELECT Namn FROM Agent WHERE Namn =" + "'" + username + "'";
            String svarNamn = idb.fetchSingle(frågaNamn);
            String user = svarNamn;

            return user;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
        return "";
>>>>>>> Stashed changes
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
        inloggButton.addActionListener(loginHandeler);
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
<<<<<<< Updated upstream
        
        //Om inloggningsstatus = true ska fönstret stängas när man klickar på login. Inte fått denna att funka än. 
        if(inloggningsStatus)
        {
        WindowEvent windowClosing = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosing);
        frame.dispatchEvent(windowClosing);
        
        }
        
=======
        return "";
    }

//______________________________________________________________________________________________________
    // Metod för att hämta en aliens registreringsdatum utan parameter    
    public String getRegistreringsdatum() throws InfException {
        try {
            String username = userText.getText();
            String frågaRegDate = "SELECT Registreringsdatum FROM Alien WHERE Namn =" + "'" + username + "'";
            String svarRegDate = idb.fetchSingle(frågaRegDate);
            String regDate = svarRegDate;

            if (svarRegDate == null) {
                JOptionPane.showMessageDialog(null, "Namnet finns inte i databasen");
            }

            return regDate;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
        return "";
>>>>>>> Stashed changes
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
        String currentPassword = cPasswordText.getText();
        
        //Hämta lösenord från AgentTabellen. vi skulle kunna göra den här till en getLosen-metod då det är ett återkommande tema.
        String fråga = "Select Losenord from Agent where Namn =" + "'" + username + "'";
        String svar = idb.fetchSingle(fråga);
        String resultat = svar;
        System.out.println(svar);
        
        //Hämta namn från AgentTabellen. samma här. skulle kunna skapa en metod. återkommande.
        String fråga2 = "Select namn from agent where namn =" + "'" + username + "'"; 
        String svar2 = idb.fetchSingle(fråga2);
        String user = svar2;
        
        
        if(user!=null)
        {
            if(resultat.equals(currentPassword))           
            {
                inloggningsStatus = true;
            }
            else
            {
                success.setText("Password and username does not match");
                inloggningsStatus = false;
            }
<<<<<<< Updated upstream
        }
        else
        {
            success.setText("Username doesn´t exist in database");
            inloggningsStatus = false;
        }
        if(inloggningsStatus)
            {
                String newPassword = nPasswordText.getText();
                String frågaChange = "UPDATE Agent SET Losenord =" + "'" + newPassword + "'" + "WHERE Namn =" + "'" + username + "'";
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
=======

            return agentId;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return "";
    }

    //______________________________________________________________________________________________________
    // Metod för att hämta en agents ID  genom id
    public String getAgentIdById(int id) throws InfException {
        try {
            String username = userText.getText();
            String frågaId = "SELECT agent_id FROM Agent WHERE agent_id =" + "'" + username + "'";
            String svarId = idb.fetchSingle(frågaId);
            String agentId = svarId;

            return agentId;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return "";
    }

    //______________________________________________________________________________________________________
    // Metod för att hämta en agents telefonnummer
    public String getAgentTelefon() throws InfException {
        try {
            String username = userText.getText();
            String frågaNamn = "SELECT telefon FROM Agent WHERE Namn =" + "'" + username + "'";
            String svarNamn = idb.fetchSingle(frågaNamn);
            String agentNamn = svarNamn;

            return agentNamn;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return "";
    }

    //______________________________________________________________________________________________________
    // Metod för att hämta en agents anställningsdatum
    public String getAgentAnstallningsdatum() throws InfException {
        try {
            String username = userText.getText();
            String frågaNamn = "SELECT anstallningsdatum FROM Agent WHERE Namn =" + "'" + username + "'";
            String svarNamn = idb.fetchSingle(frågaNamn);
            String agentNamn = svarNamn;

            return agentNamn;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return "";
    }

    //______________________________________________________________________________________________________
    // Metod för att hämta en agents adminstatus
    public String getAgentAdministrator() throws InfException {
        try {
            String username = userText.getText();
            String frågaNamn = "SELECT administrator FROM Agent WHERE Namn =" + "'" + username + "'";
            String svarNamn = idb.fetchSingle(frågaNamn);
            String agentNamn = svarNamn;

            return agentNamn;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        return "";
>>>>>>> Stashed changes
    }
    
    
//______________________________________________________________________________________________________
// Koden för knappen som instansierar GUIn ändra lösenord
    public class ChangePasswordHandeler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent a)
        {
            changePasswordWindow();
        }
<<<<<<< Updated upstream
=======
        return "";

>>>>>>> Stashed changes
    }

//______________________________________________________________________________________________________
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
<<<<<<< Updated upstream
        
        catch (InfException c)
                {
                       JOptionPane.showMessageDialog(null, "Login failed");
                }
        return getNamn();
=======
        return "";

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        
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
=======
        return "";
    }

    // Metod för att hämta en aliens lösenord utan parameter    
    public String getAlienLosenordUtanParameter() throws InfException {
        try {
            String username = userText.getText();
            String frågaLosen = "SELECT Losenord FROM Alien WHERE Namn =" + "'" + username + "'";
            String svarLosen = idb.fetchSingle(frågaLosen);
            String losenord = svarLosen;

            return losenord;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
        return "";
    }

    // Metod för att hämta en aliens telefonnummer utan parameter    
    public String getAlienTelefon() throws InfException {
        try {
            String username = userText.getText();
            String frågaTelefon = "SELECT Telefon FROM Alien WHERE Namn =" + "'" + username + "'";
            String svarTelefon = idb.fetchSingle(frågaTelefon);
            String alienTelefon = svarTelefon;

            return alienTelefon;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
        return "";
    }

    public boolean letaRasB(String id) throws InfException {
        String frågaB = "SELECT Alien_ID FROM Boglodite WHERE Alien_ID = " + id;
        String svarB = idb.fetchSingle(frågaB);

        if (svarB != null) {
            return true;
        } else {
            return false;
        }
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    
    public String getLosenAlienByName(String name) throws InfException
    {
        String fråga = "Select Losenord from Alien where Namn = '" + name + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
=======

    public String getAlienAnsvarigAgent() throws InfException {
        try {
            String username = userText.getText();
            String frågaAnsvarigAgent = "SELECT Ansvarig_Agent FROM Alien WHERE Namn =" + "'" + username + "'";
            String svarAnsvarigAgent = idb.fetchSingle(frågaAnsvarigAgent);
            String ansvarigAgent = svarAnsvarigAgent;

            return ansvarigAgent;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
        return "";
>>>>>>> Stashed changes
    }

    
//______________________________________________________________________________________________________
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
                timerUpdate();
                //sessionTimer();
            }
            else
            {
                success.setText("Login failed");
            }
        }
<<<<<<< Updated upstream
        else if(resultatAlienNamn!=null)
        {
            if(resultatAlienLosen.equals(password))
            {
                success.setText("Login successfull!");
                inloggningsStatus = true;
                GUIMeny_alien();
                timerUpdate();
                //sessionTimer();
=======
        return null;
    }

//______________________________________________________________________________________________________
//Metod för att hämta alla aliens av ras
    public ArrayList<String> getAlienAvRas() throws InfException {

        ArrayList<String> alienLista = new ArrayList();

        try {
            String ras = userText.getText();
            String fragaRas = "SELECT alien.namn from Alien join " + ras + " on " + ras + ".`Alien_ID` = Alien.`Alien_ID`";
            ArrayList<HashMap<String, String>> svarRas = idb.fetchRows(fragaRas);

            for (HashMap<String, String> rad : svarRas) {
                alienLista.add(rad.get("Namn"));
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        
       
        
        
        
=======
        return "";
    }

    //______________________________________________________________________________________________________
//Metod för att hämta områdeschefs namn genom plats
    public String getOmradeschefNamnByPlats() throws InfException {

        String s = "Namn saknas";
        try {
            String plats = userText.getText();
            String fragaPlats = "select namn from agent where agent_id in(select agent_id from omradeschef where omrade = " + plats + ")";
            String svarPlats = idb.fetchSingle(fragaPlats);
            String enAgent = svarPlats;

            if (svarPlats == null) {
                JOptionPane.showMessageDialog(null, "ID finns inte i databasen");
            }

            return enAgent;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Namn saknas");
        }
        return s;
    }

    //______________________________________________________________________________________________________
//Metod för att hämta områdeschefs telefon genom plats
    public String getOmradeschefTelefonByPlats() throws InfException {

        String s = "Telefon saknas";
        try {
            String plats = userText.getText();
            String fragaPlats = "select telefon from agent where agent_id in(select agent_id from omradeschef where omrade = " + plats + ")";
            String svarPlats = idb.fetchSingle(fragaPlats);
            String enAgent = svarPlats;

            return enAgent;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Telefon saknas");
        }
        return s;
    }

    //______________________________________________________________________________________________________
//Metod för att hämta områdeschefs anställningsdatum genom plats
    public String getOmradeschefAnstallninsdatumByPlats() throws InfException {

        String s = "error";
        try {
            String plats = userText.getText();
            String fragaPlats = "select anstallningsdatum from agent where agent_id in(select agent_id from omradeschef where omrade = " + plats + ")";
            String svarPlats = idb.fetchSingle(fragaPlats);
            String enAgent = svarPlats;

            return enAgent;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Anställningsdatum saknas");
        }
        return s;
    }

    //______________________________________________________________________________________________________
//Metod för att hämta områdeschefs lösenord genom plats
    public String getOmradeschefLosenordByPlats() throws InfException {

        String s = "Lösenord saknas";
        try {
            String plats = userText.getText();
            String fragaPlats = "select losenord from agent where agent_id in(select agent_id from omradeschef where omrade = " + plats + ")";
            String svarPlats = idb.fetchSingle(fragaPlats);
            String enAgent = svarPlats;

            return enAgent;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Lösenord saknas");
        }
        return s;
    }

    //______________________________________________________________________________________________________
//Metod för att hämta områdeschefs agent_Id genom plats
    public String getOmradeschefIdByPlats() throws InfException {

        String s = "Agent_ID saknas";
        try {
            String plats = userText.getText();
            String fragaPlats = "select Agent_id from agent where agent_id in(select agent_id from omradeschef where omrade = " + plats + ")";
            String svarPlats = idb.fetchSingle(fragaPlats);
            String enAgent = svarPlats;

            return enAgent;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Agent_ID saknas");
        }
        return s;
    }

    //______________________________________________________________________________________________________
//Metod för att hämta områdeschef admininstartörsstatus genom plats
    public String getOmradeschefAdminByPlats() throws InfException {

        String s = "Adminstatus saknas";
        try {
            String plats = userText.getText();
            String fragaPlats = "select administrator from agent where agent_id in(select agent_id from omradeschef where omrade = " + plats + ")";
            String svarPlats = idb.fetchSingle(fragaPlats);
            String enAgent = svarPlats;

            return enAgent;
        } catch (InfException c) {
            JOptionPane.showMessageDialog(null, "Adminstatus saknas");
        }
        return s;
    }

    public String getIDAgent(String namn) throws InfException {
        String fråga = "Select Agent_ID from Agent where Namn = '" + namn + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }

    public String getIDAlien(String namn) throws InfException {
        String fråga = "Select Alien_ID from Alien where Namn = '" + namn + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }

    public boolean letaAktivFaltagent(String id) throws InfException {
        String fråga = "SELECT Agent_ID FROM Faltagent where Agent_ID =" + id;
        String svar = idb.fetchSingle(fråga);

        if (svar != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean letaAlienIDs(String id) throws InfException {
        String fråga = "Select Alien_ID from Alien where Alien_ID = " + id;
        String svar = idb.fetchSingle(fråga);

        if (svar != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getLosenAgentByID(String id) throws InfException {
        String fråga = "Select Losenord from Agent where Alien_ID = " + id + ";";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }

    public String getLosenAgentByName(String name) throws InfException {
        String fråga = "Select Losenord from Agent where namn = '" + name + "';";
        String svar = idb.fetchSingle(fråga);
        return svar;
    }
    
    public String getRasAlien() throws InfException {
        String alienNamn = userText.getText();
        String alienID = getIDAlien(alienNamn);
        
        if(letaRasB(alienID)) {
            String svar = "Boglodite";
            return svar;
        }
        if(letaRasS(alienID)) {
            String svar = "Squid";
            return svar;
        }
        if(letaRasW(alienID)) {
            String svar = "Worm";
            return svar;
        }
        return "";
    }
    
    public String getRasByID(String id) throws InfException {
        
        if(letaRasB(id)) {
            String svar = "Boglodite";
            return svar;
        }
        if(letaRasS(id)) {
            String svar = "Squid";
            return svar;
        }
        if(letaRasW(id)) {
            String svar = "Worm";
            return svar;
        }
        return "";
    }

    public String getLosenAlienByID(String id) throws InfException {
        String fråga = "Select Losenord from Alien where id = " + id;
        String svar = idb.fetchSingle(fråga);
        return svar;
>>>>>>> Stashed changes
    }
    }

//______________________________________________________________________________________________________
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
        ImageIcon logo = new ImageIcon("Images/bildlogga.png");
       // ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(bildtest1.png));
        logoLabel.setIcon(logo);
        panel.add(logoLabel);
        
        JPanel listPanel = new JPanel();
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
        
        JPanel timerPanel = new JPanel();
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
        ImageIcon logo = new ImageIcon("Images/bildlogga.png");
       // ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(bildtest1.png));
        logoLabel.setIcon(logo);
        panel.add(logoLabel);
       
        
        frame.setVisible(true);
    }
    
    
public void sessionTimer()
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
        
}


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



}
}



    
    



<<<<<<< Updated upstream
=======
        frame.setVisible(true);
    }

    public String andraOmradeschef() throws InfException {

        String s = "error";
        try {
            String agent = text1.getText();
            String omrade = text2.getText();
            String fragaChef = "update omradeschef set agent_id = " + agent + " where omrade = " + omrade;
            String svarChef = idb.fetchSingle(fragaChef);
            String enAgent = svarChef;

            String fraga2 = "select omrades_id from omrade where omrades_id = " + omrade;
            String svar2 = idb.fetchSingle(fraga2);
            String ettOmrade = svar2;

            if (ettOmrade == null) {
                JOptionPane.showMessageDialog(null, "Området eller agent finns inte");
            } else {

                JOptionPane.showMessageDialog(null, "Områdeschef tillsatt");
            }

            return enAgent;
        } catch (InfException p) {

            JOptionPane.showMessageDialog(null, "Agenten finns inte eller är redan områdeschef..");
            return s;
        }

    }

    public void andraKontorschefWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Agent_ID: ");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        label2 = new JLabel("Nytt chefsområde: ");
        label2.setBounds(10, 60, 120, 25);
        panel.add(label2);

        //Textfält för agentnamnt
        text1 = new JTextField();
        text1.setBounds(120, 20, 120, 25);
        panel.add(text1);

        //Textfält för nytt chefsområde
        text2 = new JTextField();
        text2.setBounds(120, 60, 120, 25);
        panel.add(text2);

        instansieraNyButton = new JButton("Utse ny områdeschef");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(andraKontorschef);
        panel.add(instansieraNyButton);

        frame.setVisible(true);
    }

    public String andraKontorschef() throws InfException {

        String s = "error";

        try {
            String agent = text1.getText();
            String kontor = text2.getText();
            String fragaChef = "update kontorschef set agent_id = " + agent + " where kontorsbeteckning = " + "'" + kontor + "'";
            String svarChef = idb.fetchSingle(fragaChef);
            String enAgent = svarChef;

            JOptionPane.showMessageDialog(null, "Kontorschef tillsatt");

            return enAgent;
        } catch (InfException p) {

            JOptionPane.showMessageDialog(null, "Agenten finns inte eller är redan kontorschef");
            return s;

        }

    }

    public void platsAllaAliensWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Plats: ");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        userText = new JTextField();
        userText.setBounds(60, 20, 120, 25);
        panel.add(userText);

        // platsLabel = new JLabel("");
        // platsLabel.setBounds(100,140,120,25);
        // panel.add(platsLabel);
        platsLabel = new JLabel("");
        platsLabel.setBounds(45, 170, 120, 25);
        platsLabel.setFont(fontBread);
        panel.add(platsLabel);

        instansieraNyButton = new JButton("Hämta aliens");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(platsAllaAliens);
        panel.add(instansieraNyButton);

        frame.setVisible(true);
    }

    public void alienAvRasWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Ras: ");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        namnLabel = new JLabel("");
        namnLabel.setBounds(130, 50, 120, 25);
        namnLabel.setFont(fontBread);
        panel.add(namnLabel);

        userText = new JTextField();
        userText.setBounds(60, 20, 120, 25);
        panel.add(userText);

        instansieraNyButton = new JButton("Hämta info");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(alienAvRas);
        panel.add(instansieraNyButton);

        frame.setVisible(true);
    }

    public void registreraAlienWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Alien_ID");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        label2 = new JLabel("Registreringsdatum");
        label2.setBounds(10, 50, 120, 25);
        panel.add(label2);

        label3 = new JLabel("Lösenord");
        label3.setBounds(10, 80, 120, 25);
        panel.add(label3);

        label4 = new JLabel("Namn");
        label4.setBounds(10, 110, 120, 25);
        panel.add(label4);

        label5 = new JLabel("Telefon");
        label5.setBounds(10, 140, 120, 25);
        panel.add(label5);

        label6 = new JLabel("Plats");
        label6.setBounds(10, 170, 120, 25);
        panel.add(label6);

        label7 = new JLabel("Ansvarig agent");
        label7.setBounds(10, 200, 120, 25);
        panel.add(label7);

        text1 = new JTextField(20);
        text1.setBounds(125, 20, 185, 25);
        panel.add(text1);

        text2 = new JTextField(20);
        text2.setBounds(125, 50, 185, 25);
        panel.add(text2);

        text3 = new JTextField(20);
        text3.setBounds(125, 80, 185, 25);
        panel.add(text3);

        text4 = new JTextField(20);
        text4.setBounds(125, 110, 185, 25);
        panel.add(text4);

        text5 = new JTextField(20);
        text5.setBounds(125, 140, 185, 25);
        panel.add(text5);

        text6 = new JTextField(20);
        text6.setBounds(125, 170, 185, 25);
        panel.add(text6);

        text7 = new JTextField(20);
        text7.setBounds(125, 200, 185, 25);
        panel.add(text7);

        instansieraNyButton = new JButton("Registrera Alien");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(instansieraNyAlien);
        panel.add(instansieraNyButton);
        //Här ska vi koda in nya knappen som instansierar en ny alien. Uppbyggd på samma sätt men som refererar till en annan klass än exeNewPasswordHandeler, som inte ännu är skapad.
        /**
         * exeNewPasswordButton = new JButton("Ändra lösenord");
         * exeNewPasswordButton.setBounds(10, 230, 185, 25);
         * exeNewPasswordButton.addActionListener(exeNewPasswordHandeler);
         * panel.add(exeNewPasswordButton);
         */

        success = new JLabel("");
        success.setBounds(10, 100, 300, 25);
        panel.add(success);

        frame.setVisible(true);

    }

    public void väljAgentWindow() {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Välj Alien_ID");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        text8 = new JTextField(20);
        text8.setBounds(125, 20, 185, 25);
        panel.add(text8);

        instansieraNyButton = new JButton("Välj Alien");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(letaAlienID);
        panel.add(instansieraNyButton);

        frame.setVisible(true);
    }

    public void valjAlienWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Välj Alien_ID");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        text8 = new JTextField(20);
        text8.setBounds(125, 20, 185, 25);
        panel.add(text8);

        instansieraNyButton = new JButton("Välj Alien");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(letaAlienID);
        panel.add(instansieraNyButton);

        frame.setVisible(true);
    }

    public void ändraAlienWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Alien_ID");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        label2 = new JLabel("Registreringsdatum");
        label2.setBounds(10, 50, 120, 25);
        panel.add(label2);

        label3 = new JLabel("Lösenord");
        label3.setBounds(10, 80, 120, 25);
        panel.add(label3);

        label4 = new JLabel("Namn");
        label4.setBounds(10, 110, 120, 25);
        panel.add(label4);

        label5 = new JLabel("Telefon");
        label5.setBounds(10, 140, 120, 25);
        panel.add(label5);

        label6 = new JLabel("Plats");
        label6.setBounds(10, 170, 120, 25);
        panel.add(label6);

        label7 = new JLabel("Ansvarig agent");
        label7.setBounds(10, 200, 120, 25);
        panel.add(label7);
        
        label8 = new JLabel("Ras");
        label8.setBounds(10, 230, 120, 25);
        panel.add(label8);

        text1 = new JTextField(20);
        text1.setBounds(125, 20, 185, 25);
        panel.add(text1);

        text2 = new JTextField(20);
        text2.setBounds(125, 50, 185, 25);
        panel.add(text2);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(125, 80, 185, 25);
        panel.add(passwordText);

        text4 = new JTextField(20);
        text4.setBounds(125, 110, 185, 25);
        panel.add(text4);

        text5 = new JTextField(20);
        text5.setBounds(125, 140, 185, 25);
        panel.add(text5);

        text6 = new JTextField(20);
        text6.setBounds(125, 170, 185, 25);
        panel.add(text6);

        text7 = new JTextField(20);
        text7.setBounds(125, 200, 185, 25);
        panel.add(text7);
        
        text9 = new JTextField(20);
        text9.setBounds(125, 230, 185, 25);
        panel.add(text9);

        

        instansieraNyButton = new JButton("Ändra Alien");
        instansieraNyButton.setBounds(10, 300, 185, 25);
        instansieraNyButton.addActionListener(uppdateraAlienHandler);
        panel.add(instansieraNyButton);
        //Här ska vi koda in nya knappen som instansierar en ny alien. Uppbyggd på samma sätt men som refererar till en annan klass än exeNewPasswordHandeler, som inte ännu är skapad.
        /**
         * exeNewPasswordButton = new JButton("Ändra lösenord");
         * exeNewPasswordButton.setBounds(10, 230, 185, 25);
         * exeNewPasswordButton.addActionListener(exeNewPasswordHandeler);
         * panel.add(exeNewPasswordButton);
         */

        success = new JLabel("");
        success.setBounds(10, 100, 300, 25);
        panel.add(success);

        frame.setVisible(true);

    }


    public void hanteraAgentWindow() {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Agent ID");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        label2 = new JLabel("Namn");
        label2.setBounds(10, 50, 120, 25);
        panel.add(label2);

        label3 = new JLabel("Telefon");
        label3.setBounds(10, 80, 120, 25);
        panel.add(label3);

        label4 = new JLabel("Anställningsdatum");
        label4.setBounds(10, 110, 120, 25);
        panel.add(label4);

        label5 = new JLabel("Administrator");
        label5.setBounds(10, 140, 120, 25);
        panel.add(label5);

        label6 = new JLabel("Lösenord");
        label6.setBounds(10, 170, 120, 25);
        panel.add(label6);

        label7 = new JLabel("Område");
        label7.setBounds(10, 200, 120, 25);
        panel.add(label7);

        text1 = new JTextField(20);
        text1.setBounds(125, 20, 185, 25);
        panel.add(text1);

        text2 = new JTextField(20);
        text2.setBounds(125, 50, 185, 25);
        panel.add(text2);

        text3 = new JTextField(20);
        text3.setBounds(125, 80, 185, 25);
        panel.add(text3);

        text4 = new JTextField(20);
        text4.setBounds(125, 110, 185, 25);
        panel.add(text4);

        text5 = new JTextField(20);
        text5.setBounds(125, 140, 185, 25);
        panel.add(text5);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(125, 170, 185, 25);
        panel.add(passwordText);

        text7 = new JTextField(20);
        text7.setBounds(125, 200, 185, 25);
        panel.add(text7);

        instansieraNyButton = new JButton("Ändra Agent");
        instansieraNyButton.setBounds(10, 240, 140, 25);
        instansieraNyButton.addActionListener(uppdateraAgentHandler);
        panel.add(instansieraNyButton);

        dropAgentButton = new JButton("Ta bort Agent");
        dropAgentButton.setBounds(10, 270, 140, 25);
        dropAgentButton.addActionListener(dropAgent);
        panel.add(dropAgentButton);

        //Här ska vi koda in nya knappen som instansierar en ny alien. Uppbyggd på samma sätt men som refererar till en annan klass än exeNewPasswordHandeler, som inte ännu är skapad.
        /**
         * exeNewPasswordButton = new JButton("Ändra lösenord");
         * exeNewPasswordButton.setBounds(10, 230, 185, 25);
         * exeNewPasswordButton.addActionListener(exeNewPasswordHandeler);
         * panel.add(exeNewPasswordButton);
         */
        success = new JLabel("");
        success.setBounds(10, 100, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

    public void dropAlienWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Alien ID: ");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        userText = new JTextField();
        userText.setBounds(60, 20, 120, 25);
        panel.add(userText);

        // platsLabel = new JLabel("");
        // platsLabel.setBounds(100,140,120,25);
        // panel.add(platsLabel);
        platsLabel = new JLabel("");
        platsLabel.setBounds(45, 170, 120, 25);
        platsLabel.setFont(fontBread);
        panel.add(platsLabel);

        instansieraNyButton = new JButton("Ta bort Alien");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(dropAlienExe);
        panel.add(instansieraNyButton);

        frame.setVisible(true);
    }

    public void registreraUtrustningWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Utrustnings ID");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        label2 = new JLabel("Benämning");
        label2.setBounds(10, 50, 120, 25);
        panel.add(label2);

        text1 = new JTextField(20);
        text1.setBounds(125, 20, 185, 25);
        panel.add(text1);

        text2 = new JTextField(20);
        text2.setBounds(125, 50, 185, 25);
        panel.add(text2);

        instansieraNyButton = new JButton("Registrera Utrustning");
        instansieraNyButton.setBounds(10, 240, 160, 25);
        instansieraNyButton.addActionListener(instansieraNyUtrustning);
        panel.add(instansieraNyButton);

        if (admin) {
            instansieraNyButton2 = new JButton("Ta bort utrustning");
            instansieraNyButton2.setBounds(10, 270, 160, 25);
            instansieraNyButton2.addActionListener(dropUtrustning);
            panel.add(instansieraNyButton2);
        }
        //Här ska vi koda in nya knappen som instansierar en ny alien. Uppbyggd på samma sätt men som refererar till en annan klass än exeNewPasswordHandeler, som inte ännu är skapad.
        /**
         * exeNewPasswordButton = new JButton("Ändra lösenord");
         * exeNewPasswordButton.setBounds(10, 230, 185, 25);
         * exeNewPasswordButton.addActionListener(exeNewPasswordHandeler);
         * panel.add(exeNewPasswordButton);
         */

        success = new JLabel("");
        success.setBounds(10, 100, 300, 25);
        panel.add(success);

        frame.setVisible(true);

    }

    public void alienMellanDatumWindow() {

        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Startdatum: ");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        label2 = new JLabel("Slutdatum: ");
        label2.setBounds(10, 50, 120, 25);
        panel.add(label2);

        namnLabel = new JLabel("");
        namnLabel.setBounds(100, 80, 120, 25);
        namnLabel.setFont(fontBread);
        panel.add(namnLabel);

        text1 = new JTextField();
        text1.setBounds(80, 20, 120, 25);
        panel.add(text1);

        text2 = new JTextField();
        text2.setBounds(80, 50, 120, 25);
        panel.add(text2);

        label3 = new JLabel("(YYYY-MM-DD)");
        label3.setBounds(10, 100, 120, 25);
        panel.add(label3);

        instansieraNyButton = new JButton("Hämta info");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(alienMellanDatum);
        panel.add(instansieraNyButton);

        frame.setVisible(true);
        success = new JLabel("");
        success.setBounds(10, 100, 300, 25);
        panel.add(success);

        //AlienMellanDatumLabel.setText(“”);
        frame.setVisible(true);

    }

    // Koden för Agent Menyn som öppnas efter inlogg som agent    
    public void GUIMeny() throws InfException {
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);

        JPanel panel = new JPanel();
        panel.setBounds(100, 220, 200, 200);
        panel.setBackground(Color.black);
        frame.add(panel);

        JLabel headliner = new JLabel("MIB HUB");
        headliner.setBounds(620, 80, 300, 80);
        headliner.setForeground(Color.black);
        headliner.setFont((fontHeadliner1));
        frame.add(headliner);

        JLabel welcomeLabel = new JLabel("Welcome back " + getNamn());
        welcomeLabel.setBounds(690, 150, 450, 50);
        welcomeLabel.setForeground(Color.red);
        welcomeLabel.setFont(fontBread);
        frame.add(welcomeLabel);

        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(1320, 630, 200, 200);
        ImageIcon logo = new ImageIcon("Images/bildlogga(3).png");
        // ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(bildtest1.png));
        logoLabel.setIcon(logo);
        frame.add(logoLabel);

        JPanel listPanel = new JPanel();

        listPanel.setBounds(500, 270, 700, 250);
        listPanel.setBackground(Color.DARK_GRAY);
        listPanel.setLayout(new GridLayout(4, 2));
        frame.add(listPanel);

        buttonSet1 = new JButton("Registrera Alien");
        buttonSet1.setFont(fontBread);
        buttonSet1.setFocusPainted(true);
        buttonSet1.addActionListener(registreraAlienHandler);
        buttonSet1.setActionCommand(" ");
        listPanel.add(buttonSet1);

        buttonSet2 = new JButton("Ändra Alien");
        buttonSet2.setFont(fontBread);
        buttonSet2.setFocusPainted(true);
        buttonSet2.addActionListener(valjAlienHandler);
        buttonSet2.setActionCommand(" ");
        listPanel.add(buttonSet2);

        buttonSet3 = new JButton("Hantera utrustning");
        buttonSet3.setFont(fontBread);
        buttonSet3.setFocusPainted(true);
        buttonSet3.addActionListener(registreraUtrustningHandler);
        buttonSet3.setActionCommand(" ");
        listPanel.add(buttonSet3);

        buttonSet4 = new JButton("Visa områdeschef");
        buttonSet4.setFont(fontBread);
        buttonSet4.setFocusPainted(true);
        buttonSet4.addActionListener(omradeschefInfoWindow);
        buttonSet4.setActionCommand(" ");
        listPanel.add(buttonSet4);

        buttonSet5 = new JButton("Visa Alien på plats");
        buttonSet5.setFont(fontBread);
        buttonSet5.setFocusPainted(true);
        buttonSet5.addActionListener(platsAllaAliensWindow);
        buttonSet5.setActionCommand(" ");
        listPanel.add(buttonSet5);

        buttonSet6 = new JButton("Visa Alien av ras");
        buttonSet6.setFont(fontBread);
        buttonSet6.setFocusPainted(true);
        buttonSet6.addActionListener(alienAvRasWindow);
        buttonSet6.setActionCommand(" ");
        listPanel.add(buttonSet6);

        buttonSet7 = new JButton("Registrerad mellan datum");
        buttonSet7.setFont(fontBreadLiten);
        buttonSet7.setFocusPainted(true);
        buttonSet7.addActionListener(alienMellanDatumWindow);
        buttonSet7.setActionCommand(" ");
        listPanel.add(buttonSet7);

        buttonSet8 = new JButton("Visa Alien info");
        buttonSet8.setFont(fontBread);
        buttonSet8.setFocusPainted(true);
        buttonSet8.addActionListener(visaAlienInfo);
        buttonSet8.setActionCommand(" ");
        listPanel.add(buttonSet8);

        if (admin) {
            /**
             * ta bort alien ta bort utrustning hantera agent
             */
            buttonSet9 = new JButton("Ta bort Alien");
            buttonSet9.setFont(fontBread);
            buttonSet9.setFocusPainted(true);
            buttonSet9.addActionListener(dropAlien);
            //buttonSet9.setActionCommand(" ");
            listPanel.add(buttonSet9);

            /*   buttonSet10 = new JButton("Ta bort Utrustning");
            buttonSet10.setFont(fontBread);
            buttonSet10.setFocusPainted(true);
            //buttonSet10.addActionListener();
            //buttonSet10.setActionCommand(" ");
            listPanel.add(buttonSet10); */
            buttonSet11 = new JButton("Hantera Agent");
            buttonSet11.setFont(fontBread);
            buttonSet11.setFocusPainted(true);
            buttonSet11.addActionListener(hanteraAgentHandler);
            //buttonSet11.setActionCommand(" ");
            listPanel.add(buttonSet11);

            buttonSet12 = new JButton("Visa agentinfo");
            buttonSet12.setFont(fontBread);
            buttonSet12.setFocusPainted(true);
            buttonSet12.addActionListener(hamtaAgentInfoWindow);
            //buttonSet11.setActionCommand(" ");
            listPanel.add(buttonSet12);

            buttonSet13 = new JButton("Ändra områdeschef");
            buttonSet13.setFont(fontBread);
            buttonSet13.setFocusPainted(true);
            buttonSet13.addActionListener(andraOmradeschefWindow);
            //buttonSet13.setActionCommand(" ");
            listPanel.add(buttonSet13);

            buttonSet14 = new JButton("Ändra kontorschef");
            buttonSet14.setFont(fontBread);
            buttonSet14.setFocusPainted(true);
            buttonSet14.addActionListener(andraKontorschefWindow);
            //buttonSet14.setActionCommand(" ");
            listPanel.add(buttonSet14);

            buttonSet15 = new JButton("Registrera Agent");
            buttonSet15.setFont(fontBread);
            buttonSet15.setFocusPainted(true);
            buttonSet15.addActionListener(registreraAgent);
            listPanel.add(buttonSet15);

        }

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
        //frame.setVisible(true);
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
    public void GUIMeny_alien() throws InfException {
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);

        JPanel panel = new JPanel();
        panel.setBounds(100, 220, 200, 200);
        panel.setBackground(Color.black);
        frame.add(panel);

        JLabel headliner = new JLabel("Alien HUB");
        headliner.setBounds(620, 80, 400, 80);
        headliner.setForeground(Color.black);
        headliner.setFont((fontHeadliner1));
        frame.add(headliner);

        JLabel welcomeLabel = new JLabel("Welcome back " + getNamnAlien());
        welcomeLabel.setBounds(690, 150, 450, 50);
        welcomeLabel.setForeground(Color.red);
        welcomeLabel.setFont(fontBread);
        frame.add(welcomeLabel);

        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(1320, 630, 200, 200);
        ImageIcon logo = new ImageIcon("Images/bildlogga(3).png");
        // ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(bildtest1.png));
        logoLabel.setIcon(logo);
        frame.add(logoLabel);

        JPanel listPanel = new JPanel();

        listPanel.setBounds(1100, 270, 400, 250);
        listPanel.setBackground(Color.DARK_GRAY);
        listPanel.setLayout(new GridLayout(4, 2));
        frame.add(listPanel);

        buttonSet1 = new JButton("Min områdeschef");
        buttonSet1.setFont(fontBread);
        buttonSet1.setFocusPainted(true);
        buttonSet1.addActionListener(omradeschefInfoWindow);
        buttonSet1.setActionCommand(" ");
        listPanel.add(buttonSet1);

        frame.setVisible(true);
    }

    public void hamtaAlienAvRas() throws InfException {

        try {
            JPanel panel = new JPanel();

            JFrame frame = new JFrame();
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setLocationRelativeTo(null);
            panel.setLayout(null);

            JLabel titel = new JLabel("Aliens: ");
            titel.setBounds(10, 20, 120, 25);
            panel.add(titel);

            JLabel tempLabel = new JLabel();

            ArrayList<String> alienLista = new ArrayList();
            alienLista = getAlienAvRas();

            int counter = 1;
            for (String namn : alienLista) {
                tempLabel.setText(namn);
                tempLabel.setBounds(10, 40 * counter, 120, 25);
                panel.add(tempLabel);
                counter++;
            }

            frame.setVisible(true);

        } catch (InfException a) {

        }

    }

    public class VisaAlienInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent k) {
            alienInfoWindow();
        }
    }

    public class HamtaAlienInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent l) {

            try {
                hamtaAlienInfo();
            } catch (InfException p) {

            }
        }

    }

    public class OmradeschefInfoWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent k) {
            omradeschefInfoWindow();
        }
    }

    public class OmradeschefInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent l) {

            try {
                namnLabel.setText(getOmradeschefNamnByPlats());
                telefonLabel.setText(getOmradeschefTelefonByPlats());
                registreringsdatumLabel.setText(getOmradeschefAnstallninsdatumByPlats());
                ansvarigAgentLabel.setText(getOmradeschefAdminByPlats());
                idLabel.setText(getOmradeschefIdByPlats());

            } catch (InfException p) {

            }
        }

    }

    public class HamtaAgentInfoWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent k) {
            hamtaAgentInfoWindow();
        }
    }

    public class HamtaAgentInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent l) {

            try {
                hamtaAgentInfo();
            } catch (InfException p) {

            }
        }

    }

    public class AndraOmradeschefWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent k) {
            andraOmradeschefWindow();
        }
    }

    public class AndraOmradeschef implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent l) {

            try {
                andraOmradeschef();
            } catch (InfException p) {

            }
        }

    }

    public class AndraKontorschefWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent k) {
            andraKontorschefWindow();
        }
    }

    public class AndraKontorschef implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent l) {

            try {
                andraKontorschef();
            } catch (InfException p) {

            }
        }

    }

    public class PlatsAllaAliensWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent w) {
            platsAllaAliensWindow();
        }
    }

    public class PlatsAllaAliens implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent l) {

            try {
                JPanel panel = new JPanel();

                JFrame frame = new JFrame();
                frame.setSize(400, 400);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.add(panel);
                frame.setLocationRelativeTo(null);
                panel.setLayout(null);

                JLabel namnLabel = new JLabel("Aliens: ");
                namnLabel.setBounds(10, 20, 120, 25);
                panel.add(namnLabel);

                if (frame != null) {
                    frame.dispose();
                }

                ArrayList<String> s = getPlatsAllaAliens();
                int counter = 1;
                //platsLabel
                for (String namn : s) {
                    JLabel tempLabel = new JLabel(namn);
                    tempLabel.setBounds(10, 40 * counter, 120, 25);
                    panel.add(tempLabel);
                    counter++;

                }
                frame.setVisible(true);

            } catch (InfException p) {
                JOptionPane.showMessageDialog(null, "Platsen saknar aliens eller finns inte");
            }
        }

    }

    public class AlienAvRasWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent w) {
            alienAvRasWindow();
        }

    }

    public class AlienAvRas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent jj) {

            try {
                hamtaAlienAvRas();

            } catch (InfException jjj) {

            }
        }
    }

// Koden för knappen man trycker på för att logga in
    public class LoginHandeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            //throw new UnsupportedOperationException("Not supported yet.");
            try {
                String username = userText.getText();
                String password = passwordText.getText();
                String jaAdmin = "J";
                String nejAdmin = "N";
                String omrade = getAlienPlats();

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
                //Hämta adminstatus
                String frågaAgentAdmin = "SELECT Administrator FROM Agent WHERE Namn =" + "'" + username + "'";
                String svarAgentAdmin = idb.fetchSingle(frågaAgentAdmin);
                String adminStatus = svarAgentAdmin;

                if (resultatAgentNamn != null) {
                    if (resultatAgentLosen.equals(password) && adminStatus.equals(jaAdmin)) {
                        success.setText("Login successfull! User identified as admin");
                        inloggningsStatus = true;
                        admin = true;
                        GUIMeny();
                    } else if (resultatAgentLosen.equals(password) && adminStatus.equals(nejAdmin)) {
                        success.setText("Login successfull! User identified as pesant");
                        inloggningsStatus = true;
                        admin = false;

                        GUIMeny();
                    } // timerUpdate();
                    //sessionTimer();
                    else {
                        success.setText("Login failed");
                    }
                } else if (resultatAlienNamn != null) {
                    if (resultatAlienLosen.equals(password)) {
                        success.setText("Login successfull!");
                        inloggningsStatus = true;

                        GUIMeny_alien();
                        // timerUpdate();
                        //sessionTimer();
                    }
                } else {
                    success.setText("Username doesn´t exist in database");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Login failed due to unknown reason");
            }

        }
    }

    public String omradeschefInfo() throws InfException {

        // String s = getOmradeschefNamnByPlats();
        String omrade = getAlienPlats();

        try {
            //String plats = userText.getText();
            String fragaPlats = "SELECT Agent_ID FROM omradeschef WHERE Omrade in (SELECT Plats from Alien WHERE Alien_ID = " + omrade + ")";
            String svarPlats = idb.fetchSingle(fragaPlats);
            String enAgent = svarPlats;

            String fragaAgent = "select * from agent where agent_id = " + enAgent;
            String svarAgent = idb.fetchSingle(fragaAgent);
            String allAgent = svarAgent;

            namnLabel.setText(allAgent);

            /* namnLabel.setText(getOmradeschefNamnByPlats());
            telefonLabel.setText(getOmradeschefTelefonByPlats());
            registreringsdatumLabel.setText(getOmradeschefAnstallninsdatumByPlats());
            ansvarigAgentLabel.setText(getOmradeschefAdminByPlats());
            idLabel.setText(getOmradeschefIdByPlats()); */
            return allAgent;

        } catch (InfException p) {

            JOptionPane.showMessageDialog(null, "");
        }
        return omradeschefInfo();
    }

    public void registreraAgentWindow() {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        label1 = new JLabel("Agent_ID");
        label1.setBounds(10, 20, 120, 25);
        panel.add(label1);

        label2 = new JLabel("Namn");
        label2.setBounds(10, 50, 120, 25);
        panel.add(label2);

        label3 = new JLabel("Telefon");
        label3.setBounds(10, 80, 120, 25);
        panel.add(label3);

        label4 = new JLabel("Anställningsdatum");
        label4.setBounds(10, 110, 120, 25);
        panel.add(label4);

        label5 = new JLabel("Adminstatus");
        label5.setBounds(10, 140, 120, 25);
        panel.add(label5);

        label6 = new JLabel("Lösenord");
        label6.setBounds(10, 170, 120, 25);
        panel.add(label6);

        label7 = new JLabel("Aktiv inom område");
        label7.setBounds(10, 200, 120, 25);
        panel.add(label7);

        text1 = new JTextField(20);
        text1.setBounds(125, 20, 185, 25);
        panel.add(text1);

        text2 = new JTextField(20);
        text2.setBounds(125, 50, 185, 25);
        panel.add(text2);

        text3 = new JTextField(20);
        text3.setBounds(125, 80, 185, 25);
        panel.add(text3);

        text4 = new JTextField(20);
        text4.setBounds(125, 110, 185, 25);
        panel.add(text4);

        text5 = new JTextField(20);
        text5.setBounds(125, 140, 185, 25);
        panel.add(text5);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(125, 170, 185, 25);
        panel.add(passwordText);

        text7 = new JTextField(20);
        text7.setBounds(125, 200, 185, 25);
        panel.add(text7);

        instansieraNyButton = new JButton("Registrera Agent");
        instansieraNyButton.setBounds(10, 240, 185, 25);
        instansieraNyButton.addActionListener(instansieraNyAgent);
        panel.add(instansieraNyButton);
        //Här ska vi koda in nya knappen som instansierar en ny alien. Uppbyggd på samma sätt men som refererar till en annan klass än exeNewPasswordHandeler, som inte ännu är skapad.
        /**
         * exeNewPasswordButton = new JButton("Ändra lösenord");
         * exeNewPasswordButton.setBounds(10, 230, 185, 25);
         * exeNewPasswordButton.addActionListener(exeNewPasswordHandeler);
         * panel.add(exeNewPasswordButton);
         */

        success = new JLabel("");
        success.setBounds(10, 100, 300, 25);
        panel.add(success);

        frame.setVisible(true);

    }

    public void changeAnsvarigAgentWindow() {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        userLabel = new JLabel("Ny ansvarig Agent");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        passwordLabel = new JLabel("Your Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        instansieraNyButton = new JButton("Utför");
        instansieraNyButton.setBounds(10, 80, 80, 25);
        //instansieraNyButton.addActionListener();
        //inloggButton.addActionListener(timerHandler);
        //inloggButton.setActionCommand("Login");
        panel.add(instansieraNyButton);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

//______________________________________________________________________________________________________
// Koden för GUIn till inloggningsfönstret
    public void passwordWindow() {
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
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        inloggButton = new JButton("Login");
        inloggButton.setBounds(10, 80, 80, 25);
        inloggButton.addActionListener(loginHandeler);
        //inloggButton.addActionListener(timerHandler);
        //inloggButton.setActionCommand("Login");
        panel.add(inloggButton);

        changePassButton = new JButton("Ändra lösenord");
        changePassButton.setBounds(100, 80, 165, 25);
        changePassButton.addActionListener(changePassHandeler);
        panel.add(changePassButton);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        //Om inloggningsStatus = false så ska fönstret förbli öppet när man klickar på login.
        if (!inloggningsStatus) {
            frame.setVisible(true);
        }

        //Om inloggningsstatus = true ska fönstret stängas när man klickar på login. Inte fått denna att funka än. 
        if (inloggningsStatus) {
            WindowEvent windowClosing = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosing);
            frame.dispatchEvent(windowClosing);

        }

    }

    // Koden för knappen som instansierar GUIn ändra lösenord
    public class ChangePasswordHandeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            changePasswordWindow();
        }
    }

//______________________________________________________________________________________________________    
// Koden för knappen som exikverar nytt lösenord
    public class ExeNewPassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent b) {
            try {

                String username = userText.getText();
                String currentPassword = cPasswordText.getText();

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

                if (resultatAgentNamn != null) {
                    if (resultatAgentLosen.equals(currentPassword)) {
                        inloggningsStatus = true;
                        agentinloggad = true;
                    } else {
                        success.setText("Password and username does not match");
                        inloggningsStatus = false;
                    }
                } else if (resultatAlienNamn != null) {
                    if (resultatAlienLosen.equals(currentPassword)) {
                        inloggningsStatus = true;
                        alieninloggad = true;
                    } else {
                        success.setText("Password and username does not match");
                        inloggningsStatus = false;
                    }
                } else {
                    success.setText("Username doesn´t exist in database");
                    inloggningsStatus = false;
                }

                if (agentinloggad) {
                    String newPassword = nPasswordText.getText();
                    String frågaChange = "UPDATE Agent SET Losenord =" + "'" + newPassword + "'" + "WHERE Namn =" + "'" + username + "'";
                    String svarChange = idb.fetchSingle(frågaChange);
                    String nyttPassword = svarChange;
                    success.setText("Password updated");
                } else if (alieninloggad) {
                    String newPassword = nPasswordText.getText();
                    String frågaChange = "UPDATE Alien SET Losenord =" + "'" + newPassword + "'" + "WHERE Namn =" + "'" + username + "'";
                    String svarChange = idb.fetchSingle(frågaChange);
                    String nyttPassword = svarChange;
                    success.setText("Password updated");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Attempt to create new password failed");
            }

        }

//______________________________________________________________________________________________________
//______________________________________________________________________________________________________
//______________________________________________________________________________________________________
        /**
         * public void sessionTimer() {
         *
         * timer = new Timer(timerSpeed, new ActionListener() {
         *
         * @Override public void actionPerformed(ActionEvent f) {
         * sessionTimerCounter++; sessionTimerLabel.setText(sessionTimerCounter
         * + " sekunder"); } }); }
         *
         *
         * public void timerUpdate() { if (timerOn== false) { timerOn = true; }
         * else if (timerOn== true) { timer.stop(); }
         *
         * double speed = 1/perSecond*1000; timerSpeed = (int)Math.round(speed);
         *
         * String s = String.format("%.1f", perSecond); //perSecLabel.setText(s
         * + " sekunder");
         *
         * sessionTimer(); timer.start();
         *
         * }
         *
         * public class TimerHandler implements ActionListener {
         *
         * public void actionPerformed(ActionEvent g) {
         *
         * {
         * String action = g.getActionCommand();
         *
         * switch(action) { case "Login": perSecond = perSecond + 0.1;
         * timerUpdate(); } }
         *
         * }
         */
//getNamnAgent-metod    KLART
//getNamnAlien-metod     KLART
//createFont-metod             KLART
//GUI_AGENT-metod       KLART
//GUI_ALIEN-metod        KLART
//Lösenordsfönstermetod  KLART
//ÄndraLösenFönster        KLART
//skapa meny alien           KLART
//skapa meny agent          KLART
//skapa en menypanelmetod KLART
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

    public class RegistreraAlien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent h) {

            registreraAlienWindow();
        }
    }

    public class RegistreraAgent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent esc) {
            registreraAgentWindow();
        }
    }

    public class RegistreraUtrustning implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent h) {

            registreraUtrustningWindow();
        }
    }

    public class InstansieraNyUtrustning implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent q) {
            try {

                String utrustningsID = text1.getText();
                String benamning = text2.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mibdb", "mibdba", "mibkey");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO UTRUSTNING (Utrustnings_ID, Benamning) VALUES (?, ?)");

                ps.setString(1, utrustningsID);
                ps.setString(2, benamning);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Gear added to chart");

            } catch (Exception exa) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, exa);
                JOptionPane.showMessageDialog(null, "Attempt to add gear to chart failed");
            }
        }
    }

    public class DropAlien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ssd) {

            dropAlienWindow();
        }
    }

    public class DropAlienExe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ssf) {
            try {
                String alienID = userText.getText();
                int agentId = Integer.parseInt(alienID);
                boolean existera1 = letaRasB(alienID);
                boolean existera2 = letaRasS(alienID);
                boolean existera3 = letaRasW(alienID);
                String enAlien = getNamnAlien();

                if (alienID != null) {
                    if (existera1) {
                        idb.delete("DELETE FROM Boglodite WHERE Alien_ID = " + alienID);
                        JOptionPane.showMessageDialog(null, "Alien raderad från Boglodite");
                    }
                    if (existera2) {
                        idb.delete("DELETE FROM Squid WHERE Alien_ID = " + alienID);
                        JOptionPane.showMessageDialog(null, "Alien raderad från Squid");
                    }
                    if (existera3) {
                        idb.delete("DELETE FROM Worm WHERE Alien_ID = " + alienID);
                        JOptionPane.showMessageDialog(null, "Alien raderad från Worm");
                    }
                    if (alienID!=null) {
                        idb.delete("DELETE FROM Alien WHERE Alien_ID = " + alienID);
                        JOptionPane.showMessageDialog(null, "Alien borttagen från databasen");
                    } else {
                        JOptionPane.showMessageDialog(null, "AlienID finns inte i databasen");
                    }
                }
            } catch (InfException sdes) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, sdes);
                JOptionPane.showMessageDialog(null, "Det gick inte att ta bort alien.");
            }
        }
    }

    public class DropAgent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent sss) {

            try {
                String agentID = text1.getText();
                int agentId = Integer.parseInt(agentID);
                boolean existera = letaAnsvarigAgent(agentID);
                boolean existera2 = letaAktivFaltagent(agentID);
                String enAgent = getAgentIdById(agentId);
                //String ansvarigAgent = getAlienAnsvarigAgent();

                if (agentID != null) {
                    if (existera2) {
                        idb.delete("DELETE FROM faltagent WHERE Agent_ID = " + agentId);
                    }
                    if (existera) {
                        changeAnsvarigAgentWindow();
                    } else if (!existera && enAgent != null) {
                        idb.delete("DELETE FROM Agent WHERE Agent_ID = " + agentId);
                        JOptionPane.showMessageDialog(null, "Agent dropped");

                        if (enAgent == null) {
                            JOptionPane.showMessageDialog(null, "Agent dropped2");
                        }
                    }
                    /*Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mibdb", "mibdba", "mibkey");
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Agent, Alien WHERE Agent_ID = "+ "'"+ agentID +"'");
                
                ps.execute();
                JOptionPane.showMessageDialog(null, "Agent dropped");
                
                conn.close();*/
                }

            } catch (Exception exa) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, exa);
                JOptionPane.showMessageDialog(null, "Attempt to remove Agent from database failed");

            }
        }
    }

    public class DropUtrustning implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent sss) {

            try {
                String utrustningsID = text1.getText();
                boolean existera = letaUtrustning(utrustningsID);

                /*String fragaUtrustning = "SELECT utrustnings_id FROM utrustning WHERE utrustnings_id =" + "'" + utrustning + "'";
                String svarUtrustning = idb.fetchSingle(fragaUtrustning);
                String enUtrustning = svarUtrustning; */
                if (!existera) {

                    JOptionPane.showMessageDialog(null, "UtrustningsID finns inte");

                } else {
                    idb.delete("DELETE FROM Utrustning WHERE Utrustnings_ID = " + utrustningsID);
                    JOptionPane.showMessageDialog(null, "Utrustningen är raderad");

                }

            } catch (Exception exa) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, exa);
                JOptionPane.showMessageDialog(null, "Det går inte att radera utrustning som används");

            }
        }
    }

    public class LetaAlienID implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent t) {
            try {
                String valdAlien = text8.getText();
                boolean existera = letaAlienIDs(valdAlien);
                if (valdAlien != null) {
                    if (existera) {
                        ändraAlienWindow();
                    } else if (!existera) {
                        JOptionPane.showMessageDialog(null, "Valt ID existerar inte");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Valt ID existerar inte");
            }

        }

    }

    public class ÄndraAlienHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent t) {

            try {
                ändraAlienWindow();

            } catch (Exception exb) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, exb);
                JOptionPane.showMessageDialog(null, "Attempt to access alter alien failed");
            }

        }
    }

    public class ValjAlienHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent u) {

            valjAlienWindow();

        }
    }

    public class HanteraAgentHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent o) {
            hanteraAgentWindow();
        }
    }

    public class UppdateraAgentHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ss) {

            try {
                String fråga = "UPDATE Agent SET ";

                //String valdAgentNamn = text8.getText();
                String agentID = text1.getText();
                String namn = text2.getText();
                String telefon = text3.getText();
                String anställningsdatum = text4.getText();
                String adminstatus = text5.getText();
                String lösenord = passwordText.getText();
                String område = text7.getText();

                String statemens = (" WHERE Agent_ID = " + agentID);

                if (namn != null && !namn.isBlank()) {
                    idb.update(fråga + " Namn = " + "'" + namn + "'" + statemens);
                }

                if (telefon != null && !telefon.isBlank()) {
                    idb.update(fråga + " Telefon = " + "'" + telefon + "'" + statemens);
                }

                if (anställningsdatum != null && !anställningsdatum.isBlank()) {
                    idb.update(fråga + " Anstallningsdatum = " + "'" + anställningsdatum + "'" + statemens);
                }
                if (adminstatus != null && !adminstatus.isBlank()) {
                    idb.update(fråga + " Administrator = " + "'" + adminstatus + "'" + statemens);
                }
                if (lösenord != null && !lösenord.equals("")) {
                    idb.update(fråga + " Losenord = " + "'" + lösenord + "'" + statemens);
                }
                if (område != null && !område.isEmpty()) {
                    idb.update(fråga + " Omrade = " + område + statemens);
                }
                if (agentID != null && !agentID.isEmpty()) {
                    idb.update(fråga + " Agent_ID = " + agentID + statemens);
                }

                JOptionPane.showMessageDialog(null, "Attempt to update agent successfull!");

            } catch (Exception ex) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Attempt to update agent failed");
            }

        }
    }
    
    public class AddAlienKön implements ActionListener
    {
        private JTextField field;
        private JFrame frame;
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Ras ändras!");
            try
            {
                String ras = getRasByID(text8.getText());
                String nyRas = text9.getText();
                String ID = text8.getText();
                String antal = field.getText();
                
                if (rasExists(ras))
                {
                    if (nyRas.equals("Boglodite"))
                    {
                        taBortRas(ID, ras);
                        läggTillB(ID, antal);
                    }
                    if (nyRas.equals("Squid"))
                    {
                        taBortRas(ID, ras);
                        läggTillS(ID, antal);
                    }
                    if (nyRas.equals("Worm"))
                    {
                        taBortRas(ID, ras);
                        läggTillW(ID);
                    }
                }
                else
                {
                    läggTillW(ID);
                }

                
                System.out.println("Sätter ny ras");
                
                frame.dispose();
            }
            
            catch(InfException ex)
            {
                System.out.println("Det gick inte att ändra ras");
            }
        }
        
        public void taBortRas(String alienID, String ras) throws InfException
        {
            idb.delete("DELETE FROM " + ras + " where Alien_ID = " + alienID + ";");
        }
        
        public void läggTillB(String alienID, String antalBoogies) throws InfException
        {
            idb.insert("INSERT INTO Boglodite values (" + alienID + ", " + antalBoogies + ");");
        }
        
        public void läggTillS(String alienID, String antalArmar) throws InfException
        {
            idb.insert("INSERT INTO Squid values (" + alienID + ", " + antalArmar + ");");
        }
        
        public void läggTillW(String alienID) throws InfException
        {
            idb.insert("INSERT INTO Worm values(" + alienID + ");");
        }
        
        public boolean rasExists(String ras) throws InfException
        {
            ArrayList<HashMap<String, String>> svar = new ArrayList();
            svar = idb.fetchRows("SHOW TABLES like '" + ras + "';");
            
            return !(svar.isEmpty());
        }
        
        public void alienKönWindow(String idbSvar)
        {
            JPanel panel = new JPanel();

            frame = new JFrame();
            frame.setSize(400, 250);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setLocationRelativeTo(null);
            panel.setLayout(null);

            field = new JTextField();


            if(!(idbSvar.isEmpty()))
            {
                    JLabel temp = new JLabel(idbSvar);
                    temp.setBounds(10, 20, 300, 25);
                    panel.add(temp);

                    field.setBounds(100, 20, 100, 25);
                    panel.add(field);

                    JButton knappisen = new JButton("OK");
                    knappisen.setBounds(10, 100, 50,25 );
                    knappisen.addActionListener(alienKön);
                    panel.add(knappisen);

                    frame.setVisible(true);
            }


        }
    }


    public class UppdateraAlien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent s) {

            try {
                String fråga = "UPDATE Alien SET ";

                //String valdAgentNamn = text8.getText();
                String alienIDNy = text1.getText();
                String registrering = text2.getText();
                String lösenord = passwordText.getText();
                String namn = text4.getText();
                String telefon = text5.getText();
                String plats = text6.getText();
                String ansvarigAgent = text7.getText();
                String alienID = text8.getText();
                String läggTill = text9.getText();
                
                boolean skickaFråga = false;

                String statemens = (" WHERE Alien_ID = " + alienID);

                if (!(registrering.isEmpty())) {
                    fråga = fråga + (" Registreringsdatum = '" + registrering + "',");
                    skickaFråga = true;
                }
                if (!(lösenord.isEmpty())) {
                    fråga = fråga + (" Losenord = " + "'" + lösenord + "',");
                    skickaFråga = true;
                }
                if (!(namn.isEmpty())) {
                    fråga = fråga + (" Namn = " + "'" + namn + "',");
                    skickaFråga = true;
                }
                if (!(telefon.isEmpty())) {
                    fråga = fråga + (" Telefon = " + "'" + telefon + "',");
                    skickaFråga = true;
                }
                if (!(plats.isEmpty())) {
                    fråga = fråga + (" Plats = " + plats + ",");
                    skickaFråga = true;
                }
                if (!(ansvarigAgent.isEmpty())) {
                    fråga = fråga + (" Ansvarig_Agent = " + ansvarigAgent + ",");
                    skickaFråga = true;
                }
                if (!(alienIDNy.isEmpty())) {
                    fråga = fråga + (" Alien_ID = " + alienIDNy + ",");
                    skickaFråga = true;
                }
                
                
                if (!(läggTill.isEmpty()))
                {
                    ArrayList<HashMap<String, String>> svar = new ArrayList();

 
                    if (!(alienKön.rasExists(läggTill)))
                    {
                        JOptionPane.showMessageDialog(null, "Rasen existerar inte");
                    }
                    else
                    {
                        svar = idb.fetchRows("Select * from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = '" + läggTill + "';");
                        if (svar.size() > 1)
                        {
                            alienKön.alienKönWindow(svar.get(1).get("COLUMN_NAME"));
                        }
                        else
                        {
                            alienKön.läggTillW(alienID);
                        }
                    }
                
                }
                    

                
                StringBuffer sb = new StringBuffer(fråga);
                sb.deleteCharAt(sb.length()-1);
                fråga = sb.toString();
                fråga += statemens;
                
                if (skickaFråga)
                {
                    idb.update(fråga);
                    JOptionPane.showMessageDialog(null, "Alien uppdaterad");
                }
                
                
                

            } catch (Exception ex) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Det gick inte att uppdatera alien");
            }

        }
    }

    public class InstansieraNyAgent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ecs) {
            try {

                String ettNamn = text2.getText();

                String frågaAgentNamn = "Select namn from agent where namn =" + "'" + ettNamn + "'";
                String svarAgentNamn = idb.fetchSingle(frågaAgentNamn);
                String resultatAgentNamn = svarAgentNamn;

                if (resultatAgentNamn == null) {

                    String agentID = text1.getText();
                    String namn = text2.getText();
                    String telefon = text3.getText();
                    String anställd = text4.getText();
                    String admin = text5.getText();
                    String lösen = passwordText.getText();
                    String område = text7.getText();

                    Validering.isValidPassword();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mibdb", "mibdba", "mibkey");
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO Agent (Agent_ID, Namn, Telefon, Anstallningsdatum, Administrator, Losenord, Omrade) VALUES (?, ?, ?, ?, ?, ?, ?)");

                    ps.setString(1, agentID);
                    ps.setString(2, namn);
                    ps.setString(3, telefon);
                    ps.setString(4, anställd);
                    ps.setString(5, admin);
                    ps.setString(6, lösen);
                    ps.setString(7, område);

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Agent added to MIB-database");
                } else {
                    JOptionPane.showMessageDialog(null, "Agentnamn upptaget");
                }
            } catch (Exception exy) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, exy);
                JOptionPane.showMessageDialog(null, "Attempt to add Agent to database failed");

            }
        }
    }

    public class InstansieraNyAlien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent s) {

            try {
                //String sql =

                String iD = text1.getText();
                String registreringsDatum = text2.getText();
                String lösenord = text3.getText();
                String namn = text4.getText();
                String tele = text5.getText();
                String plats = text6.getText();
                String ansvarigAgent = text7.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mibdb", "mibdba", "mibkey");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO ALIEN (Alien_ID, Registreringsdatum, Losenord, Namn, Telefon, Plats, Ansvarig_Agent) VALUES (?, ?, ?, ?, ?, ?, ?)");

                ps.setString(1, iD);
                ps.setString(2, registreringsDatum);
                ps.setString(3, lösenord);
                ps.setString(4, namn);
                ps.setString(5, tele);
                ps.setString(6, plats);
                ps.setString(7, ansvarigAgent);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Alien tillagd");
//String sql = "INSERT INTO Alien VALUES " + "'" + text1.getText() + "'" + "'" + text2.getText() + "'"+ "'" + text3.getText() + "'"+ "'" + text4.getText() + "'"+ "'" + text5.getText() + "'"+ "'" + text6.getText() + "'"+ "'" + text7.getText() + "'";

                //Scanner sc = new Scanner(System.out);
                //String sql = "INSERT INTO Alien VALUES " + ("'"+iD+"'" +"," +  "'"+registreringsDatum+"'" +"," + "'"+lösenord+"'" +","  + "'"+namn+"'" +"," + "'"+tele+"'" +"," + "'"+plats+"'" +"," + "'"+ansvarigAgent+"'");
                //stmt.executeUpdate(sql);
                //stmt.close();
                //conn.close();
                //int x=stmt.executeUpdate(sql);
                /**
                 * if(x!=0) { System.out.println("Alien tillaggd");
                 *
                 * }
                 * else{ System.out.println("Alien inte tillaggd"); }
                 */
            } catch (Exception ex) {
                Logger.getLogger(MIB_Project.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Attempt failed");

            }

        }

    }

    public class Alien {

        private int alien_ID;
        private String registreringsDatum;
        private String namn;

        public Alien(int alien_ID, String regDatum, String namn) {
            this.alien_ID = alien_ID;
            registreringsDatum = regDatum;
            this.namn = namn;

        }

        public String toString() {
            return "ID: " + alien_ID + "\nRegDatum: " + registreringsDatum + "\nNamn: " + namn;
        }

        public int getAlien_ID() {

            return alien_ID;

        }

        public String getRegDatum() {

            return registreringsDatum;

        }

        public String getNamn() {
            return namn;
        }

    }

    public ArrayList<Alien> alienRegDatum(String startDatum, String slutDatum) throws InfException {
        String fråga = "Select * from alien where registreringsdatum BETWEEN '" + startDatum + "' and '" + slutDatum + "';";
        ArrayList<HashMap<String, String>> svar = new ArrayList();
        ArrayList<Alien> lista = new ArrayList();

        try {

            svar = idb.fetchRows(fråga);
            for (HashMap<String, String> rad : svar) {
                Alien temp = new Alien(Integer.parseInt(rad.get("Alien_ID")), rad.get("Registreringsdatum"), rad.get("Namn"));
                lista.add(temp);
            }

        } catch (InfException ex) {
            System.out.println("FEL");
        }

        System.out.println(lista);

        return lista;

    }

    public class AlienMellanDatumWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent w) {
            alienMellanDatumWindow();
        }
    }

    public void visaAlien(ArrayList<Alien> lista) {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        int counter = 1;
        for (Alien a : lista) {
            JLabel tempLabel = new JLabel("ID: " + a.getAlien_ID());
            tempLabel.setBounds(10, 20 * counter, 120, 25);
            panel.add(tempLabel);

            tempLabel = new JLabel("Namn: " + a.getNamn());
            tempLabel.setBounds(10, 20 * counter + 20, 120, 25);
            panel.add(tempLabel);

            tempLabel = new JLabel("Registreringsdatum: " + a.getRegDatum());
            tempLabel.setBounds(10, 20 * counter + 40, 250, 25);
            panel.add(tempLabel);

            counter += 4;
        }
        frame.setVisible(true);

    }

    public class AlienMellanDatumHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent s) {
            try {
                ArrayList<Alien> svar = new ArrayList();
                svar = alienRegDatum(text1.getText(), text2.getText());
                //namnLabel.setText(alienRegDatum);
                visaAlien(svar);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "hihi du fick ett felmeddelande!! :)");

            }
        }
    }

    public class Validering {

        public static boolean isValidDate(String input) {
            try {
                LocalDate.parse(input);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        public static boolean isValidPassword() {
            try {
                String ettLosen = passwordText.getText();
                int losen = Integer.parseInt(ettLosen);
                if (losen > 6) {
                    JOptionPane.showMessageDialog(null, "Lösenordet är för långt");

                }
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }
}
>>>>>>> Stashed changes
