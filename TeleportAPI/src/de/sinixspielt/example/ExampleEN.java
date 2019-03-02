package de.sinixspielt.example;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sinixspielt.teleportapi.TeleportAPI;
import de.sinixspielt.teleportapi.task.TPDelay;

public class ExampleEN  implements CommandExecutor{
	
	public Location loc = new Location(Bukkit.getWorld(""), 2, 2, 2);  //<--- You Location

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		p.sendMessage("§8» §7You will be teleported in §a3 §7Seconds. §cDont Move!");
		
		TPDelay delay = new TPDelay(p, 0, 5, 12) {
			public void onTick() {
				if(!(TeleportAPI.getTeleportManager().getTeleportDelays().containsKey(sender))) {
					cancel();
					getPlayer().sendMessage("§8» §cTeleportation was canceled.");
					return;
				}
			}
			public void onEnd() {
				getPlayer().teleport(loc);
				getPlayer().sendMessage("§8» §7You have been teleported.");
			}
		};
		TeleportAPI.getTeleportManager().getTeleportDelays().put(p, delay);
		return true;
	}
}