package shopinfo.model;

public class Store {
	private int	Store_id;
	private String Store_name;
	private int People_id;
	public int getStore_id() {
		return Store_id;
	}
	public void setStore_id(int store_id) {
		Store_id = store_id;
	}
	public String getStore_name() {
		return Store_name;
	}
	public void setStore_name(String store_name) {
		Store_name = store_name;
	}
	public int getPeople_id() {
		return People_id;
	}
	public void setPeople_id(int people_id) {
		People_id = people_id;
	}
}
