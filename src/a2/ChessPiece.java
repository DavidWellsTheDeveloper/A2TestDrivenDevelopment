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
			case 0: return "a" + Integer.toString(row + 1);
			case 1: return "b" + Integer.toString(row + 1);
			case 2: return "c" + Integer.toString(row + 1);
			case 3: return "d" + Integer.toString(row + 1);
			case 4: return "e" + Integer.toString(row + 1);
			case 5: return "f" + Integer.toString(row + 1);
			case 6: return "g" + Integer.toString(row + 1);
			case 7: return "h" + Integer.toString(row + 1);
			default: throw new IllegalPositionException();
		}
	}
	
	public void setPosition(String position) throws IllegalPositionException {
		this.row = getRowFromPosition(position);
		this.column = getColumnFromPosition(position); 
		
	}
	
	private int getColumnFromPosition(String position) throws IllegalPositionException {
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
			default: throw new IllegalPositionException();
		}
	}

	private int getRowFromPosition(String position) throws IllegalPositionException {
		String row = position.substring(1);
		switch (row) {
			case "1": return 0;
			case "2": return 1;
			case "3": return 2;
			case "4": return 3;
			case "5": return 4;
			case "6": return 5;
			case "7": return 6;
			case "8": return 7;
			default: throw new IllegalPositionException();
		}
	}

	abstract public String toString();
	
	abstract public ArrayList<String> legalMoves();
}
