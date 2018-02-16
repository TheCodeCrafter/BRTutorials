package net.fathomtech.plugins.BRTutorials.util;

public class TutorialUtils {
  
  BRTutorialPlugin plugin = JavaPlugin.forClass(BRTutorialPlugin.class);
  
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
    
    plugin.addTutorial(tutorial);
    
    return tutorial;
  }
  
  public static void runTutorial(Player player, Tutorial tutorial) {
    if(player == null || tutorial == null) {
      plugin.getLogger().error("An invalid player or tutorial was passed!");
    }
    
    String prefix = "";
    String suffix = "";
    
    // Now let's get the prefix and suffix!
    if(tutorial.getPrefix() !== null) {
      prefix = tutorial.getPrefix();
    }
    
    if(tutorial.getSuffix() !== null) {
      suffix = tutorial.getSuffix();
    }
    
    // Now we need to send the begin message (if it exists)
    if(tutorial.getStartMessage() !== null) {
      player.sendMessage(prefix + tutorial.getStartMessage() + suffix);
    }
    
    // Next, we iterate to the first step of the tutorial, and start it's messages, etc.
    for(int i = 0; i < tutorial.getSteps().length; i++) {
      // First off, let's make a variable for this step;
      Step step = tutorial.getStep(i);
      
      // Now let's get the begin message and sound
      if(step.getBeginMessage() !== null) {
        player.sendMessage(prefix + step.getBeginMessage() + suffix);
      }
      
      // Now let's get the begin sound
      if(step.getBeginSound() !== null) {
        try {
          player.playSound(); // TODO: Add parameters
        } catch(Error e) {
          // If the sound specified in the string technically doesn't exist (mispellings often cause this), then throw an error.
          plugin.getLogger().error("The sound specified in " step.getName() + " (Step " + i " in " + tutorial.getName() + ") does not exist");
          e.printStackTrace();
        }
      }
      
      // Now that we've taken care of some small
    }
  }
}
