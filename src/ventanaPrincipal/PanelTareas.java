package ventanaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTareas extends JPanel {

	private static final long serialVersionUID = 1L;

	private Color colorTexto = new Color(152, 151, 105).darker().darker();
	
	private Color colorIcono = new Color(152, 151, 105).darker(); //same dark green as the ⛶

	private JButton crearBoton(String texto) {
		JButton boton = new JButton(texto);
		boton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 22));
		boton.setForeground(colorIcono);
		boton.setMargin(new Insets(0, 8, 0, 8));
		boton.setFocusPainted(false);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
		boton.setOpaque(false);

		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boton.setForeground(colorIcono);
			}
		});
		return boton;
	}
	
	private JPanel listaTareas;

	public PanelTareas() {
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 10));

		JButton botonNuevaTarea = crearBoton("+");
		
		botonNuevaTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedirTareas();
			}
		});

		JPanel arriba = new JPanel(new FlowLayout(FlowLayout.RIGHT, -19, -3));
		arriba.setOpaque(false);
		arriba.add(botonNuevaTarea);
		this.add(arriba, BorderLayout.NORTH);

		listaTareas = new JPanel(new GridLayout(0, 1, 5, 5));
		listaTareas.setOpaque(false);

		JPanel contenedor = new JPanel(new BorderLayout());
		contenedor.setOpaque(false);
		contenedor.add(listaTareas, BorderLayout.NORTH);

		JScrollPane scroll = new JScrollPane(contenedor);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(null);
		this.add(scroll, BorderLayout.CENTER);
	}

	private void pedirTareas() {
		String texto = JOptionPane.showInputDialog(this, "Nueva tarea: ");
		if (texto != null && !texto.trim().isEmpty()) {
			anadirTarea(texto.trim());
			
		}
	}

	private void anadirTarea(String texto) {
		JPanel fila = new JPanel(new BorderLayout());
		fila.setOpaque(false);

		JCheckBox check = new JCheckBox(texto);
		check.setOpaque(false);
		check.setForeground(colorTexto);

		JButton borrar = crearBoton("x");
		borrar.setVisible(false);

		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check.isSelected()) {
					check.setText("<html><strike>" + texto + "</strike></html>");
					borrar.setVisible(true);
				} else {
					check.setText(texto);
					borrar.setVisible(false);
				}
			}
		});

		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaTareas.remove(fila);
				listaTareas.revalidate();
				listaTareas.repaint();
			}
		}
		);

		fila.add(check, BorderLayout.CENTER);
		fila.add(borrar, BorderLayout.EAST);
		listaTareas.add(fila);
		listaTareas.revalidate();
		listaTareas.repaint();
		
		
	}
}