package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 *
 */

@Entity
@Table(name = "computers")
public class Computer {
	@Id
	@Column(name="idcomputers")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="computers_inventory")
	private int inventoryNumber;
	@Column(name="computers_ip")
	private String ip;
	@Column(name="computers_mac")
	private String mac;
	@Column(name="computers_chair")
	private String chair;
	@Column(name="computers_name")
	private String name;
	@Column(name="computers_intendant")
	private String intendant;
	@Column(name="computers_date_of_purchase")
	private Date dateOfPurchase;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(int inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getChair() {
		return chair;
	}

	public void setChair(String chair) {
		this.chair = chair;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntendant() {
		return intendant;
	}

	public void setIntendant(String intendant) {
		this.intendant = intendant;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

}
