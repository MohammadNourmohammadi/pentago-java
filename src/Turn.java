import java.util.Scanner;

public class Turn {

    public static void main(String[] args) {
        Board board = new Board();
        Player red = new Player(1 ,board);
        Player blue = new Player(2 , board) ;
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < 36 ; i++){
            board.print();
            if(i % 2 == 0 ){
                System.out.println("Red player's turn ");
                while (true){
                    System.out.println("Enter coordinates : ");
                    int x = input.nextInt() , y=input.nextInt();
                    if(red.moveSet(x,y))
                        break;
                    else
                        System.out.println("this input is not valid enter again");

                }
                if(red.isWine())
                    break;
                while (true){

                    System.out.println("1 : up left    2 : up right    3 : down left   4: down right");
                    System.out.println("Select one number to rotation : ");
                    int x = input.nextInt();
                    System.out.println("enter 1 to clockwise or enter 2 to counterclockwise :");
                    int y = input.nextInt();
                    if(x <0 || x > 4 || y <1 || y >2)
                        System.out.println("this input is not valid enter again");
                    else {
                        red.moveTurn(x,y);
                        break;
                    }
                }
                if (red.isWine() || blue.isWine())
                    break;
            }
            else {
                System.out.println("Blue player's turn ");
                while (true){
                    System.out.println("Enter coordinates : ");
                    int x = input.nextInt() , y=input.nextInt();
                    if(blue.moveSet(x,y))
                        break;
                    else
                        System.out.println("this input is not valid enter again");

                }
                if(blue.isWine())
                    break;
                while (true){

                    System.out.println("1 : up left    2 : up right    3 : down left   4: down right");
                    System.out.println("Select one number to rotation : ");
                    int x = input.nextInt();
                    System.out.println("enter 1 to clockwise or enter 2 to counterclockwise :");
                    int y = input.nextInt();
                    if(x <0 || x > 4 || y <1 || y >2)
                        System.out.println("this input is not valid enter again");
                    else {
                        blue.moveTurn(x,y);
                        break;
                    }
                }
                if (red.isWine() || blue.isWine())
                    break;
            }
        }
        board.print();
        if(red.isWine() == blue.isWine())
            System.out.println("tie");
        if(red.isWine() && blue.isWine() == false)
            System.out.println("red is win");
        if(red.isWine() == false && blue.isWine())
            System.out.println("blue is win");



    }
}
