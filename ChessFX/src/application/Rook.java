package application;
import java.util.List;

import javafx.scene.image.Image;
public class Rook extends ChessPiece {
	public static final int ROOK_VALUE = 5;
	
	public Rook(int x, int y, boolean isWhite) {
		super(x,y,ROOK_VALUE,isWhite);
		this.setSprite(new Image("Sprites/" + (isWhite?"white":"black") + "Rook.png"));
	}

	@Override
	List<Pos> getValidMoves(ChessPiece[][] board) {
		return null;
	}

}
