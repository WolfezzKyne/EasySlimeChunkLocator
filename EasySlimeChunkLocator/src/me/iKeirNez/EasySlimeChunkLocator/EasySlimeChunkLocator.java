package me.iKeirNez.EasySlimeChunkLocator;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EasySlimeChunkLocator extends JavaPlugin {
	
	public void onEnable(){
		final FileConfiguration config = this.getConfig();
		config.options().copyDefaults(true);
		saveConfig();

		System.out.println("[EasySlimeChunkLocator] Successfully loaded config.");
		
		if (config.getBoolean("debug-mode")){
			System.out.println("[EasySlimeChunkDetector] Debug Mode, change debug-mode to false in the config to disable.");
		}
		
		if (config.getBoolean("enabled")){
			PluginManager pm = this.getServer().getPluginManager();
			pm.registerEvents(new EasySlimeChunkLocatorPlayerListener(this), this);
			if (config.getBoolean("debug-mode")){
				System.out.println("[EasySlimeChunkDetector] Player Listener Successfully Registered.");
			}
		} else {
			System.out.println("[EasySlimeChunkLocator] Enabled set to false in config, disabling plugin...");
		}
	}
	
	public void onReload(){
		reloadConfig();
		System.out.println("[EasySlimeChunkLocator] Successfully reloaded config.");
	}

}
