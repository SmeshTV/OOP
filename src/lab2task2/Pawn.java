package lab2task2;

public class Pawn extends Piece {

    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position target) {
        if (!target.isValid()) return false;
        if (target.equals(position)) return false;

        int direction = isWhite ? -1 : 1;
        int startRow = isWhite ? 6 : 1;

        int rowDiff = target.getRow() - position.getRow();
        int colDiff = Math.abs(target.getCol() - position.getCol());

        if (colDiff == 0 && rowDiff == direction && target.getRow() != startRow + direction) {
            return true;
        }

        if (position.getRow() == startRow && colDiff == 0 && rowDiff == 2 * direction) {
            return true;
        }

        if (colDiff == 1 && rowDiff == direction) {
            return true;
        }

        return false;
    }
}