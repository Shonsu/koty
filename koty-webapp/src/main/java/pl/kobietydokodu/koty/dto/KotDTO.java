package pl.kobietydokodu.koty.dto;



import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.validation.constraints.NotNull;


public class KotDTO {

    
    @NotNull(message="Imię nie może być puste")
    @Size(min=2, max=30)
    private String imie;
    
    //@Pattern(regexp="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataUrodzenia;
    
    @NotNull(message="Waga nie może być pusta")
    private Float waga;
    
    @NotNull(message="Imię nie może być puste")
    @Size(min=3, max=30)
    private String imieOpiekuna;

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public Float getWaga() {
		return waga;
	}

	public void setWaga(Float waga) {
		this.waga = waga;
	}

	public String getImieOpiekuna() {
		return imieOpiekuna;
	}

	public void setImieOpiekuna(String imieOpiekuna) {
		this.imieOpiekuna = imieOpiekuna;
	}
    
    
}
