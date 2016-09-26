package com.gummypvp.redrover.utils.game.arena;

	/**
	 * 
	 * Created on Sep 22, 2016 by Jeremy Gooch.
	 * 
	 * WAITING - Waiting for players to fill up the match
	 * RUNNING - Game is running
	 * WON - A team won, this should only be the GameState for about 10 seconds (just to announce the winner), it should immediately return to WAITING
	 * 
	 */

public enum ArenaState {
	
	WAITING, RUNNING, WON; 

}
