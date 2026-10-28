package mascota;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

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
			
		JPanel pMercado =new JPanel(new BorderLayout());
			//pMercado.add(new JLabel("Tabla de info sacada de Base de Datos con comida, precio, etc..."));
			initTables();
			JPanel tabla = new JPanel(new BorderLayout());
			//TODO: barra para buscar
			JScrollPane scroll = new JScrollPane(this.mercadillo);
			
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

	protected void filtrar() {
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
	}
}
