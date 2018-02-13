package net.fathomtech.plugins.BRTutorials.handlers;

public class Tutorial {
  public String name;
  
  public ArrayList<Step> steps;
  public int stepCount;
  
  public String prefix;
  public String suffix;
  
  public String startMessage;
  public String endMessage;
  
  public Permission permission;
  
  public Tutorial(String n, ArrayList<Step> s, String pre, String suf, String sMessage, String eMessage, Permission perm) {
    name = n;
    steps = s;
    stepCount = s.length;
    prefix = pre;
    suffix = suf;
    startMessage = sMessage;
    endMessage = eMessage;
    
    if(perm == null) {
      permission = Permission.START.NODE;
    } else {
      permission = perm;
    }
  }
  
  // GETTERS
  public String getName() {
    return this.name;
  }
  
  public ArrayList<Steps> getSteps() {
    return this.steps;
  }
  
  public int getStepCount() {
    return this.stepCount;
  }
  
  public String getPrefix() {
    return this.prefix;
  }
  
  public String getSuffix() {
    return this.suffix;
  }
  
  public String getStartMessage() {
    return this.startMessage;
  }
  
  public String getEndMessage() {
    return this.endMessage;
  }
  
  // SETTERS
  
  public void setName(String newName) {
    this.name = newName;
  }
}
