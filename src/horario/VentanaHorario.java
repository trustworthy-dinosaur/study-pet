package horario;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ventanaPrincipal.Ventana;
public class VentanaHorario extends JFrame {
	private static final long serialVersionUID = 6253219151150225472L;
	
	public VentanaHorario() {
		JPanel pPrincipal = new JPanel(new GridLayout(1, 3, 20, 20));
		this.getContentPane().add(pPrincipal);
		pPrincipal.add(new JLabel("Horario - Marina"));
		JLabel back = new JLabel("🔙");
		back.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 30));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Ventana();
				dispose();
			}
		});
		this.getContentPane().add(back, BorderLayout.NORTH);
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);

		
	}
}