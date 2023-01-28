package hw2;

/**
 * This is a locker class by passing in maxWidth, maxHeight, and maxDepth.
 * Also passing MailItem class of mailItem.
 */
public class Locker {
  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private MailItem mailItem;
  private boolean availability;
  
  /**
   * This is a constructor for create the dimension constraints of locker.
   * @param maxWidth max width.
   * @param maxHeight max height.
   * @param maxDepth max depth.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) {
    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException("max value should be larger or equal to 1.");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null; // default mailItem created. Set to null: no item inside.
    this.availability = true; // default: true to be available.
  }
  
  public boolean isAvailability() {
    return this.availability;
  }
  /**
   * This is an add mail method.
   * Including some constraints.
   * @param mailItem mail item.
   */
  public void addMail(MailItem mailItem) {
    if (this.mailItem != null || !this.availability) { // was set to null in constructor.
      throw new IllegalArgumentException("Locker not available.");
    }
    if (mailItem.getWidth() > this.maxWidth || mailItem.getHeight() > this.maxHeight
            || mailItem.getDepth() > this.maxDepth) { // exceeds dimension condition.
      throw new IllegalArgumentException("Exceed locker dimension: over maximum.");
    }
    this.mailItem = mailItem;
    this.availability = false;
  }
  
  /**
   * This is a pickUpMail method for checking if mail can be picked up.
   * Setting some constraints by checking if mailItem is empty or not, recipient name fits or not.
   * @param person person of recipient.
   * @return mail item.
   */
  public MailItem pickupMail(Recipient person) {
    if (this.mailItem == null || this.availability || !this.mailItem.getRecipient().equals(person)) {
      return null;
    }
    //if not fulfill condition above, go ahead to let
    MailItem mail = this.mailItem; // assign mail
    this.mailItem = null; // then remove it.
    this.availability = true; // set back to available.
    return mail;
  }
}
