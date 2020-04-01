import java.io.File;


import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;

public class Main {
  public static void main(String args[]) throws IllegalArgumentException {


    for(int i = 0; i<args.length; i++) {
      boolean passedIn = false;
      boolean passedView = false;
      boolean passedOut = false;
      boolean passedSpeed = false;

      if (args[i].equalsIgnoreCase("-in")) {
        if (passedIn = true) {
          throw new IllegalArgumentException ("Can't use two -in as the command line argument.");
        }
        String txtName = args[i+1];
        File f = new File(txtName);
        System.out.println(txtName);
        i++;
        passedIn = true;
      }

      else if (args[i].equalsIgnoreCase("-cs5004.animator.view")) {
        if (passedView = true) {
          throw new IllegalArgumentException ("Can't use two -cs5004.animator.view as the command line argument.");
        }
        String viewName = args[i+1];
        IView view;
        ViewFactory vf = new ViewFactory();
        view = vf.getInstance(viewName);
        //DO SOMETHING WITH VIEW
        i++;
        passedView = true;
      }

      else if (args[i].equalsIgnoreCase("-out")) {
        if (passedOut = true) {
          throw new IllegalArgumentException ("Can't use two -out as the command line argument.");
        }
        System.out.println(args[i+1]);
        i++;
        passedOut = true;
      }

      else if (args[i].equalsIgnoreCase("-speed")) {
        if (passedSpeed = true) {
          throw new IllegalArgumentException ("Can't use two -speed as the command line argument.");
        }
        System.out.println(args[i+1]);
        i++;
        passedSpeed = true;
      }

      else {
        throw new IllegalArgumentException("That's not a valid -tag");
      }
    }
    //Need to account for if there is no -out or -speed. -In and -View are necessary.


    //File f = new File("Buildings.txt");
    //IModel model = AnimationReader.parseFile(f, new ModelImpl.Builder());
    //IView cs5004.animator.view = new ViewImplText("Part 1: Text Output");
  }
}