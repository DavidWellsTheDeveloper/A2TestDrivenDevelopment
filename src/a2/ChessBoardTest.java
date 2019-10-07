package a2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Dave Wells
 */
class ChessBoardTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testConstructorBoard() {
		ChessBoard chessBoard = new ChessBoard();
		
		try {
			assertEquals(chessBoard.getPiece("a1"), null);
			assertEquals(chessBoard.getPiece("h1"), null);
			assertEquals(chessBoard.getPiece("h8"), null);
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testExpectedIllegalPosition () {
		ChessBoard chessBoard = new ChessBoard();
		Assertions.assertThrows(IllegalPositionException.class, () -> {
			chessBoard.getPiece("a9");
		});
		Assertions.assertThrows(IllegalPositionException.class, () -> {
			chessBoard.getPiece("q9");
		});
	}
	
	@Test
	void testNotThrowIllegalPosition () {
		
	}
	

	@Test
	void testInitialize() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPiece() {
		fail("Not yet implemented");
	}

	@Test
	void testPlacePiece() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
