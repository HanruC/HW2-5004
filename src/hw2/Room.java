package hw2;



public class Room {
  enum RoomType {
    DOUBLE, FAMILY, SINGLE
  }
  private RoomType type;
  private double price;
  private int guests;
  private int maxOccupancy;
  
  public Room(RoomType type, double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Negative price. Please reset!");
    }
    this.type = type;
    this.price = price;
    this.guests = 0;
    switch (type) {
      case SINGLE:
        this.maxOccupancy = 1;
        break;
      case DOUBLE:
        this.maxOccupancy = 2;
        break;
      case FAMILY:
        this.maxOccupancy = 4;
        break;
    }
  }
  public boolean isAvailable() {
    if (guests != 0) {
      return false;
    }
    return true;
  }
  
  public int getNumberOfGuests() {
    return this.guests;
  }
  
  public void bookRoom(int guests) {
    if (isAvailable() && guests > 0 && guests <= maxOccupancy) {
      this.guests = guests;
    }
  }
}
