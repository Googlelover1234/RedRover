package com.gummypvp.redrover.utils.game.arena;

import java.util.HashSet;
import java.util.Set;

import com.gummypvp.redrover.utils.game.arena.region.Bounds;

/**
	 * 
	 * Created on Sep 22, 2016 by Jeremy Gooch.
	 * 
	 */

public class ArenaManager {
	
	private Set<Arena> arenas = new HashSet<Arena>();
	
	private ArenaManager() { }
	
	private static ArenaManager instance = new ArenaManager();
	
	public static ArenaManager get() {
		return instance;
	}
	
	// load, unload, delete, add etc
	
	public Set<Arena> getArenas() {
		return arenas;
	}
	
	public void registerArena(Arena arena) {
		
		arenas.add(arena);
		
	}
	
	public Bounds red = null, blue = null, guard = null;
	
}
