package horario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import ventanaPrincipal.Ventana;

public class VentanaHorario extends JFrame {
	private static final long serialVersionUID = 6253219151150225472L;
	private static DefaultTableModel modelo;
	public VentanaHorario() {
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

		JLabel titulo = new JLabel("Horario", JLabel.CENTER);
			titulo.setFont(new Font("Academy Engraved LET", Font.PLAIN, 30));
			titulo.setForeground(new Color(74, 73, 51));
			pTitulo.add(titulo, BorderLayout.CENTER);

		JLabel mas = new JLabel("+", JLabel.CENTER);
			mas.setFont(new Font("Segoe UI Symbol", Font.BOLD, 36));
			mas.setForeground(new Color(74, 73, 51));
			mas.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
			mas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					anadirTarea();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					mas.setForeground(Color.BLACK);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mas.setForeground(new Color(74, 73, 51));
				}
			});
			pTitulo.add(mas, BorderLayout.EAST);

		String[] columnas = {"Hora", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
		modelo = new DefaultTableModel(columnas, 24) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (int i = 0; i < 24; i++) {
			modelo.setValueAt(String.format("%02d:00", i), i, 0);
		}
		JTable horario = new JTable(modelo);
		horario.setRowHeight(44);
			horario.setGridColor(new Color(152, 151, 105));
			horario.setBackground(new Color(238, 237, 218));
			horario.getColumnModel().getColumn(0).setMaxWidth(70);
			horario.getTableHeader().setBackground(new Color(152, 151, 105));
			horario.getTableHeader().setForeground(Color.WHITE);
			horario.getTableHeader().setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			horario.getTableHeader().setReorderingAllowed(false);

		TableCellRenderer celdas = (table, value, isSelected, hasFocus, row, column) -> {
			
			
			// antes así, pero no quedaba bien -> 
			//JLabel resultado = new JLabel((value == null) ? "" : value.toString(), JLabel.CENTER);
			
			// Hecho con IA solo la parte de HTML por no tener conocimiento
			// Ahora el texto se ajusta al ancho de la celda y se centra
			String texto = (value == null) ? "" : value.toString().replace("&", "&amp;");
			int ancho = table.getColumnModel().getColumn(column).getWidth() - 30;
			JLabel resultado = new JLabel("<html><div style='width:" + ancho + "px; text-align:center'>"
					+ texto + "</div></html>", JLabel.CENTER);
			// Hasta aquí 
			
			
				resultado.setOpaque(true);
				resultado.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
				resultado.setForeground(new Color(74, 73, 51));
				resultado.setBackground(new Color(238, 237, 218));

			if (column == 0) {
				resultado.setBackground(new Color(152, 151, 105));
				resultado.setForeground(Color.WHITE);
			} else if (value != null) {
				resultado.setBackground(new Color(223, 147, 157));
			}
			if (isSelected && column != 0) {
				resultado.setBackground(new Color(74, 73, 51));
				resultado.setForeground(new Color(238, 237, 218));
			}
			return resultado;
		};

		horario.setDefaultRenderer(Object.class, celdas);
		JScrollPane scroll = new JScrollPane(horario);
			scroll.getViewport().setBackground(new Color(238, 237, 218));
			scroll.setBorder(BorderFactory.createEmptyBorder());
			pPrincipal.add(scroll, BorderLayout.CENTER);
		pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		this.setSize(960, 600);
		cargarDatosDemo();      // <- esto se borra más adelante, es solo para mostrar datos de ejemplo
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	
	// Hecho con IA
	
	// Pone un texto en una celda; si ya hay algo, lo junta con " / "
	private void ponerTarea(String texto, int columna, int fila) {
		Object actual = modelo.getValueAt(fila, columna);
		if (actual != null) {
			texto = actual + " / " + texto;
		}
		modelo.setValueAt(texto, fila, columna);
	}

	
	// Hecho con IA. Ejemplos
	private void cargarDatosDemo() {
		// {tarea, columna del día, hora de inicio, hora de fin (esa hora NO se incluye)}
		Object[][] datos = {
			// ---- CLASES ----
			// Lunes
			{"Tech & Sci Programming",   1,  8, 10},
			{"Programación III",         1, 10, 12},
			{"Metodología y Lenguajes",  1, 12, 14},
			// Martes
			{"Tech & Sci Programming",   2,  8, 10},
			{"Statistics",               2, 10, 12},
			{"Telematics",               2, 12, 14},
			// Miércoles
			{"Statistics",               3,  8, 10},
			{"Programación III",         3, 10, 12},
			{"Bases de Datos",           3, 12, 14},
			// Jueves
			{"Metodología y Lenguajes",  4,  8, 10},
			{"Telematics",               4, 10, 12},
			// Viernes
			{"Bases de Datos",           5, 10, 12},

			// ---- TARDES Y FINES DE SEMANA ----
			// Lunes
			{"Comida",                   1, 14, 15},
			{"Estudiar Estadística",     1, 15, 17},
			{"Gimnasio",                 1, 17, 18},
			{"Proyecto Java",            1, 18, 20},
			{"Series",                   1, 21, 23},
			// Martes
			{"Comida",                   2, 14, 15},
			{"Descanso",                 2, 15, 16},
			{"Estudiar Telematics",      2, 16, 18},
			{"Prácticas Tech & Sci",     2, 18, 20},
			{"Llamar a mis padres",      2, 21, 22},
			// Miércoles
			{"Comida",                   3, 14, 15},
			{"Ejercicios Bases de Datos",3, 15, 17},
			{"Leer",                     3, 17, 19},
			{"Repasar apuntes",          3, 19, 20},
			{"Pomodoro de estudio",      3, 21, 23},
			// Jueves
			{"Comida",                   4, 12, 13},
			{"Estudiar Programación III",4, 13, 15},
			{"Estudiar Estadística",     4, 15, 17},
			{"Gimnasio",                 4, 17, 18},
			{"Proyecto Java",            4, 18, 20},
			{"Peli",                     4, 21, 23},
			// Viernes
			{"Comida",                   5, 12, 13},
			{"Estudiar Bases de Datos",  5, 13, 15},
			{"Siesta",                   5, 15, 16},
			{"Café con las amigas",      5, 17, 19},
			{"Salir con las amigas",     5, 21, 24},
			// Sábado
			{"Brunch",                   6, 11, 13},
			{"Comida",                   6, 14, 15},
			{"Estudiar Metodología",     6, 16, 18},
			{"Compras",                  6, 18, 20},
			{"Cine",                     6, 21, 23},
			// Domingo
			{"Colada",                   7, 10, 11},
			{"Comida familiar",          7, 14, 16},
			{"Repasar la semana",        7, 17, 19},
			{"Preparar la mochila",      7, 19, 20},
			{"Series",                   7, 21, 23}
		};

		// 1) Recorre cada línea del array...
		for (int i = 0; i < datos.length; i++) {
			String texto = (String) datos[i][0];
			int columna = (int) datos[i][1];
			int desde = (int) datos[i][2];
			int hasta = (int) datos[i][3];

			// 2) ...y rellena cada hora desde "desde" hasta "hasta" (sin incluir esta)
			for (int fila = desde; fila < hasta; fila++) {
				ponerTarea(texto, columna, fila);
			}
		}

		// 3) Cosas que se repiten: desayuno de lunes a viernes, cena todos los días
		for (int columna = 1; columna <= 5; columna++) {
			ponerTarea("Desayuno", columna, 7);
		}
		for (int columna = 1; columna <= 7; columna++) {
			ponerTarea("Cena", columna, 20);
		}
	}
		
	// hasta aquí era hecho con IA
	
	
	
	
	// Ventana para añadir una tarea al horario
	private void anadirTarea() {
		JTextField txtTarea = new JTextField(15);
		JComboBox<String> cbDia = new JComboBox<>(
				new String[] {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"});
		JComboBox<String> cbHora = new JComboBox<>();
		for (int h = 0; h < 24; h++) {
			cbHora.addItem(String.format("%02d:00", h));
		}

		JPanel pForm = new JPanel(new GridLayout(3, 2, 5, 5));
			pForm.add(new JLabel("Tarea:"));
			pForm.add(txtTarea);
			pForm.add(new JLabel("Día:"));
			pForm.add(cbDia);
			pForm.add(new JLabel("Hora:"));
			pForm.add(cbHora);
		int opcion = JOptionPane.showConfirmDialog(this, pForm, "Nueva tarea",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (opcion == JOptionPane.OK_OPTION && !txtTarea.getText().trim().isEmpty()) {
			int fila = cbHora.getSelectedIndex();
			int columna = cbDia.getSelectedIndex() + 1;
			String texto = txtTarea.getText().trim();
			Object actual = modelo.getValueAt(fila, columna);
			if (actual != null) {
				texto = actual + " / " + texto;
			}
			
			modelo.setValueAt(texto, fila, columna);
		}
	}
}
