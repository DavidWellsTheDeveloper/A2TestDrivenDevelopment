/**
 * 
 */
package a2;

import java.util.ArrayList;

/**
 * @author Dave
 *
 */
public abstract class ChessPiece {
	public enum Color {WHITE, BLACK};
	protected ChessBoard board;
	protected int row;
	protected int column;
	protected Color color;
	
	public ChessPiece(ChessBoard board, Color color) {
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getPosition() {
		return null;
	}
	
	public void setPosition(String position) throws IllegalPositionException {
		
	}
	
	abstract public String toString();
	
	abstract public ArrayList<String> legalMoves();
}
