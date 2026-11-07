package stats;

public class statsdia extends AsbtractTableModel{

	private String [] columnas = {"Materia", "Horas", "Porcentaje "};
	
	@Override
	public int getRowCount(int r) {
		return r;
	}
	
	@Override 
	public int gerColumnCount(int c ) {
		return c;
	}
	
	
	
	
}
