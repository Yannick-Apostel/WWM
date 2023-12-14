import javax.swing.*;
import java.awt.Font;
import java.io.File;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.util.ArrayList;

public class altGUI
{
    private JFrame frame;
    
    private JPanel panel;
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton exitB;
    private JButton jokerB;
    private JButton tjB;
    private JButton pjB;
    private JButton fjB;
    private JButton xB;
    private JButton nsB;
    
    private JLabel Titel;
    
    private JTextArea frageText;
    
    private WWM wwm = new WWM();
    private int beantworteteFragen = 0;
    Font font = new Font("Arial", Font.PLAIN, 20);
    
    public altGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        UIManager.put("TextField.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("TextArea.font", font);
        
        wwm.erstelleSpiel();
        erstelleJObjekte();
        setJObjekte();
        mainMenu();
    }
    
    public void erstelleJObjekte() {
        frame = new JFrame();
        
        panel = new JPanel();
        
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();
        exitB = new JButton();
        jokerB = new JButton();
        tjB = new JButton();
        pjB = new JButton();
        fjB = new JButton();
        xB = new JButton();
        nsB = new JButton();
        
        Titel = new JLabel();
        
        frageText = new JTextArea();
    }
    
    public void setJObjekte() {
        frageText.setPreferredSize(new Dimension(800, 150));
        frageText.setLineWrap(true);
        frageText.setWrapStyleWord(true);
        frageText.setEditable(false);
        Titel.setFont(font);
        b1.setPreferredSize(new Dimension(400, 150)); b1.setFont(font);
        b2.setPreferredSize(new Dimension(400, 150)); b2.setFont(font);
        b3.setPreferredSize(new Dimension(400, 150)); b3.setFont(font);
        b4.setPreferredSize(new Dimension(400, 150)); b4.setFont(font);
        exitB.setPreferredSize(new Dimension(400, 150)); exitB.setText("Spiel beenden");  exitB.setFont(font);
        jokerB.setPreferredSize(new Dimension(400, 150)); jokerB.setText("Joker"); jokerB.setFont(font);
        tjB.setPreferredSize(new Dimension(400, 150)); tjB.setText("Telefonjoker"); tjB.setFont(font);
        fjB.setPreferredSize(new Dimension(400, 150)); fjB.setText("50/50 Joker"); fjB.setFont(font);
        pjB.setPreferredSize(new Dimension(400, 150)); pjB.setText("Publikumjoker"); pjB.setFont(font);
        xB.setPreferredSize(new Dimension(400, 150)); xB.setText("Zurück"); xB.setFont(font);
        nsB.setPreferredSize(new Dimension(400, 150)); nsB.setText("Neues Spiel"); nsB.setFont(font);
        
        b1.addActionListener(e -> {
            if (antwortAuswertung(wwm.getAktuellesSpiel().getFrageNr(beantworteteFragen), 0)) {
                setFrage(wwm.getAktuellesSpiel().getNächsteFrage());
            } else {
                spielVerlassen();
            }
            beantworteteFragen++;
        });
        b2.addActionListener(e -> {
            if (antwortAuswertung(wwm.getAktuellesSpiel().getFrageNr(beantworteteFragen), 1)) {
                setFrage(wwm.getAktuellesSpiel().getNächsteFrage());
            } else {
                spielVerlassen();
            }
            beantworteteFragen++;
        });
        b3.addActionListener(e -> {
            if (antwortAuswertung(wwm.getAktuellesSpiel().getFrageNr(beantworteteFragen), 2)) {
                setFrage(wwm.getAktuellesSpiel().getNächsteFrage());
            } else {
                spielVerlassen();
            }
            beantworteteFragen++;
        });
        b4.addActionListener(e -> {
            if (antwortAuswertung(wwm.getAktuellesSpiel().getFrageNr(beantworteteFragen), 3)) {
                setFrage(wwm.getAktuellesSpiel().getNächsteFrage());
            } else {
                spielVerlassen();
            }
            beantworteteFragen++;
        });
        exitB.addActionListener(e -> {
            spielVerlassen();
        });
        jokerB.addActionListener(e -> {
            jokermenü();
        });
        xB.addActionListener(e -> {
            erstelleFragePanel();
        });
        nsB.addActionListener(e -> {
            eingabeSicherheitsstufen(wwm.getAktuellesSpiel());
        });
        pjB.addActionListener(e -> {
            publikumjoker(wwm.getAktuellesSpiel().getFrageNr(beantworteteFragen));
            wwm.getAktuellesSpiel().setPublikumjoker(false);
        });
        fjB.addActionListener(e -> {
            fiftyfiftyjoker(wwm.getAktuellesSpiel().getFrageNr(beantworteteFragen));
            wwm.getAktuellesSpiel().setFiftyfiftyjoker(false);
        });
        
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("WWM.exe");
        frame.setResizable(false);
    }
    
