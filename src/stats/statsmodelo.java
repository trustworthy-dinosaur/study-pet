package stats;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class statsmodelo extends AbstractTableModel{
	
	
	private String [] columnanombre = {"Lunes", "Martes", "Miércoles","Jueves", "Viernes", "Sábado", "Domingo", "Total Semanal", "Tiempo"};
	private String [] asignaturas = {"Matemáticas", "Lengua", "Ingles", "Biología"};
	
	
	@Override 
	public int getRowCount() {
		return asignaturas.length;
	}
	
	@Override
	public int getColumnCount() {
		return columnanombre.length;
	}
	
	@Override
	public String getColumnName(int c) {
		return columnanombre[c];
	}
	
	@Override
	public boolean isCellEditable(int a, int b) {
		return false;
	}
	
	@Override
	public Object getValueAt(int r, int c) {
		return 0;
	}
	
}
