package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEquipe extends JPanel {
	private JButton btnSupprimer;
	private JButton btnRetour;
	private JButton btnAjouter;
	private JButton btnModifier;


	public PanelEquipe() {
		setBackground(new Color(70, 130, 180));
		setLayout(null);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(170, 110, 115, 28);
		add(btnModifier);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(170, 50, 115, 28);
		add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(170, 170, 115, 28);
		add(btnSupprimer);
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(170, 230, 115, 28);
		add(btnRetour);
	}
	
	public JButton getBtnAjouter()
	{
		return this.btnAjouter;
	}
	
	public JButton getBtnModifier()
	{
		return this.btnModifier;
	}
	
	public JButton getBtnSupprimer()
	{
		return this.btnSupprimer;
	}
	
	public JButton getBtnRetour()
	{
		return this.btnRetour;
	}
}