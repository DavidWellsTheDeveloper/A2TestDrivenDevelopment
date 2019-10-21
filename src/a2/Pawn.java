package a2;

import java.util.ArrayList;

/**
 * @author dave
 *
 */
public class Pawn extends ChessPiece {

	public Pawn(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String unicode =  "";
		if (this.color == Color.WHITE)
			return unicode + '\u2659';
		else 
			return unicode + '\u265F';
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
	

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		ArrayList<String> moves = new ArrayList<String>();
		try {
			String position = this.getPosition();
			int row = Integer.parseInt(position.substring(1));
			String column = position.substring(0, 1);
			ChessPiece forward1 = null;
			ChessPiece forward2 = null;
			if (this.color == Color.WHITE) {
				forward1 = this.board.getPiece(column + Integer.toString(row + 1));
				forward2 = this.board.getPiece(column + Integer.toString(row + 2));
				if (forward1 == null) {
					moves.add(column + Integer.toString(row + 1));
				}
				if (row == 2 && forward2 == null) {
					moves.add(column + Integer.toString(row + 2));
				}
				if (getColumnFromPosition(position) > 0) {
					String attackLeftPosition = getFileFromColumn(getColumnFromPosition(position)-1) + Integer.toString(row + 1);
					boolean leftAttack = (this.board.getPiece(attackLeftPosition) != null) && (this.board.getPiece(attackLeftPosition).color != this.color);
					if (leftAttack) {
						moves.add(attackLeftPosition);
					}
				}
				if (getColumnFromPosition(position) < 7) {
					String attackRightPosition = getFileFromColumn(getColumnFromPosition(position)+1) + Integer.toString(row + 1);
					boolean rightAttack = (this.board.getPiece(attackRightPosition) != null) && (this.board.getPiece(attackRightPosition).color != this.color);
					if (rightAttack) {
						moves.add(attackRightPosition);
					}
				}
				
				
				
			}
			if (this.color == Color.BLACK) {
				forward1 = this.board.getPiece(column + Integer.toString(row - 1));
				forward2 = this.board.getPiece(column + Integer.toString(row - 2));
				if (forward1 == null) {
					moves.add(column + Integer.toString(row - 1));
				}
				if (row == 7 && forward2 == null) {
					moves.add(column + Integer.toString(row - 2));
				}
				String attackLeftPosition = getFileFromColumn(getColumnFromPosition(position)-1) + Integer.toString(row - 1);
				boolean leftAttack = (this.board.getPiece(attackLeftPosition) != null) && (this.board.getPiece(attackLeftPosition).color != this.color);
				String attackRightPosition = getFileFromColumn(getColumnFromPosition(position)+1) + Integer.toString(row - 1);
				boolean rightAttack = (this.board.getPiece(attackRightPosition) != null) && (this.board.getPiece(attackRightPosition).color != this.color);
				if (rightAttack) {
					moves.add(attackRightPosition);
				}
				if (leftAttack) {
					moves.add(attackLeftPosition);
				}
			}
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moves;
	}

}
