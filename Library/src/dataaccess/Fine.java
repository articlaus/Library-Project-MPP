package dataaccess;

import java.io.Serializable;
import java.util.*;

public class Fine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double amount;
	private Date datePaid;
	
	Fine(double amount, Date datePaid) {
		this.amount = amount;
		this.datePaid = datePaid;
	}
	
	// if null is returned, fine hasn't been paid
	public Date getDatePaid() {
		return datePaid;
	}
	
	public double getAmount() {
		return amount;
	}
}
