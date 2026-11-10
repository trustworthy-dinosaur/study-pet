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
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import sun.jvm.hotspot.runtime.Threads;
import ventanaPrincipal.Ventana;

public class VentanaStats extends JFrame {

	private static final long serialVersionUID = 702089359884714690L;
	private List<Asignaturasemana> asignaturas = new ArrayList<>();
	
	
	
	public VentanaStats() {
		
		//Uso de IA
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
		card.add(VistaGeneralBarras(), "Vista General");
		card.add(CrearJTables(), "Vista Detallada");
		
		JButton botongeneral = new JButton("Vista General Semana");
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
		//Panel principal dos graficos
		JPanel dosgrid = new JPanel(new GridLayout(1,2));
		
		//Crear para poner Label de titulo norte y centro el panel general grafico. EL IZQUIERDO
		JPanel generalizqui = new JPanel(new BorderLayout());
		JLabel semana = new JLabel("Gráfico Horas Total", JLabel.CENTER);
		semana.setPreferredSize(new Dimension(0, 70));
		generalizqui.add(semana, BorderLayout.NORTH);
		
		
		//EL GRÁFICO DERECHO CREAR
		
		//Crear general panel para  asignatura (gráfico, nombres...) Derecho
		JPanel panelasig = new JPanel(new BorderLayout());
		
		
		//Crear grafico por asignatura por semana
		JPanel flowbarrasasig = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		
		for(Asignaturasemana asig: asignaturas) {
			JProgressBar barra = new JProgressBar(JProgressBar.VERTICAL,0,100);
			barra.setValue(asig.getHoratotal());
			barra.setPreferredSize(new Dimension(40,270));
			flowbarrasasig.add(barra);
		}
		
		panelasig.add(flowbarrasasig, BorderLayout.CENTER);
		
		// EL PANEL DERECHO
		JPanel panelderecho = new JPanel(new BorderLayout());
		JLabel textoasig = new JLabel("Gráfico Horas Asignatura", JLabel.CENTER);
		textoasig.setPreferredSize(new Dimension(0, 70));
		panelderecho.add(textoasig, BorderLayout.NORTH);
		panelderecho.add(panelasig, BorderLayout.CENTER);
		
		
		
		//EL PANEL IZQUIERDO
		
		//Creamos el grafico por semana
		JPanel panelsemana = new JPanel(new BorderLayout());
		JPanel barrasflow = new JPanel(new FlowLayout(FlowLayout.CENTER, 90, 50));
		
		for (int i = 0; i < 7; i++) {
				
			JProgressBar barra = new JProgressBar(JProgressBar.VERTICAL, 0, 200);
			barra.setValue(asig.porcentajetotal());
			barra.setPreferredSize(new Dimension(30,200));
			barrasflow.add(barra);
		
		}
		
		 panelsemana.add(barrasflow, BorderLayout.SOUTH);
		 
		 
		 dosgrid.add(generalizqui);
		 dosgrid.add(panelderecho);
		 
		 
		 return dosgrid;
		
	}
	
	private class Hiloprogressbar extends Thread{
		
		@Override
		public void run(){
			
			
		}
		
	
		
	}
	
}