    public void starten() {
        erstelleFragePanel();
        setFrage(wwm.getAktuellesSpiel().getNächsteFrage());
    }
    
    public void mainMenu() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setLayout(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.VERTICAL;
        Titel.setText("Wer Wird Millionär?!"); Titel.setFont(new Font("Arial", Font.PLAIN, 40));
        c.gridy = 0;
        panel.add(Titel, c);
        c.gridy = 1;
        panel.add(nsB, c);
        c.gridy = 2;
        panel.add(exitB, c);
    }
    
    public void setFrage(Frage aktuelleFrage) {
        frageText.setText("Hier ist die " + aktuelleFrage.getStufe().getGeldString() + " Frage: \n" + aktuelleFrage.getText());
        b1.setText("A: " + aktuelleFrage.getAntwortenListe().get(0).getText());
        b2.setText("B: " + aktuelleFrage.getAntwortenListe().get(1).getText());
        b3.setText("C: " + aktuelleFrage.getAntwortenListe().get(2).getText());
        b4.setText("D: " + aktuelleFrage.getAntwortenListe().get(3).getText());
    }
    
    public boolean antwortAuswertung(Frage aktuelleFrage, int antwort) {
        if (aktuelleFrage.getAntwortenListe().get(antwort).getIstRichtig()==true) {
            return true;
        } else {
            return false;
        }
    }
    
    public void erstelleFragePanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setLayout(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 2;
        panel.add(frageText, c);
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(b1, c);
        c.gridx = 1;
        panel.add(b2, c);
        c.gridy = 2;
        c.gridx = 0;
        panel.add(b3, c);
        c.gridx = 1;
        panel.add(b4, c);
        c.gridy = 3;
        c.gridx = 0;
        panel.add(exitB, c);
        c.gridx = 1;
        panel.add(jokerB, c);
    }
    
    public void jokermenü() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setLayout(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.VERTICAL;
        c.gridy = 0;
        panel.add(xB, c);
        c.gridy++;
        if (wwm.getAktuellesSpiel().getFiftyfiftyjoker()) {
            panel.add(fjB, c);
            c.gridy++;
        }
        if (wwm.getAktuellesSpiel().getTelefonjoker()) {
            panel.add(tjB, c);
            c.gridy++;
        }
        if (wwm.getAktuellesSpiel().getPublikumjoker()) {
            panel.add(pjB, c);
        }
    }
    
    public void fiftyfiftyjoker(Frage aktuelleFrage) {
        Frage veränderteFrage = aktuelleFrage;
        
        Antwort richtigeAntwort = new Antwort(), falscheAntwort = new Antwort();
        int rng = (int)(Math.random() * 3);
        int i = 0;
        for (Antwort aktuelleAntwort : aktuelleFrage.getAntwortenListe()) {
            if (aktuelleAntwort.getIstRichtig() == true) {
                richtigeAntwort = aktuelleAntwort;
            }
            else {
                if (i == rng) {
                    falscheAntwort = aktuelleAntwort;
                }
                i++;
            }
        }
        
        ArrayList<Antwort> veränderteAntwortenListe = new ArrayList<Antwort>();
        veränderteAntwortenListe.add(richtigeAntwort);
        veränderteAntwortenListe.add(falscheAntwort);
        veränderteFrage.setAntwortenListe(veränderteAntwortenListe);
        
        frageText.setText("Hier ist die " + aktuelleFrage.getStufe().getGeldString() + " Frage: \n" + aktuelleFrage.getText());
        b1.setText("A: " + veränderteFrage.getAntwortenListe().get(0).getText());
        b2.setText("B: " + veränderteFrage.getAntwortenListe().get(1).getText());
        b3.setText("");
        b4.setText("");
    }
    
