package a2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import a2.ChessPiece.Color;

/**
 * @author Dave Wells
 */
class ChessPieceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testChessPiece() {
		fail("Not yet implemented");
	}

	@Test
	void testGetColor() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("b1");
		assertEquals(chessPiece.color, Color.WHITE);
		chessPiece = chessBoard.getPiece("f8");
		assertEquals(chessPiece.color, Color.BLACK);
	}

	@Test
	void testGetPosition() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		Rook chessPiece = new Rook(chessBoard, Color.WHITE);
		assert (chessBoard.placePiece(chessPiece, "a1"));
		assertEquals(chessPiece.getPosition(), "a1");
	}

	@Test
	void testSetPosition() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testLegalMoves() {
		fail("Not yet implemented");
	}

}
