import java.util.Scanner;

interface GameInterface{
	public static final int x = 1, o = -1, EMPTY = 0;
	void clear();
	void markAt(int p);
	void printBoard();
	int winner();
	
}
public class TicTacToe implements GameInterface{
	private int[][] board = new int[3][3];
	private int player;
	int size;
	public TicTacToe() {
		clear();
	}
	
	public void clear() {
		board = new int[3][3];
		player = x;
		size = 0;
	}
	
	public void markAt(int p) throws IllegalArgumentException{
		int i,j;
		switch(p){
			case 1->{
				i = j = 0;
			}case 2->{
				i = 0;
				j = 1;
			}case 3->{
				i = 0;
				j = 2;
			}case 4->{
				i = 1;
				j = 0;
			}case 5->{
				i = 1;
				j = 1;
			}case 6->{
				i = 1;
				j = 2;
			}case 7->{
				i = 2;
				j = 0;
			}case 8->{
				i = 2;
				j = 1;
			}case 9->{
				i = 2;
				j = 2;
			}default->throw new IllegalArgumentException("Invalid Position !");
		}
		if(board[i][j] != EMPTY)
			throw new IllegalArgumentException("Position Occupied !");
		board[i][j] = player;
		player = -player;
		size++;
	}
	
	
	private boolean row0(int m){
			return board[0][0] + board[0][1] + board[0][2] == m*3;
		}
	private boolean row1(int m) {
			return board[1][0] + board[1][1] + board[1][2] == m*3;
		}
	private boolean row2(int m) {
			return board[2][0] + board[2][1] + board[2][2] == m*3;
		}
	private boolean col0(int m) {
			return board[0][0] + board[1][0] + board[2][0] == m*3;
		}
	private boolean col1(int m) {
			return board[0][1] + board[1][1] + board[2][1] == m*3;
		}
	private boolean col2(int m) {
			return board[0][2] + board[1][2] + board[2][2] == m*3;
		}
	private boolean majD(int m) {
			return board[0][0] + board [1][1] + board[2][2] == m*3;
		}
	private boolean minD(int m) {
			return board[2][0] + board[1][1] + board[0][2] == m*3;
		}
		
	
	public boolean isWin(int mark) {
		return row0(mark) || row1(mark) || row2(mark)
				|| col0(mark) || col1(mark) || col2(mark)
				|| majD(mark) || minD(mark);
	}
	
	public int winner() {
		if(isWin(x))
			return x;
		else if(isWin(o))
			return o;
		else
			return 0;
	}

	private int fill(int i,int j){
		return (i==0)?(j==0)?1:(j == 1)?2:3:(i==1)?(j==0)?4:(j == 1)?5:6:(j==0)?7:(j==1)?8:9;
	}
	
	public void printBoard() {
		System.out.println("  0 1 2 ");

		for(int i=0;i<3;i++){
			System.out.print(i+"|");
			for(int j=0;j<3;j++){
				switch(board[i][j]){
					case 1->System.out.print("x|");
					case -1->System.out.print("o|");
					case 0->System.out.print(fill(i, j)+"|");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TicTacToe t = new TicTacToe();
		System.out.print("Enter Player1 name: ");
		String p1 = sc.nextLine();
		System.out.print("Enter Player2 Name: ");
		String p2 = sc.nextLine();
		String[] p = {p1,p2};
		t.printBoard();
		int i = 0,choice = 1;
		int winningPlayer = 0,size = 0;
		while(choice == 1){			
			System.out.println(p[i]+"'s turn: ");
			System.out.println("Enter position to mark: ");
			try {
				t.markAt(sc.nextInt());
				i = (i==0)?1:0;
				size++;
			}catch(IllegalArgumentException e) {
				System.out.println(e);
			}
			t.printBoard();
			winningPlayer = t.winner();
			if(winningPlayer == 1) {
				System.out.println("CONGRATULATIONS !\nWinner : "+p1);
				i = winningPlayer = size = 0;
				System.out.println("If you want to continue press 1: ");
				choice = sc.nextInt();
			}
			else if(winningPlayer == -1) {
				System.out.println("CONGRATULATIONS !\nWinner : "+p2);
				i = winningPlayer = size = 0;
				System.out.println("If you want to continue press 1: ");
				choice = sc.nextInt();
			}
			else if(size == 9) {
				System.out.println("TIE !");
				i = winningPlayer = size = 0;
				System.out.println("If you want to continue press 1: ");
				choice = sc.nextInt();
			}
		}
		System.out.println("Game Finished !\nThank You For Playing !");
	}
}