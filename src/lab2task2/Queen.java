package lab2task2;
public class Queen extends Piece {

    public Queen(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position target) {
        if (!target.isValid()) return false;
        if (target.equals(position)) return false;

        int rowDiff = Math.abs(target.getRow() - position.getRow());
        int colDiff = Math.abs(target.getCol() - position.getCol());

        return (target.getRow() == position.getRow() || target.getCol() == position.getCol()) ||
               (rowDiff == colDiff);
    }
}