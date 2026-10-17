package mascota;

import javax.swing.ImageIcon;

public class Mascota {
	ImageIcon imagen = new ImageIcon("images/mascota.png");
	int estomago = 100;
	int felicidad = 100;
	int energia = 100;
	
	public ImageIcon getImagen() {
		return imagen;
	}
}
