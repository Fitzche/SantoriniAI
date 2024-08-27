package SantoObjects;

public class Move {
	public PlayerData player;
	public Position base;
	public Position arr;
	public Position constuctPos;
	
	public Move(PlayerData player, Position base, Position arr, Position constuctPos) {
		this.player = player;
		this.base = base;
		this.arr = arr;
		this.constuctPos = constuctPos;
	}
}
