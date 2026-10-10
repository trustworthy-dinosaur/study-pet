package ventanaPrincipal;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaStats extends JFrame {

	private static final long serialVersionUID = 702089359884714690L;
	
	public VentanaStats() {
		JPanel pPrincipal = new JPanel(new GridLayout(1, 3, 20, 20));
		this.getContentPane().add(pPrincipal);
		
		pPrincipal.add(new JLabel("Stats"));
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
}
