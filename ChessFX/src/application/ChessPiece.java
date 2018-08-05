package application;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class ChessPiece {
	public static final boolean WHITE = true, BLACK = false;
	private boolean isWhite;
	private Image sprite;
	private int value;
	private Pos pos;
	
	public ChessPiece(int x, int y, int value, boolean isWhite) {
		pos = new Pos(x,y);
		this.value = value;
		this.isWhite = isWhite;
	}
	
	abstract List<Pos> getValidMoves(ChessPiece[][] board);
	
	public void draw(GraphicsContext g, int size) {
		if(sprite != null) {
			g.drawImage(sprite, pos.getX()*size, pos.getY()*size,size,size);
		}else {
			g.setFill(isWhite ? Color.WHITE : Color.BLACK);
			g.setStroke(isWhite ? Color.BLACK : Color.WHITE);
			g.strokeOval(pos.getX()*size, pos.getY()*size, size,size);
			g.fillOval(pos.getX()*size, pos.getY()*size, size,size);
		}
	}
	
	public void move(int x, int y) {
		pos.set(x,y);
	}
	
	public Pos getPos() {
		return pos;
	}

	public int getValue() {
		return this.value;
	}
	
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	
	public boolean isWhite() {
		return isWhite;
	}
}
