/**
 * 
 */
package a2;

import java.util.ArrayList;

/**
 * @author dave
 *
 */
public class King extends ChessPiece {

	public King(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String unicode =  "";
		if (this.color == Color.WHITE)
			return unicode + '\u2654';
		else 
			return unicode + '\u265A';
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

	@Override
	public ArrayList<String> legalMoves() {
		ArrayList<String> moves = new ArrayList<String>();
		try {
			String position = this.getPosition();
			int row = Integer.parseInt(position.substring(1));
			String column = position.substring(0, 1);
			if (this.color == Color.WHITE) {
				ChessPiece back = null;
				ChessPiece backLeft = null;
				ChessPiece left = null;
				ChessPiece forwardLeft = null;
				ChessPiece forward = null;
				ChessPiece forwardRight = null;
				ChessPiece right = null;
				ChessPiece backRight = null;
				if (row > 1) {
					back = this.board.getPiece(column + Integer.toString(row - 1));
					moves.add(back.getPosition());
				}
				if (row > 1 && column != "a") { 
					backLeft= this.board.getPiece(getFileFromColumn(getColumnFromPosition(position)-1) + Integer.toString(row - 1));
					moves.add(backLeft.getPosition());
				}	
				if (column != "a") {
					left = this.board.getPiece(getFileFromColumn(getColumnFromPosition(position)-1) + Integer.toString(row));
					moves.add(left.getPosition());
				}
				if (row < 8 && column != "a") {
					String option = getFileFromColumn(getColumnFromPosition(position)-1) + Integer.toString(row + 1);
					forwardLeft = this.board.getPiece(option);
					moves.add(option);
				}
				if (row < 8) {
					String option = column + Integer.toString(row + 1);
					forward = this.board.getPiece(option);
					moves.add(option);
				}
				if (row < 8 && column != "h") {
					forwardRight = this.board.getPiece(getFileFromColumn(getColumnFromPosition(position)+1) + Integer.toString(row + 1));
					moves.add(forwardRight.getPosition());
				}
				if (column != "h") {
					right = this.board.getPiece(getFileFromColumn(getColumnFromPosition(position)+1) + Integer.toString(row));
					moves.add(right.getPosition());
				}
				if (row > 1 && column != "h") {
					backRight = this.board.getPiece(getFileFromColumn(getColumnFromPosition(position)+1) + Integer.toString(row - 1));
					moves.add(backRight.getPosition());
				}
			}
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moves;
	}

}
