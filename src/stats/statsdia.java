package stats;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class statsdia extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;
	private String [] columnas = {"Horas", "Estudio", "Porcentaje"};
	private Dia dia;
	private List<CeldaHora> horacelda = dia.getTramos();
	
	public statsdia(List<CeldaHora> horacelda) {
		this.horacelda = horacelda;
	}
	
	
	@Override
	public int getRowCount() {
		if(horacelda == null) {
			return 0;
		}
		return horacelda.size();
	}
	
	@Override 
	public int getColumnCount() {
		return columnas.length;
	}
	
	@Override 
	public String getColumnName(int c) {
		return columnas[c];
	}
	
	@Override
	public boolean isCellEditable(int r, int c) {
		return false;
	}
	
	@Override
	public Object getValueAt(int r, int c) {
		CeldaHora horas = horacelda.get(r);
		if(c == 0) {
			return horas.getHora();
		}else if (c == 1) {
			return horas.getMateria();
		}else {
			return horas.getPorcentaje();
		}
	}
}
