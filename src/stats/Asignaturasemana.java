package stats;

import java.util.Arrays;

public class Asignaturasemana {
	
	private String nombre;
	private int [] horas = new int[7];
	private int horatotal;
	private int porcentaje;
	
	public Asignaturasemana(String nombre, int[] horas, int horatotal, int porcentaje) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.horatotal = horatotal;
		this.porcentaje = porcentaje;
	}
	
	public void calcularHoraToal() {
		int suma = 0;
		for (int i = 0; i < horas.length; i++) {
			suma = suma + horas[i];
		}
		
		this.horatotal = suma;
	}
	
	public void porcentajetotal(int sumatotalhorasasignatura) {
		this.porcentaje = (int) (((double)this.horatotal/sumatotalhorasasignatura) * 100);
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getHoras() {
		return horas;
	}

	public void setHoras(int[] horas) {
		this.horas = horas;
	}

	public int getHoratotal() {
		return horatotal;
	}

	public void setHoratotal(int horatotal) {
		this.horatotal = horatotal;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Asignaturasemana [nombre=" + nombre + ", horas=" + Arrays.toString(horas) + ", horatotal=" + horatotal
				+ ", porcentaje=" + porcentaje + "]";
	}
	
	
	
}
