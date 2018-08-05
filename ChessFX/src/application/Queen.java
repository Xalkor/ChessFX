package application;
import java.util.List;

import javafx.scene.image.Image;
public class Queen extends ChessPiece {
	public static final int QUEEN_VALUE = 9;
	
	public Queen(int x, int y, boolean isWhite) {
		super(x,y,QUEEN_VALUE,isWhite);
		this.setSprite(new Image("Sprites/" + (isWhite?"white":"black") + "Queen.png"));
	}

	@Override
	List<Pos> getValidMoves(ChessPiece[][] board) {
		return null;
	}

}
