package net.fathomtech.plugins.BRTutorials.handlers;

public class Argument {
  public String name;
  public String child;
  public String value;
  
  public boolean methodBased;
  
  public Argument(String n, String input, boolean isMethod, String v) {
    this.name = n;
    this.child = input;
    this.value = v;
    
    this.methodBased = isMethod;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getChild() {
    return this.child;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean isMethod() {
    return this.methodBased;
  }
}
