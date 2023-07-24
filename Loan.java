import java.time.LocalDate;

public class Loan {
    private String loanId;	
    private String customerId;
    private String lenderId;
    private double amount;
    private double remainingAmount;
    private LocalDate paymentDate;
    private double interestPerDay;
    private LocalDate dueDate;
    private double penaltyPerDay;
    private boolean canceled;

    public Loan(String loanId, String customerId, String lenderId, double amount,
                double remainingAmount, LocalDate paymentDate, double interestPerDay,
                LocalDate dueDate, double penaltyPerDay) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.lenderId = lenderId;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.paymentDate = paymentDate;
        this.interestPerDay = interestPerDay;
        this.dueDate = dueDate;
        this.penaltyPerDay = penaltyPerDay;
        this.canceled = false;
    }

    // Add getters and setters as needed

    public boolean isPaymentDateGreaterThanDueDate() {
        return paymentDate.isAfter(dueDate);
    }

    public void updateRemainingAmount(double paidAmount) {
        this.remainingAmount -= paidAmount;
    }

    public void applyPenalty() {
        double penaltyAmount = remainingAmount * penaltyPerDay / 100;
        remainingAmount += penaltyAmount;
    }

    public void cancelLoan() {
        canceled = true;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getInterestPerDay() {
		return interestPerDay;
	}

	public void setInterestPerDay(double interestPerDay) {
		this.interestPerDay = interestPerDay;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getPenaltyPerDay() {
		return penaltyPerDay;
	}

	public void setPenaltyPerDay(double penaltyPerDay) {
		this.penaltyPerDay = penaltyPerDay;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
    
}
