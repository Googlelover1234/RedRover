package com.gummypvp.redrover.utils.game.arena;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.gummypvp.redrover.utils.game.Role;
import com.gummypvp.redrover.utils.game.arena.region.Bounds;

/**
	 * 
	 * Created on Sep 22, 2016 by Jeremy Gooch.
	 * 
	 */

public class Arena {
	
	private String name;
	
	private Map<String, Role> players = new HashMap<String, Role>();
	
	private ArenaState state = ArenaState.WAITING;
	
	private Bounds redSafeZone, blueSafeZone, guardZone;
	
	public Arena(String name, Bounds rZ, Bounds bZ, Bounds gZ) {
		
		this.name = name;
		this.redSafeZone = rZ;
		this.blueSafeZone = bZ;
		this.guardZone = gZ;
		
	}
	
	public String getName() {
		return name;
	}
	
	public Map<String, Role> getPlayers() {
		return players;
	}
	
	public ArenaState getState() {
		return state;
	}
	
	public Bounds getRedSafeZone() {
		return redSafeZone;
	}
	
	public Bounds getBlueSafeZone() {
		return blueSafeZone;
	}
	
	public Bounds getGuardZone() {
		return guardZone;
	}
	
	public void addPlayer(Player player, Role role) {
		players.put(player.getName(), role);
	}
	
	public void removePlayer(Player player) {
		
		for (String name : players.keySet()) {
			
			if (name.equalsIgnoreCase(player.getName())) players.remove(name);
			
		}
		
	}
	
	public void setState(ArenaState state) {
		this.state = state;
	}
	
	public Role getRole(Player player) {
		return players.get(player.getName());
	}
	
	@SuppressWarnings("deprecation")
	public void update() {
		
		if (getState() == ArenaState.WAITING || getState() == ArenaState.WON) return;
		
		for (Vector blueVector : getBlueSafeZone().getGroundBlocks()) {
			
			getBlueSafeZone().getWorld().getBlockAt(blueVector.getBlockX(), blueVector.getBlockY(), blueVector.getBlockZ()).setTypeIdAndData(Material.WOOL.getId(), DyeColor.LIGHT_BLUE.getData(), true);
			
		}
		
		for (Vector redVector : getRedSafeZone().getGroundBlocks()) {
			
			getRedSafeZone().getWorld().getBlockAt(redVector.getBlockX(), redVector.getBlockY(), redVector.getBlockZ()).setTypeIdAndData(Material.WOOL.getId(), DyeColor.RED.getData(), true);
			
		}
		
	}
	
}
