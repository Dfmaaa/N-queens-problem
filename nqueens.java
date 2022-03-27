import java.util.Scanner;
public class nqueens {
	static class square{
		boolean isAttacked;
		String containString=" ";
		public square(){
			this.isAttacked=false;
		}
	}
	static void initializeBoardWithSquaresWithDefaultValues(){ // makes every value a instance of the square class with isAttacked as false.
		for(int x=0;x<8;x++){
			for(int i=0;i<8;i++){
				board[x][i]=new square();
			}
		}
	}
	static String queen="Q";
	static square[][] board=new square[8][8]; //the board.
	static boolean place(){
	 for(int x=0;x<8;x++){
		 for(int n=0;n<8;n++){
			 if(board[x][n].isAttacked==false){
				 board[x][n].containString=queen;
				 assignAttackedUpDownLeftRightAndDiagonal(x,n);
				 return true;
			 }
		 }
	 }
	 return false;
	}
	static void upDown(int x, int y){
		//first go up
		for(int n=x+1;n<8;n++){
			board[n][y].isAttacked=true;
		}
		//go down
		for(int n=7;n>-1;n--){
			board[n][y].isAttacked=true;
		}
	}
	static void rightLeft(int x, int y){
		//go left
		for(int n=y-1;n>-1;n--){
			board[x][n].isAttacked=true;
		}
		//go right
		for(int n=y+1;n<8;n++){
			board[x][n].isAttacked=true;
		}
	}
	static void diagonal(int x, int y){
		int xincreaser=x+1;
		int xdecreaser=x-1;
		int yincreaser=x+1;
		int ydecreaser=y-1;
		//front
		while(xincreaser<8&yincreaser<8){
			board[xincreaser][yincreaser].isAttacked=true;
			xincreaser++;
			yincreaser++;
		}
		//back
		while(xdecreaser>-1&ydecreaser>-1){
			board[xdecreaser][ydecreaser].isAttacked=true;
			xdecreaser--;
			ydecreaser--;
		}
	}
	static void assignAttackedUpDownLeftRightAndDiagonal(int x,int y){
		//assert board[x][y].containString.equals(queen); //remove if everything goes well
		board[x][y].isAttacked=true;
		upDown(x,y);
		rightLeft(x,y);
		diagonal(x,y);
	}
	static void showBoard(){
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				System.out.print(board[x][y].containString);
		    }
		    System.out.println("\n");
		}
	}
	public static void main (String[] args) {
		Scanner input=new Scanner(System.in);
		initializeBoardWithSquaresWithDefaultValues();
		while(true){
			System.out.println("Place how many queens?");
			int n=input.nextInt();
			while(n>0){
				if(place()){
					System.out.println(n+" queens left.");
					n--;
					continue;
				}
				System.out.println("Queen overflow(haha) "+ n);
				break;		
			}
			showBoard();
			initializeBoardWithSquaresWithDefaultValues();
		}
	}
}
