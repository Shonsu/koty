package pl.kobietydokodu.koty.dto;



import javax.validation.constraints.Size;
import javax.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class KotDTO {

    @Override
	public String toString() {
		return "KotDTO [custId=" + custId + ", name=" + name + ", birthDate=" + birthDate + ", weight=" + weight
				+ ", owner=" + owner + ", sex=" + sex + ", coloring=" + coloring + "]";
	}

	private Long custId;
    
    @NotNull(message="Imię nie może być puste")
    @Size(min=2, max=30, message = "Długość musi być od 2 do 30 zanków")
    private String name;
    

    
    //@Pattern(regexp="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="Data nie może być pusta")
    @PastOrPresent(message="Data musi być przeszła lub terazniejsza")
	private Date birthDate;
    
    @NotNull(message="Waga nie może być pusta")
    private Float weight;
    
    @NotNull(message="Imię nie może być puste")
    @Size(min=3, max=30, message = "Długość musi być od 3 do 30 zanków")
    private String owner;
    @NotEmpty(message="Please select cat sex")
    private String sex;
    @NotEmpty(message="Please choose cat coloring")
    private String coloring;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getColoring() {
		return coloring;
	}

	public void setColoring(String coloring) {
		this.coloring = coloring;
	}
    
    
}
