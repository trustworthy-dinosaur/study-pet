package mascota;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MercadoModelo extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	private List<Item> items = new ArrayList<Item>();
	private String[] cname = {"NOMBRE", "BENEFICIA", "PRECIO", "ALMACEN"};

	public MercadoModelo(List<Item> items) {
		this.items = items;
	}
	
	@Override
	public String getColumnName(int column) {
		return this.cname[column];
	}
	
	@Override
	public int getRowCount() {
		if (this.items == null) {
			return 0;
		}
		return this.items.size();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Item it = this.items.get(row);
		if (column==0) {
			return it.getNombre();
		} else if (column==1){
			return it.getBeneficio();
		} else if (column==2){
			return it.getPrecio();
		} else if (column==3) {
			return it.getAlmacen();
		}
		return "no existe";
	}
}

