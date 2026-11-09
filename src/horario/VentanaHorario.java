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
			titulo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 30));
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
			horario.setRowHeight(34);
			horario.setGridColor(new Color(152, 151, 105));
			horario.setBackground(new Color(238, 237, 218));
			horario.getColumnModel().getColumn(0).setMaxWidth(70);
			horario.getTableHeader().setBackground(new Color(152, 151, 105));
			horario.getTableHeader().setForeground(Color.WHITE);
			horario.getTableHeader().setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			horario.getTableHeader().setReorderingAllowed(false);

		TableCellRenderer celdas = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel resultado = new JLabel((value == null) ? "" : value.toString(), JLabel.CENTER);
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
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

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
