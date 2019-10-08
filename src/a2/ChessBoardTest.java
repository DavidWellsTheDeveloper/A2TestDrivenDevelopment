package a2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import a2.ChessPiece.Color;

/**
 * @author Dave Wells
 */
class ChessBoardTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testConstructorBoard() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		assertEquals(chessBoard.getPiece("a1"), null);
		assertEquals(chessBoard.getPiece("h1"), null);
		assertEquals(chessBoard.getPiece("h8"), null);
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
		ChessBoard chessBoard = new ChessBoard();
		try {
			chessBoard.getPiece("a1");
		}
		catch (IllegalPositionException ex){
			fail("This should be a valid operation");
		}
	}
	

	@Test
	void testInitialize() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("a1");
		assertTrue(chessPiece != null);
		
	}

	@Test
	void testGetRook() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("a1");
		assertTrue(chessPiece instanceof Rook);
		chessPiece = chessBoard.getPiece("a8");
		assertTrue(chessPiece instanceof Rook);
		chessPiece = chessBoard.getPiece("h1");
		assertTrue(chessPiece instanceof Rook);
		chessPiece = chessBoard.getPiece("h8");
		assertTrue(chessPiece instanceof Rook);
	}
	
	@Test
	void testGetBishop() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("c1");
		assertTrue(chessPiece instanceof Bishop);
		chessPiece = chessBoard.getPiece("c8");
		assertTrue(chessPiece instanceof Bishop);
		chessPiece = chessBoard.getPiece("f1");
		assertTrue(chessPiece instanceof Bishop);
		chessPiece = chessBoard.getPiece("f8");
		assertTrue(chessPiece instanceof Bishop);
	}
	
	@Test
	void testGetKing() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("e1");
		assertTrue(chessPiece instanceof King);
		chessPiece = chessBoard.getPiece("e8");
		assertTrue(chessPiece instanceof King);
	}
	
	@Test
	void testGetQueen() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("d1");
		assertTrue(chessPiece instanceof Queen);
		chessPiece = chessBoard.getPiece("d8");
		assertTrue(chessPiece instanceof Queen);
	}
	
	@Test
	void testGetKnight() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("b1");
		assertTrue(chessPiece instanceof Knight);
		chessPiece = chessBoard.getPiece("b8");
		assertTrue(chessPiece instanceof Knight);
		chessPiece = chessBoard.getPiece("g1");
		assertTrue(chessPiece instanceof Knight);
		chessPiece = chessBoard.getPiece("g8");
		assertTrue(chessPiece instanceof Knight);
	}
	
	@Test
	void testGetPawn() throws IllegalPositionException {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.initialize();
		ChessPiece chessPiece = chessBoard.getPiece("a2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("b2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("c2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("d2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("e2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("f2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("g2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("h2");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("a7");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("b7");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("c7");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("d7");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("e7");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("f7");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("g7");
		assertTrue(chessPiece instanceof Pawn);
		chessPiece = chessBoard.getPiece("h7");
		assertTrue(chessPiece instanceof Pawn);
		
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
