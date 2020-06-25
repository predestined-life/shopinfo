package shopinfo.model;

public class Sales {
	private int Sale_id;
	private int G_id;
	private String G_name;
	private int Sale_num;
	private float G_price;
	private float	Sale_sum;
	private String On_name;
	public int getSale_id() {
		return Sale_id;
	}
	public void setSale_id(int sale_id) {
		Sale_id = sale_id;
	}
	public int getG_id() {
		return G_id;
	}
	public void setG_id(int g_id) {
		G_id = g_id;
	}
	public String getG_name() {
		return G_name;
	}
	public void setG_name(String g_name) {
		G_name = g_name;
	}
	public int getSale_num() {
		return Sale_num;
	}
	public void setSale_num(int sale_num) {
		Sale_num = sale_num;
	}
	public float getG_price() {
		return G_price;
	}
	public void setG_price(float g_price) {
		G_price = g_price;
	}
	public float getSale_sum() {
		return Sale_sum;
	}
	public void setSale_sum(float sale_sum) {
		Sale_sum = sale_sum;
	}
	public String getOn_name() {
		return On_name;
	}
	public void setOn_name(String on_name) {
		On_name = on_name;
	}
	
	
}
