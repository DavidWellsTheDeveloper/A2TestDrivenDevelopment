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
	
	public String getPosition() {
		String file = null;
		switch (column) {
			case 0: {
				file = "a";
				break;
			}
			case 1: {
				file = "b";
				break;
			}
			case 2: {
				file = "c";
				break;
			}
			case 3: {
				file = "d";
				break;
			}
			case 4: {
				file = "e";
				break;
			}
			case 5: {
				file = "f";
				break;
			}
			case 6: {
				file = "g";
				break;
			}
			case 7: {
				file = "h";
				break;
			}
		}
		return file + Integer.toString(row);
	}
	
	public void setPosition(String position) throws IllegalPositionException {
		
	}
	
	abstract public String toString();
	
	abstract public ArrayList<String> legalMoves();
}
