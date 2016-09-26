package com.gummypvp.redrover.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gummypvp.redrover.RedRover;
import com.gummypvp.redrover.utils.game.arena.Arena;
import com.gummypvp.redrover.utils.game.arena.ArenaManager;
import com.gummypvp.redrover.utils.game.arena.region.Bounds;
import com.sk89q.worldedit.bukkit.selections.Selection;

/**
	 * 
	 * Created on Sep 25, 2016 by Jeremy Gooch.
	 * 
	 */

public class RRTest implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			return true;
		}
		
		Player player = (Player) sender;
		
		if (RedRover.get().getWorldEdit() == null) {
			
			return true;
		}
		
		Selection selection = RedRover.get().getWorldEdit().getSelection(player);
		
		if (selection == null) {
			
			return true;
		}
		
		if (selection.getMaximumPoint() == null || selection.getMinimumPoint() == null) {
			
			return true;
		}
		
		if (args.length == 0) {
			
			if (ArenaManager.get().red == null || ArenaManager.get().blue == null || ArenaManager.get().guard == null) {
				
				
				return true;
			}
			
			Arena testArena = new Arena("test", ArenaManager.get().red, ArenaManager.get().blue, ArenaManager.get().guard);
			
			ArenaManager.get().registerArena(testArena);
			
			Bukkit.broadcastMessage(testArena.getName());
			
			return true;
			
		}
		
		if (args[0].equalsIgnoreCase("red")) {
			
			ArenaManager.get().red = new Bounds(selection.getMinimumPoint().toVector(), selection.getMaximumPoint().toVector(), player.getWorld());
			
			return true;
		}
		
		if (args[0].equalsIgnoreCase("blue")) {
			
			ArenaManager.get().blue = new Bounds(selection.getMinimumPoint().toVector(), selection.getMaximumPoint().toVector(), player.getWorld());
			
			return true;
		}
		
		if (args[0].equalsIgnoreCase("guard")) {
			
			ArenaManager.get().guard = new Bounds(selection.getMinimumPoint().toVector(), selection.getMaximumPoint().toVector(), player.getWorld());
			
			return true;
		}
		
		return true;
	}

}
