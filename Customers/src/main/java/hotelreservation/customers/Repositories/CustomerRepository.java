package hotelreservation.customers.Repositories;


import hotelreservation.customers.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
