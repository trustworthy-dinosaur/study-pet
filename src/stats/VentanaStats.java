package stats;

import java.awt.BorderLayout;

import javax.swing.table.DefaultTableCellRenderer; 
import javax.swing.table.TableCellRenderer;  

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import ventanaPrincipal.Ventana;

public class VentanaStats extends JFrame {

	private static final long serialVersionUID = 702089359884714690L;
	private List<Asignaturasemana> asignaturas = new ArrayList<>();
	private List<Dia> listaDias = new ArrayList<>();
	
	
	public VentanaStats() {
		
		
		
		//Uso de IA
		asignaturas.add(new Asignaturasemana("Matemáticas", new int[]{2, 2, 0, 2, 0, 4, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Programación", new int[]{0, 3, 3, 0, 2, 0, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Bases de Datos", new int[]{2, 0, 2, 2, 0, 3, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Telemática", new int[]{3, 0, 2, 0, 2, 0, 0}, 0, 0));
		asignaturas.add(new Asignaturasemana("Cálculo", new int[]{0, 2, 0, 1, 0, 0, 0}, 0, 0));
		
		int horastotalsemanageneral = 0;
		for(Asignaturasemana asigna: asignaturas) {
			asigna.calcularHoraToal();
			horastotalsemanageneral += asigna.getHoratotal();
		}
		
		for(Asignaturasemana asigna: asignaturas) {
			asigna.porcentajetotal(horastotalsemanageneral);
		}
		
		// Método para inicializar los 7 días con sus tramos horarios
	    // --- LUNES (7h totales: Mates 2h, Bases de Datos 2h, Telemática 3h) ---
		List<CeldaHora> tramosLunes = new ArrayList<>();
	    tramosLunes.add(new CeldaHora("08:00 - 09:00", "---", 0));
	    tramosLunes.add(new CeldaHora("09:00 - 10:00", "Matemáticas", 100));
	    tramosLunes.add(new CeldaHora("10:00 - 11:00", "Matemáticas", 100));
	    tramosLunes.add(new CeldaHora("11:00 - 12:00", "Descanso", 0));
	    tramosLunes.add(new CeldaHora("12:00 - 13:00", "Bases de Datos", 100));
	    tramosLunes.add(new CeldaHora("13:00 - 14:00", "Bases de Datos", 100));
	    tramosLunes.add(new CeldaHora("16:00 - 17:00", "Telemática", 100));
	    tramosLunes.add(new CeldaHora("17:00 - 18:00", "Telemática", 100));
	    tramosLunes.add(new CeldaHora("18:00 - 19:00", "Telemática", 100));
	    listaDias.add(new Dia("Lunes", tramosLunes));

	    // --- MARTES (7h totales: Mates 2h, Prog 3h, Cálculo 2h) ---
	    List<CeldaHora> tramosMartes = new ArrayList<>();
	    tramosMartes.add(new CeldaHora("08:00 - 09:00", "---", 0));
	    tramosMartes.add(new CeldaHora("09:00 - 10:00", "Programación", 100));
	    tramosMartes.add(new CeldaHora("10:00 - 11:00", "Programación", 100));
	    tramosMartes.add(new CeldaHora("11:00 - 12:00", "Descanso", 0));
	    tramosMartes.add(new CeldaHora("12:00 - 13:00", "Bases de Datos", 50)); // Ejemplo con 50%
	    tramosMartes.add(new CeldaHora("13:00 - 14:00", "Programación", 50));
	    tramosMartes.add(new CeldaHora("16:00 - 17:00", "Matemáticas", 100));
	    tramosMartes.add(new CeldaHora("17:00 - 18:00", "Matemáticas", 100));
	    tramosMartes.add(new CeldaHora("18:00 - 19:00", "Cálculo", 100));
	    tramosMartes.add(new CeldaHora("19:00 - 20:00", "Cálculo", 100));
	    listaDias.add(new Dia("Martes", tramosMartes));

	    // --- MIÉRCOLES (7h totales: Prog 3h, BD 2h, Telemática 2h) ---
	    List<CeldaHora> tramosMiercoles = new ArrayList<>();
	    tramosMiercoles.add(new CeldaHora("09:00 - 10:00", "Programación", 100));
	    tramosMiercoles.add(new CeldaHora("10:00 - 11:00", "Programación", 100));
	    tramosMiercoles.add(new CeldaHora("11:00 - 12:00", "Programación", 100));
	    tramosMiercoles.add(new CeldaHora("12:00 - 13:00", "Bases de Datos", 100));
	    tramosMiercoles.add(new CeldaHora("13:00 - 14:00", "Bases de Datos", 100));
	    tramosMiercoles.add(new CeldaHora("16:00 - 17:00", "Telemática", 100));
	    tramosMiercoles.add(new CeldaHora("17:00 - 18:00", "Telemática", 100));
	    listaDias.add(new Dia("Miércoles", tramosMiercoles));

	    // --- JUEVES (5h totales: Mates 2h, BD 2h, Cálculo 1h) ---
	    List<CeldaHora> tramosJueves = new ArrayList<>();
	    tramosJueves.add(new CeldaHora("09:00 - 10:00", "Matemáticas", 100));
	    tramosJueves.add(new CeldaHora("10:00 - 11:00", "Matemáticas", 100));
	    tramosJueves.add(new CeldaHora("11:00 - 12:00", "Cálculo", 100));
	    tramosJueves.add(new CeldaHora("16:00 - 17:00", "Bases de Datos", 100));
	    tramosJueves.add(new CeldaHora("17:00 - 18:00", "Bases de Datos", 100));
	    listaDias.add(new Dia("Jueves", tramosJueves));

	    // --- VIERNES (4h totales: Prog 2h, Telemática 2h) ---
	    List<CeldaHora> tramosViernes = new ArrayList<>();
	    tramosViernes.add(new CeldaHora("09:00 - 10:00", "Programación", 100));
	    tramosViernes.add(new CeldaHora("10:00 - 11:00", "Programación", 100));
	    tramosViernes.add(new CeldaHora("11:00 - 12:00", "Telemática", 100));
	    tramosViernes.add(new CeldaHora("12:00 - 13:00", "Telemática", 100));
	    listaDias.add(new Dia("Viernes", tramosViernes));

	    // --- SÁBADO (4h totales: Mates 4h) ---
	    List<CeldaHora> tramosSabado = new ArrayList<>();
	    tramosSabado.add(new CeldaHora("10:00 - 11:00", "Matemáticas", 100));
	    tramosSabado.add(new CeldaHora("11:00 - 12:00", "Matemáticas", 100));
	    tramosSabado.add(new CeldaHora("12:00 - 13:00", "Matemáticas", 100));
	    tramosSabado.add(new CeldaHora("13:00 - 14:00", "Matemáticas", 100));
	    listaDias.add(new Dia("Sábado", tramosSabado));

	    // --- DOMINGO (Descanso) ---
	    List<CeldaHora> tramosDomingo = new ArrayList<>();
	    tramosDomingo.add(new CeldaHora("08:00 - 23:59", "Descanso Total", 0));
	    listaDias.add(new Dia("Domingo", tramosDomingo));

		//Hasta aquí
		
	    
	    
		
		//Panel base
		JPanel pPrincipal = new JPanel(new BorderLayout());
		this.getContentPane().add(pPrincipal);
	
		//JPanel botones
		JPanel norte = new JPanel(new BorderLayout());
		norte.setBackground(new Color(238, 169, 178));
		
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
		card.add(VistaGeneralBarras(), "Vista Gráficos Semana");
		card.add(CrearJTables(), "Vista Tabla Detallada");
		
		JButton botongeneral = new JButton("Vista Gráficos Semana");
		botongeneral.setBackground(new Color(223,147,157).darker());
		botongeneral.setForeground(Color.WHITE);
		botongeneral.setFocusPainted(false);
		botongeneral.setPreferredSize(new Dimension(0,40));
		botongeneral.setFont(new Font("Centaur", Font.PLAIN, 22));
		botongeneral.addActionListener( e-> {
			layoutcard.show(card, "Vista Gráficos Semana");
		});
		
		
		JButton botondetalles = new JButton("Vista Tabla Detallada");
		botondetalles.setBackground(new Color(223,147,157).darker());
		botondetalles.setForeground(Color.WHITE);
		botondetalles.setFocusPainted(false);
		botondetalles.setPreferredSize(new Dimension(0,40));
		botondetalles.setFont(new Font("Centaur", Font.PLAIN, 22));
		botondetalles.addActionListener(e -> {
			layoutcard.show(card, "Vista Tabla Detallada");
		});
		
		JPanel grid = new JPanel(new GridLayout(1,2));
		grid.add(botongeneral);
		
		grid.add(botondetalles);
		
		centro.add(grid, BorderLayout.NORTH);
		
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	private JPanel CrearJTables() {
		
		
		//Crear JTable principal
		Statsmodelo modelo = new Statsmodelo(asignaturas);
		JTable estadisticasemana = new JTable(modelo);
		estadisticasemana.setFillsViewportHeight(true);
		estadisticasemana.setRowHeight(35);
		estadisticasemana.setBackground(new Color(241, 230, 224));
		estadisticasemana.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane(estadisticasemana);
			
		
		
		//Renderer celdas
		TableCellRenderer porcentaje = (table,value,isSelected, hasFocus, row, column) -> {
			int valor = 0;
			if(value instanceof Integer) {
				valor = (Integer) value;
			}
			
			JProgressBar barra = new JProgressBar(0,100);
			barra.setValue(valor);
			barra.setStringPainted(true);
			barra.setString(valor + "%");
			
			return barra;
		};

		estadisticasemana.getColumnModel().getColumn(9).setCellRenderer(porcentaje);
		
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);
		
		for (int i = 0; i < estadisticasemana.getColumnCount()-1; i++) {
			estadisticasemana.getColumnModel().getColumn(i).setCellRenderer(centro);
		}
		
		
		
		//Renderer cabecera
				
		TableCellRenderer headerRenderer = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel result = new JLabel(value.toString());			
			result.setHorizontalAlignment(JLabel.CENTER);
			result.setBackground(new Color(233,229,219));
			result.setForeground(Color.BLACK);
			result.setOpaque(true);
			
			return result;
		};
		
		estadisticasemana.getTableHeader().setDefaultRenderer(headerRenderer);
		
		//JTable dia
		Statsdia modelodia = new Statsdia(listaDias.get(0).getTramos());
		
		JTable tabladia = new JTable(modelodia);
		tabladia.setFillsViewportHeight(true);
		tabladia.setRowHeight(25);
		tabladia.setBackground(new Color(225,222,216));
		tabladia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JScrollPane scrolldia= new JScrollPane(tabladia);
		
		TitledBorder bordertit = BorderFactory.createTitledBorder(listaDias.get(0).getNombredia());
		scrolldia.setBorder(bordertit);
		
		
		TableCellRenderer headerrenderer = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel result = new JLabel(value.toString());			
			result.setHorizontalAlignment(JLabel.CENTER);
			result.setBackground(new Color(225,222,216));
			result.setForeground(Color.BLACK);
			result.setOpaque(true);
			
			return result;
		};
		 
		tabladia.getTableHeader().setDefaultRenderer(headerrenderer);
		
		TableCellRenderer rendererporcentaje = (table,value,isSelected, hasFocus,row,column) -> {
			int valor = 0;
			if(value instanceof Integer) {
				valor = (Integer) value;
			}
			
			JProgressBar barra = new JProgressBar(0,100);
			barra.setValue(valor);
			barra.setStringPainted(true);
			barra.setString(valor + "%");
			
			return barra;
		};
		
		tabladia.getColumnModel().getColumn(2).setCellRenderer(rendererporcentaje);
		
		
		
		estadisticasemana.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cindice = estadisticasemana.columnAtPoint(e.getPoint());
				if(cindice >= 1 && cindice <= 7) {
					int diaindice = cindice -1;
					Dia diaclick = listaDias.get(diaindice);
					tabladia.setModel(new Statsdia(diaclick.getTramos()));
					
					bordertit.setTitle(diaclick.getNombredia());
					
					//pregunta IA de por qué no se me actualizaba el titulo y era por que no había puesto repaint()
					scrolldia.repaint();
					
				}
				
			}
			
		});
		
		
		JPanel panelTablas = new JPanel(new GridLayout(2,1,0,10));
		panelTablas.add(scroll);
		panelTablas.add(scrolldia);
		
