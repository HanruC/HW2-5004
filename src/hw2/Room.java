package hw2;

/**
 * This is a class for room.
 * Getting an enum for having different types of room.
 */
public class Room {
  enum RoomType {
    SINGLE, DOUBLE, FAMILY
  }
  
  private final RoomType type;
  // private final double price;
  private int guests;
  private int maxOccupancy;
  
  /**
   * constructor of room.
   * Also, giving different conditions for different types of room.
   * @param type type of room.
   * @param price room price.
   */
  public Room(RoomType type, double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Negative price. Please reset!");
    }
    this.type = type;
    //this.price = price;
    this.guests = 0;
    switch (this.type) {
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
  
  /**
   * Method to check if the room is available.
   * @return true or false.
   */
  public boolean isAvailable() {
    if (guests != 0) {
      return false;
    }
    return true;
  }
  
  /**
   * Getter method for number of guests.
   * @return guests.
   */
  public int getNumberOfGuests() {
    return this.guests;
  }
  
  /**
   * check the room can be booked or not.
   * @param guests guests.
   */
  public void bookRoom(int guests) {
    if (isAvailable() && guests > 0 && guests <= maxOccupancy) {
      this.guests = guests;
    }
  }
}
