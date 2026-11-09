package stats;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import sun.jvm.hotspot.runtime.Threads;
import ventanaPrincipal.Ventana;

public class VentanaStats extends JFrame {

	private static final long serialVersionUID = 702089359884714690L;
	private List<Asignaturasemana> asignaturas = new ArrayList<>();
	
	public VentanaStats() {
		
		//IA
		asignaturas.add(new Asignaturasemana("Matemáticas", new int[]{2, 2, 0, 2, 0, 0, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Programación", new int[]{0, 3, 3, 0, 2, 0, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Bases de Datos", new int[]{2, 0, 2, 2, 0, 0, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Sistemas Informáticos", new int[]{3, 0, 2, 0, 2, 0, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Inglés Técnico", new int[]{0, 2, 0, 1, 0, 0, 0}, 0, 0));
		//Hasta aquí
		
		int horastotalsemanageneral = 0;
		for(Asignaturasemana asigna: asignaturas) {
			asigna.calcularHoraToal();
			horastotalsemanageneral += asigna.getHoratotal();
		}
		
		for(Asignaturasemana asigna: asignaturas) {
			asigna.porcentajetotal(horastotalsemanageneral);
		}
			
		
		
		//Panel base
		JPanel pPrincipal = new JPanel(new BorderLayout());
		this.getContentPane().add(pPrincipal);
	
		//JPanel botones
		JPanel norte = new JPanel(new BorderLayout());
		
		//Salida 
		JLabel back = new JLabel("🔙");
			norte.add(back, BorderLayout.WEST);
			back.setFont(new Font("Segoe UI Symbol", NORMAL, 30));
			back.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Ventana();
					dispose();
					super.mouseClicked(e);
				}
			});
		
		JLabel texto = new JLabel("Estadísticas");
		texto.setPreferredSize(new Dimension(0, 100));
		Font fuente = new Font("Bell MT", Font.PLAIN, 30);
		texto.setFont(fuente);
		texto.setHorizontalAlignment(JLabel.CENTER);
		
	
		
		
		norte.add(texto, BorderLayout.CENTER);
		
		pPrincipal.add(norte, BorderLayout.NORTH);
		
		//Panel centro
		JPanel centro = new JPanel(new BorderLayout());
		
		pPrincipal.add(centro, BorderLayout.CENTER);
	
	
		
		//Crear cardlayout
		CardLayout layoutcard = new CardLayout();
		
		JPanel card = new JPanel(layoutcard);
		
		centro.add(card, BorderLayout.CENTER);
		card.add(CrearJTables(), "Vista General");
		card.add(CrearJTables(), "Vista Detallada");
		
		JButton botongeneral = new JButton("Vista General");
		botongeneral.addActionListener( e-> {
			layoutcard.show(card, "Vista General");
		});
		
		
		JButton botondetalles = new JButton("Vista Detallada");
		botondetalles.addActionListener(e -> {
			layoutcard.show(card, "Vista Detallada");
		});
		
		JPanel grid = new JPanel(new GridLayout(1,2));
		grid.add(botongeneral);
		
		grid.add(botondetalles);
		
		centro.add(grid, BorderLayout.NORTH);
		
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	private JScrollPane CrearJTables() {
		
		
		
		//Crear JTable principal
		Statsmodelo modelo = new Statsmodelo(asignaturas);
		JTable estadisticasemana = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(estadisticasemana);
			
		
		
		//Renderer celdas
		TableCellRenderer celdas = (table,value,isSelected, hasFocus, row, column) -> {
			JLabel resultado = new JLabel(value.toString());
			return resultado;
		};
	
		//Renderer cabecera
				
		TableCellRenderer cabecera = (table,value,isSelected, hasFocus,row,column) -> {
			JLabel resultado = new JLabel(value.toString());
			return resultado;
		};
		return scroll;
		
	}
	
	private JPanel VistaGeneralBarras() {
		
		
		
	}
	
	private class Hiloprogressbar extends Thread{
		
		@Override
		public void run(){
			
			
		}
		
	
		
	}
	
}
