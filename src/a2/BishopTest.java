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
		chessBoard.initialize();
	}

	/**
	 * Test method for {@link a2.Bishop#legalMoves()}.
	 */
	@Test
	void testIllegalMoves() {
		assertThrows(IllegalMoveException.class, () -> {
			
		});
	}

	/**
	 * Test method for {@link a2.Bishop#Bishop(a2.ChessBoard, a2.ChessPiece.Color)}.
	 */
	@Test
	void testBishop() {
		fail("Not yet implemented");
	}

}
