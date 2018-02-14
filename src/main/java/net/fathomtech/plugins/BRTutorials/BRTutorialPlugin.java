package net.fathomtech.plugins.BRTutorials;

public class BRTutorialPlugin extends JavaPlugin {
  
  public HashMap<OfflinePlayer, Tutorial> tutorialQueue = new HashMap<OfflinePlayer, Tutorial>();
  public HashMap<String, Tutorial> tutorials = new HashMap<String, Tutorial>();
  
  public Configuration config = new Configuration();
  
  @Override
  public void onEnable() {
    // LOAD CONFIG
    getLogger().info(ChatColor.YELLOW + "Loading configuration...");
    config.loadConfig();
    getLogger().info(ChatColor.GREEN + "Configuration loaded!");
    
    // LOAD TUTORIALS FROM CONFIG
    getLogger().info(ChatColor.YELLOW + "Loading tutorials...");
    tutorials = this.loadTutorials();
    getLogger().info(ChatColor.GREEN + "Tutorials loaded!");
  }
  
  @Override
  public void onDisable() {
    // PLACEHOLDER MESSAGES
    getLogger().info("Checking config for changes...");
    getLogger.info("Unloading data...");
  }
  
  public void reloadConfig() {
    this.getConfig().reload();
    this.loadTutorials();
  }
  
  public void loadTutorials() {
    this.tutorials = this.config.loadTutorials();
  }
}
