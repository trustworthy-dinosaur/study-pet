package ventanaPrincipal;

import mascota.GestorBDM;

public class Main {

	public static void main(String[] args) {
		GestorBDM gbdm = new GestorBDM();	
		gbdm.crearBBDD();
		new Ventana();
	}

}
 