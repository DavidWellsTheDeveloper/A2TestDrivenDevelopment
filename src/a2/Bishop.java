package a2;

import java.util.ArrayList;

import a2.ChessPiece.Color;

/**
 * @author dave
 *
 */
public class Bishop extends ChessPiece {

	public Bishop(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String unicode =  "";
		if (this.color == Color.WHITE)
			return unicode + '\u2657';
		else 
			return unicode + '\u265D';
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
