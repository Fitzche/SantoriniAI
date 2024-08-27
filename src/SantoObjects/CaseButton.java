package SantoObjects;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CaseButton extends JButton{
	public Position position;
	public boolean isSelected = false;
	public ImageIcon icon;
	public GameFrame frame;
	public CaseButton(Position position, GameFrame frame) {
		this.frame = frame;
		this.position = position;
		this.setPreferredSize(new Dimension(100, 100));
		this.setIcon(frame.place);
		
		
	}
}
