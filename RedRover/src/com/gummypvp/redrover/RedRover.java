package com.gummypvp.redrover;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.gummypvp.redrover.commands.RRTest;
import com.gummypvp.redrover.utils.game.arena.ArenaLoop;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;

/**
	 * 
	 * Created on Sep 22, 2016 by Jeremy Gooch.
	 * 
	 */

public class RedRover extends JavaPlugin {
	
	private static RedRover instance;
	
	public void onEnable() {
		
		loadRedRover();
		
		instance = this;
		
		ArenaLoop.get().start();
		
	}
	
	public void onDisable() {
		
		instance = null;
		
	}
	
	private void loadRedRover() {
		
		// register commands & listeners (plus load configuration stuff)
		
		getCommand("rrtest").setExecutor(new RRTest());
		
	}
	
	private void unloadRedRover() {
		
		// do other things
		
	}
	
	public static RedRover get() {
		return instance;
	}
	
	public WorldEditPlugin getWorldEdit() {
		
		if (Bukkit.getPluginManager().getPlugin("WorldEdit") == null) return null;
		
		return (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		
	}

}
