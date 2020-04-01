package model.motion;

import model.shape.Identifier;

/**
 * This interface represents the animation Motion associated with each Shape.
 */
public interface Motion {

  /**
   * Getter method for the Motion's start time.
   * @return Motion's start time.
   */
  int getStartTime();

  /**
   * Getter method for the Motion's end time.
   * @return Motion's end time.
   */
  int getEndTime();

  /**
   * Returns whether the Motion's class is Move.
   * @return boolean true if Motion's class is Move.
   */
  boolean isMove();

  /**
   * Returns whether the Motion's class is ChangeColor.
   * @return boolean true if Motion's class is ChangeColor.
   */
  boolean isChangeColor();

  /**
   * Returns whether the Motion's class is Scale.
   * @return boolean true if Motion's class is Scale.
   */
  boolean isScale();

  /**
   * Returns text description of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @return Text description of the animation motion and its properties as a String.
   */
  String getString(Identifier identifier);
}
