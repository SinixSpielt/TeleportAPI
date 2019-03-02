package de.sinixspielt.teleportapi.task;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import de.sinixspielt.teleportapi.TeleportAPI;

public abstract class TPDelay {
	
	private Player player;
	private int times;
	private int baseTime;
	private double yMultiplier;
	private double yAdd;
	private BukkitTask task;

	public TPDelay(Player player, int startTime, int delay, int time) {
		this.player = player;
		this.times = time;
		this.baseTime = this.times;
		this.yMultiplier = (2.5D / this.baseTime);
		this.yAdd = 0.0D;
		this.task = new BukkitRunnable() {
			public void run() {
				if ((TPDelay.this.getPlayer() == null) || (TPDelay.this.getPlayer().isDead()) || (!TPDelay.this.getPlayer().isOnline())) {
					cancel();
					TeleportAPI.getTeleportManager().getTeleportDelays().remove(TPDelay.this.getPlayer());
					return;
				}
				TPDelay.this.onTick();
				if ((TPDelay.this.getTimes() % 4 == 0) && (TPDelay.this.getTimes() > 0)) {
					//TPDelay.this.getPlayer().playSound(TPDelay.this.getPlayer().getLocation(), Sound.BLOCK_NOTE_BASEDRUM, 1.0F, 0.5F);
				}
				TPDelay.this.yAdd += TPDelay.this.yMultiplier;

				Location nextLocation = TPDelay.this.getPlayer().getLocation().clone();
				nextLocation.add(0.0D, TPDelay.this.yAdd, 0.0D);

				if (TPDelay.this.times <= 0) {
					TPDelay.this.onEnd();
					TeleportAPI.getTeleportManager().getTeleportDelays().remove(TPDelay.this.getPlayer());
					cancel();
					return;
				}
				TPDelay.this.times -= 1;
			}
		}.runTaskTimer(TeleportAPI.getInstance(), startTime, delay);
	}

	public Player getPlayer() {
		return this.player;
	}

	public int getTimes() {
		return this.times;
	}

	public int getBaseTime() {
		return this.baseTime;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public void cancel() {
		this.task.cancel();
	}

	public abstract void onTick();

	public abstract void onEnd();
}
