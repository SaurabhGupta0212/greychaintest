import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanStoreTest {

    private LoanStore loanStore;

    @BeforeEach
    public void setUp() {
        // Initialize the loanStore before each test case
        loanStore = new LoanStore();
    }

    @Test
    public void testLoanPaymentDateNotGreaterThanDueDate() {
        // Test that the payment date can't be greater than the due date
        assertThrows(IllegalArgumentException.class, () -> {
            loanStore.addLoan("L1", "C1", "LEN1", 10000, 10000,
            		LocalDate.of(2023, 6, 5), 1, LocalDate.of(2023, 7, 5), 0.01);
        });
    }

    @Test
    public void testLoanAggregationByLender() {
        // Test the aggregation of remaining amount, interest, and penalty by lender
        loanStore.addLoan("L1", "C1", "LEN1", 25000, 5000,LocalDate.of(2023, 6, 1),
                 1, LocalDate.of(2023, 8, 5), 0.01);
        loanStore.addLoan("L2", "C2", "LEN2", 50000, 30000,
        		LocalDate.of(2023, 4, 4), 2, LocalDate.of(2023, 5, 4), 0.02);

        double[] expectedAggregation = loanStore.getLoanAggregationByLender("LEN1");
        double[] actualAggregation = {25000.0, 5000.0, 0.01};
        assertArrayEquals(expectedAggregation, actualAggregation, 0.01);
    }

    @Test
    public void testLoanAggregationByInterest() {
        // Test the aggregation of remaining amount, interest, and penalty by interest
        loanStore.addLoan("L1", "C1", "LEN1", 20000, 5000,
        		LocalDate.of(2023, 6, 1), 1, LocalDate.of(2023, 8, 5), 0.01);
        loanStore.addLoan("L2", "C2", "LEN2", 50000, 30000,
        		LocalDate.of(2023, 4, 4), 2, LocalDate.of(2023, 5, 4), 0.02);

        double[] expectedAggregation = loanStore.getLoanAggregationByInterest(1);
        double[] actualAggregation = {20000.0, 5000.0, 0.01};
        assertArrayEquals(expectedAggregation, actualAggregation, 0.01);
    }

    @Test
    public void testLoanAggregationByCustomer() {
        // Test the aggregation of remaining amount, interest, and penalty by customer
        loanStore.addLoan("L1", "C1", "LEN1", 20000, 5000,
        		LocalDate.of(2023, 6, 1), 1, LocalDate.of(2023, 8, 5) , 0.01);
        loanStore.addLoan("L2", "C2", "LEN2", 50000, 30000,
        		LocalDate.of(2023, 4, 4), 2, LocalDate.of(2023, 5, 4 ), 0.02);

        double[] expectedAggregation = loanStore.getLoanAggregationByCustomer("C1");
        double[] actualAggregation = {20000.0, 5000.0, 0.01};
        assertArrayEquals(expectedAggregation, actualAggregation, 0.01);
    }

    @Test
    public void testLoanAlertOnDueDateCrossed() {
    	loanStore.getLoanDateForLoanAlert();
}
}
