package hw2;
import hw2.Room.RoomType;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RoomTest {
  private Room Single;
  private Room Double;
  private Room Family;
  
  @Before
  public void setUp() {
    Single = new Room(RoomType.SINGLE, 100.0);
    Double = new Room(RoomType.DOUBLE, 190.0);
    Family = new Room(RoomType.FAMILY, 350.0);
  }
  
  @Test
  public void testIsAvailable() {
    assertEquals(true, Single.isAvailable());
    Single.bookRoom(1);
    assertEquals(false, Single.isAvailable());
    assertEquals(true, Double.isAvailable());
    Double.bookRoom(2);
    assertEquals(false, Double.isAvailable());
  }
  
  @Test
  public void TestGetNumberOfGuests() {
    Family.bookRoom(3);
    assertEquals(3, Family.getNumberOfGuests());
    Double.bookRoom(2);
    assertEquals(2, Double.getNumberOfGuests());
  }
  
  @Test
  public void TestBookRoom() {
    Double.bookRoom(2);
    assertEquals(2, Double.getNumberOfGuests());
    assertEquals(false, Double.isAvailable());
  }
  
  @Test
  public void TestBookRoom_invalid_check() {
    Family.bookRoom(5); //check the case of invalid guest number.
    assertEquals(0, Family.getNumberOfGuests());
    assertEquals(true, Family.isAvailable());
    
    Double.bookRoom(1); // check the case of invalid availability.
    assertEquals(1, Double.getNumberOfGuests());
    assertEquals(false, Double.isAvailable());
    Double.bookRoom(1);
    assertEquals(1, Double.getNumberOfGuests());
    assertEquals(false, Double.isAvailable());
  }
  
  @Test
  public void testForInvalidPrice() {
    Room Single2 = new Room(RoomType.SINGLE, -100); //Should throw IllegalArgumentException
  }
}