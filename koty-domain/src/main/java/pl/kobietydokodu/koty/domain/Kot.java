package pl.kobietydokodu.koty.domain;

import java.util.Date;


/*
 * use koty;
CREATE TABLE koty_table(
		  `CUST_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
		  `imie` varchar(30) NOT NULL,
		  `opiekun` varchar(30) NOT NULL,
		  `dataUrodzenia` DATE,
		  `waga` int(10) unsigned NOT NULL,
		  PRIMARY KEY (`CUST_ID`)
		) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/

public class Kot {

	private int custId;
    private String imie;
    private Date dataUrodzenia;
    private Float waga;
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

    public void setDataUrodzenia(Date string) {
        this.dataUrodzenia = string;
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

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

}
