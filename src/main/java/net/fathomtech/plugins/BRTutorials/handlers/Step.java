package net.fathomtech.plugins.BRTutorials.handlers;

public class Step {
  public String name;
  
  public String beginMessage;
  public String failureMessage;
  public String completionMessage;
  
  public String beginSound;
  public String failureSound;
  public String completionSound;
  
  public Event event;
  
  public Tutorial tutorial;
  
  public Step(String n, String bMessage, String fMessage, String cMessage, String bSound, String fSound, String cSound, Event e) {
    this.name = n;
    
    this.beginMessage = bMessage;
    this.failureMessage = fMessage;
    this.completionMessage = bMessage;
    
    this.beginSound = bSound;
    this.failureSound = fSound;
    this.completionSound = cSound;
    
    this.event = e;
  }
  
  // GETTERS
  
  public String getName() {
    return this.name;
  }
  
  public String getBeginMessage() {
    return this.beginMessage;
  }
  
  public String getFailureMessage() {
    return this.failureMessage;
  }
  
  public String getCompletionMessage() {
    return this.completionMessage;
  }
  
  public String getBeginSound() {
    return this.beginSound;
  }
  
  public String getFailureSound() {
    return this.failureSound;
  }
  
  public String getCompletionSound() {
    return this.completionSound;
  }
  
  public Event getEvent() {
    return this.event;
  }
  
  public Tutorial getTutorial() {
    if(this.tutorial !== null) {
      return this.tutorial; 
    } else {
      throw new Error("The tutorial for event " + this.getName() + " has not been set!");
    }
  }
  
  // SETTERS
  
  public void setName(String newName) {
    this.name = newName; 
  }
  
  public void setBeginMessage(String newMessage) {
    this.beginMessage = newMessage; 
  }
  
  public void setFailureMessage(String newMessage) {
    this.failureMessage = newMessage; 
  }
  
  public void setCompletionMessage(String newMessage) {
    this.completionMessage = newMessage;
  }
  
  public void setBeginSound(String newSound) {
    this.beginSound = newSound;
  }
  
  public void setFailureSound(String newSound) {
    this.failureSound = newSound;
  }
  
  public void setCompletionSound(String newSound) {
    this.completionSound = newSound;
  }
  
  public void setEvent(Event newEvent) {
    this.event = newEvent;
  }
  
  public void setTutorial(Tutorial tutorial) {
    this.tutorial = tutorial;
  }
}
