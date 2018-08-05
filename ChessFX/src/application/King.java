package application;
import java.util.List;

import javafx.scene.image.Image;
public class King extends ChessPiece {
	public static final int KING_VALUE = 100;
	
	public King(int x, int y, boolean isWhite) {
		super(x,y,KING_VALUE,isWhite);
		this.setSprite(new Image("Sprites/" + (isWhite?"white":"black") + "King.png"));
	}

	@Override
	List<Pos> getValidMoves(ChessPiece[][] board) {
		return null;
	}

}
