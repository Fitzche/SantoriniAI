package SantoObjects;

public class Position {
	public int letter;
	public int number;
	public int hight;
	public Board board;
	public Character chara;
	public boolean constructable = true;
	
	public Position(int letter, int number, Board board) {
		this.letter = letter;
		this.number = number;
		this.board = board;
	}
	public void construct() {
		if (!constructable) {
			System.out.println("can not build on this case");
			return;
		}
		hight ++;
		if (hight > 3) {
			constructable = false;
		}
		
	}
	
	public void characterArrive(Character chara) {
		this.constructable = false;
		this.chara = chara;
	}
	
	public void characterLeft() {
		this.constructable = true;
		this.chara = null;
	}
	
}
