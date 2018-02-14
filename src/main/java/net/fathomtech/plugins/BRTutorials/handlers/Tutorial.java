package net.fathomtech.plugins.BRTutorials.handlers;

public class Tutorial {
  public String name;
  
  public Step[] steps;
  public int stepCount;
  
  public String prefix;
  public String suffix;
  
  public String startMessage;
  public String endMessage;
  
  public Permission permission;
  
  public Tutorial(String n, Step[] s, String pre, String suf, String sMessage, String eMessage, Permission perm) {
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
  
  public Step[] getSteps() {
    return this.steps;
  }
  
  pubic Step getStep(int number) {
    return this.steps[number];
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
  
  public void setStep(index, Step newStep) {
    this.steps[index] = newStep;
    this.stepCount = steps.length;
  }
  
  public void setPrefix(String newPrefix) {
    this.prefix = newPrefix;
  }
  
  public void setSuffix(String newSuffix) {
    this.suffix = newSuffix;
  }
  
  public void setStartMessage(String newMessage) {
    this.startMessage = newMessage;
  }
  
  public void setEndMessage(String newMessage) {
    this.endMessage = newMessage;
  }
}
