package net.fathomtech.plugins.BRTutorials.util;

public static class InfoMessage {
  
  BRTutorialPlugin plugin = JavaPlugin.getPluginByClass(BRTutorialPlugin.class);

  public ArrayList<String> getMessage() {
    ArrayList<String> message = new ArrayList<String>();
    
    message.push(ChatColor.ORANGE + "~-------=+=------~");
    message.push(ChatColor.PURPLE + "" + ChatColor.BOLD + "Plugin: " + ChatColor.GOLD + "" + ChatColor.BOLD + " " + plugin.getDescription().getName());
    message.push(ChatColor.PURPLE + "" + ChatColor.BOLD + "Version: " + ChatColor.GOLD + "" + ChatColor.BOLD + " " + plugin.getDescription().getVersion());
    message.push(ChatColor.PURPLE + "" + ChatColor.BOLD + "Author: " + ChatColor.GOLD + "" + ChatColor.BOLD + " " + plugin.getDescription().getAuthor());
    message.push(ChatColor.ORANGE + "~-------=+=------~");
    
    return message;
  }
}
