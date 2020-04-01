package model.model;

import model.shape.Shape;

/**
 * This interface represents the model of our MVC and contains operations offered by
 * our animation model.
 */
public interface IModel {

  /**
   * Adds a Shape object (currently only oval and rectangle) to our model.
   * @param shape representing a Shape object.
   */
  void addShape(Shape shape);

  /**
   * Moves the specified shape from its current position to (endPosX,endPosY) from
   * time t=startTick to t=endTick.
   * @param shape the shape being moved.
   * @param endPosX X-coordinate that the shape will end at.
   * @param endPosY Y-coordinate that the shape will end at.
   * @param startTime start time that the shape will start moving at.
   * @param endTime end time that the shape will stop moving at.
   */
  void addMove(Shape shape,  double endPosX, double endPosY, int startTime, int endTime);

  /**
   * Changes the specified shape color from its current color to the specified (red,green,blue)
   * color from time t=startTime to t=endTime.
   * @param shape the shape that is getting its color changed.
   * @param red integer representing intensity of red hue from 0-255.
   * @param green integer representing intensity of green hue from 0-255.
   * @param blue integer representing intensity of blue hue from 0-255.
   * @param startTime start time that the shape will start changing color at.
   * @param endTime end time that the animation will stop changing color at.
   */
  void addChangeColor(Shape shape, int red, int green, int blue, int startTime, int endTime);

  /**
   * Changes the specified shape's left-to-right side (X-radius for oval, width for rectangle)
   * to the specified leftToRightNewDimension and the up-to-down side
   * (Y-radius for oval, height for rectangle) to the specified upToDownNewDimension from time
   * t=startTime to t=endTime.
   * @param shape the shape that is getting its dimensions scaled.
   * @param leftToRightNewDimension new length of the shape's left-to-right side.
   * @param upToDownNewDimension new length of the shape's up-to-down side.
   * @param startTime start time that the shape will start scaling its dimensions at.
   * @param endTime end time that the animation will stop scaling its dimensions at.
   */
  void addScale(Shape shape, double leftToRightNewDimension, double upToDownNewDimension,
                int startTime, int endTime);

  void setBounds(int x, int y, int width, int height);

  /**
   * Returns a text description of the model's shapes and their motions. Specific implementation and
   * more details can be found in ModelImpl class.
   * @return String describing model's shapes and their motions.
   */
  String toString();
}
