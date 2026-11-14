package notas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ventanaPrincipal.Ventana;

public class VentanaNotas extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaNotas() {

		JPanel pPrincipal = new JPanel(new BorderLayout());
			pPrincipal.setBackground(new Color(226, 225, 196));
			this.getContentPane().add(pPrincipal);

		JPanel pTitulo = new JPanel(new BorderLayout());
			pTitulo.setOpaque(false);
			pPrincipal.add(pTitulo, BorderLayout.NORTH);

		JLabel back = new JLabel("🔙");
			back.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 30));
			back.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Ventana.ventana.setVisible(true); 
					dispose();
				}
			});
			pTitulo.add(back, BorderLayout.WEST);

		JLabel titulo = new JLabel("Tareas", JLabel.CENTER);
			titulo.setFont(new Font("Arial", Font.PLAIN, 30));
			titulo.setForeground(new Color(74, 73, 51));
			pTitulo.add(titulo, BorderLayout.CENTER);

		

		pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		this.setSize(960, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
