OVERVIEW of Assignment 7 Code:


package modelpack.model;

-IModel is the interface for our Model. It has the ability to add shapes,
 move shapes (that were added to it), change the color of shapes (that 
 were added to it), scale the width and height dimensions of shapes
 (that were added to it), and an Overridden toString() method.

-ModelImpl implements IModel. Internally, it maintains a List<Shape>. 
 (Shape is another user defined class). A Shape must be added to that
 list via addShape method.
 It's toString method first goes through its
 List<Shape> and accumulates each Shape's toString. Then it goes into
 each Shape's List<Motion> and accumulates each Motion's toString.
 The toString method will be slightly different than the example given in
 the assignment 7 page. Instead of representing color from 0.0-1.0, it 
 will be represented from 0-255. Clark said this was ok.


package modelpack.model.shape;

-Shape is the interface for Shape objects. Like IModel, it has methods to
 move shapes, change colors of shapes, and scale the shapes. Thats because
 the Model is actually delegating all of its work to the Shape objects 
 themselves. It has an overridden toString method which describes the
 properties of the modelpack.model.shape object.

-AbstractShape implements Shape. It has the ability to move shapes, 
 change color of shapes, and scale shapes. It also contains a List<Motion>
 to store Motions related to each Shape object.

-Oval extends AbstractShape. It has the method getMotionToStrings which
 gets toStrings of the Motion objects in its List<Motion>. It passes an
 Identifier.OVAL enum as parameter so Motion's getString returns a string
 in the correct format.

-Rectangle extends AbstractShape. It has the method getMotionToStrings 
 which gets toStrings of the Motion objects in its List<Motion>. It passes
 an Identifier.RECTANGLE enum as parameter so Motion's getString returns a 
 string in the correct format.

-Identifier enum is an enum used by Oval and Rectangle to get its Motion's 
 toStrings in the correct format.


package modelpack.model.motion;

-Motion is the interface for Motion objects. It represents that animation
 motions that Shapes can perform, such as moving, changing colors, and 
 scaling dimensions. It has methods to determine if a Motion is of class
 Move, ChangeColor, or Scale via isMove, isChangeColor, and isScale 
 methods.

-AbstractMotion implements Motion. It has getter methods for the start time
 and end time of each Motion. For isMove, isChangeColor, and isScale it 
 returns false.

-Move extends AbstractMotion. It returns true for isMove, and returns a 
 text representation of itself when getString is called.

-ChangeColor extends AbstractMotion. It returns true for isChangeColor,
 and returns a text representation of itself when getString is called.

-Scale extends AbstractMotion. It returns true for isScale, and returns a
 text representation of itself when getString is called. Note that this
 getString method checks the enum object passed to it as parameter and 
 returns different strings depending on the enum.
 