package net.fathomtech.plugins.BRTutorials.handlers;

public class Event {
  public Class<?> EventClass;
  
  ArrayList<Argument> arguments = new ArrayList<Arguments>();
  
  public int eventTimes;
  private int eventCount = 0;
  
  public boolean isDone = false;
  
  public Event(String eventClass, ArrayList<Argument> args, int eTimes) {
    this.EventClass = Class.forName(eventClass);
    
    if(this.EventClass == null) {
      this.EventClass = net.fathomtech.plugins.BRTutorials.events.NoEvent;
    }
    
    this.arguments = args;
    
    if(eTimes == null || eTimes < 1) {
      this.eventTimes = 1;
    } else {
      this.eventTimes = eTimes;
    }
  }
  
  // METHODS
  public void startListening() {
    // Activate the event's handler.
    this.runEvent -> {
      // Now here we are going to look for the variables and setup argument handlers.
      // I need to figure out how to run special methods on "eventHandler" that are defined via string. For instance, event.getType() (which you could use in a GUI listener, etc) would be something that you would check for.
    }
  }
  
  public void stopListening() {
    // Deactivate the event's handler.
  }
  
  // Object eventHandler = this.EventClass.newInstance(); ?? Reference: https://docs.oracle.com/javase/tutorial/reflect/member/methodInvocation.html
  private void runEvent(this.EventClass eventHandler) {
    // Placeholder function that's used for deactivation and activation.
  }
  
  // GETTERS
  
  public class getEventClass() {
    return this.EventClass;
  }
  
  public HashMap<String, String> getArguments() {
    return this.arguments;
  }
  
  public String getArgument(String name) {
    return this.arguements.get(name);
  }
  
  public int getEventTimes() {
     return this.eventTimes;
  }
  
  public int getEventCount() {
    return this.eventCount;
  }
  
  // SETTERS
  
  public void setEventClass(class newEventClass) {
    this.EventClass = newEventClass;
  }
  
  public void setArguments(ArrayList<Argument> newArguments) {
    this.arguments = newArguments;
  }
  
  public void addArgument(Argument argument) {
    this.arguments.add(argument);
  }
  
  public void setEventTimes(int newEventTimes) {
    this.eventTimes = newEventTimes;
  }
  
  public void setEventCount(int newEventCount) {
    this.eventCount = newEventCount;
  }
  
  public void incrementEventCount() {
    this.eventCount++;
  }
  
  public void decreaseEventCount() {
    this.eventCount--;
  }
}
