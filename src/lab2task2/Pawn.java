package lab2task2;

public class Pawn extends Piece {

    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position target) {
        if (!target.isValid()) return false;
        if (target.equals(position)) return false;

        int direction = isWhite ? -1 : 1;  // white goes up (row decreases), black down (row increases)
        int startRow = isWhite ? 6 : 1;    // white pawns start at row 6 (2nd rank), black at 1 (7th rank)

        int rowDiff = target.getRow() - position.getRow();
        int colDiff = Math.abs(target.getCol() - position.getCol());

        // Normal move forward 1 square
        if (colDiff == 0 && rowDiff == direction && target.getRow() != startRow + direction) {
            return true;
        }

        // First move - 2 squares forward
        if (position.getRow() == startRow && colDiff == 0 && rowDiff == 2 * direction) {
            return true;
        }

        // Capture diagonally
        if (colDiff == 1 && rowDiff == direction) {
            return true;  // в упрощённой версии не проверяем наличие противника
        }

        return false;
    }
}