package stats;

import java.util.List;

public class Dia {
	private String nombredia;
	private List<CeldaHora> tramos;
	
	
	public Dia(String nombredia, List<CeldaHora> tramos) {
		super();
		this.nombredia = nombredia;
		this.tramos = tramos;
	}


	public String getNombredia() {
		return nombredia;
	}


	public void setNombredia(String nombredia) {
		this.nombredia = nombredia;
	}


	public List<CeldaHora> getTramos() {
		return tramos;
	}


	public void setTramos(List<CeldaHora> tramos) {
		this.tramos = tramos;
	}


	@Override
	public String toString() {
		return "Dia [nombredia=" + nombredia + ", tramos=" + tramos + "]";
	}
	
	
	
}

