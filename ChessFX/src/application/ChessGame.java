package application;
	
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class ChessGame extends Application {
	public static final int BOX_SIZE = 50, ROWS = 8, COLS = 8, WIDTH = 400, HEIGHT = 400;
	public ChessPiece[][] board = new ChessPiece[ROWS][COLS];
	public List<Pos> highlightedPieces;
	public Canvas canvas;
	public GraphicsContext g;
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			canvas = new Canvas(WIDTH,HEIGHT);
			canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if(event.getButton().equals(MouseButton.PRIMARY)) {
						Pos mousePos = new Pos((int)(event.getSceneX()/WIDTH*COLS), (int)(event.getSceneY()/HEIGHT*ROWS));
						leftClick(mousePos);
					}
				}
				
			});
			g = canvas.getGraphicsContext2D();
			root.getChildren().add(canvas);
			Scene scene = new Scene(root,WIDTH-10,HEIGHT-10);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Chess");
			primaryStage.setResizable(false);
			setupBoard();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		new AnimationTimer() {
            @Override
            public void handle(long now) {
               gameLoop();
            }
        }.start();
	}
	public void init(String [] args) {
		launch(args);
	}
	public void setupBoard() {
		for(int i = 0; i < COLS; i++) {
			board[1][i] = new Pawn(i,1,ChessPiece.WHITE);
			board[ROWS-2][i] = new Pawn(i,ROWS-2,ChessPiece.BLACK);
		}
		board[0][4] = new Queen(4,0,ChessPiece.WHITE);
		board[7][4] = new Queen(4,7,ChessPiece.BLACK);
		
		board[5][3] = new King(3,5,true);
		
		board[0][3] = new King(3,0,ChessPiece.WHITE);
		board[7][3] = new King(3,7,ChessPiece.BLACK);
		
		board[0][2] = new Bishop(2,0,ChessPiece.WHITE);
		board[0][5] = new Bishop(5,0,ChessPiece.WHITE);
		board[7][2] = new Bishop(2,7,ChessPiece.BLACK);
		board[7][5] = new Bishop(5,7,ChessPiece.BLACK);
		
		board[0][1] = new Knight(1,0,ChessPiece.WHITE);
		board[0][6] = new Knight(6,0,ChessPiece.WHITE);
		board[7][1] = new Knight(1,7,ChessPiece.BLACK);
		board[7][6] = new Knight(6,7,ChessPiece.BLACK);
		
		board[0][0] = new Rook(0,0,ChessPiece.WHITE);
		board[0][7] = new Rook(7,0,ChessPiece.WHITE);
		board[7][0] = new Rook(0,7,ChessPiece.BLACK);
		board[7][7] = new Rook(7,7,ChessPiece.BLACK);
	}
	public void gameLoop() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				g.setFill((i+(j%2))%2 == 1 ? Color.rgb(75, 75, 75): Color.rgb(180, 180, 180));
				g.fillRect(j*BOX_SIZE, i*BOX_SIZE, BOX_SIZE, BOX_SIZE);
				if(board[i][j] != null) {
					board[i][j].draw(g,BOX_SIZE);
				}
				
			}
		}
		if(highlightedPieces != null) {
			System.out.println(highlightedPieces.size());
			Pos pos;
			for(int i = 0; i < highlightedPieces.size(); i++) {
				pos = highlightedPieces.get(i);
				System.out.println(pos);
				if(i == 0) {
					g.setFill(Color.rgb(15,100,100,.5));
				}else {
					g.setFill(Color.rgb(15,100,25,.5));
				}
				g.fillRect(pos.getX()*BOX_SIZE, pos.getY()*BOX_SIZE, BOX_SIZE, BOX_SIZE);
			}
		}
	}
	
	public void leftClick(Pos mouse) {
		ChessPiece piece = board[mouse.getY()][mouse.getX()];
		if(piece != null) {
			highlightedPieces = piece.getValidMoves(board);
			highlightedPieces.add(0, mouse);
		}
		System.out.println(mouse);
	}
}
