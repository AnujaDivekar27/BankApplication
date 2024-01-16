package com.alexa.bank.apps.dto;

public class Balance {

	private double creditAmount;
	
	private double debitAmount;
	
	private String accounttype;

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	@Override
	public String toString() {
		return "Balance [creditAmount=" + creditAmount + ", debitAmount=" + debitAmount + ", accounttype=" + accounttype
				+ "]";
	}
	
	
}
