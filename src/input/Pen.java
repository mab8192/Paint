package input;

import graphics.DrawPanel;
import graphics.Scribble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pen extends MouseAdapter implements MouseMotionListener {
	
	private DrawPanel dp;
	
	private int size;
	private Color color;
	private boolean draw = false;
	private boolean erase = false;
	
	private int numScribbles = 0;
	
	/**
	 * The scribble that's currently being drawn
	 */
	private Scribble scribble;
	private int id = 0;
	
	public Pen(DrawPanel dp) {
		this.dp = dp;
		size = 5;
		color = Color.BLACK;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			draw = true;
			scribble = new Scribble();
			scribble.setColor(color);
			scribble.setSize(size);
			id = numScribbles++;
		}
		else if (e.getButton() == MouseEvent.BUTTON2) erase = true;
	}
	
	public void mouseMoved(MouseEvent e){
	
	}
	
	public void mouseDragged(MouseEvent e){
		
		if (draw) {
			scribble.addPoint(e.getX(), e.getY());
			dp.addScribble(id, scribble);
		}
		
		dp.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) draw = false;
		else if (e.getButton() == MouseEvent.BUTTON2) erase = false;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	
	}
	
}
