package ventanaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	private static final long serialVersionUID = -4737376985574446318L;

	public Ventana() {
		JPanel pPrincipal = new JPanel(new GridLayout(1, 3, 20, 20));
		this.getContentPane().add(pPrincipal);

		
		JPanel pMascotPomod = new JPanel(new GridBagLayout());
			pMascotPomod.setOpaque(false);
			
			GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1.0;
				gbc.insets = new Insets(10, 0, 10, 0);
			
			JPanelRound pMascot = new JPanelRound(new BorderLayout());
				pMascot.setBackground(new Color(111, 93, 79));
				JLabel eMascot = new JLabel("⛶", JLabel.RIGHT);
				eMascot.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 10));
				eMascot.setFont(new Font(getName(), Font.BOLD, 20));
				eMascot.setForeground(pMascot.getBackground().darker())
				;
				eMascot.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						new VentanaMascota();
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						super.mouseEntered(e);
						eMascot.setForeground(Color.BLACK);;
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						super.mouseExited(e);
						eMascot.setForeground(pMascot.getBackground().darker());
					}
				});
				
				pMascot.add(eMascot, BorderLayout.NORTH);
				
				gbc.gridy = 0;
				gbc.weighty = 0.7;
				pMascotPomod.add(pMascot, gbc);
			
			JPanelRound pTimer = new JPanelRound();
				pTimer.setBackground(new Color(223, 147, 157));
				gbc.gridy = 1;
				gbc.weighty = 0.3;
				pMascotPomod.add(pTimer, gbc);
			
		pPrincipal.add(pMascotPomod);
		
		
		JPanel pGreetings = new JPanel(new GridBagLayout());
			pGreetings.setOpaque(false);
			
			GridBagConstraints gbc1 = new GridBagConstraints();
			gbc1.fill = GridBagConstraints.BOTH;
			gbc1.weightx = 1.0;
			gbc1.insets = new Insets(10, 0, 10, 0);
			
			JPanelRound pTime = new JPanelRound(new BorderLayout());
				pTime.setBackground(new Color(152, 151, 105));
				JLabel eTime = new JLabel("⛶", JLabel.RIGHT);
				eTime.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 10));
				eTime.setFont(new Font(getName(), Font.BOLD, 20));
				eTime.setForeground(pTime.getBackground().darker())
				;
				eTime.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						new VentanaHorario();
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						super.mouseEntered(e);
						eTime.setForeground(Color.BLACK);;
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						super.mouseExited(e);
						eTime.setForeground(pTime.getBackground().darker());
					}
				});
				
				pTime.add(eTime, BorderLayout.NORTH);
			

				gbc1.gridy = 0;
				gbc1.weighty = 0.2;
				pGreetings.add(pTime, gbc1);
			
			JPanelRound pHoli = new JPanelRound(new BorderLayout());
				pHoli.setOpaque(false);
				JLabel holi = new JLabel("HOLI", JLabel.CENTER);
				holi.setFont(new Font("Dubai Medium", Font.BOLD, 60));
				pHoli.add(holi, BorderLayout.CENTER);
				gbc1.gridy = 1;
				gbc1.weighty = 0.2;
				pGreetings.add(pHoli, gbc1);
			
			JPanelRound pNotas = new JPanelRound();
				pNotas.setBackground(new Color(152, 151, 105));
				gbc1.gridy = 2;
				gbc1.weighty = 0.6;
				pGreetings.add(pNotas, gbc1);
			
			
			//Para no alterar tamaños
			pTime.setPreferredSize(new Dimension(0, 0));
			pHoli.setPreferredSize(new Dimension(0, 0));
			pNotas.setPreferredSize(new Dimension(0, 0));
			
		pPrincipal.add(pGreetings);
		
		
		JPanelRound pStats = new JPanelRound(new BorderLayout());
			pStats.setBackground(new Color(223, 147, 157));
			
			JLabel eStats = new JLabel("⛶", JLabel.RIGHT);
			eStats.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 10));
			eStats.setFont(new Font(getName(), Font.BOLD, 20));
			eStats.setForeground(pStats.getBackground().darker())
			;
			eStats.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					new VentanaStats();
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					eStats.setForeground(Color.BLACK);;
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					super.mouseExited(e);
					eStats.setForeground(pStats.getBackground().darker());
				}
			});
			
			pStats.add(eStats, BorderLayout.NORTH);
			
		pPrincipal.add(pStats);
		
		
		
		
		//Default
		
		pPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
