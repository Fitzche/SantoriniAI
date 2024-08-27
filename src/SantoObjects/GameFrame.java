package SantoObjects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	
	public Board board;
	public CaseButton fromMoveCase;
	public CaseButton toMoveCase;
	public CaseButton constructMoveCase;
	
	public CaseButton selectedCase;
	public ImageIcon blue_selector = new ImageIcon("image/select_blue.png");

	public ImageIcon green_selector = new ImageIcon("image/select_green.png");
	public ImageIcon select = new ImageIcon("image/select.png");
	public ImageIcon yellow_selector = new ImageIcon("image/select_yellow.png");
	public ImageIcon place = new ImageIcon("image/place.png");
	public ImageIcon place_selected = new ImageIcon("image/place_selected.png");
	public ImageIcon first = new ImageIcon("image/first.png");
	public ImageIcon first_selected = new ImageIcon("image/first_selected.png");
	public ImageIcon second = new ImageIcon("image/second.png");
	public ImageIcon second_selected = new ImageIcon("image/second_selected.png");
	public ImageIcon third = new ImageIcon("image/third.png");
	public ImageIcon third_selected = new ImageIcon("image/third_selected.png");
	public ImageIcon fourth = new ImageIcon("image/fourth.png");
	public ImageIcon fourth_selected = new ImageIcon("image/fourth_selected.png");
		
	
	public void setNewIcon(CaseButton c) {
		System.out.println("this is "+ c.position.letter+ c.position.number);
		BufferedImage im1 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = im1.createGraphics();
		g.drawImage(((ImageIcon) c.icon).getImage(), 0, 0, null);
		if (c.equals(selectedCase)) {
			g.drawImage(((ImageIcon) select).getImage(), 0, 0, null);
		}
		if (c.equals(toMoveCase)) {
			g.drawImage(((ImageIcon) yellow_selector).getImage(), 0, 0, null);
		}
		if (c.equals(fromMoveCase)) {
			g.drawImage(((ImageIcon) green_selector).getImage(), 0, 0, null);

		}
		if (c.equals(constructMoveCase)) {
			g.drawImage(((ImageIcon) blue_selector).getImage(), 0, 0, null);

		}
		
		c.setIcon(new ImageIcon(im1));
	} 
	
	
	
	
	
	
	public GameFrame(Board board) {
		
		super("Santorini");
		
		
		
		this.board = board;
		FlowLayout layout = new FlowLayout();
        this.setLayout(layout);
		
        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(600, 600));
        
        for (int i1 = 0; i1 < 5; i1++) {
        	for (int i2 = 0; i2 < 5; i2++) {
        		CaseButton button = new CaseButton(board.getPosition(i1+1, i2+1), this);
        		pane.add(button);
        		button.setLocation(i1 * 120+20, (i2 *120));
        		button.setVisible(true);
        		button.icon = place;
        		button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						if (button.isSelected) {
							return;
						}else {
							button.setVisible(false);
							CaseButton old = selectedCase;
							selectedCase = button;
							if (old != null) {
								setNewIcon(old);
							}
							

							
							setNewIcon(button);
							
							System.out.println("reload");
							button.setVisible(true);
						}
					}
				});
        	
        	}
        
        }
        JPanel pan1 = new JPanel();
       
        TextField area1 = new TextField("Personnage Choisi: ");
        area1.setVisible(true);
        pan1.add(area1);
        pan1.setVisible(true);
        
        TextField area2 = new TextField("Case de déplacement Choisie: ");
        area2.setVisible(true);
        pan1.add(area2);
        pan1.setVisible(true);
        
        
        
        this.add(pan1);
        
        
        
        JButton moveSetter = new JButton("Appliquer comme destination");
        moveSetter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CaseButton old = toMoveCase;
				toMoveCase = selectedCase;
				if (old != null) {
					setNewIcon(old);
				}
				
				
				
				area2.setText("Case de déplacement Choisie: "+ toMoveCase.position.letter+ "; "+ toMoveCase.position.number);
				
				
				
				setNewIcon(selectedCase);
			}
		});
        this.add(moveSetter);
        
        JButton moveSetter2 = new JButton("Choisir ce personnage à déplacer");
        moveSetter2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (selectedCase.position.chara != null) {
					CaseButton old = fromMoveCase;
					fromMoveCase = selectedCase;
					if (old != null) {
						setNewIcon(old);
					}
					setNewIcon(selectedCase);
					area1.setText("Personnage Choisi: "+ fromMoveCase.position.letter+ "; "+fromMoveCase.position.number);
					
				} 
				
				
				
			}
		});
        this.add(moveSetter2);
        
        
        
        
        
        JButton moveSetter3 = new JButton("Choisir cette case sur laquelle construire");
        moveSetter3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CaseButton old = constructMoveCase;
				
				constructMoveCase = selectedCase; 
				if (old != null) {
					setNewIcon(old);
				}
				setNewIcon(constructMoveCase);
				
			}
		});
        this.add(moveSetter3);
        
        
        
        pane.setVisible(true);
        pane.setBackground(Color.RED);
        pane.setLocation(0, 0);
        this.add(pane);
        
		
		
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        this.setLocationRelativeTo(null);
        
        this.setLocation(200, 180);
        this.setPreferredSize(new Dimension(1000, 500));
        this.setBackground(Color.BLACK);
        this.pack();
        this.setVisible(true);
	}
	
	
	
	
}
