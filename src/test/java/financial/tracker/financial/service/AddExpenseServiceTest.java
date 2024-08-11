package financial.tracker.financial.service;

import financial.tracker.financial.dto.AddExpenseDto;
import financial.tracker.financial.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AddExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private AddExpenseService addExpenseService;

    @Test
    void addExpense() {
        //Given
        AddExpenseDto addExpenseDto = new AddExpenseDto();
        addExpenseDto.setId(1L);
        addExpenseDto.setName("name");
        addExpenseDto.setAmount(10.75);
        //When
        Mockito.when(expenseRepository.save(any(AddExpenseDto.class))).thenReturn(addExpenseDto);
        AddExpenseDto created = addExpenseService.addExpense(addExpenseDto);
        //Then
        Mockito.verify(expenseRepository, Mockito.times(1)).save(addExpenseDto);
        assertEquals(addExpenseDto.getName(), created.getName());
    }
}