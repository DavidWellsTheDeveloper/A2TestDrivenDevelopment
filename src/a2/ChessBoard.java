/**
 * 
 */
package a2;

import a2.ChessPiece.Color;

/**
 * @author Dave Wells
 */
public class ChessBoard {
	private ChessPiece[][] board;
	
	ChessBoard() {
		this.board = new ChessPiece[8][8];
//		iterate rows
		for (int i = 0; i < 8; i++) {
//			iterate columns
			for (int j = 0; j < 8; j++) {
				this.board[i][j] = null;
			}
		}
	}
	
	public void initialize() {
		for(int i = 0; i < 8; i++) {
			this.board[1][i] = new Pawn(this, Color.WHITE);
			this.board[6][i] = new Pawn(this, Color.BLACK);
		}
		this.board[0][0] = new Rook(this, Color.WHITE);
		this.board[0][7] = new Rook(this, Color.WHITE);
		this.board[7][0] = new Rook(this, Color.BLACK);
		this.board[7][7] = new Rook(this, Color.BLACK);
		
		this.board[0][1] = new Knight(this, Color.WHITE);
		this.board[0][6] = new Knight(this, Color.WHITE);
		this.board[7][1] = new Knight(this, Color.BLACK);
		this.board[7][6] = new Knight(this, Color.BLACK);
		
		this.board[0][2] = new Bishop(this, Color.WHITE);
		this.board[0][5] = new Bishop(this, Color.WHITE);
		this.board[7][2] = new Bishop(this, Color.BLACK);
		this.board[7][5] = new Bishop(this, Color.BLACK);
		
		this.board[0][3] = new Queen(this, Color.WHITE);
		this.board[7][3] = new Queen(this, Color.BLACK);
		this.board[0][4] = new Queen(this, Color.WHITE);
		this.board[7][4] = new Queen(this, Color.BLACK);
	}
	
	public ChessPiece getPiece(String position) throws IllegalPositionException {
		int row = Integer.parseInt(position.substring(1, 1));
		int column = 0;
		return board[row][column];
	}
	
	public boolean placePiece(ChessPiece piece, String position) {
		return false;
	}
	
	public String toString(){
	    String chess="";
	    String upperLeft = "\u250C";
	    String upperRight = "\u2510";
	    String horizontalLine = "\u2500";
	    String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
	    String verticalLine = "\u2502";
	    String upperT = "\u252C";
	    String bottomLeft = "\u2514";
	    String bottomRight = "\u2518";
	    String bottomT = "\u2534";
	    String plus = "\u253C";
	    String leftT = "\u251C";
	    String rightT = "\u2524";

	    String topLine = upperLeft;
	    for (int i = 0; i<7; i++){
	        topLine += horizontal3 + upperT;
	    }
	    topLine += horizontal3 + upperRight;

	    String bottomLine = bottomLeft;
	    for (int i = 0; i<7; i++){
	        bottomLine += horizontal3 + bottomT;
	    }
	    bottomLine += horizontal3 + bottomRight;
	    chess+=topLine + "\n";

	    for (int row = 7; row >=0; row--){
	        String midLine = "";
	        for (int col = 0; col < 8; col++){
	            if(board[row][col]==null) {
	                midLine += verticalLine + " \u3000 ";
	            } else {midLine += verticalLine + " "+board[row][col]+" ";}
	        }
	        midLine += verticalLine;
	        String midLine2 = leftT;
	        for (int i = 0; i<7; i++){
	            midLine2 += horizontal3 + plus;
	        }
	        midLine2 += horizontal3 + rightT;
	        chess+=midLine+ "\n";
	        if(row>=1)
	            chess+=midLine2+ "\n";
	    }

	    chess+=bottomLine;
	    return chess;
	}
}
