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

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
