/**
 * 
 */
package a2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import a2.ChessPiece.Color;

/**
 * @author Dave
 *
 */
class BishopTest {

	ChessBoard chessBoard = new ChessBoard();

	Bishop bishop = new Bishop(chessBoard, Color.WHITE);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
//		chessBoard.placePiece(bishop, "c4");
	}

	/**
	 * Test method for {@link a2.Bishop#legalMoves()}.
	 */
	@Test
	void testIllegalMoves() {
		assertThrows(IllegalMoveException.class, () -> {
			ChessBoard chessBoard = new ChessBoard();
			Bishop bishop = new Bishop(chessBoard, Color.WHITE);
			chessBoard.placePiece(bishop, "c6");
			chessBoard.move("c6", "d6");
		});
	}

	/**
	 * Test method for {@link a2.Bishop#Bishop(a2.ChessBoard, a2.ChessPiece.Color)}.
	 */
	@Test
	void testMoveForwardLeft() {
		try {
			ChessBoard chessBoard = new ChessBoard();
			Bishop bishop = new Bishop(chessBoard, Color.WHITE);
			chessBoard.placePiece(bishop, "c6");
			chessBoard.move("c6", "a8");
			assert (chessBoard.getPiece("c6") == null);
			assert (chessBoard.getPiece("a8").getClass() == Bishop.class);
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
