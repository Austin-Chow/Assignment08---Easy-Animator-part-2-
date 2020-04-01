package cs5004.animator.view;

public class ViewFactory {

  public IView getInstance(String viewName) throws IllegalArgumentException {
    IView view;
    if (viewName.equalsIgnoreCase("text")) {
      view = new ViewImplText("TextView");
    }
    else if (viewName.equalsIgnoreCase("visual")) {
      view = new ViewImplGUI("VisualView");
    }
    else if (viewName.equalsIgnoreCase("svg")) {
      view = new ViewImplSVG("SVGView");
    }
    else {
      throw new IllegalArgumentException("That's not a valid cs5004.animator.view!!!");
    }
    return view;
  }
}
