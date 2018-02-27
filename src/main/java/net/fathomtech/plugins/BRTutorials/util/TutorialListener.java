package net.fathomtech.plugins.BRTutorials.util;

import java.lang.reflect.Method;
import java.util.logging.Level;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TutorialListener implements Listener {

	private final JavaPlugin plugin;
	private final String expectedValue;
	private final Method method;

	public TutorialListener(JavaPlugin plugin, String expectedValue, String canonicalClassName, String methodName)
			throws Exception {
		this.plugin = plugin;
		this.expectedValue = expectedValue;

		Class<? extends Event> eventClass = Class.forName(canonicalClassName).asSubclass(Event.class);
		method = eventClass.getMethod(methodName);
		
		plugin.getServer().getPluginManager().registerEvent(eventClass, this, EventPriority.MONITOR, (l, e) -> onEvent(e),
				plugin);
	}

	public void onEvent(Event event) {
		try {
			Object eventObject = method.invoke(event);
			if (eventObject != null && expectedValue.equalsIgnoreCase(eventObject.toString())) {
				plugin.getLogger().info("The player has completed this tutorial step!");
			}
		} catch (ReflectiveOperationException e) {
			plugin.getLogger().log(Level.WARNING, "Something went wrong whilst processing the event.", e);
		}
	}
}
