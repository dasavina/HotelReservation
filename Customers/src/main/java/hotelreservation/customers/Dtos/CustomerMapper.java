package hotelreservation.customers.Dtos;

import hotelreservation.customers.Entities.Customer;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
    List<CustomerDTO> toDtoList(List<Customer> customers);
    List<Customer> toEntityList(List<CustomerDTO> customerDTOs);
}

