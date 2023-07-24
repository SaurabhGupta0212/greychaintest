import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LoanStore {

    private Map<String, Loan> loans;
    public LoanStore() {
        loans = new HashMap<>();
    }

    public void addLoan(String loanId, String customerId, String lenderId, double amount, double remainingAmount,
                        LocalDate paymentDate, int interestPerDay, LocalDate dueDate, double penaltyPerDay) {

    	Loan loan = new Loan(loanId, customerId,lenderId, amount, remainingAmount,paymentDate,interestPerDay,dueDate,penaltyPerDay);
    	loans.put(loanId, loan);
    }

    public double[] getLoanAggregationByLender(String lenderId) {
		for(String l: loans.keySet()) {
			Loan ls = loans.get(l);
			if (ls.getLenderId()== lenderId) {
    	double[] ret = new double[] {ls.getAmount(), ls.getRemainingAmount(), ls.getPenaltyPerDay()};
    	return ret;
			}
		}
		return null;
    }

    public double[] getLoanAggregationByInterest(int interestPerDay) {
		for(String l: loans.keySet()) {
			Loan ls = loans.get(l);
			if (ls.getInterestPerDay()== interestPerDay) {
		    	double[] ret = new double[] {ls.getAmount(), ls.getRemainingAmount(), ls.getPenaltyPerDay()};
    	return ret;
			}
		}
		return null;
    }


    public double[] getLoanAggregationByCustomer(String customerId) {
		for(String l: loans.keySet()) {
			Loan ls = loans.get(l);
			if (ls.getCustomerId()== customerId) {
		    	double[] ret = new double[] {ls.getAmount(), ls.getRemainingAmount(), ls.getPenaltyPerDay()};

    	return ret;
			}
		}
		return null;
    }


	public void getLoanDateForLoanAlert() {
		if(!loans.isEmpty()) {
		for(String l: loans.keySet()) {
			Loan ls = loans.get(l);
			if (ls.getDueDate().compareTo(LocalDate.now())>0) {
				System.out.println("Due date "+ls.getDueDate() +" have been crossed");
			}
			}
	}}
}

