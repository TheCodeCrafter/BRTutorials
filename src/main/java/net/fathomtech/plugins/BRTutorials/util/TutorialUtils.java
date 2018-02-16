package net.fathomtech.plugins.BRTutorials.util;

public class TutorialUtils {
  // METHODS
  
  public static Tutorial createTutorial(String name, ConfigurationSection section) {
    String startMessage = section.getString("start");
    String endMessage = section.getString("end");
    
    String prefix = section.getString("prefix");
    String suffix = section.getString("suffix");
    
    Permission permission = new Permission(section.getString("permission"));
    
    Step[] steps;
    
    ConfigurationSection stepSection = section.getConfigurationSection("steps");
    String[] stepNames = ((ArrayList<String>) steps.getKeys(false)).toArray();
    
    for(String stepName : stepNames) {
      
      // MESSAGES AND SOUNDS
      String beginMessage = stepSection.getString(stepName + ".begin.message");
      String beginSound = stepSection.getString(stepName + ".begin.sound");
      
      String failureMessage = stepSection.getString(stepName + ".failure.message");
      String failureSound = stepSection.getString(stepName + ".failure.sound");
      
      String completionMessage = stepSection.getString(stepName + ".completion.message");
      String completionSound = stepSection.getString(stepName + ".completion.sound");
      
      // RETREIVING EVENT VIA REFLECTIONS
      ConfigurationSection eventSection = stepSection.getConfigurationSection(stepName + ".event");
      
      // NOW LET'S GET THE CLASS
      String eventClassName = eventSection.getString("type");
      
      HashMap<String, ConfigurationSection> methods = (HashMap<String, ConfigurationSection>) eventSection.get("arguments.methods");
      ArrayList<Argument> arguments = new ArrayList<Argument>();
      
      for(String argumentName : methods.getKeys()) {
        ConfigurationSection arg = methods.get(argumentName);
        String method = arg.getString("method");
        String value = arg.getString("value");
        
        Argument argument = new Argument(argumentName, method, true, value);
        arguments.add(argument);
      }
      
      int eventTimes = eventSection.getInt("times");
      Event event = new Event(eventClassName, arguments, eventTimes);
      
      // Create our step :D
      Step step = new Step(stepName, beginMessage, failureMessage, completionMessage, beginSound, failureSound, completionSound, event);
      steps.push(step);
    }
    
    // Now finally, we'll create our tutorial.
    Tutorial tutorial = new Tutorial(name, steps, prefix, suffix, startMessage, endMessage, permission);
    return tutorial;
  }
}
