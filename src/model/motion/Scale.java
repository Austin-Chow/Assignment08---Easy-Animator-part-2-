package model.motion;

import model.shape.Identifier;

/**
 * Represents a Scale Motion. Scale returns true for isScale method, and has a
 * print method which describes this Motion.
 */
public class Scale extends AbstractMotion {
  private String name;
  private double width;
  private double height;

  private double leftToRightNewDimension;
  private double upToDownNewDimension;

  /**
   * Constructor sets the object's reference variables equal to input parameters.
   * @param name Name of this shape.
   * @param width Current left-to-right length.
   * @param height Current up-to-down length.
   * @param leftToRightNewDimension New left-to-right length.
   * @param upToDownNewDimension New up-to-down length.
   * @param startTime start time for this Motion.
   * @param endTime end time for this Motion.
   */
  public Scale(String name, double width, double height, double leftToRightNewDimension,
               double upToDownNewDimension, int startTime, int endTime) {
    super(startTime, endTime);
    this.name = name;
    this.width = width;
    this.height = height;

    this.leftToRightNewDimension = leftToRightNewDimension;
    this.upToDownNewDimension = upToDownNewDimension;
  }

  /**
   * Returns whether this object is Scale class. Tautologically true.
   * @return always returns true.
   */
  @Override
  public boolean isScale() {
    return true;
  }

  /**
   * Returns text description of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @return Text description of the animation motion and its properties as a String.
   */
  @Override
  public String getString(Identifier identifier) throws IllegalArgumentException {
    if (identifier.equals(Identifier.OVAL)) {
      return "Shape " + this.name + " scales from X radius: " + this.width +
              ", Y radius: " + this.height + " to X radius: " + leftToRightNewDimension +
              ", Y radius: " + upToDownNewDimension + " from t=" + startTime + " to t="
              + endTime + "\n";
    }
    if (identifier.equals(Identifier.RECTANGLE)) {
      return "Shape " + this.name + " scales from Width: " + this.width +
              ", Height: " + this.height + " to Width: " + leftToRightNewDimension +
              ", Height: " + upToDownNewDimension + " from t=" + startTime + " to t="
              + endTime + "\n";
    }
    else {
      throw new IllegalArgumentException("That enum isn't accounted for!");
    }
  }
}
