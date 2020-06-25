package shopinfo.model;

public class Stock {
	private int	Stock_id;
	private int Store_id;
	private int	G_id;
	private int Stock_num;
	public int getStock_id() {
		return Stock_id;
	}
	public void setStock_id(int stock_id) {
		Stock_id = stock_id;
	}
	public int getStore_id() {
		return Store_id;
	}
	public void setStore_id(int store_id) {
		Store_id = store_id;
	}
	public int getG_id() {
		return G_id;
	}
	public void setG_id(int g_id) {
		G_id = g_id;
	}
	public int getStock_num() {
		return Stock_num;
	}
	public void setStock_num(int stock_num) {
		Stock_num = stock_num;
	}
}
