package net.fathomtech.plugins.BRTutorials.commands;

public class TutorialCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(args.length == 0) {
      if(sender.hasPermission(Permission.ADMIN.NODE) {
        for(String message : InfoMessage.getMessage()) {
          sender.sendMessage(message);
        }
      } else {
        // SEND LIST OF TUTORIALS
      }
    }
  }
}
