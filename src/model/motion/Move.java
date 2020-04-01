package model.motion;

import model.shape.Identifier;

/**
 * Represents a Move Motion. Move returns true for isMove method, and has a
 * print method which describes this Motion.
 */
public class Move extends AbstractMotion {
  private String name;
  private double startX;
  private double startY;
  private double endPosX;
  private double endPosY;

  /**
   * Constructor sets the object's reference variables equal to input parameters.
   * @param name Name of this shape.
   * @param startX start X coordinate
   * @param startY start Y coordinate
   * @param endPosX end X coordinate
   * @param endPosY end Y coordinate
   * @param startTime start time for this Motion.
   * @param endTime end time for this Motion.
   */
  public Move(String name, double startX, double startY, double endPosX, double endPosY,
              int startTime, int endTime) {
    super(startTime, endTime);
    this.name = name;
    this.startX = startX;
    this.startY = startY;
    this.endPosX = endPosX;
    this.endPosY = endPosY;
  }

  /**
   * Returns whether this object is Move class. Tautologically true.
   * @return always returns true.
   */
  @Override
  public boolean isMove() {
    return true;
  }

  /**
   * Returns text description of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @return Text description of the animation motion and its properties as a String.
   */
  @Override
  public String getString(Identifier identifier) {
    return "Shape " + this.name + " moves from (" + this.startX + "," +
            this.startY + ") to (" + this.endPosX + "," + this.endPosY + ") from t="
            + this.startTime + " to t=" + this.endTime + "\n";
  }
}