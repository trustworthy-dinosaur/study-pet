package mascota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ventanaPrincipal.*;

import ventanaPrincipal.Ventana;

public class VentanaMascota extends JFrame {

	private static final long serialVersionUID = 7975229772580650805L;

	public VentanaMascota() {
		JPanel pPrincipal = new JPanel(new BorderLayout());
		pPrincipal.setBackground(new Color(207, 196, 186));
		this.getContentPane().add(pPrincipal);
		
		JPanel pTitulo = new JPanel(new BorderLayout());
			pPrincipal.add(pTitulo, BorderLayout.NORTH);
			pTitulo.setOpaque(false);
		
		
		JLabel back = new JLabel("🔙");
			pTitulo.add(back, BorderLayout.WEST);
			back.setFont(new Font("Segoe UI Symbol", NORMAL, 30));
			back.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Ventana();
					dispose();
					super.mouseClicked(e);
				}
			});
			
		JLabel titulo = new JLabel("Tu Mascota", JLabel.CENTER);
			titulo.setFont(new Font("Segoe UI Symbol", NORMAL, 30));
			pTitulo.add(titulo, BorderLayout.CENTER);
			
		Image imagen = Ventana.getM().getImagen().getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
			JLabel mascota = new JLabel(new ImageIcon(imagen));
			
		JPanel prado = new JPanel(null);
		prado.setPreferredSize(new Dimension(250, 150));
			prado.add(mascota);
			mascota.setSize(100, 100);
			Thread movimientoMascota = new Thread(() -> {
				 while (true) {
					 mascota.setLocation(75, 0);
					 prado.revalidate();
					 prado.repaint();
					 System.out.println(mascota.getLocation());
					 try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
					 mascota.setLocation(75, 50);
					 prado.revalidate();
					 prado.repaint();
					 System.out.println(mascota.getLocation());
				    }
			});
			movimientoMascota.start();
			pPrincipal.add(prado, BorderLayout.SOUTH);
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
