package lab2task2;

public class Bishop extends Piece {

    public Bishop(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position target) {
        if (!target.isValid()) return false;
        if (target.equals(position)) return false;

        // Bishop moves diagonally
        int rowDiff = Math.abs(target.getRow() - position.getRow());
        int colDiff = Math.abs(target.getCol() - position.getCol());
        return rowDiff == colDiff;
    }
}