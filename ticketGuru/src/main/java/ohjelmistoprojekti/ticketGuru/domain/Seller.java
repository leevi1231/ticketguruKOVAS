package ohjelmistoprojekti.ticketGuru.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sellerid;

	@NotBlank(message = "First name cannot be blank")
	private String sellerfirstname;

	@NotBlank(message = "Surname name cannot be blank")
	private String sellersurname;

	@NotBlank(message = "Address cannot be blank")
	private String selleraddress;

	@NotBlank(message = "Phone cannot be blank")
	private String sellerphone;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email must be valid")
	private String selleremail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
	private List<Transaction> transactions = new ArrayList<>();

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Seller(String sellerfirstname, String sellersurname, String selleraddress, String sellerphone,
			String selleremail) {
		super();
		this.sellerfirstname = sellerfirstname;
		this.sellersurname = sellersurname;
		this.selleraddress = selleraddress;
		this.sellerphone = sellerphone;
		this.selleremail = selleremail;
	}

	public Seller() {
	};

	public Long getId() {
		return sellerid;
	}

	public void setSellerid(Long sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellerfirstname() {
		return sellerfirstname;
	}

	public void setSellerfirstname(String sellerfirstname) {
		this.sellerfirstname = sellerfirstname;
	}

	public String getSellersurname() {
		return sellersurname;
	}

	public void setSellersurname(String sellersurname) {
		this.sellersurname = sellersurname;
	}

	public String getSelleraddress() {
		return selleraddress;
	}

	public void setSelleraddress(String selleraddress) {
		this.selleraddress = selleraddress;
	}

	public String getSellerphone() {
		return sellerphone;
	}

	public void setSellerphone(String sellerphone) {
		this.sellerphone = sellerphone;
	}

	public String getSelleremail() {
		return selleremail;
	}

	public void setSelleremail(String selleremail) {
		this.selleremail = selleremail;
	}

	@Override
	public String toString() {
		if (this.transactions != null)

			return "Seller [sellerid=" + sellerid + ", sellerfirstname=" + sellerfirstname + ", sellersurname="
					+ sellersurname + ", selleraddress=" + selleraddress + ", sellerphone=" + sellerphone
					+ ", selleremail=" + selleremail + ", transactions=" + transactions
					+ "]";

		else
			return "Seller [sellerid=" + sellerid + ", sellerfirstname=" + sellerfirstname + ", sellersurname="
					+ sellersurname + ", selleraddress=" + selleraddress + ", sellerphone=" + sellerphone
					+ ", selleremail=" + selleremail + ", transactions= " + transactions + "]";
	}

}