package model.shape;

import java.util.ArrayList;
import java.util.List;

import model.motion.ChangeColor;
import model.motion.Motion;
import model.motion.Move;
import model.motion.Scale;

/**
 * AbstractShape contains data common to all Shape objects. It contains a getColor, addMove,
 * addChangeColor method.
 */
public abstract class AbstractShape implements Shape {
  List<Motion> listOfMotions;
  int red;
  int green;
  int blue;

  String name;

  double posX;
  double posY;
  double width;
  double height;
  int appears;
  int disappears;

  /**
   * AbstractShape constructor checks if any parameter values are illegal values, and throws IAE
   * if they are. Red, green, blue are integers from 0 to 255. Name is the name of this shape.
   * posX and posY describes a specific point on the shape (like center for oval). Width and height
   * are the width and height of this shape. Appears is the time at which the shape appears, and
   * disappears is the time at which the shape disappears.
   * @param red Red hue value of this shape.
   * @param green Green hue value of this shape.
   * @param blue Blue hue value of this shape.
   * @param name Name of this shape.
   * @param posX Position X of this shape.
   * @param posY Position Y of this shape.
   * @param width Width of this shape.
   * @param height Height of this shape.
   * @param appears Time at which this shape appears.
   * @param disappears Time at which this shape disappears.
   * @throws IllegalArgumentException if red, green, or blue are either less than 0, or greater
   *     than 255, or if width or height is less than or equal to 0, or if appears time value is
   *     greater than disappears time value.
   */
  public AbstractShape(int red, int green, int blue, String name, double posX, double posY,
                       double width, double height, int appears, int disappears)
                       throws IllegalArgumentException {
    if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Make sure your colors are between 0 and 255.");
    }
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException("Make sure height and width are greater than 0.");
    }
    if (appears < 0) {
      throw new IllegalArgumentException("Make sure appears is 0 or greater.");
    }
    if (appears > disappears) {
      throw new IllegalArgumentException("Make sure disappear time comes after appear time.");
    }
    this.listOfMotions = new ArrayList<Motion>();
    this.red = red;
    this.green = green;
    this.blue = blue;

    this.name = name;

    this.posX = posX;
    this.posY = posY;
    this.width = width;
    this.height = height;
    this.appears = appears;
    this.disappears = disappears;
  }

  /*
  public AbstractShape() {
    this.listOfMotions = new ArrayList<Motion>();
    this.red = 0;
    this.green = 0;
    this.blue = 0;

    this.name = "";

    this.posX = 0;
    this.posY = 0;
    this.width = 1;
    this.height = 1;
    this.appears = 0;
    this.disappears = 1;
  }
   */

  /**
   * Getter method for the shape's color in string format. Hues range from 0 to 255.
   * @return returns the shape's color in (red,green,blue) format.
   */
  @Override
  public String getColor() {
    return "(" + this.red + "," + this.green + "," + this.blue + ")";
  }

  /**
   * Adds a Motion object to our List of Motions. Motion object contains information about where
   * the end X and end Y coordinates will be at, as well as its start time and end time information.
   * @param endPosX X coordinate the shape will move to.
   * @param endPosY Y coordinate the shape will move to.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   * @throws IllegalArgumentException if startTime is greater than or equal to endTime, if startTime
   *     is less than this shape's appears time, and if endTime is greater than this shape's
   *     disappear time.
   */
  @Override
  public void addMove(double endPosX, double endPosY, int startTime, int endTime)
          throws IllegalArgumentException {
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }
    if (startTime < this.appears) {
      throw new IllegalArgumentException("StartTime can't be before this object appears");
    }
    if (endTime > this.disappears) {
      throw new IllegalArgumentException("EndTime can't be after this object disappears");
    }

    Motion newMove = new Move(this.name, this.posX, this.posY, endPosX, endPosY,
            startTime, endTime);
    for (int i = 0; i < this.listOfMotions.size(); i++) {
      if (this.listOfMotions.get(i).isMove()) {
        Motion temp = this.listOfMotions.get(i);
        if (startTime >= temp.getStartTime() && startTime < temp.getEndTime()) {
          throw new IllegalArgumentException("Trying to do addMove, but it overlaps with " +
                  "another move's times. (1)");
        }
        if (temp.getStartTime() >= startTime && temp.getStartTime() < endTime) {
          throw new IllegalArgumentException("Trying to do addMove, but it overlaps with " +
                  "another move's times. (2)");
        }
      }
    }
    this.listOfMotions.add(newMove);
    this.posX = endPosX;
    this.posY = endPosY;
  }

  /**
   * Adds a Motion object to our List of Motions. Motion object contains information about the new
   * red hue, green hue, and blue hue, as well as its start time and end time information.
   * @param newRed The red hue value of our new color.
   * @param newGreen The green hue value of our new color.
   * @param newBlue The blue hue value of our new color.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   * @throws IllegalArgumentException if the new red, new green or new blue are greater than 255,
   *     or less than 0, or if startTime is greater than or equal to endTime, or if startTime is
   *     less than this shape's appears time, or if endTime is greater than this shape's disappears
   *     time.
   */
  @Override
  public void addChangeColor(int newRed, int newGreen, int newBlue, int startTime, int endTime)
          throws IllegalArgumentException {
    if (newRed > 255 || newRed < 0 || newGreen > 255 || newGreen < 0 ||
            newBlue > 255 || newBlue < 0) {
      throw new IllegalArgumentException("Make sure your colors are between 0 and 255.");
    }
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }
    if (startTime < this.appears) {
      throw new IllegalArgumentException("StartTime can't be before this object appears");
    }
    if (endTime > this.disappears) {
      throw new IllegalArgumentException("EndTime can't be after this object disappears");
    }

    Motion newColor = new ChangeColor(this.name, this.red, this.green, this.blue, newRed, newGreen,
            newBlue, startTime, endTime);
    for (int i = 0; i < this.listOfMotions.size(); i++) {
      if (this.listOfMotions.get(i).isChangeColor()) {
        Motion temp = this.listOfMotions.get(i);
        if (startTime >= temp.getStartTime() && startTime < temp.getEndTime()) {
          throw new IllegalArgumentException("Trying to do addChangeColor, but it overlaps with" +
                  " another move's times. (1)");
        }
        if (temp.getStartTime() >= startTime && temp.getStartTime() < endTime) {
          throw new IllegalArgumentException("Trying to do addChangeColor, but it overlaps with " +
                  "another move's times. (2)");
        }
      }
    }
    this.listOfMotions.add(newColor);

    this.red = newRed;
    this.green = newGreen;
    this.blue = newBlue;
  }

  /**
   * Adds a Motion object to our List of Motions. Motion object contains information about the new
   * left-to-right dimension, new up-to-down dimension, as well as its start time and end time
   * information.
   * @param leftToRightNewDimension The new length of our left-to-right dimension.
   * @param upToDownNewDimension The new length of our up-to-down dimension.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   * @throws IllegalArgumentException if startTime is greater or equal to endTime, if startTime is
   *     less than this shape's appears time, if endTime is greater than this shape's disappears
   *     time.
   */
  @Override
  public void addScale(double leftToRightNewDimension, double upToDownNewDimension,  int startTime,
                       int endTime) throws IllegalArgumentException {
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }
    if (startTime < this.appears) {
      throw new IllegalArgumentException("StartTime can't be before this object appears");
    }
    if (endTime > this.disappears) {
      throw new IllegalArgumentException("EndTime can't be after this object disappears");
    }

    Motion newScale = new Scale(this.name, this.width, this.height, leftToRightNewDimension,
            upToDownNewDimension, startTime, endTime);
    for (int i = 0; i < this.listOfMotions.size(); i++) {
      if (this.listOfMotions.get(i).isScale()) {
        Motion temp = this.listOfMotions.get(i);
        if (startTime >= temp.getStartTime() && startTime < temp.getEndTime()) {
          throw new IllegalArgumentException("Trying to do addScale, but it overlaps with " +
                  "another move's times. (1)");
        }
        if (temp.getStartTime() >= startTime && temp.getStartTime() < endTime) {
          throw new IllegalArgumentException("Trying to do addScale, but it overlaps with " +
                  "another move's times. (2)");
        }
      }
    }
    this.listOfMotions.add(newScale);

    this.width = leftToRightNewDimension;
    this.height = upToDownNewDimension;
  }
}
