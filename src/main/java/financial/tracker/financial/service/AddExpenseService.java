package financial.tracker.financial.service;

import financial.tracker.financial.dto.AddExpenseDto;
import financial.tracker.financial.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class AddExpenseService {
    private ExpenseRepository expenseRepository;

    public AddExpenseDto addExpense(AddExpenseDto addExpenseDto) {
        return expenseRepository.save(addExpenseDto);
    }
}
