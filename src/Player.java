
public class Player {
    private int number ;
    private Board board;

    /**
     * Instantiates a new Player.
     *
     * @param number the number of player 1 is red 2 is blue
     * @param board  the board
     */
    public Player(int number , Board board){
        this.number = number ;
        this.board = board;
    }

    /**
     * move set the cell
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean moveSet(int x, int y){
        if(x >5 || y > 5 || x < 0 || y < 0) return false;
        if(board.getCell(x,y) != 0) return false;
        board.setCell(x,y,number);
        return true;
    }

    /**
     * Is win boolean.
     *
     * @return the boolean
     */
    public boolean isWine(){
        board.upd_aim();
        for(int i = 0 ; i < 6 ; i++)
            for(int j =0 ; j < 6 ; j++)
                if(board.getCell(i,j) == number && board.getAid(i,j) >= 5)
                    return true;
        return false;
    }

    /**
     * Move turn.
     *
     * @param x the x
     * @param y the y
     */
    public void moveTurn(int x , int y){
        x--;
        if(y == 1)
            board.rotationClockwise((x/2)*3 , (x%2)*3);
        else
            board.rotationCountClockwise((x/2)*3 , (x%2)*3);
    }
}
