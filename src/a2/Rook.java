package a2;

import java.util.ArrayList;

import a2.ChessPiece.Color;

/**
 * @author dave
 *
 */
public class Rook extends ChessPiece {

	public Rook(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String unicode =  "";
		if (this.color == Color.WHITE)
			return unicode + '\u2656';
		else 
			return unicode + '\u265C';
	}
	

	private String getFileFromColumn(int col) {
		switch (col) {
			case 0: return "a";
			case 1: return "b";
			case 2: return "c";
			case 3: return "d";
			case 4: return "e";
			case 5: return "f";
			case 6: return "g";
			case 7: return "h";
			default: return null;
		}
	}

	private int getColumnFromPosition(String position) {
		String col = position.substring(0, 1);
		switch (col) {
			case "a": return 0;
			case "b": return 1;
			case "c": return 2;
			case "d": return 3;
			case "e": return 4;
			case "f": return 5;
			case "g": return 6;
			case "h": return 7;
			default: return -1;
		}
	}
	
	private int getRowFromPosition(String position) {
		String row = position.substring(1);
		switch (row) {
			case "1": return 1;
			case "2": return 2;
			case "3": return 3;
			case "4": return 4;
			case "5": return 5;
			case "6": return 6;
			case "7": return 7;
			case "8": return 8;
			default: return -1;
		}
	}

	@Override
	public ArrayList<String> legalMoves() {
		ArrayList<String> moves = new ArrayList<String>();
		try {
			String position = this.getPosition();
			int row = Integer.parseInt(position.substring(1));
			String column = position.substring(0, 1);
			ChessPiece piece = null;
			
			// Left
			String leftPosition = position;
			String forwardPosition = position;
			String rightPosition = position;
			String backPosition = position;
			while (piece == null && ! leftPosition.substring(0, 1).contains("a")) {
				leftPosition = getFileFromColumn(getColumnFromPosition(leftPosition)-1) + Integer.toString(getRowFromPosition(leftPosition));
				piece = this.board.getPiece(leftPosition);
				if (piece == null || piece.color != this.color)
					moves.add(leftPosition);
			}
			
			// works, base the others off this
			while (piece == null && ! forwardPosition.substring(1).contains("8")) {
				forwardPosition = getFileFromColumn(getColumnFromPosition(forwardPosition)) + Integer.toString(getRowFromPosition(forwardPosition) + 1);
				piece = this.board.getPiece(forwardPosition);
				if (piece == null || piece.color != this.color)
					moves.add(forwardPosition);
			}
			while (! rightPosition.substring(0, 1).contentEquals("h")) {
				rightPosition = getFileFromColumn(getColumnFromPosition(rightPosition)+1) + Integer.toString(getRowFromPosition(rightPosition));
				piece = this.board.getPiece(rightPosition);
				if (piece == null || piece.color != this.color)
					moves.add(rightPosition);
			}
			while (piece == null && ! backPosition.substring(1).equals("1")) {
				backPosition = getFileFromColumn(getColumnFromPosition(backPosition)) + Integer.toString(getRowFromPosition(backPosition)-1);
				piece = this.board.getPiece(backPosition);
				if (piece == null || piece.color != this.color)
					moves.add(backPosition);
			}
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		return moves;
	}

}
