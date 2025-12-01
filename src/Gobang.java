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
        outre:
        while(true){
            String currentPlayer=(times%2==0)?"该玩家A落子":"该玩家B落子";
            System.out.println(currentPlayer);
            char currentPiece=(times%2==0)?pieceA:pieceB;
            //这倒是提醒我了，一个加一个输入判断
            int position;
            if(sc.hasNextInt()){
                position=sc.nextInt();
            }else{
                sc.next();
                System.out.println("落子失败，请重新落子");
                continue ;
            }
            int positionMAX=chessBoard.length*chessBoard[0].length;
            if(position>=0&&position<positionMAX){
                int cow=position/10;
                int line=position%10;
                if(chessBoard[cow][line]==pieceA||chessBoard[cow][line]==pieceB){
                    System.out.println("落子失败，请重新落子");
                    continue ;
                }
                else{
                    chessBoard[cow][line]=currentPiece;
                    //次数和打印都交给判断胜利的函数吧
//                    times++;
                    //
                }
            }else{
                System.out.println("落子失败，请重新落子");
                continue ;
            }

            int row_length=chessBoard.length;//从上往下数，10列（行列不分，希望没说错）
            int line_length=chessBoard[0].length;//从左往右数，10行
            for(int i=0;i<row_length;i++){
                for(int j=0;j<line_length;j++){
                    //注意哦，我还没有更新times，好吧其实更新了也无所谓，因为上面代码并没有重新执行
                    if(chessBoard[i][j]==currentPiece){
                        boolean judge1=false,judge2=false,judge3=false,judge4=false;
                        //水平
                        if(i+4<row_length) {
                            judge1=(chessBoard[i+1][j]==currentPiece)
                                    &&(chessBoard[i+2][j]==currentPiece)
                                    &&(chessBoard[i+3][j]==currentPiece)
                                    && chessBoard[i+4][j]==currentPiece;
                        }
                        if(j+4<line_length){
                            judge2=(chessBoard[i][j+1]==currentPiece)
                                    &&(chessBoard[i][j+2]==currentPiece)
                                    &&(chessBoard[i][j+3]==currentPiece)
                                    && chessBoard[i][j+4]==currentPiece;
                        }
                        //哎呀，写错了
                        if( i+4<row_length && j+4<line_length ){
                            judge3=(chessBoard[i+1][j+1]==currentPiece)
                                    &&(chessBoard[i+2][j+2]==currentPiece)
                                    &&(chessBoard[i+3][j+3]==currentPiece)
                                    && chessBoard[i+4][j+4]==currentPiece;
                        }

                        if( i+4<row_length && j>=4 ){
                            judge4=(chessBoard[i+1][j-1]==currentPiece)
                                    &&(chessBoard[i+2][j-2]==currentPiece)
                                    &&(chessBoard[i+3][j-3]==currentPiece)
                                    && chessBoard[i+4][j-4]==currentPiece;
                        }
                        if(judge1||judge2||judge3||judge4){
                            String currentWin=(times%2==0)?"玩家A":"玩家B";
                            System.out.println(currentWin+"获得胜利！！");
                            break outre;
                        }
                    }
                }
            }
            times++;
            showChessBoard();
        }

    }


}
