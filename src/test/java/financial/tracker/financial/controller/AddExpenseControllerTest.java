package financial.tracker.financial.controller;

import financial.tracker.financial.dto.AddExpenseDto;
import financial.tracker.financial.service.AddExpenseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class AddExpenseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddExpenseService addExpenseService;

    @Test
    void givenExpenseToAddShouldReturn201() throws Exception {
        AddExpenseDto addExpenseDto = new AddExpenseDto(1L, "name", 10.75);
        Mockito.when(addExpenseService.addExpense(any(AddExpenseDto.class)))
                .thenReturn(addExpenseDto);

        mockMvc.perform(post("/expense/add"))
                .andExpect(status().isCreated());
    }
}
