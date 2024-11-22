package hotelreservation.customers.Controllers;

import hotelreservation.customers.Dtos.CustomerDTO;
import hotelreservation.customers.Dtos.RoomDTO;
import hotelreservation.customers.Services.CustomerService;
import hotelreservation.customers.Services.RoomIntegrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final RoomIntegrationService roomIntegrationService;

    public CustomerController(CustomerService customerService, RoomIntegrationService roomIntegrationService) {
        this.customerService = customerService;
        this.roomIntegrationService = roomIntegrationService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/api/customers/rooms")
    public List<RoomDTO> getAvailableRooms() {
        return roomIntegrationService.fetchAvailableRooms();
    }
}
