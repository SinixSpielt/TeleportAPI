package de.sinixspielt.teleportapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.sinixspielt.teleportapi.file.FileManager;
import de.sinixspielt.teleportapi.listeners.MoveListener;
import de.sinixspielt.teleportapi.manager.TeleportManager;

public class TeleportAPI extends JavaPlugin{
	
	public static TeleportAPI instance;
	public static FileManager fileManager;
	public static TeleportManager teleportManager;
	
	@Override
	public void onEnable() {
		instance = this;
		fileManager = new FileManager();
		teleportManager = new TeleportManager();
		Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
	}

	@Override
	public void onDisable() {
		instance = null;
	}
	
	public static TeleportAPI getInstance() {
		return instance;
	}
	
	public static TeleportManager getTeleportManager() {
		return teleportManager;
	}
}