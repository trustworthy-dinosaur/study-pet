package stats;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class VentanaStats extends JFrame {

	private static final long serialVersionUID = 702089359884714690L;
	
	public VentanaStats() {
		List<Asignaturasemana> asignaturas = new ArrayList<>();
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
		
		
		//Renderer celdas
		TableCellRenderer celdas = (table,value,isSelected, hasFocus, row, column) -> {
			JLabel resultado = new JLabel(value.toString());
			return resultado;
		};
		
		
		//Renderer cabezera
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel pPrincipal = new JPanel();
		this.getContentPane().add(pPrincipal);
	
		//Crear JTable principal
		Statsmodelo modelo = new Statsmodelo(asignaturas);
		JTable estadisticasemana = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(estadisticasemana);
		
		pPrincipal.add(scroll);
		
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
}
