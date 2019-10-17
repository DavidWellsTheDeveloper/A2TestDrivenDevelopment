package a2;

import java.util.ArrayList;

import a2.ChessPiece.Color;

/**
 * @author dave
 *
 */
public class Knight extends ChessPiece {

	public Knight(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String unicode =  "";
		if (this.color == Color.WHITE)
			return unicode + '\u2658';
		else 
			return unicode + '\u265E';
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
