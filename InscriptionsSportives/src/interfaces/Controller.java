package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

public class Controller {

	private JFrame frame;
	private JPanel panelCont;
	private CardLayout cl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller window = new Controller();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Controller() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(600, 600, 0, 0));
		frame.setTitle("Inscriptions sportives");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(450, 360));
		
		CardLayout cl = new CardLayout();
		panelCont = new JPanel();
		panelCont.setLayout(cl);
		PanelIndex panelIndex = new PanelIndex();
		PanelEquipe panelEquipe = new PanelEquipe();
		PanelCompetition panelCompetition = new PanelCompetition();
		PanelPersonne panelPersonne = new PanelPersonne();
		panelCont.add(panelIndex, "1");
		panelCont.add(panelEquipe, "2");
		panelCont.add(panelCompetition, "3");
		panelCont.add(panelPersonne, "4");
		
		cl.show(panelCont, "1");
		
		panelIndex.getBtnCompetition().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "3");
			} 
		});
		
		panelIndex.getBtnEquipe().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "2");
			}
		});
		
		panelIndex.getBtnPersonne().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "4");
			}
		});
		
		panelCompetition.getBtnRetour().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
		
		panelEquipe.getBtnRetour().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
		
		panelPersonne.getBtnRetour().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
		
		frame.getContentPane().add(panelCont);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setPanel(JPanel panel)
	{
		JPanel contentPane = (JPanel) frame.getContentPane();

		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.revalidate(); 
		contentPane.repaint();
	}
	
	public void switchPanel(JButton button, String panel)
	{
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, panel);
			}
		});
	}
	
}
