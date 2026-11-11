package mascota;

import javax.swing.ImageIcon;

public class Mascota {
	ImageIcon imagen = new ImageIcon("images/mascota.png");
	int estomago = 10;
	int felicidad = 40;
	int energia = 90;
	
	public ImageIcon getImagen() {
		return imagen;
	}

	public int getEstomago() {
		return estomago;
	}

	public void setEstomago(int estomago) {
		this.estomago = estomago;
	}

	public int getFelicidad() {
		return felicidad;
	}

	public void setFelicidad(int felicidad) {
		this.felicidad = felicidad;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	
}
