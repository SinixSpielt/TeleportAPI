package de.sinixspielt.teleportapi.manager;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import de.sinixspielt.teleportapi.task.TPDelay;
import de.sinixspielt.teleportapi.task.TPRequest;

public class TeleportManager {
	
	private Map<Player, TPRequest> tpRequests;
	private Map<Player, Long> tpCooldowns;
	private Map<Player, TPDelay> teleportDelays;
	private Map<Player, Location> lastPositions;
	
	public TeleportManager() {
		this.tpRequests = new HashMap<Player, TPRequest>();
		this.tpCooldowns = new HashMap<Player, Long>();
		this.teleportDelays = new HashMap<Player, TPDelay>();
	}
	
	public Map<Player, TPRequest> getTPRequests() {
		return this.tpRequests;
	}

	public Map<Player, Long> getTeleportCooldowns() {
		return this.tpCooldowns;
	}

	public Map<Player, TPDelay> getTeleportDelays() {
		return this.teleportDelays;
	}

	public Map<Player, Location> getLastPositions() {
		return this.lastPositions;
	}
}