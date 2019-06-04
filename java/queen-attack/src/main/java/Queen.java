public class Queen {

    private int row;
    private int col;

    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
        checkValidPosition();
    }

    private void checkValidPosition() {
        if (row < 0) throw new IllegalArgumentException("Queen position must have positive row.");
        if (col < 0) throw new IllegalArgumentException("Queen position must have positive column.");
        if (row > 7) throw new IllegalArgumentException("Queen position must have row <= 7.");
        if (col > 7) throw new IllegalArgumentException("Queen position must have column <= 7.");
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
