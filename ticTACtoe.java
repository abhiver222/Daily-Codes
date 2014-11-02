import java.util.Scanner;

public class ticTACtoe {

	private char[][] table;

	private static char vals1 = 'X';
	private static char vals2 = 'O';

	public static int countX = 0;
	public static int countO = 0;

	public static Scanner sc = new Scanner(System.in);

	public void populate() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				this.table[i][j] = '-';
	}

	public boolean set1(int x, int y) {
		if (this.table[x][y] == '-') {
			this.table[x][y] = vals1;
			countX++;
			return true;
		} else
			return false;
	}

	public boolean set2(int x, int y) {
		if (this.table[x][y] == '-') {
			this.table[x][y] = vals2;
			countO++;
			return true;
		} else
			return false;
	}

	public boolean checkcols() {
		boolean here=true;
		for (int i = 0; i < table.length; i++) {
			if (this.table[0][i] == this.table[1][i]
					&& this.table[1][i] == this.table[2][i]
					&& (this.table[1][i] != '-'))
					here = true;
			else
				here = false;

		}
		return here;
	}

	public boolean checkrows() {
		boolean here=true;;
		for (int i = 0; i < table.length; i++) {
			if (this.table[i][0] == this.table[i][1]
					&& this.table[i][1] == this.table[i][2]
					&& (this.table[i][0] != '-'))
					here = true;
			else
				here = false;
		}
		return here;
	}

	public boolean checkdiag1() {
		for (int i = 0; i < table.length; i++) {
			if (this.table[0][0] == this.table[1][1]
					&& this.table[1][1] == this.table[2][2]
					&& (this.table[1][1] != '-'))
				return true;
			else
				return false;
		}
		return false;

	}
	
	public boolean checkdiag2() {
		for (int i = 0; i < table.length; i++) {
			if (this.table[0][2] == this.table[1][1]
					&& this.table[1][1] == this.table[2][0]
					&& (this.table[1][1] != '-'))
				return true;
			else
				return false;
		}
		return false;

	}

	
	public boolean checkwin() {
		if (this.checkcols() || this.checkdiag1()|| this.checkdiag2() || this.checkrows())
			return true;
		else
			return false;
	}

	public int setterofcompx() {
		return ((int) (Math.random() * 3));
	}

	public int setterofcompy() {
		return ((int) (Math.random() * 3));
	}

	public void print() {
		System.out.println("____________");
		for (int i = 0; i < table.length; i++) {
			System.out.print("|");
			for (int j = 0; j < table.length; j++) {

				System.out.print(" ");
				System.out.print(this.table[i][j]);
				System.out.print(" ");
				System.out.print("|");
			}

			System.out.println("\n");
			System.out.println("____________");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ticTACtoe game1 = new ticTACtoe();
		game1.table = new char[3][3];
		game1.populate();
		game1.print();

		boolean win = true;
		int x1 = 0, y1 = 0;
		int x2 = 0, y2 = 0;
		int last=0;
		System.out.println("You will play against the computer and have the mark X");
		
		while (win) {
			
			boolean comp = true;
			System.out.println("enter a x and y value:");
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			if (game1.set1(x1, y1))
				System.out.println("You set X at " + x1 + " , " + y1);
			else
				continue;
			
			if (game1.checkwin()) {
				System.out.println("It seems we have a winner");
				break;
			}
			while (comp) {
				x2 = game1.setterofcompx();
				y2 = game1.setterofcompy();
				if (game1.set2(x2, y2)) {
					System.out.println("Comp set O at " + x2 + " , " + y2);
					comp = false;
				} else
					comp = true;
			}

			System.out.println(countX);
			System.out.println(countO);
			game1.print();

			if (game1.checkwin()) {
				System.out.println("It seems we have a winner");
				break;
			}

		}
		if (countX > countO)
			System.out.println("Winner is player1");
		else
			System.out.println("Winner is computer");

	}

}
