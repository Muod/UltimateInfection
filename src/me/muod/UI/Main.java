package me.muod.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main instance = new Main();
	public UICommands CommandExectutor;
	public UIListener playerListener;
    @Override
    public void onEnable() {
    	final FileConfiguration config = this.getConfig();
    	config.addDefault("Version.Number", Double.valueOf(0));
    	config.addDefault("Locations.Humans.X", Double.valueOf(0));
    	config.addDefault("Locations.Humans.Y", Double.valueOf(0));
    	config.addDefault("Locations.Humans.Z", Double.valueOf(0));
    	config.addDefault("Locations.Humans.World", String.valueOf("world"));
    	config.addDefault("Locations.Zombies.X", Double.valueOf(0));
    	config.addDefault("Locations.Zombies.Y", Double.valueOf(0));
    	config.addDefault("Locations.Zombies.Z", Double.valueOf(0));
    	config.addDefault("Locations.Zombies.World", String.valueOf("world"));
    	config.addDefault("Players.Max", Integer.valueOf(0));
    	config.addDefault("Players.Min", Integer.valueOf(0));
    	config.addDefault("Players.Max", Integer.valueOf(0));
        saveConfig();
    	getCommand("ultimateinfection").setExecutor(new UICommands(this));
    }
	  public static Main getInstance() {
		    return instance;
		  }
    
    @Override
    public void onDisable() {
     
    }
}
