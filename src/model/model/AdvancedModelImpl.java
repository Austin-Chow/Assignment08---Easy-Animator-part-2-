package model.model;

import java.util.HashMap;

public class AdvancedModelImpl extends ModelImpl implements AdvancedIModel {
  HashMap<String, String> hashMapOfIdentifierAndType;

  int x;
  int y;
  int width;
  int height;

  public AdvancedModelImpl() {
    super();
  }

  public void setBounds(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }
}
