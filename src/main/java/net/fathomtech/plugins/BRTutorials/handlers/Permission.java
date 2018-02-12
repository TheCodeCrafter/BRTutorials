package net.fathomtech.plugins.BRTutorials.handlers;

public enum Permission {
  Permission(String permission) {
    this.permission = permission;
    return permission;
  }
  
  ADMIN("brtutorials.admin"),
  START_TUTORIAL("brtutorials.start"),
  CANCEL_TUTORIAL("brtutorials.cancel")
}
