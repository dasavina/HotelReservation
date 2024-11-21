package hotelreservation.customers;

import hotelreservation.customers.Dtos.CustomerDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomersApplicationTests {

    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(DockerImageName.parse("mysql:8.3.0"));
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }



    @Test
    void shouldCreateCustomer() {
        CustomerDTO customer = getCustomerDTO();

        var createdCustomer = RestAssured.given()
                .contentType("application/json")
                .body(customer)
                .when()
                .post("/api/customers")
                .then()
                .log().all()
                .statusCode(201) // Assuming 201 Created for successful POST
                .extract().response().as(CustomerDTO.class);

        assertNotNull(createdCustomer, "Created customer should not be null");
        assertNotNull(createdCustomer.getId(), "Customer ID should not be null");
        assertEquals(customer.getName(), createdCustomer.getName(), "Customer name should match");
        assertEquals(customer.getEmail(), createdCustomer.getEmail(), "Customer email should match");
    }

    private CustomerDTO getCustomerDTO() {
        return new CustomerDTO(19L,"John Doe", "john.doe@example.com");
    }
}
