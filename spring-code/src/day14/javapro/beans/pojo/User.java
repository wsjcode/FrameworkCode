package day14.javapro.beans.pojo;

//总共分为三个部分：1）私有属性，2）get/set方法，3）toString
public class User {
	private Integer id;
	private String name;
	private String company;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	
	
}
