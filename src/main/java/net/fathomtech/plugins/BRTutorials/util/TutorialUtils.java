package net.fathomtech.plugins.BRTutorials.util;

public class TutorialUtils {
  // METHODS
  
  public static Tutorial createTutorial(String name, ConfigurationSection section) {
    String startMessage = section.getString("start");
    String endMessage = section.getString("end");
    
    Permission permission = new Permission(section.getString("permission"));
    
    ConfigurationSection steps = section.getConfigurationSection("steps");
    String[] stepNames = ((ArrayList<String>) steps.getKeys(false)).toArray();
    
    for(String stepName : stepNames) {
      
      // MESSAGES AND SOUNDS
      String beginMessage = steps.getString(stepName + ".begin.message");
      String beginSound = steps.getString(stepName + ".begin.sound");
      
      String failureMessage = steps.getString(stepName + ".failure.message");
      String failureSound = steps.getString(stepName + ".failure.sound");
      
      String completionMessage = steps.getString(stepName + ".completion.message");
      String completionSound = steps.getString(stepName + ".completion.sound");
      
      // RETREIVING EVENT VIA REFLECTIONS
      ConfigurationSection eventSection = steps.getConfigurationSection(stepName + ".event");
      
      String eventType = eventSection.getString("type");
      Class EventClass = Class.forName(eventType);
    }
  }
}
