
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Fenetre extends JFrame{
	JPanel onglet1;
	JPanel onglet2;
	JButton variable1;
	JButton variable2;
	JButton influence1;
	JButton influence2;
	JButton action;
	static Onglet onglet;
	int valeurVar;
	String nomVar;



	public Fenetre(String string) {
		super(string);
		onglet1 = new JPanel();
		onglet2 = new JPanel();
		variable1 = new JButton("Variable");
		variable2 = new JButton("Variable");
		influence1 = new JButton("Influence");
		influence2 = new JButton("Influence");
		action = new JButton("Action");
		onglet = crea_onglet();
	}


//creation des onglets avec les boutons
	public Onglet crea_onglet() {
		Onglet retour = new Onglet();
		onglet1.setPreferredSize(new Dimension(155,705));
		onglet1.add(variable1);
		onglet1.add(action);
		onglet1.add(influence1);
		onglet2.add(variable2);
		onglet2.add(influence2);
		onglet2.setPreferredSize(new Dimension(155,705));
		retour.addTab("Initiateur", null, onglet1, "tout ce qui concerne l'initiateur de l'action");
		retour.addTab("Receveur", null, onglet2, "tout ce qui concerne le receveur de l'action");
		variable1.addActionListener(new VariableInit());
		variable2.addActionListener(new VariableRec());
		influence1.addActionListener(new InfluenceInit());
		influence2.addActionListener(new InfluenceRec());
		action.addActionListener(new Action());
		return retour;
	}
	
	////////////////tout les listener///////////////
	
	//listener pour les variables de l'initiateur
	class VariableInit implements ActionListener{
		JFrame action;
		JTextField nomVariable;
		JTextField valeur;
		JButton validation;
		JButton annuler;
	    public void actionPerformed(ActionEvent arg0) {
	    	//initialisation de toute les variables
	       action = new JFrame("Nommer la variable");
	       JPanel panel = new JPanel();
	       JPanel panel2 = new JPanel();
	       JPanel boutons = new JPanel();
	       JLabel nom = new JLabel("Nom variable : ");
	       JLabel Varvaleur = new JLabel("Valeur : ");
	       nomVariable = new JTextField();
	       valeur = new JTextField();
	       annuler = new JButton("Annuler");
	       validation = new JButton("Valider");
	       validation.addActionListener(new Validation());
	       annuler.addActionListener(new Annulation());
	       //placement de tout les composants
	       action.add(panel,BorderLayout.NORTH);
	       action.add(panel2);
	       action.add(boutons,BorderLayout.SOUTH);
	       panel.add(nom,BorderLayout.NORTH);
	       panel.add(nomVariable,BorderLayout.NORTH);
	       panel2.add(Varvaleur,BorderLayout.SOUTH);
	       panel2.add(valeur,BorderLayout.SOUTH);
	       boutons.add(validation);
	       boutons.add(annuler);
	       //définition des dimentions
	       action.setSize(300, 150);
	       panel.setPreferredSize(new Dimension(600,30));
	       panel2.setPreferredSize(new Dimension(600,30));
	       nom.setPreferredSize(new Dimension(100,25));
	       nomVariable.setPreferredSize(new Dimension(100,25));
	       Varvaleur.setPreferredSize(new Dimension(100,25));
	       valeur.setPreferredSize(new Dimension(100,25));
	       action.setVisible(true);
	       action.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	    
	    class Validation implements ActionListener{
	    	
	    	public void actionPerformed(ActionEvent arg0) {
	    		valeurVar = Integer.parseInt(valeur.getText());
	    		nomVar = nomVariable.getText();
	    		action.dispose();
	    		System.out.println(valeurVar);
	    		System.out.println(nomVar);
	    	}
	    }
	    class Annulation implements ActionListener{
	    	
	    	public void actionPerformed(ActionEvent arg0) {
	    		action.dispose();
	    	}
	    }
	  }
	//listener pour les variables du receveur
	class VariableRec implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	       JFrame action = new JFrame("Nommer la variable");
	       action.setSize(600, 400);
	       action.setVisible(true);
	       action.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	  }
	//listener pour les influences des patchs sur l'initiateur
	class InfluenceInit implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	       JFrame action = new JFrame("Quelle influence ?");
	       action.setSize(600, 400);
	       action.setVisible(true);
	       action.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	  }
	//listener pour les influences des patchs sur le receveur
	class InfluenceRec implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	       JFrame action = new JFrame("Quelle influence ?");
	       action.setSize(600, 400);
	       action.setVisible(true);
	       action.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	  }
	//listener pour créer des actions pour l'initiateurs
	class Action implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	       JFrame action = new JFrame("Choisissez une action");
	       action.setSize(600, 400);
	       action.setVisible(true);
	       action.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	  }
	
	
	//les actions principales
	public static void main(String s[]) {
		Fenetre frame = new Fenetre("Interact Logo");
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 1);
		Border redBorder = BorderFactory.createLineBorder(Color.red, 1);
		JPanel part_gauche = new JPanel();
		JPanel part_droite = new JPanel();
		JPanel part_central = new JPanel();
		frame.setSize(1200, 800);
		frame.add(part_gauche, BorderLayout.WEST);
		frame.add(part_droite, BorderLayout.EAST);
		frame.add(part_central,BorderLayout.CENTER);
		part_central.setPreferredSize(new Dimension(800,650));
		part_gauche.setPreferredSize(new Dimension(160,700));
		part_droite.setPreferredSize(new Dimension(155,700));
		part_droite.setBorder(lineBorder);
		part_central.setBorder(redBorder);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		part_gauche.add(onglet);
	}

}
