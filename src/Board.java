
public class Board {
    private Integer [][] cell ;
    private Integer [][] aim ;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public Board(){
        cell = new Integer[6][6] ;
        aim = new Integer[6][6] ;
        for (int i=0 ; i < 6 ; i++)
            for (int j=0 ; j <6 ; j++){
                cell[i][j] = new Integer(0);
                aim[i][j] = new Integer(0);
            }
    }

    /**
     * Rotation clockwise.
     *
     * @param x the x
     * @param y the y
     */
    public void rotationClockwise(int x , int y){
        Integer [][] cur = new Integer[3][3] ;
        for(int i = 0 ; i < 3 ; i++)
            for(int j = 0 ; j < 3 ; j++)
                cur[i][j] = new Integer(0);
        cur[0][0] = cell [x+2][y+0];
        cur[1][0] = cell [x+2][y+1];
        cur[2][0] = cell [x+2][y+2];
        cur[0][1] = cell [x+1][y+0];
        cur[1][1] = cell [x+1][y+1];
        cur[2][1] = cell [x+1][y+2];
        cur[0][2] = cell [x+0][y+0];
        cur[1][2] = cell [x+0][y+1];
        cur[2][2] = cell [x+0][y+2];
        for(int i = 0 ; i < 3 ; i++ )
            for(int j = 0 ; j < 3 ; j++)
                cell[i+x][j+y] = cur[i][j];
    }

    /**
     * Get cell int.
     *
     * @param x the x
     * @param y the y
     * @return the int
     */
    public int getCell(int x, int y){
        return cell[x][y];
    }

    /**
     * Set cell.
     *
     * @param x   the x
     * @param y   the y
     * @param val the val
     */
    public void setCell(int x , int y, int val){
        cell[x][y] = val ;
    }

    /**
     * Get aid int.
     *
     * @param x the x
     * @param y the y
     * @return the int
     */
    public int getAid(int x , int y){
        return aim[x][y];
    }
    private void buildAid(int x , int y){
        aim[x][y] = 0 ;
        if(cell[x][y] == 0) return;
        int i = x , j = y ;
        while (j < 6  && cell[i][j] == cell[x][y])
            j++;
        aim[x][y] = Math.max(aim[x][y] , j - y);
        i = x ; j = y ;
        while (i < 6  && cell[i][j] == cell[x][y])
            i++;
        aim[x][y] = Math.max(aim[x][y] , i - x);
        i = x ; j = y ;
        while (j >=0  && cell[i][j] == cell[x][y])
            j--;
        aim[x][y] = Math.max(aim[x][y] , y - j);
        i = x ; j = y ;
        while (i >= 0  && cell[i][j] == cell[x][y])
            i--;
        aim[x][y] = Math.max(aim[x][y] , x - i);
        i = x ; j = y ;
        while (i < 6  && j < 6 && cell[i][j] == cell[x][y]){
            i++; j++;
        }
        aim[x][y] = Math.max(aim[x][y] , i - x);
        i = x ; j = y ;
        while (i < 6  && j >=0 && cell[i][j] == cell[x][y]){
            i++; j--;
        }
        aim[x][y] = Math.max(aim[x][y] , i - x);
        i = x ; j = y ;
        while (i >=0 && j >= 0 && cell[i][j] == cell[x][y]){
            i--; j--;
        }
        aim[x][y] = Math.max(aim[x][y] , x -i);
        i = x ; j = y ;
        while (i >=0  && j < 6 && cell[i][j] == cell[x][y]){
            i--; j++;
        }
        aim[x][y] = Math.max(aim[x][y] , x -i);
    }

    /**
     * Upd aim.
     */
    public void upd_aim(){
        for(int i =0 ; i < 6 ; i++ )
            for(int j = 0 ; j < 6 ; j++)
                buildAid(i , j);
    }

    /**
     * Rotation count clockwise.
     *
     * @param x the x
     * @param y the y
     */
    public void rotationCountClockwise ( int x , int y){
        Integer [][] cur = new Integer[3][3] ;
        for(int i = 0 ; i < 3 ; i++)
            for(int j = 0 ; j < 3 ; j++)
                cur[i][j] = new Integer(0);
        cur[2][0] = cell [x+0][y+0];
        cur[1][0] = cell [x+0][y+1];
        cur[0][0] = cell [x+0][y+2];
        cur[2][1] = cell [x+1][y+0];
        cur[1][1] = cell [x+1][y+1];
        cur[0][1] = cell [x+1][y+2];
        cur[2][2] = cell [x+2][y+0];
        cur[1][2] = cell [x+2][y+1];
        cur[0][2] = cell [x+2][y+2];

        for(int i = 0 ; i < 3 ; i++ )
            for(int j = 0 ; j < 3 ; j++)
                cell[i+x][j+y] = cur[i][j];
    }

    /**
     * Print.
     */
    public void print(){
        char circle = '\u25cf';
        System.out.print(ANSI_GREEN_BACKGROUND + "  ");
        for( int i = 0 ; i < 6 ; i++){
            System.out.print(ANSI_GREEN_BACKGROUND+ ANSI_PURPLE+ i + "  "+ANSI_RESET);
            if( i == 2)
                System.out.print(ANSI_GREEN_BACKGROUND + ANSI_PURPLE +"||  ");
        }
        System.out.println();
        for(int i = 0 ; i< 3 ; i++ ){
            System.out.print(ANSI_GREEN_BACKGROUND+ ANSI_PURPLE + i + " ");
            for (int j = 0 ; j < 3 ; j ++ ){
                if(cell[i][j] == 0)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 1)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_RED + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 2)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLUE + circle + "  " + ANSI_RESET);
            }
            System.out.print(ANSI_GREEN_BACKGROUND + ANSI_PURPLE + "||  " + ANSI_RESET);
            for (int j = 3 ; j < 6; j ++ ){
                if(cell[i][j] == 0)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 1)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_RED + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 2)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLUE + circle + "  " + ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_PURPLE + "  ====================  " + ANSI_RESET);
        for(int i = 3 ; i< 6; i++ ){
            System.out.print(ANSI_GREEN_BACKGROUND+ ANSI_PURPLE + i + " ");
            for (int j = 0 ; j < 3 ; j ++ ){
                if(cell[i][j] == 0)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 1)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_RED + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 2)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLUE + circle + "  " + ANSI_RESET);
            }
            System.out.print(ANSI_GREEN_BACKGROUND + ANSI_PURPLE + "||  " + ANSI_RESET);
            for (int j = 3 ; j < 6; j ++ ){
                if(cell[i][j] == 0)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 1)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_RED + circle + "  " + ANSI_RESET);
                if (cell[i][j] == 2)
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLUE + circle + "  " + ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println();
    }
}
