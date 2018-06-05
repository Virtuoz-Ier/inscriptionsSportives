package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Color;

public class PanelIndex extends JPanel {
	private JButton btnCompetition;
	private JButton btnEquipe;
	private JButton btnPersonne;

	/**
	 * Create the panel.
	 */
	public PanelIndex() {
		setBackground(new Color(70, 130, 180));
		setLayout(null);
		
		btnCompetition = new JButton("G\u00E9rer comp\u00E9titions");
		btnCompetition.setBounds(155, 60, 145, 28);
		add(btnCompetition);
		
		btnEquipe = new JButton("G\u00E9rer \u00E9quipes");
		btnEquipe.setBounds(155, 120, 145, 28);
		add(btnEquipe);
		
		btnPersonne = new JButton("G\u00E9rer personnes");
		btnPersonne.setBounds(155, 180, 145, 28);
		add(btnPersonne);
		
		JPanel test = new PanelCompetition();
		this.add(test);

	}
	
	public JButton getBtnCompetition()
	{
		return this.btnCompetition;
	}
	
	public JButton getBtnEquipe()
	{
		return this.btnEquipe;
	}
	
	public JButton getBtnPersonne()
	{
		return this.btnPersonne;
	}
}
