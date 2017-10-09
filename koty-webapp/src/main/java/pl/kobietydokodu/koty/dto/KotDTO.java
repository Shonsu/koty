package pl.kobietydokodu.koty.dto;



import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;




public class KotDTO {

    
    @NotNull(message="Imię nie może być puste")
    @Size(min=2, max=30)
    private String imie;
    
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private String dataUrodzenia;
    
    @NotNull(message="Imię nie może być puste")
    private Float waga;
    
    @NotNull(message="Imię nie może być puste")
    @Size(min=2, max=30)
    private String imieOpiekuna;

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(String dataUrodzenia) {
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
