package lab2task2;
public abstract class Piece {
    protected Position position;
    protected boolean isWhite;

    public Piece(Position position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isLegalMove(Position target);

    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " " + getClass().getSimpleName() + " at " + position;
    }
}