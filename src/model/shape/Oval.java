package model.shape;


import model.motion.Motion;
import model.shape.Identifier;

/**
 * Represents an Oval shape. Contains AbstractShape's constructor, getColor, addMove, and
 * addChangeColor methods. Oval has a print method which describes the Motions associated
 * with this object and a toString method, which describes this object and its properties.
 */
public class Oval extends AbstractShape {

  public Oval(int red, int green, int blue, String name, double posX, double posY,
              double width, double height, int appears, int disappears) {
    super(red, green, blue, name, posX, posY, width, height, appears, disappears);
  }

  /**
   * Returns a text description of this shape's animation motions and its properties.
   * @return Text description of shape's animations as a String.
   */
  @Override
  public String getMotionToStrings() {
    String returnString = "";
    for (Motion motion: this.listOfMotions) {
      returnString += motion.getString(Identifier.OVAL);
    }
    return returnString;
  }

  /**
   * Returns a text description of this object and its properties.
   * @return Text description of shape as a String.
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\n" +
            "Type: oval\n" +
            "Center: (" + this.posX + "," + this.posY + "), X radius: " + this.width +
            ", Y radius: " + this.height + ", Color: " + this.getColor() + "\n" +
            "Appears at t=" + this.appears + "\n" +
            "Disappears at t=" + this.disappears + "\n";
  }
}
