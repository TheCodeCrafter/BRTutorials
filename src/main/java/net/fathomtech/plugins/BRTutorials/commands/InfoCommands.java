package net.fathomtech.plugins.BRTutorials.commands;

public class InfoCommands implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender.hasPermission(Permission.ADMIN.NODE) {
      for(String message : InfoMessage.getMessage()) {
        sender.sendMessage(message);
        return true;
      }
    } else {
      return false;
    }
  }
}
