package de.sinixspielt.teleportapi.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.sinixspielt.teleportapi.TeleportAPI;

public class MoveListener implements Listener {
	
	@EventHandler
	public void PlayerMove(PlayerMoveEvent e) {
		Location from = e.getFrom();
		Location to = e.getTo();
		if(TeleportAPI.getTeleportManager().getTeleportDelays().containsKey(e.getPlayer())) {
			if(hasLocationChanged(from, to)) {
				TeleportAPI.getTeleportManager().getTeleportDelays().remove(e.getPlayer());
			}	
		}
	}
	
	private boolean hasLocationChanged(Location from, Location to) {
		if ((from.getBlockX() != to.getBlockX()) || (from.getBlockZ() != to.getBlockZ())) {
			return true;
		}
		return false;
	}
}