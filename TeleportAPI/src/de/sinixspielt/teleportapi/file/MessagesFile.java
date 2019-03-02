package de.sinixspielt.teleportapi.file;

import org.bukkit.configuration.file.FileConfiguration;

/*
Class created on 28.02.2019 by SinixSpielt
 * */

public class MessagesFile extends FileBase {

	public MessagesFile() {
		super("", "message");
		writeDefaults();
	}

	private void writeDefaults() {
		FileConfiguration cfg = getConfig();
		cfg.addDefault("CONIG.SURVIVALGAMES.NOPERMISSION", "%PREFIX% &4Keine Berechtigung!");
		cfg.options().copyDefaults(true);
		saveConfig();
	}
	
	public String getMessage(String path) {
		FileConfiguration cfg = getConfig();
		String message = cfg.getString(path);
		message = message.replace("&", "§");
		return message;
	}
}