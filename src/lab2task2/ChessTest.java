package lab2task2;

public class ChessTest {
    public static void main(String[] args) {
        Piece[] pieces = new Piece[6];

        Position p1 = new Position(0, 0);   // a8
        Position p2 = new Position(3, 3);   // d5
        Position p3 = new Position(7, 4);   // e1

        pieces[0] = new Rook(p1, true);
        pieces[1] = new Bishop(p2, false);
        pieces[2] = new Knight(new Position(4, 4), true);
        pieces[3] = new Queen(new Position(1, 7), false);
        pieces[4] = new King(p3, true);
        pieces[5] = new Pawn(new Position(6, 4), true);  // e2 white pawn

        System.out.println("=== Chess Pieces Demo ===");
        for (Piece p : pieces) {
            System.out.println(p);
            System.out.println("  Can move to e4 (row=4, col=4)? → " + p.isLegalMove(new Position(4, 4)));
            System.out.println("  Can move to a1 (row=7, col=0)? → " + p.isLegalMove(new Position(7, 0)));
            System.out.println();
        }

        System.out.println("=== Simple Board Example ===");
        drawSimpleBoard(pieces);
    }

    private static void drawSimpleBoard(Piece[] pieces) {
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '.';
            }
        }

        for (Piece p : pieces) {
            int r = p.getPosition().getRow();
            int c = p.getPosition().getCol();
            char symbol = getSymbol(p);
            board[r][c] = symbol;
        }

        System.out.println("  a b c d e f g h");
        for (int r = 0; r < 8; r++) {
            System.out.print((8 - r) + " ");
            for (int c = 0; c < 8; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println((8 - r));
        }
        System.out.println("  a b c d e f g h");
    }

    private static char getSymbol(Piece p) {
        if (p instanceof Rook)   return p.isWhite() ? 'R' : 'r';
        if (p instanceof Bishop) return p.isWhite() ? 'B' : 'b';
        if (p instanceof Knight) return p.isWhite() ? 'N' : 'n';
        if (p instanceof Queen)  return p.isWhite() ? 'Q' : 'q';
        if (p instanceof King)   return p.isWhite() ? 'K' : 'k';
        if (p instanceof Pawn)   return p.isWhite() ? 'P' : 'p';
        return '?';
    }
}