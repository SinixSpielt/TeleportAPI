package de.sinixspielt.example;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sinixspielt.teleportapi.TeleportAPI;
import de.sinixspielt.teleportapi.task.TPDelay;

public class ExampleDE implements CommandExecutor{
	
	public Location loc = new Location(Bukkit.getWorld(""), 2, 2, 2);  //<--- Deine Location

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		p.sendMessage("§8» §7Du wirst Teleportiert in §a3 §7Sekunden. §cBitte bewege dich nicht!");
		
		TPDelay delay = new TPDelay(p, 0, 5, 12) {
			public void onTick() {
				if(!(TeleportAPI.getTeleportManager().getTeleportDelays().containsKey(sender))) {
					cancel();
					getPlayer().sendMessage("§8» §cTeleportation wurde abgebrochen.");
					return;
				}
			}
			public void onEnd() {
				getPlayer().teleport(loc);
				getPlayer().sendMessage("§8» §7Du wurdest teleportiert.");
			}
		};
		TeleportAPI.getTeleportManager().getTeleportDelays().put(p, delay);
		return true;
	}
}