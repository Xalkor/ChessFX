package application;
import java.util.List;

import javafx.scene.image.Image;
public class Knight extends ChessPiece {
	public static final int KNIGHT_VALUE = 3;
	
	public Knight(int x, int y, boolean isWhite) {
		super(x,y,KNIGHT_VALUE,isWhite);
		this.setSprite(new Image("Sprites/" + (isWhite?"white":"black") + "Knight.png"));
	}

	@Override
	List<Pos> getValidMoves(ChessPiece[][] board) {
		return null;
	}

}
