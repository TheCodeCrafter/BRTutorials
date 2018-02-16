package net.fathomtech.plugins.BRTutorials.commands;

public class TutorialCommand implements CommandExecutor {
  
  BRTutorialPlugin plugin = JavaPlugin.forClass(BRTutorialPlugin.class);
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(args.length == 0) {
      if(sender.hasPermission(Permission.ADMIN.NODE) || sender.isOp()) {
        sendInfoMessage(sender);
        return true;
      } else {
        sendTutorialsList(sender);
        return true;
      }
    } else if(args.length == 1) {
      if(args[0].equalsIgnoreCase("info")) {
        sendInfoMessage(sender);
        return true;
      } else if(args[0].equalsIgnoreCase("list")) {
        sendTutorialsList(sender);
        return true;
      } else {
        // Since they didn't name a command, we'll assume that they've named a tutorial they want to do.
        if(!(sender instanceof Player)) {
          sender.sendMessage("You must be a player to run a tutorial!");
          return true;
        }
        
        Player player = (Player) sender;
        
        Tutorial tutorial = plugin.getTutorial(args[0]);
        if(tutorial == null) {
          // The tutorial wasn't found in the tutorials list, which means either the plugin has an error or they mispelled something.
          if(player.isOp() || player.hasPermission(Permission.ADMIN.NODE)) {
            player.sendMessage("That tutorial is not defined! Check for mispellings in the config.yml!");
          } else {
            player.sendMessage("That tutorial is not defined! Check for mispellings in your command!");
          }
        }
        
        plugin.startTutorial(player, tutorial);
        return true;
      }
    } else if(args.length == 2) {
      
    }
  }
  
  ///////////////////
  // HELPER METHODS//
  ///////////////////
  
  private void sendInfoMessage(CommandSender sender) {
    for(String message : InfoMessage.getMessage()) {
      sender.sendMessage(message);
    }
  }
  
  private void sendTutorialsList(CommandSender sender) {
    // Get the permissions that they have and send a list of the tutorials that they have access to
    sender.sendMessage("~------~ Tutorials ~------~");

    String[] tutorialsList;

    for(Tutorial tutorial : plugin.getTutorials()) {
      Permission permission = tutorial.getPermission();
      if(sender.hasPermission(permission)) {
        tutorialsList.push(tutorial.getName());
      }
    }

    String message = "";
    for(int i = 1; i < tutorialsList.length; i++) {
      if(i == (tutorialsList.length - 1)) {
        message += "and " + tutorialsList[i];
      } else {
        message += tutorialsList[i] + ", ";
      }
    }

    sender.sendMessage(message);

    sender.sendMessage("~------~ ~---~---~ ~------~");
  }
}
