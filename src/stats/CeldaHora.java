package stats;

public class CeldaHora {
	private String hora;
	private String materia;
	private int porcentaje;
	public CeldaHora(String hora, String materia, int porcentaje) {
		super();
		this.hora = hora;
		this.materia = materia;
		this.porcentaje = porcentaje;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	@Override
	public String toString() {
		return "CeldaHora [hora=" + hora + ", materia=" + materia + ", porcentaje=" + porcentaje + "]";
	}
	
	
	
}
