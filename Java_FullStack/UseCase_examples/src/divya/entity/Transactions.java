package divya.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class Transactions {
	
	private int tranc_id;
	private int cus_id;
	private int transc_amt;
	private String transc_type;
	private Date transc_date;
	private String account_name;
	
	public Transactions(int tranc_id, int cus_id, int transc_amt, String transc_type, Date transc_date) {
		this.tranc_id = tranc_id;
		this.cus_id = cus_id;
		this.transc_amt = transc_amt;
		this.transc_type = transc_type;
		this.transc_date = transc_date;
	}
	
	
	public Transactions(int cus_id, int transc_amt, String transc_type, String account_name) {
		this.cus_id = cus_id;
		this.transc_amt = transc_amt;
		this.transc_type = transc_type;
		this.account_name = account_name;
	}
	

	public Transactions(int transc_amt, String transc_type, Date transc_date, String account_name) {
		this.transc_amt = transc_amt;
		this.transc_type = transc_type;
		this.transc_date = transc_date;
		this.account_name = account_name;
	}


	public Transactions(int transc_amt, String transc_type) {

		this.transc_amt = transc_amt;
		this.transc_type = transc_type;
	}


	public int getTranc_id() {
		return tranc_id;
	}
	public void setTranc_id(int tranc_id) {
		this.tranc_id = tranc_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public int getTransc_amt() {
		return transc_amt;
	}
	public void setTransc_amt(int transc_amt) {
		this.transc_amt = transc_amt;
	}
	public String getTransc_type() {
		return transc_type;
	}
	public void setTransc_type(String transc_type) {
		this.transc_type = transc_type;
	}
	public Date getTransc_date() {
		return transc_date;
	}
	public void setTransc_date(Date transc_date) {
		this.transc_date = transc_date;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	
}