    public void publikumjoker(Frage aktuelleFrage) {
        int rngRichtigeAntwort = (int)(Math.random() * ((75 - 25) + 1) + 25); // int rng = (int)(Math.random() * ((max - min) + 1) + min)
        int rngFalscheAntwort1 = (int)(Math.random() * ((100 - rngRichtigeAntwort) + 1));
        int rngFalscheAntwort2 = (int)(Math.random() * ((100 - rngRichtigeAntwort - rngFalscheAntwort1) + 1));
        int rngFalscheAntwort3 = 100 - rngRichtigeAntwort - rngFalscheAntwort1 - rngFalscheAntwort2;
        
        frageText.setText(frageText.getText() + "\nDas Publikum hat abgestimmt: \n");
        int rIndex = 0;
        for (int i = 1 ; i<=aktuelleFrage.getAntwortenListe().size() ; i++) {
            if (aktuelleFrage.getAntwortenListe().get(i-1).getIstRichtig()==true) {
                switch(i) {
                    case 1: frageText.setText(frageText.getText() + "A: " + rngRichtigeAntwort + "%, "); break;
                    case 2: frageText.setText(frageText.getText() + "B: " + rngRichtigeAntwort + "%, "); break;
                    case 3: frageText.setText(frageText.getText() + "C: " + rngRichtigeAntwort + "%, "); break;
                    case 4: frageText.setText(frageText.getText() + "D: " + rngRichtigeAntwort + "%, "); break;
                }
                rIndex = i;
            }
            else {
                switch (rIndex) {
                    case 0: 
                    switch (i) {
                        case 1: frageText.setText(frageText.getText() + "A: " + rngFalscheAntwort1 + "%, "); break;
                        case 2: frageText.setText(frageText.getText() + "B: " + rngFalscheAntwort2 + "%, "); break;
                        case 3: frageText.setText(frageText.getText() + "C: " + rngFalscheAntwort3 + "%, "); break;
                    }
                    break;
                    case 1:
                    switch (i) {
                        case 2: frageText.setText(frageText.getText() + "B: " + rngFalscheAntwort1 + "%, "); break;
                        case 3: frageText.setText(frageText.getText() + "C: " + rngFalscheAntwort2 + "%, "); break;
                        case 4: frageText.setText(frageText.getText() + "D: " + rngFalscheAntwort3 + "%, "); break;
                    }
                    break;
                    case 2:
                    switch (i) {
                        case 3: frageText.setText(frageText.getText() + "C: " + rngFalscheAntwort2 + "%, "); break;
                        case 4: frageText.setText(frageText.getText() + "D: " + rngFalscheAntwort3 + "% "); break;
                    }
                    break;
                    case 3:
                        frageText.setText(frageText.getText() + "D: " + rngFalscheAntwort3 + "%, ");
                    break;
                }
            }
        }
    }
    
    public boolean nochmalSpielen() {
        return false; //TODO   
    }
    
