package pl.kobietydokodu.koty.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* for jdbc
 * use koty;
CREATE TABLE koty_table(
		  `CUST_ID` BIGINT unsigned NOT NULL AUTO_INCREMENT,
		  `imie` varchar(30) NOT NULL,
		  `opiekun` varchar(30) NOT NULL,
		  `dataUrodzenia` DATE,
		  `waga` int(10) unsigned NOT NULL,
		  PRIMARY KEY (`CUST_ID`)
		) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long custId;
    private String name;
    private Date birthDate;
    private Float weight;
    private String owner;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date string) {
        this.birthDate = string;
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

	public boolean isNew() {
		return (this.custId == null);

	}

}
