package ventanaPrincipal;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaHorario extends JFrame {

	private static final long serialVersionUID = 6253219151150225472L;

	public VentanaHorario() {
		JPanel pPrincipal = new JPanel(new GridLayout(1, 3, 20, 20));
		this.getContentPane().add(pPrincipal);
		
		pPrincipal.add(new JLabel("Horario - Marina"));
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
