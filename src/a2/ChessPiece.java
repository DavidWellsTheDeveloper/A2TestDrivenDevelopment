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
		this.board = board;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getPosition() throws IllegalPositionException {
		switch (column) {
			case 0: return "a" + Integer.toString(row);
			case 1: return "b" + Integer.toString(row);
			case 2: return "c" + Integer.toString(row);
			case 3: return "d" + Integer.toString(row);
			case 4: return "e" + Integer.toString(row);
			case 5: return "f" + Integer.toString(row);
			case 6: return "g" + Integer.toString(row);
			case 7: return "h" + Integer.toString(row);
			default: throw new IllegalPositionException();
		}
	}
	
	public void setPosition(String position) throws IllegalPositionException {
		
	}
	
	abstract public String toString();
	
	abstract public ArrayList<String> legalMoves();
}
