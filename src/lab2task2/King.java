package lab2task2;
public class King extends Piece {

    public King(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position target) {
        if (!target.isValid()) return false;
        if (target.equals(position)) return false;

        int rowDiff = Math.abs(target.getRow() - position.getRow());
        int colDiff = Math.abs(target.getCol() - position.getCol());

        // King moves one square in any direction (including diagonal)
        return rowDiff <= 1 && colDiff <= 1;
    }
}