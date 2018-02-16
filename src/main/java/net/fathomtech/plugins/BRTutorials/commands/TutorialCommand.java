package net.fathomtech.plugins.BRTutorials.commands;

public class TutorialCommand implements CommandExecutor {
  
  BRTutorialPlugin plugin = JavaPlugin.forClass(BRTutorialPlugin.class);
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(args.length == 0) {
      if(sender.hasPermission(Permission.ADMIN.NODE) {
        for(String message : InfoMessage.getMessage()) {
          sender.sendMessage(message);
        }
        return true;
      } else {
        // Get the permissions that they have and send a list of the tutorials that they have access to
        sender.sendMessage("~------~ Tutorials ~------~");
        
        String[] tutorialsList;
        
        for(Tutorial tutorial : plugin.getTutorials()) {
          Permission permission = tutorial.getPermission();
          if(sender.hasPermission(permission) || sender.isConsole() || sender.isOp()) {
            tutorialsList.push(tutorial.getName());
          }
        }
        
        String message = "";
        for(int i = 1; i < tutorialsList.length; i++) {
          if(i == tutorialsList.length - 1) {
            message += "and " + tutorialsList[i];
          } else {
            message += (tutorialsList[i] + ", ");
          }
        }
        
        sender.sendMessage(message);
        
        sender.sendMessage("~------~ ~---~---~ ~------~");
        return true;
      }
    } else if(args.length == 1) {
      if(args[0].equalsIgnoreCase("list")) {
        
      } else if(args[0].equalsIgnoreCase("info")) {
        for(String message : InfoMessage.getMessage()) {
          sender.sendMessage(message);
        }
        return true;
      }
    } else if(args.length == 2) {
      
    }
  }
}
