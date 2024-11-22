package hotelreservation.customers.Dtos;


public class RoomDTO {
    private Long id;
    private String roomNumber;
    private String type;
    private Double price;

    // Getters, Setters, and Constructors
    public RoomDTO() {}

    public RoomDTO(Long id, String roomNumber, String type, Double price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
