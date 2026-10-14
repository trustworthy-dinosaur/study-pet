
package ayuda;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

public class FontExplorer extends JFrame {
	
	// prueba carmen
	

    private static final long serialVersionUID = 1L;
    private final DefaultTableModel model;
    private final JTable table;
    private final JTextField txtBuscar;

    public FontExplorer() {
        super("Explorador de fuentes Java");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(850, 600);
        setLocationRelativeTo(null);

        // Modelo de la tabla
        model = new DefaultTableModel(
            new Object[]{"Nombre de la fuente", "Vista previa"}, 0
        ) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setRowHeight(35);
        table.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        // Renderizador: cada fuente se muestra con su propio estilo
        table.getColumnModel().getColumn(1)
            .setCellRenderer(new DefaultTableCellRenderer() {
                private static final long serialVersionUID = 1L;

                @Override
                public java.awt.Component getTableCellRendererComponent(
                        JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {

                    JLabel label = (JLabel)
                        super.getTableCellRendererComponent(
                            table, value, isSelected,
                            hasFocus, row, column
                        );

                    String family = table.getValueAt(
                        row, 0
                    ).toString();

                    label.setFont(new Font(
                        family, Font.PLAIN, 18
                    ));

                    return label;
                }
            });

        // Buscar fuentes
        txtBuscar = new JTextField();
        txtBuscar.setToolTipText("Escribe el nombre de una fuente");

        TableRowSorter<DefaultTableModel> sorter =
            new TableRowSorter<>(model);

        table.setRowSorter(sorter);

        txtBuscar.getDocument().addDocumentListener(
            new javax.swing.event.DocumentListener() {
                private void filtrar() {
                    String texto = txtBuscar.getText().trim();

                    sorter.setRowFilter(
                        texto.isEmpty()
                            ? null
                            : RowFilter.regexFilter(
                                "(?i)" + java.util.regex.Pattern
                                    .quote(texto), 0
                            )
                    );
                }

                @Override
                public void insertUpdate(
                        javax.swing.event.DocumentEvent e) {
                    filtrar();
                }

                @Override
                public void removeUpdate(
                        javax.swing.event.DocumentEvent e) {
                    filtrar();
                }

                @Override
                public void changedUpdate(
                        javax.swing.event.DocumentEvent e) {
                    filtrar();
                }
            }
        );

        JButton btnCopiar = new JButton("Copiar nombre");
        btnCopiar.addActionListener(e -> {
            int fila = table.getSelectedRow();

            if (fila >= 0) {
                String nombre = table.getValueAt(
                    fila, 0
                ).toString();

                java.awt.Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(
                        new java.awt.datatransfer.StringSelection(nombre),
                        null
                    );

                JOptionPane.showMessageDialog(
                    this, "Fuente copiada: " + nombre
                );
            } else {
                JOptionPane.showMessageDialog(
                    this, "Selecciona una fuente primero."
                );
            }
        });

        JPanel arriba = new JPanel(new BorderLayout(8, 8));
        arriba.add(new JLabel("Buscar fuente:"), BorderLayout.WEST);
        arriba.add(txtBuscar, BorderLayout.CENTER);
        arriba.setBorder(BorderFactory.createEmptyBorder(
            10, 10, 10, 10
        ));

        JPanel abajo = new JPanel(new BorderLayout());
        abajo.add(btnCopiar, BorderLayout.EAST);
        abajo.setBorder(BorderFactory.createEmptyBorder(
            8, 10, 10, 10
        ));

        add(arriba, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);

        cargarFuentes();
    }

    private void cargarFuentes() {
        GraphicsEnvironment entorno =
            GraphicsEnvironment.getLocalGraphicsEnvironment();

        String[] fuentes = entorno.getAvailableFontFamilyNames();

        Arrays.sort(fuentes, String.CASE_INSENSITIVE_ORDER);

        for (String fuente : fuentes) {
            model.addRow(new Object[]{
                fuente,
                "AaBbCc 123 — " + fuente
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FontExplorer ventana = new FontExplorer();
            ventana.setVisible(true);
        });
    }
}
