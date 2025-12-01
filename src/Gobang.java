import java.util.Scanner;

public class Gobang {
    public static char[][] chessBoard={
            {'┌', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┐'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
            {'└', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┘'}
    };
    public static char pieceA='■';
    public static char pieceB='○';
    public static String kongXia="─────";
    public static int times;
    //算了不管了，先实现棋盘打印的功能
    public static void showChessBoard(){
        int row=chessBoard.length;//从上往下数，10列（行列不分，希望没说错）
        int line=chessBoard[0].length;//从左往右数，10行
        System.out.println("    0     1     2     3     4     5     6     7     8     9");
        for(int i=0;i<row;i++){
            System.out.print(i+"   ");
            for(int j=0;j<line;j++){
                if(j<line-1) {
                    System.out.print(chessBoard[i][j] + kongXia);
                }else {
                    System.out.print(chessBoard[i][j]);
                }
            }
            System.out.println();
            if(i<row-1) {
                System.out.println("    │     │     │     │     │     │     │     │     │     │");
            }
        }
    }

    public static void main(String []  args){
        Scanner sc=new Scanner(System.in);
        showChessBoard();
        times=0;
        while(true){
            String currentPlayer=(times%2==0)?"该玩家A落子":"该玩家B落子";
            System.out.println(currentPlayer);
            char currentPiece=(times%2==0)?pieceA:pieceB;
            int position=sc.nextInt();
            int positionMAX=chessBoard.length*chessBoard[0].length;
            if(position>=0&&position<positionMAX){
                int cow=position/10;
                int line=position%10;
                if(chessBoard[cow][line]==pieceA||chessBoard[cow][line]==pieceB){
                    System.out.println("落子失败，请重新落子");
                }
                else{
                    chessBoard[cow][line]=currentPiece;
                    //次数和打印都交给判断胜利的函数吧
                    times++;
                    //
                }
            }else{
                System.out.println("落子失败，请重新落子");
            }
        }
    }
    public static void judgeWin(){

    }

}
