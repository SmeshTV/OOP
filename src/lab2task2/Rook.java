package lab2task2;

public class Rook extends Piece {

    public Rook(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position target) {
        if (!target.isValid()) return false;
        if (target.equals(position)) return false;

        return target.getRow() == position.getRow() || target.getCol() == position.getCol();
    }
}