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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Beneficio getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getAlmacen() {
		return almacen;
	}
	public void setAlmacen(int almacen) {
		this.almacen = almacen;
	}
	
	
}
