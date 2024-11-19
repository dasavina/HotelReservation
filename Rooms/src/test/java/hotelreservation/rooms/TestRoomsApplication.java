package hotelreservation.rooms;

import org.springframework.boot.SpringApplication;

public class TestRoomsApplication {

    public static void main(String[] args) {
        SpringApplication.from(RoomsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
