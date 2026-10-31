package mascota;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import ventanaPrincipal.JButtonRound;
import ventanaPrincipal.Ventana;

public class VentanaMascota extends JFrame {

	private static final long serialVersionUID = 7975229772580650805L;
	JTable mercadillo;
	private DefaultTableModel modeloDatosMercado;
	private JTextField txtFiltro;
	
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
			centro.add(content, BorderLayout.CENTER);
			
		JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
			botones.setBackground(new Color(207, 196, 186));
			CardLayout cl = (CardLayout)(content.getLayout());
			
			JButton mercado = new JButton("Mercado");
				mercado.setBackground(new Color(168, 154, 140));
				mercado.setBorderPainted(false);
				botones.add(mercado);
				
			JButton info = new JButton("Info");
				info.setBackground(new Color(232, 224, 216));
				info.setBorderPainted(false);
				
				mercado.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						cl.show(content, "MERCADO");
						mercado.setBackground(new Color(168, 154, 140));
						info.setBackground(new Color(232, 224, 216));
					}
				});
				
				info.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cl.show(content, "INFO");
					info.setBackground(new Color(168, 154, 140));
					mercado.setBackground(new Color(232, 224, 216));
				}
			});
				botones.add(info);
				
			centro.add(botones, BorderLayout.NORTH);

		JPanel pMercado =new JPanel(new BorderLayout());
			initTables();
			JPanel tabla = new JPanel(new BorderLayout());
			this.mercadillo.setBackground(new Color(232, 224, 216));
			mercadillo.getTableHeader().setBackground(new Color(168, 154, 140));
			mercadillo.getTableHeader().setForeground(Color.WHITE);
			mercadillo.getTableHeader().setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			mercadillo.setShowGrid(false);
			JScrollPane scroll = new JScrollPane(this.mercadillo);
			scroll.getViewport().setBackground(new Color(232, 224, 216));
			scroll.setBorder(BorderFactory.createEmptyBorder());
			
			this.txtFiltro = new JTextField(20);
			txtFiltro.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					filtrar();	
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					filtrar();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					filtrar();
				}
			});
			
			JPanel buscador = new JPanel(new FlowLayout());
			buscador.setBackground(new Color(168, 154, 140));
				buscador.add(txtFiltro);
			tabla.add(buscador, BorderLayout.NORTH);
			tabla.add(scroll, BorderLayout.CENTER);
			pMercado.add(tabla, BorderLayout.CENTER);
			content.add(pMercado, "MERCADO");
			
		JPanel pInfo =new JPanel();
			pInfo.add(new JLabel("Información sobre tu mascota"));
			content.add(pInfo, "INFO");
			
		Image imagen = Ventana.getM().getImagen().getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
			JLabel mascota = new JLabel(new ImageIcon(imagen));
			
		JPanel prado = new JPanel(new BorderLayout());
		prado.setPreferredSize(new Dimension(250, 150));
		prado.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new Color(168, 154, 140)));
		prado.setBackground(new Color(210, 227, 209));
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	protected void filtrar() {
		//TODO: Terminar
		String f = txtFiltro.getText().toLowerCase();
		
		this.modeloDatosMercado.setRowCount(0);
		
//		for (Comic c : this.comics) {
//			if (c.getTitulo().toLowerCase().contains(f)) {
//				this.modeloDatosComics.addRow(
//						new Object[] {c.getId(), c.getEditorial(), c.getTitulo(), c.getPersonajes().size()} );
//
//			}}
		
	}

	private void initTables() {
		Vector<String> cabeceraMercado = new Vector<String>(Arrays.asList( "NOMBRE", "BENEFICIA", "PRECIO", "ALMACEN"));
		this.modeloDatosMercado = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraMercado);
		this.mercadillo = new JTable(this.modeloDatosMercado);

		TableCellRenderer tcr = new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel result = new JLabel(value.toString());
				return result;
			}
		};
		mercadillo.setDefaultRenderer(Object.class, tcr);
	}
}
