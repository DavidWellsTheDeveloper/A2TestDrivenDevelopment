/**
 * 
 */
package a2;

import java.util.ArrayList;

/**
 * @author dave
 *
 */
public class Queen extends ChessPiece {

	public Queen(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String unicode =  "";
		if (this.color == Color.WHITE)
			return unicode + '\u2655';
		else 
			return unicode + '\u265B';
	}

	@Override
	public ArrayList<String> legalMoves() {
		ArrayList<String> moves = new ArrayList<String>();
		return moves;
	}

}
