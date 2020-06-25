package shopinfo.model;

public class People {
	private int People_id;
	private String People_name;
	private String People_sex;
	private int People_tel;
	private String People_job;
	private String Name;
	private String Pass;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public int getPeople_id() {
		return People_id;
	}
	public void setPeople_id(int people_id) {
		People_id = people_id;
	}
	public String getPeople_name() {
		return People_name;
	}
	public void setPeople_name(String people_name) {
		People_name = people_name;
	}
	public String getPeople_sex() {
		return People_sex;
	}
	public void setPeople_sex(String people_sex) {
		People_sex = people_sex;
	}
	public int getPeople_tel() {
		return People_tel;
	}
	public void setPeople_tel(int people_tel) {
		People_tel = people_tel;
	}
	public String getPeople_job() {
		return People_job;
	}
	public void setPeople_job(String people_job) {
		People_job = people_job;
	}
}
