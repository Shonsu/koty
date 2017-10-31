package pl.kobietydokodu.koty.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * use koty;
CREATE TABLE koty_table(
		  `CUST_ID` SIGNED BIGINT unsigned NOT NULL AUTO_INCREMENT,
		  `imie` varchar(30) NOT NULL,
		  `opiekun` varchar(30) NOT NULL,
		  `dataUrodzenia` DATE,
		  `waga` int(10) unsigned NOT NULL,
		  PRIMARY KEY (`CUST_ID`)
		) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/
@Entity
public class Kot {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long custId;
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

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public boolean isNew() {
		return (this.custId == null);

	}

}
