package mascota;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
			
		JPanel content = new JPanel(new CardLayout());
		JPanel centro = new JPanel(new BorderLayout());
			pPrincipal.add(centro, BorderLayout.CENTER);
			JPanel botones = new JPanel(new FlowLayout());
			CardLayout cl = (CardLayout)(content.getLayout());
			JButton mercado = new JButton("Mercado");
				mercado.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						cl.show(content, "MERCADO");
						
					}
				});
				botones.add(mercado);
			JButton info = new JButton("Info");
			info.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cl.show(content, "INFO");
					
				}
			});
				botones.add(info);
			centro.add(botones, BorderLayout.NORTH);
			

			centro.add(content, BorderLayout.CENTER);
			
		JPanel pMercado =new JPanel();
			pMercado.add(new JLabel("Tabla de info sacada de Base de Datos con comida, precio, etc..."));
			content.add(pMercado, "MERCADO");
			
		JPanel pInfo =new JPanel();
			pInfo.add(new JLabel("Información sobre tu mascota"));
			content.add(pInfo, "INFO");
			
		Image imagen = Ventana.getM().getImagen().getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
			JLabel mascota = new JLabel(new ImageIcon(imagen));
			
		JPanel prado = new JPanel(new BorderLayout());
		prado.setPreferredSize(new Dimension(250, 150));
			prado.add(mascota);
			mascota.setSize(100, 100);
			Thread movimientoMascota = new Thread(() -> {
				 while (true) {
					 
					 try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
					 
				    }// TODO: Ordinaria año pasado
			});
			movimientoMascota.start();
			pPrincipal.add(prado, BorderLayout.SOUTH);
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
