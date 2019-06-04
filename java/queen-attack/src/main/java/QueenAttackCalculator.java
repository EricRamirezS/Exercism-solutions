public class QueenAttackCalculator {

    private Queen whiteQueen;
    private Queen blackQuuen;

    public QueenAttackCalculator(Queen whiteQueen, Queen blackQuuen) {
        this.whiteQueen = whiteQueen;
        this.blackQuuen = blackQuuen;
        checkQueens();
    }

    private void checkQueens() {
        if (whiteQueen == null || blackQuuen == null)
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        if (whiteQueen.getCol() == blackQuuen.getCol() && whiteQueen.getRow() == blackQuuen.getRow())
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
    }

    public boolean canQueensAttackOneAnother() {
        int wqRow = whiteQueen.getRow();
        int wqCol = whiteQueen.getCol();
        int bqRow = blackQuuen.getRow();
        int bqCol = blackQuuen.getCol();
        if (wqRow == bqRow) return true;
        if (wqCol == bqCol) return true;
        return Math.abs(wqRow - bqRow) == Math.abs(wqCol - bqCol);
    }
}
