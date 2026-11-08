package stats;

import javax.swing.table.DefaultTableModel;

public class statsdia extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] columnas = {"Materia", "Horas", "Porcentaje "};
	
	@Override
	public int getRowCount(int r) {
		return r;
	}
	
	@Override 
	public int gerColumnCount(int c ) {
		return columnas.length;
	}
	
	@Override 
	public String getColumnName(int c) {
		return columnas[c];
	}
	
	@Override
	public boolean isCellEditable() {
		return false;
	}
	
	
	
	
}
