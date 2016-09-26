package com.gummypvp.redrover.utils.game.arena;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import com.gummypvp.redrover.RedRover;

/**
	 * 
	 * Created on Sep 23, 2016 by Jeremy Gooch.
	 * 
	 */

public class ArenaLoop implements Runnable {
	
	private BukkitTask task;
	
	private ArenaLoop() {}
	
	private static ArenaLoop instance = new ArenaLoop();
	
	public static ArenaLoop get() {
		return instance;
	}

	@Override
	public void run() {
		
		for (Arena arena : ArenaManager.get().getArenas()) {
			
			arena.update();
			
			Bukkit.broadcastMessage("Updated: " + arena.getName());
			
		}
		
	}
	
	public void start() {
		
		task = Bukkit.getScheduler().runTaskTimer(RedRover.get(), this, 0, 20);
		
		Bukkit.broadcastMessage("started");
		
		run();
		
	}
	
	public void stop() {
		Bukkit.getScheduler().cancelTask(task.getTaskId());
	}

}
