import org.junit.Test;

import model.model.IModel;
import model.model.ModelImpl;
import model.shape.Oval;
import model.shape.Rectangle;
import model.shape.Shape;

import static org.junit.Assert.assertEquals;

/**
 * Test class for ModelImpl.
 */
public class TestModel {

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersRed() {
    Shape rect = new Rectangle(-1,0,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersRed2() {
    Shape rect = new Rectangle(256,0,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersGreen() {
    Shape rect = new Rectangle(0,-1,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersGreen2() {
    Shape rect = new Rectangle(0,256,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersBlue() {
    Shape rect = new Rectangle(0,0,-1, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersBlue2() {
    Shape rect = new Rectangle(0,0, 256, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersWidth() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, -1, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersWidth2() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 0, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersHeight() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, -1, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersHeight2() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 0, 20, 50);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersAppears() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 10, -1, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersAppears2() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 10, 51, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersDisappears() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 10, 20, 10);
  }

  @Test
  public void testAddShape() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    Shape oval = new Oval(0,0,0, "O", 100, 100, 5, 5, 0, 100);
    model.addShape(rect);
    model.addShape(oval);
    assertEquals(model.toString(), "Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,250.0), Width: 10.0, Height: 10.0, Color: (255,0,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Center: (100.0,100.0), X radius: 5.0, Y radius: 5.0, Color: (0,0,0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAlreadyExists() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addShape(rect);
    model.addShape(rect);
  }

  @Test
  public void testAddMoveSuccess() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addShape(rect);
    model.addMove(rect,200, 400, 30, 40);
    model.addMove(rect, 300,300,40,50);
    assertEquals(model.toString(), "Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (300.0,300.0), Width: 10.0, Height: 10.0, Color: (255,0,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Shape R moves from (200.0,250.0) to (200.0,400.0) from time t=30 to t=40\n" +
            "Shape R moves from (200.0,400.0) to (300.0,300.0) from time t=40 to t=50\n");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveShapeNotAddedToModelImpl() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove(rect,200, 400, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveStartTimeEndTimeFails() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove(rect,200, 400, 50, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsShapeAppears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove(rect,200, 400, 10, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsShapeDisappears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove(rect,200, 400, 30, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsAddMove() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove(rect,200, 400, 30, 40);
    model.addMove(rect,200, 400, 25, 35);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsAddMove2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove(rect,200, 400, 25, 35);
    model.addMove(rect,200, 400, 30, 40);
  }

  @Test
  public void testAddChangeColorSuccess() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addShape(rect);
    model.addChangeColor(rect,0, 255,0, 30, 40);
    model.addChangeColor(rect, 0,0,255,40,50);
    assertEquals(model.toString(), "Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,250.0), Width: 10.0, Height: 10.0, Color: (0,0,255)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Shape R changes color from (255,0,0) to (0,255,0) from time t=30 to t=40\n" +
            "Shape R changes color from (0,255,0) to (0,0,255) from time t=40 to t=50\n");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorBadColors() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor(rect,0, 256,0, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorBadColors2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor(rect,0, -1,0, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorTimeEndTimeFails() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor(rect,0, 0,255, 50, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsShapeAppears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor(rect,0,0,255,10, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsShapeDisappears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor(rect,0,0,255, 30, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsAddChangeColor() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor(rect,0,0,255, 30, 40);
    model.addChangeColor(rect,0,0,255, 25, 35);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsAddChangeColor2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor(rect,0,0,255, 25, 35);
    model.addChangeColor(rect,0,0,255, 30, 40);
  }

  @Test
  public void testAddScaleRectangleSuccess() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addShape(rect);
    model.addScale(rect,20, 40, 30, 40);
    model.addScale(rect, 30,30,40,50);
    assertEquals(model.toString(), "Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,250.0), Width: 30.0, Height: 30.0, Color: (255,0,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Shape R scales from Width: 10.0, Height: 10.0 to Width: 20.0, Height: 40.0 from time" +
            " t=30 to t=40\n" +
            "Shape R scales from Width: 20.0, Height: 40.0 to Width: 30.0, Height: 30.0 from time" +
            " t=40 to t=50\n");
  }

  @Test
  public void testAddScaleOvalSuccess() {
    IModel model = new ModelImpl();
    Shape oval = new Oval(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addShape(oval);
    model.addScale(oval,20, 40, 30, 40);
    model.addScale(oval, 30,30,40,50);
    assertEquals(model.toString(), "Shapes: \n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Center: (200.0,250.0), X radius: 30.0, Y radius: 30.0, Color: (255,0,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Shape O scales from X radius: 10.0, Y radius: 10.0 to X radius: 20.0, Y radius: 40.0" +
            " from time t=30 to t=40\n" +
            "Shape O scales from X radius: 20.0, Y radius: 40.0 to X radius: 30.0, Y radius: 30.0" +
            " from time t=40 to t=50\n");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleNotAddedToModelImpl() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale(rect,20, 40, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleTimeEndTimeFails() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale(rect,20, 40, 50, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsShapeAppears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale(rect,20, 40, 10, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsShapeDisappears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale(rect,200, 400, 30, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsAddScale() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale(rect,20, 40, 30, 40);
    model.addScale(rect,20, 40, 25, 35);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsAddScale2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale(rect,20, 40, 25, 35);
    model.addScale(rect,20, 40, 30, 40);
  }

  @Test
  public void testManyAdditions() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    Shape oval = new Oval(0,0,0, "O", 100, 100, 5, 5, 0, 100);
    model.addShape(rect);
    model.addShape(oval);

    model.addChangeColor(rect,0, 0, 255, 20,50);
    model.addMove(oval,200, 400, 30, 40);
    model.addScale(rect, 10, 50, 25, 40);
    model.addMove(rect,200, 400, 30, 40);
    model.addMove(rect,420, 420, 40, 50);
    model.addMove(rect, 400,400,20, 30);
    model.addScale(oval, 10,10,25, 50);
    assertEquals(model.toString(), "Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (400.0,400.0), Width: 10.0, Height: 50.0, Color: (0,0,255)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Center: (200.0,400.0), X radius: 10.0, Y radius: 10.0, Color: (0,0,0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R changes color from (255,0,0) to (0,0,255) from time t=20 to t=50\n" +
            "Shape R scales from Width: 10.0, Height: 10.0 to Width: 10.0, Height: 50.0 from" +
            " time t=25 to t=40\n" +
            "Shape R moves from (200.0,250.0) to (200.0,400.0) from time t=30 to t=40\n" +
            "Shape R moves from (200.0,400.0) to (420.0,420.0) from time t=40 to t=50\n" +
            "Shape R moves from (420.0,420.0) to (400.0,400.0) from time t=20 to t=30\n" +
            "Shape O moves from (100.0,100.0) to (200.0,400.0) from time t=30 to t=40\n" +
            "Shape O scales from X radius: 5.0, Y radius: 5.0 to X radius: 10.0, Y radius:" +
            " 10.0 from time t=25 to t=50\n");
  }
}