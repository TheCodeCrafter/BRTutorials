package net.fathomtech.plugins.BRTutorials.handlers;

public class Event {
  public class EventClass;
  
  ArrayList<Argument> arguments = new ArrayList<Arguments>();
  
  public int eventTimes;
  private int eventCount = 0;
  
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
