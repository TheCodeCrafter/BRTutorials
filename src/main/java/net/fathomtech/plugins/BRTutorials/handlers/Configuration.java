package net.fathomtech.plugins.BRTutorials.handlers;

public class Configuration {

  // Plugin Class
  private BRTutorialPlugin plugin = JavaPlugin.getPluginByClass(BRTutorialPlugin.class);
  
  ///////////////////
  // CONFIGURATION //
  ///////////////////
  
  //// Tutorials
  public static ArrayList<Tutorial> TUTORIALS = new ArrayList<Tutorial>();
  
  //// Main Settings
  public static boolean ENABLED = false;
  
  // Logging
  public static boolean LOGGING = true;
  public static boolean LOGFILE = false;
  public static LogLevel LOGLEVEL = 0;
  
  // Permissions
  public static boolean PERMISSIONS = true;
  
  // Custom Events
  public static boolean CUSTOMEVENTS = false;
  public static boolean CUSTOMDEBUG = true;
  
  /////////////////////
  // PARSING METHODS //
  /////////////////////
  
  public LogLevel IntToLogLevel(int level) {
    if(level >= 4) {
      return LogLevel.DEBUG;
    } else if(level == 3) {
      return LogLevel.HEAVY;
    } else if(level == 2) {
    return LogLevel.MEDIUM;
    } else if(level == 1) {
      return LogLevel.LIGHT;
    } else {
      return LogLevel.NONE;
    }
  }
  
  public saveConfig() {
    plugin.saveConfig();
  }
  
  public static void loadConfig() {
    for(String tutorial : plugin.getConfig().getConfigurationSection("tutorials").getKeys(false)) {
      TUTORIALS.push(TutorialUtils.parseString(tutorial));
    }
    
    ENABLED = plugin.getConfig().getBoolean("enabled");
    
    LOGGING = plugin.getConfig().getBoolean("logging.enabled");
    LOGFILE = plugin.getConfig().getBoolean("logging.file");
    LOGLEVEL = IntToLogLevel(plugin.getConfig().getInteger("logging.level"));
    
    PERMISSIONS = plugin.getConfig().getBoolean("permissions");
    
    CUSTOMEVENTS = plugin.getConfig().getBoolean("customEvents.enabled");
    CUSTOMDEBUG = plugin.getConfig().getBoolean("customEvents.debug");
  }
}
