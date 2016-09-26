package com.gummypvp.redrover.utils.game.arena.region;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

/**
	 * 
	 * Created on Sep 22, 2016 by Jeremy Gooch.
	 * 
	 */

public class Bounds {
	
	private Vector min, max;
	private World world;
	
	public Bounds(Vector min, Vector max, World world) {
		
		this.min = Vector.getMinimum(min, max);
		this.max = Vector.getMaximum(min, max);
		this.world = world;
		
	}
	
	public Vector getMinimumPoint() {
		return min;
	}
	
	public Vector getMaximumPoint() {
		return max;
	}
	
	public World getWorld() {
		return world;
	}
	
	public boolean inBounds(Location location) {
		return location.toVector().isInAABB(min, max);
	}
	
	public boolean inBounds(Vector vector) {
		return vector.isInAABB(min, max);
	}
	
	public List<Vector> getGroundBlocks() {
		
		List<Vector> result = new ArrayList<Vector>();
		
		int minX = min.getBlockX();
		int maxX = max.getBlockX();
		
		int minY = min.getBlockY();
		
		int minZ = min.getBlockZ();
		int maxZ = max.getBlockZ();
		
		for (int x = minX; x <= maxX; x++) {
			
			for (int z = minZ; z <= maxZ; z++) {
					
				result.add(new Vector(x, minY, z));
					
			}
			
		}
		
		return result;
	}
	
}
