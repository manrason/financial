package financial.tracker.financial.controller;

import financial.tracker.financial.dto.AddExpenseDto;
import financial.tracker.financial.service.AddExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AddExpenseController {

    private final AddExpenseService addExpenseService;

    @PostMapping("/expense/add")
    public ResponseEntity<Object> addExpense(AddExpenseDto addExpenseDto){
        addExpenseService.addExpense(addExpenseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
