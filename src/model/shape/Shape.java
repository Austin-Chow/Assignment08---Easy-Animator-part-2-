package model.shape;

/**
 * This interface represents a Shape object. Shapes are manipulated to create an animation.
 */
public interface Shape {

  /**
   * Getter method for the shape's color in string format.
   * @return Shape's color,
   */
  String getColor();

  /**
   * Moves this shape. Contains information about where its end X and end Y coordinates will be at,
   * as well as its start time and end time information.
   * @param endPosX X coordinate the shape will move to.
   * @param endPosY Y coordinate the shape will move to.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   */
  void addMove(double endPosX, double endPosY, int startTime, int endTime);

  /**
   * Changes this shape's color. Contains information about what the new red, new green and new
   * blue colors will be, as well as its start time and end time information.
   * @param newRed The red hue value of our new color.
   * @param newGreen The green hue value of our new color.
   * @param newBlue The blue hue value of our new color.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   */
  void addChangeColor(int newRed, int newGreen, int newBlue, int startTime, int endTime);

  /**
   * Changes this shape's dimensions. Contains information about what the new left-to-right
   * dimension and up-to-down dimension will be as well as its start time and end time information.
   * @param leftToRightNewDimension The new length of our left-to-right dimension.
   * @param upToDownNewDimension The new length of our up-to-down dimension.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   */
  void addScale(double leftToRightNewDimension, double upToDownNewDimension,
                int startTime, int endTime);

  /**
   * Returns a string containing information relevant to operations that change the shape.
   * @return String representing information relevant to operations that change the shape.
   */
  String getMotionToStrings();

  /**
   * Returns a text description of this object and its properties.
   * @return Text description of shape as a String.
   */
  String toString();
}

