package SantoObjects;

public class PlayerData {
	public Role role;
	public Character CharacterOne;
	public Character CharacterTwo;
	
	public PlayerData(Role role) {
		this.CharacterOne = new Character(this);
		this.CharacterTwo = new Character(this);
		this.role = role;
		
	}
}
