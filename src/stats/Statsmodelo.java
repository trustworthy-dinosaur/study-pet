package stats;

import java.util.List;

import javax.swing.table.DefaultTableModel;


public class Statsmodelo extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] columnanombre = {"Asignatura","Lunes", "Martes", "Miércoles","Jueves", "Viernes", "Sábado", "Domingo", "Total Semanal", "Porcentaje"};
	private List<Asignaturasemana> asignaturas;
	
	public Statsmodelo(List<Asignaturasemana> asignaturas) {
		this.asignaturas = asignaturas; 
	}
	
	public double getHorasTotalesDia(int c) {
		double total = 0.0;
		
		for (int i = 0; i < getRowCount(); i++) {
			Object hora = getValueAt(i, c);
			total = total + (double) hora;
		}
		return total;
	}
	
	@Override 
	public int getRowCount() {
		if(asignaturas == null) {
			return 0;
		}
		return asignaturas.size();
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
		
		Asignaturasemana asig = asignaturas.get(r);
		if(c == 0) {
			return asig.getNombre();
		}else if (c >=1 && c <= 7) {
			return asig.getHoras()[c-1];
		}else if(c == 8){
			return asig.getHoratotal();
		}else if (c == 9){
			return asig.getPorcentaje();
		}else {
			return null;
		}
	
	}
	
}
