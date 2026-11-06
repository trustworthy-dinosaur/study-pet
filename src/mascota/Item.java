package mascota;

public class Item {
	enum Beneficio{
		ESTOMAGO,
		FELICIDAD,
		ENERGIA
	};
	
	public Item(String nombre, Beneficio beneficio, int precio, int almacen) {
		this.nombre=nombre;
		this.beneficio = beneficio;
		this.precio = precio;
		this.almacen= almacen;
	}
	String nombre;
	Beneficio beneficio;
	int precio;
	int almacen;
	
}
