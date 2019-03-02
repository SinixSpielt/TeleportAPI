package de.sinixspielt.teleportapi.task;

import org.bukkit.entity.Player;

public class TPRequest {
	
	private Player from;
	private Player to;
	private boolean here;
	private long sentTime;

	public TPRequest(Player from, Player to, boolean here) {
		this.from = from;
		this.to = to;
		this.here = here;
		this.sentTime = System.currentTimeMillis();
	}

	public Player getFrom() {
		return this.from;
	}

	public Player getTo() {
		return this.to;
	}

	public boolean isHere() {
		return this.here;
	}

	public long getSentTime() {
		return this.sentTime;
	}
}