package a2;

import java.util.ArrayList;

/**
 * @author dave
 *
 */
public class Bishop extends ChessPiece {

	public Bishop(ChessBoard board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		String unicode =  "";
		if (this.color == Color.WHITE)
			return unicode + '\u2657';
		else 
			return unicode + '\u265D';
	}
	
	private String getLeft(String position) {
		String file = position.substring(0,1);
		switch (file) {
			case "b": {
				file = "a";
				break;
			}
			case "c": {
				file = "b";
				break;
			}
			case "d": {
				file = "c";
				break;
			}
			case "e": {
				file = "d";
				break;
			}
			case "f": {
				file = "e";
				break;
			}
			case "g": {
				file = "f";
				break;
			}
			case "h": {
				file = "g";
				break;
			}
		}
		return file + position.substring(1);
	}
	
	private String getRight(String position) {
		String file = position.substring(0,1);
		switch (file) {
			case "a": {
				file = "b";
				break;
			}
			case "b": {
				file = "c";
				break;
			}
			case "c": {
				file = "d";
				break;
			}
			case "d": {
				file = "e";
				break;
			}
			case "e": {
				file = "f";
				break;
			}
			case "f": {
				file = "g";
				break;
			}
			case "g": {
				file = "h";
				break;
			}
		}
		return file + position.substring(1);
	}
	
	private String getForward(String position) {
		String file = position.substring(0,1);
		int row = Integer.parseInt(position.substring(1)) + 1;
		return file + Integer.toString(row);
	}
	
	private String getBack(String position) {
		String file = position.substring(0,1);
		int row = Integer.parseInt(position.substring(1)) - 1;
		return file + Integer.toString(row);
	}

	@Override
	public ArrayList<String> legalMoves() {
		ArrayList<String> moves = new ArrayList<String>();
		String forwardLeft = this.getPosition();
		String forwardRight = this.getPosition();
		String backLeft = this.getPosition();
		String backRight = this.getPosition();
		while(!forwardLeft.substring(0, 1).equals("a") && !forwardLeft.substring(1).contentEquals("8")) {
			forwardLeft = getLeft(getForward(forwardLeft));
			try {
				if(board.getPiece(forwardLeft) == null) {
					moves.add(forwardLeft);
				}
				else if (board.getPiece(forwardLeft).color != this.color) {
					moves.add(forwardLeft);
					break;
				}
				else {
					break;
				}
			} catch (IllegalPositionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!forwardRight.substring(0, 1).equals("h") && !forwardRight.substring(1).contentEquals("8")) {
			forwardRight = getRight(getForward(forwardRight));
			try {
				if(board.getPiece(forwardRight) == null) {
					moves.add(forwardRight);
				}
				else if (board.getPiece(forwardRight).color != this.color) {
					moves.add(forwardRight);
					break;
				}
				else {
					break;
				}
			} catch (IllegalPositionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!backRight.substring(0, 1).equals("h") && !backRight.substring(1).contentEquals("1")) {
			backRight = getRight(getBack(backRight));
			try {
				if(board.getPiece(backRight) == null) {
					moves.add(backRight);
				}
				else if (board.getPiece(backRight).color != this.color) {
					moves.add(backRight);
					break;
				}
				else {
					break;
				}
			} catch (IllegalPositionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!backLeft.substring(0, 1).equals("h") && !backLeft.substring(1).contentEquals("1")) {
			backLeft = getLeft(getBack(backLeft));
			try {
				if(board.getPiece(backLeft) == null) {
					moves.add(backLeft);
				}
				else if (board.getPiece(backLeft).color != this.color) {
					moves.add(backLeft);
					break;
				}
				else {
					break;
				}
			} catch (IllegalPositionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return moves;
		
	}

}
