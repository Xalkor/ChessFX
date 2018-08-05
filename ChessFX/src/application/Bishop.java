package application;
import java.util.List;

import javafx.scene.image.Image;
public class Bishop extends ChessPiece {
	public static final int BISHOP_VALUE = 3;
	
	public Bishop(int x, int y, boolean isWhite) {
		super(x,y,BISHOP_VALUE,isWhite);
		this.setSprite(new Image("Sprites/" + (isWhite?"white":"black") + "Bishop.png"));
	}

	@Override
	List<Pos> getValidMoves(ChessPiece[][] board) {
		return null;
	}

}
