package SantoObjects;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Board {
	public ArrayList<Position> positions = new ArrayList<Position>();
	public PlayerData PlayerOne;
	public PlayerData PlayerTwo;
	public HashMap<Position, CaseButton> buttonsOfPositions = new HashMap<Position, CaseButton>();
	public boolean turnOfFirst = true;
	
	public Board(PlayerData one, PlayerData two) {
		this.PlayerOne = one;
		this.PlayerTwo = two;
		for (int i = 0; i<5; i++) {
			for (int i2 = 0; i2 < 5; i2++) {
				positions.add(new Position(i+1, i2+1, this));
			}
			
		}
	}
	
	public Position getPosition(int first, int second) {
		for (Position pos:positions) {
			if (pos.letter == first && pos.number == second) {
				return pos;
			}
		}
		System.out.println("position "+ first + ";"+ second+ " not found");
		return null;
	} 
	
	public boolean CheckCanPlay(Move move) {
		PlayerData p = move.player;
		Position base = move.base;
		Position arr = move.arr;
		boolean canMove = true;
		Character charToMove;
		if (p.CharacterOne.position.equals(base)) {
			charToMove = p.CharacterOne;
		} else if (p.CharacterTwo.position.equals(base)) {
			charToMove = p.CharacterTwo;
		} else {
			canMove = false;
		}
		int difLetter;
		if (base.letter > arr.letter) {
			difLetter = base.letter - arr.letter;
		} else {
			difLetter = arr.letter - base.letter;
		}
		
		int difNumber;
		if (base.number > arr.number) {
			difNumber = base.number - arr.number;
		} else {
			difNumber = arr.number - base.number;
		}
		if (difNumber > 1 || difLetter > 1 || arr.hight - base.hight > 1 || move.constuctPos.constructable) {
			canMove = false;
		}
		
		if (canMove) {
			return true;
		} else {
			return false;
		}
		
		
		
	}

	
	
	public static void main(String[] args) {
		Board board = new Board(new PlayerData(Role.ARTEMIS), new PlayerData(Role.ATHENA));
        board.PlayerOne.CharacterOne.position = board.getPosition(3, 3);
        board.getPosition(3, 3).chara = board.PlayerOne.CharacterOne;
        board.PlayerOne.CharacterTwo.position = board.getPosition(3, 4);
        board.getPosition(3, 4).chara = board.PlayerOne.CharacterTwo;
        board.PlayerTwo.CharacterOne.position = board.getPosition(4, 3);
        board.getPosition(4, 3).chara = board.PlayerTwo.CharacterOne;
        board.PlayerTwo.CharacterTwo.position = board.getPosition(4, 4);
        board.getPosition(4, 4).chara = board.PlayerTwo.CharacterTwo;
        
		GameFrame frame = new GameFrame(board);
    }
	
	
}
