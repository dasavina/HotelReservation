package hotelreservation.reservations;

import hotelreservation.reservations.Dtos.ReservationDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationsApplicationTests {

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
	void shouldCreateReservation() {
		ReservationDTO reservation = getReservationDTO();

		var createdReservation = RestAssured.given()
				.contentType("application/json")
				.body(reservation)
				.when()
				.post("/api/reservations")
				.then()
				.log().all()
				.statusCode(201) // Assuming 201 Created for successful POST
				.extract().response().as(ReservationDTO.class);

		assertNotNull(createdReservation, "Created reservation should not be null");
		assertNotNull(createdReservation.getId(), "Reservation ID should not be null");
		assertEquals(reservation.getCustomerId(), createdReservation.getCustomerId(), "Customer ID should match");
		assertEquals(reservation.getRoomId(), createdReservation.getRoomId(), "Room number should match");
		assertEquals(reservation.getCheckOutDate(), createdReservation.getCheckOutDate(), "Reservation date should match");
	}

	private ReservationDTO getReservationDTO() {
		return new ReservationDTO(
				101L, // reservation ID, assuming null for creation
				19L,  // customer ID
				202L,  // room number
				new Date(20024, 12, 15),// current date as reservation date
				new Date(2024, 12, 20)

		);
	}
}
