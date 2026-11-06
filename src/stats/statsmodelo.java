package stats;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class statsmodelo extends DefaultTableModel{
	
	
	private String [] columnanombre = {"Lunes", "Martes", "Miércoles","Jueves", "Viernes", "Sábado", "Domingo"};
	private List<String> asignaturas; 
	
	
	@Override 
	public int getRowCount() {
		
	}
	
	@Override
	public int getColumnCount() {
		return columnanombre.length;
	}
	
	@Override
	public String getColumnName() {
		
	}
	
	@Override
	public boolean isCellEditable(int a, int b) {
		return false;
	}
	
	
}
