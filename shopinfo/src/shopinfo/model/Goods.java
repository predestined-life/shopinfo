package shopinfo.model;

public class Goods {
	private int G_id;
	private String G_name;
	private float G_price;
	private String G_class;
	private int G_date;
	private int G_num;
	private float G_sum;
	private String Sup_name;
	private int Sup_date;
	private String G_on_name;
	
	public int getG_num() {
		return G_num;
	}
	public void setG_num(int g_num) {
		G_num = g_num;
	}
	public float getG_sum() {
		return G_sum;
	}
	public void setG_sum(float g_sum) {
		G_sum = g_sum;
	}
	public String getSup_name() {
		return Sup_name;
	}
	public void setSup_name(String sup_name) {
		Sup_name = sup_name;
	}
	public int getSup_date() {
		return Sup_date;
	}
	public void setSup_date(int sup_date) {
		Sup_date = sup_date;
	}
	public String getG_on_name() {
		return G_on_name;
	}
	public void setG_on_name(String g_on_name) {
		G_on_name = g_on_name;
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
	public float getG_price() {
		return G_price;
	}
	public void setG_price(float g_price) {
		G_price = g_price;
	}
	public String getG_class() {
		return G_class;
	}
	public void setG_class(String g_class) {
		G_class = g_class;
	}
	public int getG_date() {
		return G_date;
	}
	public void setG_date(int g_date) {
		G_date = g_date;
	}
	
}
