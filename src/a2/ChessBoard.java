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
//		for (int i = 0; i < 8; i++) {
////			iterate columns
//			for (int j = 0; j < 8; j++) {
//				this.board[i][j] = null;
//			}
//		}
	}
	
	public void initialize() throws IllegalPositionException {
		
		this.placePiece(new Pawn(this, Color.WHITE), "a2");
		this.placePiece(new Pawn(this, Color.WHITE), "b2");
		this.placePiece(new Pawn(this, Color.WHITE), "c2");
		this.placePiece(new Pawn(this, Color.WHITE), "d2");
		this.placePiece(new Pawn(this, Color.WHITE), "e2");
		this.placePiece(new Pawn(this, Color.WHITE), "f2");
		this.placePiece(new Pawn(this, Color.WHITE), "g2");
		this.placePiece(new Pawn(this, Color.WHITE), "h2");
		this.placePiece(new Pawn(this, Color.BLACK), "a7");
		this.placePiece(new Pawn(this, Color.BLACK), "b7");
		this.placePiece(new Pawn(this, Color.BLACK), "c7");
		this.placePiece(new Pawn(this, Color.BLACK), "d7");
		this.placePiece(new Pawn(this, Color.BLACK), "e7");
		this.placePiece(new Pawn(this, Color.BLACK), "f7");
		this.placePiece(new Pawn(this, Color.BLACK), "g7");
		this.placePiece(new Pawn(this, Color.BLACK), "h7");
		
		this.placePiece(new Rook(this, Color.WHITE), "a1");
		this.placePiece(new Rook(this, Color.WHITE), "h1");
		this.placePiece(new Rook(this, Color.BLACK), "a8");
		this.placePiece(new Rook(this, Color.BLACK), "h8");
		
		this.placePiece(new Knight(this, Color.WHITE), "b1");
		this.placePiece(new Knight(this, Color.WHITE), "g1");
		this.placePiece(new Knight(this, Color.BLACK), "b8");
		this.placePiece(new Knight(this, Color.BLACK), "g8");
		
		this.placePiece(new Bishop(this, Color.WHITE), "c1");
		this.placePiece(new Bishop(this, Color.WHITE), "f1");
		this.placePiece(new Bishop(this, Color.BLACK), "c8");
		this.placePiece(new Bishop(this, Color.BLACK), "f8");
		
		this.placePiece(new Queen(this, Color.WHITE), "d1");
		this.placePiece(new King(this, Color.WHITE), "e1");
		this.placePiece(new Queen(this, Color.BLACK), "d8");
		this.placePiece(new King(this, Color.BLACK), "e8");
	}
	
	

	public ChessPiece getPiece(String position) throws IllegalPositionException {
		int row = Integer.parseInt(position.substring(1)) - 1;
		int column = fileToColumn(position.substring(0, 1));
		return board[row][column];
	}
	
	public boolean placePiece(ChessPiece piece, String position) throws IllegalPositionException {
		int row;
		try {
			row = Integer.parseInt(position.substring(1))-1;
		}
		catch (Exception ex) {
			throw new IllegalPositionException();
		}
		
		int column = fileToColumn(position.substring(0, 1));
		if (row < 0 || row > 7) {
			throw new IllegalPositionException();
		}
		this.board[row][column] = piece;
		if (piece != null) {
			piece.setPosition(position);
		}
		
		return true;
	}
	
	public void move(String fromPosition, String position) throws IllegalPositionException {
		ChessPiece fromPiece = getPiece(fromPosition);
//		if move is legal, lets place the piece
		if (fromPiece.legalMoves().contains(position)) {
			placePiece(fromPiece, position);
			fromPiece = null;
			placePiece(fromPiece, fromPosition);
			
		}
	}
	
	private int fileToColumn(String file) throws IllegalPositionException {
		switch(file) {
			case "a": return 0;
			case "b": return 1;
			case "c": return 2;
			case "d": return 3;
			case "e": return 4;
			case "f": return 5;
			case "g": return 6;
			case "h": return 7;
			default : throw new IllegalPositionException();
		}
	}
	
//	private String columnToFile(int i) throws IllegalPositionException {
//		switch(i) {
//			case 0: return "a";
//			case 1: return "b";
//			case 2: return "c";
//			case 3: return "d";
//			case 4: return "e";
//			case 5: return "f";
//			case 6: return "g";
//			case 7: return "h";
//			default: throw new IllegalPositionException();
//		}
//	}
	
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

public static void main(String[] args) {
	ChessBoard board = new ChessBoard();
	try {
		board.initialize();
		System.out.println(board);
		board.move("c7", "c5");
		System.out.println(board);
		board.move("d2", "d4");
		System.out.println(board);
		board.move("c5", "d4");
		System.out.println(board);
		board.move("e1", "d2");
		
	} catch (IllegalPositionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(board);
}
}
