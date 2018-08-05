package application;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
public class Pawn extends ChessPiece {
	public static final int PAWN_VALUE = 1;

	private boolean hasMoved;
	public Pawn(int x, int y, boolean isWhite) {
		super(x,y,PAWN_VALUE,isWhite);
		this.hasMoved = false;
		this.setSprite(new Image("Sprites/" + (isWhite?"white":"black") + "Pawn.png"));
	}

	@Override
	List<Pos> getValidMoves(ChessPiece[][] board) {
		List<Pos> moves = new ArrayList<Pos>();
		int dir = isWhite() ? 1 : -1;
		if((dir > 0 ? this.getPos().getY() < board.length-1 : this.getPos().getY() > 1)) { //move one forward
			if(board[this.getPos().getY()+dir][this.getPos().getX()] == null) {
				moves.add(new Pos(this.getPos().getX(),this.getPos().getY()+dir));
			}
		}
		if(!hasMoved) { //move two forward on first move
			if(board[this.getPos().getY()+(2*dir)][this.getPos().getX()] == null) {
				moves.add(new Pos(this.getPos().getX(),this.getPos().getY()+(2*dir)));
			}
		}
		return moves;
	}

}