    public void eingabeSicherheitsstufen(Spiel aktuellesSpiel) {
        JRadioButton jrb1 = new JRadioButton("50€"); jrb1.setFont(font);
        JRadioButton jrb2 = new JRadioButton("100€"); jrb2.setFont(font);
        JRadioButton jrb3 = new JRadioButton("200€"); jrb3.setFont(font);
        JRadioButton jrb4 = new JRadioButton("300€"); jrb4.setFont(font);
        JRadioButton jrb5 = new JRadioButton("500€"); jrb5.setFont(font);
        JRadioButton jrb6 = new JRadioButton("1.000€"); jrb6.setFont(font);
        JRadioButton jrb7 = new JRadioButton("2.000€"); jrb7.setFont(font);
        JRadioButton jrb8 = new JRadioButton("4.000€"); jrb8.setFont(font);
        JRadioButton jrb9 = new JRadioButton("8.000€"); jrb9.setFont(font);
        JRadioButton jrb10 = new JRadioButton("16.000€"); jrb10.setFont(font);
        JRadioButton jrb11 = new JRadioButton("32.000€"); jrb11.setFont(font);
        JRadioButton jrb12 = new JRadioButton("64.000€"); jrb12.setFont(font);
        JRadioButton jrb13 = new JRadioButton("125.000€"); jrb13.setFont(font);
        JRadioButton jrb14 = new JRadioButton("500.000€"); jrb14.setFont(font);
        JRadioButton jrb15 = new JRadioButton("1.000.000€"); jrb15.setFont(font);
        
        ButtonGroup ssAuswahl = new ButtonGroup();
        ssAuswahl.add(jrb1);
        ssAuswahl.add(jrb2);
        ssAuswahl.add(jrb3);
        ssAuswahl.add(jrb4);
        ssAuswahl.add(jrb5);
        ssAuswahl.add(jrb6);
        ssAuswahl.add(jrb7);
        ssAuswahl.add(jrb8);
        ssAuswahl.add(jrb9);
        ssAuswahl.add(jrb10);
        ssAuswahl.add(jrb11);
        ssAuswahl.add(jrb12);
        ssAuswahl.add(jrb13);
        ssAuswahl.add(jrb14);
        ssAuswahl.add(jrb15);
        
        Titel.setText("Setzen Sie ihre erste Sicherheitsstufe."); Titel.setFont(font);
        
        JButton ssBestätigen = new JButton("Bestätigen"); ssBestätigen.setPreferredSize(new Dimension(400, 150)); ssBestätigen.setFont(font); 
        
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setLayout(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 10, 6, 10);
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 2;
        panel.add(Titel, c);
        c.gridwidth = 1;
        c.gridy++;
        c.gridx = 0;
        panel.add(jrb1, c);
        c.gridy++;
        panel.add(jrb2, c);
        c.gridy++;
        panel.add(jrb3, c);
        c.gridy++;
        panel.add(jrb4, c);
        c.gridy++;
        panel.add(jrb5, c);
        c.gridy++;
        panel.add(jrb6, c);
        c.gridy++;
        panel.add(jrb7, c);
        c.gridy++;
        panel.add(jrb8, c);
        c.gridy++;
        panel.add(jrb9, c);
        c.gridy++;
        panel.add(jrb10, c);
        c.gridy++;
        panel.add(jrb11, c);
        c.gridy++;
        panel.add(jrb12, c);
        c.gridy++;
        panel.add(jrb13, c);
        c.gridy++;
        panel.add(jrb14, c);
        c.gridy++;
        panel.add(jrb15, c);
        c.gridy = 1;
        c.gridx = 2;
        c.gridheight = 8;
        panel.add(ssBestätigen, c);
        c.gridy = 9;
        c.gridx = 2;
        panel.add(exitB, c);
        c.gridheight = 1;
        
        ssBestätigen.addActionListener(e -> {
            Stufe stufe = new Stufe();
            if (jrb1.isSelected())        {
                stufe = new Stufe(1);
            } else if (jrb2.isSelected()) {
                stufe = new Stufe(2);
            } else if (jrb3.isSelected()) {
                stufe = new Stufe(3);
            } else if (jrb4.isSelected()) {
                stufe = new Stufe(4);
            } else if (jrb5.isSelected()) {
                stufe = new Stufe(5);
            } else if (jrb6.isSelected()) {
                stufe = new Stufe(6);
            } else if (jrb7.isSelected()) {
                stufe = new Stufe(7);
            } else if (jrb8.isSelected()) {
                stufe = new Stufe(8);
            } else if (jrb9.isSelected()) {
                stufe = new Stufe(9);
            } else if (jrb10.isSelected()) {
                stufe = new Stufe(10);
            } else if (jrb11.isSelected()) {
                stufe = new Stufe(11);
            } else if (jrb12.isSelected()) {
                stufe = new Stufe(12);
            } else if (jrb13.isSelected()) {
                stufe = new Stufe(13);
            } else if (jrb14.isSelected()) {
                stufe = new Stufe(14);
            } else if (jrb15.isSelected()) {
                stufe = new Stufe(15);
            }
            if (aktuellesSpiel.getSicherheitsStufe1()==null) {
                if (stufe.getLevel()!=0 && stufe.getGeld()!=0 && stufe.getGeldString()!=null) {
                    aktuellesSpiel.setSicherheitsStufe1(stufe);
                    Titel.setText("Setzen Sie ihre zweite Sicherheitsstufe.");
                    for (int i=1 ; i<stufe.getLevel() ; i++) {
                        switch (i) {
                            case 1: jrb1.setVisible(false); break; 
                            case 2: jrb2.setVisible(false); break;
                            case 3: jrb3.setVisible(false); break;
                            case 4: jrb4.setVisible(false); break;
                            case 5: jrb5.setVisible(false); break;
                            case 6: jrb6.setVisible(false); break;
                            case 7: jrb7.setVisible(false); break;
                            case 8: jrb8.setVisible(false); break;
                            case 9: jrb9.setVisible(false); break;
                            case 10: jrb10.setVisible(false); break;
                            case 11: jrb11.setVisible(false); break;
                            case 12: jrb12.setVisible(false); break;
                            case 13: jrb13.setVisible(false); break;
                            case 14: jrb14.setVisible(false); break;
                        }
                    }
                    if (stufe.getLevel()>=8) {
                        int i = stufe.getLevel() - 7;
                        double pixels = jrb1.getSize().getHeight();
                        int j = (int) (16 - stufe.getLevel() * pixels) / 2 - 3;
                        ssBestätigen.setPreferredSize(new Dimension(400, j));
                        exitB.setPreferredSize(new Dimension(400, j));
                    }
                    panel.remove(ssBestätigen);
                    panel.remove(exitB);
                    c.gridy = stufe.getLevel();
                    c.gridx = 2;
                    c.gridheight = (15-stufe.getLevel()) / 2 + 1;
                    panel.add(ssBestätigen, c);
                    c.gridy = c.gridy + c.gridheight;
                    panel.add(exitB, c);
                    ssBestätigen.setPreferredSize(new Dimension(400, 150));
                    exitB.setPreferredSize(new Dimension(400, 150));
                }
            } else if (aktuellesSpiel.getSicherheitsStufe2()==null) {
                if (stufe.getLevel()!=0 && stufe.getGeld()!=0 && stufe.getGeldString()!=null) {
                    aktuellesSpiel.setSicherheitsStufe2(stufe);
                    starten();
                }
            }
        });
    }
    
    public void checkeSicherheitsstufe(Spiel aktuellesSpiel, Frage aktuelleFrage) {
        if (aktuelleFrage.getStufe().getLevel() > aktuellesSpiel.getSicherheitsStufe2().getLevel()) {
            System.out.println("Sie gewinnen dennoch dank ihrer zweiten Sicherheitsstufe " + aktuellesSpiel.getSicherheitsStufe2().getGeldString() + ". ");
        } else if (aktuelleFrage.getStufe().getLevel() > aktuellesSpiel.getSicherheitsStufe1().getLevel()) {
            System.out.println("Sie gewinnen dennoch dank ihrer ersten Sicherheitsstufe " + aktuellesSpiel.getSicherheitsStufe1().getGeldString() + ". ");
        } else {
            System.out.println("Sie gewinnen nichts.");
        }
    }
    
    public void spielVerlassen() {
        wwm.addSpielToSpielHistorie(wwm.getAktuellesSpiel());
        frame.setVisible(false);
        System.exit(0);
    }
}
