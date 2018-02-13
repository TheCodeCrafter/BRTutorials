package net.fathomtech.plugins.BRTutorials.handlers;

public enum Permission {
  Permission(String permission) {
    this.NODE = "brtutorials." + permission;
  }
  
  public String NODE() {
    return this.NODE;
  }
  
  ADMIN("admin"),
  START_TUTORIAL("start"),
  CANCEL_TUTORIAL("cancel")
}