		return panelTablas;
		
		
	}	
	
	private JPanel VistaGeneralBarras() {
		
		List<JProgressBar> barrasDerecha = new ArrayList<>();
	    List<Integer> valoresDerecha = new ArrayList<>();
	    List<JProgressBar> barrasIzquierda = new ArrayList<>();
	    List<Integer> valoresIzquierda = new ArrayList<>();

		
		//Panel principal dos graficos
		JPanel dosgrid = new JPanel(new GridLayout(1,2));
		
		//Crear para poner Label de titulo norte y centro el panel general grafico. EL IZQUIERDO
		JPanel generalizqui = new JPanel(new BorderLayout());
		JLabel semana = new JLabel("Gráfico Horas Total", JLabel.CENTER);
		semana.setPreferredSize(new Dimension(0, 70));
		generalizqui.setBackground(new Color(233,229,219));
		generalizqui.add(semana, BorderLayout.NORTH);
		
		
		
		//EL GRÁFICO DERECHO CREAR
		
		//Crear general panel para  asignatura (gráfico, nombres...) Derecho
		JPanel panelasig = new JPanel(new BorderLayout());
		
		
		//Crear grafico por asignatura por semana
		JPanel flowbarra = new JPanel(new FlowLayout());
		flowbarra.setBackground(new Color(225,222,216));
		JPanel gridbarrasasig = new JPanel(new GridLayout(0,1,30,10));
		gridbarrasasig.setBackground(new Color(225,222,216));
		
		for(Asignaturasemana asig: asignaturas) {
			JProgressBar barra = new JProgressBar(0,20);
			barra.setBackground(new Color(242,206,217));
			barra.setForeground(new Color(223,169,186));
			barra.setValue(asig.getHoratotal());
			barra.setStringPainted(true);
			barra.setString(asig.getHoratotal() + "h");
			barra.setPreferredSize(new Dimension(290,45));
			Border borde = BorderFactory.createLineBorder(new Color(237,235,230).darker());
			TitledBorder titulo = BorderFactory.createTitledBorder(
					borde,
					asig.getNombre(),
					TitledBorder.LEFT,
					TitledBorder.TOP,
					new Font("Centaur", Font.BOLD, 14),
					new Color(223,147,157).darker()
			);
			barra.setBorder(titulo);
			gridbarrasasig.add(barra);
			
			
			
			//Rellenamos
			barrasDerecha.add(barra);
			valoresDerecha.add(asig.getHoratotal());
		}
		
		flowbarra.add(gridbarrasasig);
		JScrollPane panelbarra = new JScrollPane(flowbarra);
		panelbarra.setBorder(null);
		
		panelasig.add(panelbarra, BorderLayout.CENTER);
		
		
		
		// EL PANEL DERECHO
		JPanel panelderecho = new JPanel(new BorderLayout());
		panelderecho.setBackground(new Color(225,222,216));
		JLabel textoasig = new JLabel("Gráfico Horas Asignatura", JLabel.CENTER);
		textoasig.setPreferredSize(new Dimension(0, 70));
		panelderecho.add(textoasig, BorderLayout.NORTH);
		panelderecho.add(panelasig, BorderLayout.CENTER);
		
		
		
		//EL PANEL IZQUIERDO
		
		//Creamos el grafico por semana
		JPanel panelsemana = new JPanel(new BorderLayout());
		JPanel barrasflow = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		barrasflow.setBackground(new Color(233,229,219));
		
		for (int i = 1; i < 8; i++) {
				
			JProgressBar barra = new JProgressBar(JProgressBar.VERTICAL, 0, 20);
			Statsmodelo modelo = new Statsmodelo(asignaturas);
			barra.setBackground(new Color(242,206,217));
			barra.setForeground(new Color(223,169,186));
			barra.setValue((int) modelo.getHorasTotalesDia(i));
			barra.setPreferredSize(new Dimension(70,240));
			barra.setStringPainted(true);
			barra.setString((int)modelo.getHorasTotalesDia(i) + "h");
			Border borde = BorderFactory.createLineBorder(new Color(237,235,230).darker());
			TitledBorder titulo = BorderFactory.createTitledBorder(
					borde,
					modelo.getColumnName(i),
					TitledBorder.LEFT,
					TitledBorder.TOP,
					new Font("Centaur", Font.BOLD, 14),
					new Color(223,147,157).darker()
			);
			barra.setBorder(titulo);
			barrasflow.add(barra);
			
			
			//Rellenar izquierdo
			barrasIzquierda.add(barra);
			valoresIzquierda.add((int) modelo.getHorasTotalesDia(i));
		
		}
		JScrollPane scrollpane = new JScrollPane(barrasflow);
		scrollpane.setBorder(null);
		panelsemana.add(scrollpane, BorderLayout.CENTER);
		generalizqui.add(panelsemana, BorderLayout.CENTER);
	
		 dosgrid.add(generalizqui);
		 dosgrid.add(panelderecho);
		 
		 Hiloprogressbar hilo = new Hiloprogressbar(barrasDerecha, valoresDerecha, barrasIzquierda, valoresIzquierda);
		 hilo.start();
		 return dosgrid;
	}
	
	private class Hiloprogressbar extends Thread{
		
		private List<JProgressBar> barrasderecha;
		private List<Integer> valoresderecha;
		private List<JProgressBar> barrasizquierda;
		private List<Integer> valoresizquierda;
		
		public Hiloprogressbar(List<JProgressBar> barrasderecha, List<Integer> valoresderecha, List<JProgressBar> barrasizquierda, List<Integer> valoresizquierda) {
			this.barrasderecha = barrasderecha;
			this.valoresderecha = valoresderecha;
			this.barrasizquierda = barrasizquierda;
			this.valoresizquierda = valoresizquierda;
		}
		
		@Override
		public void run(){
			boolean actualizar = true;
			while(actualizar) {
				actualizar = false;
				for (int i = 0; i < barrasderecha.size(); i++) {
					JProgressBar barra = barrasderecha.get(i);
					int valorllegar = valoresderecha.get(i);
					if(barra.getValue() < valorllegar) {
						int valoractualizar = barra.getValue() + 1;
						barra.setValue(valoractualizar);
						barra.setString(valoractualizar + "h");
					}
					
				}
				
				for (int i = 0; i < barrasizquierda.size(); i++) {
					JProgressBar barra = barrasizquierda.get(i);
					int valorllegar = valoresizquierda.get(i);
					if(barra.getValue() < valorllegar) {
						int valoractualizar = barra.getValue() + 1;
						barra.setValue(valoractualizar);
						barra.setString(valoractualizar + "h");
					}
					
				}
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO: handle exception
					this.interrupt();
					break;
				}
			}
			
		}
	}
	
}
