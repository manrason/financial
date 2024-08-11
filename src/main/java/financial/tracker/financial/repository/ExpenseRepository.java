package financial.tracker.financial.repository;

import financial.tracker.financial.dto.AddExpenseDto;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<AddExpenseDto, Long> {
}
