package mascota;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import mascota.Item.Beneficio;
import ventanaPrincipal.JButtonRound;
import ventanaPrincipal.Ventana;

public class VentanaMascota extends JFrame {

	private static final long serialVersionUID = 7975229772580650805L;
	JTable mercadillo;
	private JTextField txtFiltro;
	JPanel prado = new JPanel(new GridLayout(2, 9));
	Image imagen = Ventana.getM().getImagen().getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
	static ArrayList<Item> items = new ArrayList<>();
	MercadoModelo mercadilloModelo;
	
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


		prado.setPreferredSize(new Dimension(250, 150));
		prado.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new Color(168, 154, 140)));
		prado.setBackground(new Color(210, 227, 209));
		for (int i = 0; i<9*2;i++) {
			if (i%2!=0) {
				JLabel mascota = new JLabel(new ImageIcon(imagen));
				prado.add(mascota);
				mascota.setSize(100, 100);
				mascota.setVisible(false);
			} else {
				prado.add(new JLabel());
			}
			
		}
			Saltitos movimientoMascota = new Saltitos();
			movimientoMascota.start();
			pPrincipal.add(prado, BorderLayout.SOUTH);
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private class Saltitos extends Thread {   
		
		public void run() {

            while (true) {
            	for (int i = 0; i<9;i++) {
            		int pos = (i%2==0)?i+9:i;
            		Component componente = prado.getComponent(pos);
            		componente.setVisible(true);
            		 try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {                   
                     	this.interrupt();
                     }
            		 componente.setVisible(false);
            	}
            	for (int i = 8; i>0;i--) {
            		int pos = (i%2==0)?i+9:i;
            		Component componente = prado.getComponent(pos);
            		componente.setVisible(true);
            		 try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {                   
                     	this.interrupt();
                     }
            		 componente.setVisible(false);
            	}
            }
        }
   
	}
	
	protected void filtrar() {
		//TODO: Terminar
		String f = txtFiltro.getText().toLowerCase();

//		for (Item i : items) {
//			if (i.getNombre().toLowerCase().contains(f)) {
//				this.mercadilloModelo.addRow(
//						new Object[] {i.getNombre(), i.getBeneficio(), i.getPrecio(), i.getAlmacen()} );
//
//			}}
		
	}
	
	public static ArrayList<Item> crearItems() {
		//hecho con IA
        

        // COMIDA - ESTÓMAGO
        items.add(new Item("Churros", Beneficio.ESTOMAGO, 2, 0));
        items.add(new Item("Pescado", Beneficio.ESTOMAGO, 3, 0));
        items.add(new Item("Sushi", Beneficio.ESTOMAGO, 4, 0));
        items.add(new Item("Tortilla de patata", Beneficio.ESTOMAGO, 3, 0));
        items.add(new Item("Pizza", Beneficio.ESTOMAGO, 4, 0));
        items.add(new Item("Manzana", Beneficio.ESTOMAGO, 1, 0));
        items.add(new Item("Galletas", Beneficio.ESTOMAGO, 2, 0));
        items.add(new Item("Hamburguesa", Beneficio.ESTOMAGO, 5, 0));
        items.add(new Item("Zanahoria", Beneficio.ESTOMAGO, 1, 0));
        items.add(new Item("Tarta", Beneficio.ESTOMAGO, 4, 0));

        // ENTRETENIMIENTO - FELICIDAD
        items.add(new Item("Pelota", Beneficio.FELICIDAD, 2, 0));
        items.add(new Item("Peluche", Beneficio.FELICIDAD, 3, 0));
        items.add(new Item("Teléfono", Beneficio.FELICIDAD, 5, 0));
        items.add(new Item("Videojuego", Beneficio.FELICIDAD, 4, 0));
        items.add(new Item("Cometa", Beneficio.FELICIDAD, 2, 0));
        items.add(new Item("Libro de aventuras", Beneficio.FELICIDAD, 3, 0));
        items.add(new Item("Patinete", Beneficio.FELICIDAD, 5, 0));
        items.add(new Item("Guitarra", Beneficio.FELICIDAD, 4, 0));
        items.add(new Item("Burbujas", Beneficio.FELICIDAD, 1, 0));
        items.add(new Item("Disfraz", Beneficio.FELICIDAD, 3, 0));

        // ENERGÍA
        items.add(new Item("Café", Beneficio.ENERGIA, 2, 0));
        items.add(new Item("Almohada", Beneficio.ENERGIA, 3, 0));
        items.add(new Item("Manta", Beneficio.ENERGIA, 2, 0));
        items.add(new Item("Siesta", Beneficio.ENERGIA, 1, 0));
        items.add(new Item("Té", Beneficio.ENERGIA, 2, 0));
        items.add(new Item("Cama pequeña", Beneficio.ENERGIA, 5, 0));
        items.add(new Item("Zapatillas", Beneficio.ENERGIA, 3, 0));
        items.add(new Item("Reloj despertador", Beneficio.ENERGIA, 4, 0));
        items.add(new Item("Música relajante", Beneficio.ENERGIA, 2, 0));
        items.add(new Item("Batido de frutas", Beneficio.ENERGIA, 3, 0));

        return items;
    }
	
	private void initTables() {
		crearItems();
		mercadilloModelo = new MercadoModelo(items);
		this.mercadillo = new JTable(mercadilloModelo);
		mercadillo.setRowHeight(30);
		mercadillo.setGridColor(new Color(168, 154, 140));
		mercadillo.getTableHeader().setBackground(new Color(168, 154, 140));
		mercadillo.getTableHeader().setForeground(Color.WHITE);
		mercadillo.getTableHeader().setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		mercadillo.getColumnModel().getColumn(2).setMaxWidth(70);
		mercadillo.getColumnModel().getColumn(3).setPreferredWidth(100);
		mercadillo.getColumnModel().getColumn(3).setMaxWidth(100);
		mercadillo.getColumnModel().getColumn(4).setPreferredWidth(100);
		mercadillo.getColumnModel().getColumn(4).setMaxWidth(100);
		//TODO: Hacer que el boton funcione
		TableCellRenderer tcr = new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel result = new JLabel(value.toString(), JLabel.CENTER);
				JPanel pResult = new JPanel(new GridBagLayout());
				JButton btnResult = new JButton("+");
					pResult.add(btnResult);
					pResult.setBackground(new Color(232, 224, 216));
					btnResult.setBackground(new Color(111, 93, 79));
					btnResult.setForeground(new Color(232, 224, 216));
					if (hasFocus && column ==4 ) {
						Item it = (Item) value;
						it.setAlmacen(it.getAlmacen()+1);
					}
					
					
				result.setForeground(new Color(111, 93, 79));
				result.setFont(new Font("Segoe UI Symbol", NORMAL, 20));

				if (isSelected) {
					result.setBackground(new Color(111, 93, 79));
					result.setForeground(new Color(232, 224, 216));
					pResult.setBackground(new Color(111, 93, 79));
					pResult.setForeground(new Color(232, 224, 216));
					btnResult.setBackground(new Color(232, 224, 216));
					btnResult.setForeground(new Color(111, 93, 79));
					result.setOpaque(true);
				}
				
				return (column==4)?pResult:result;
			}
		};
		mercadillo.setDefaultRenderer(Object.class, tcr);
	}
}
