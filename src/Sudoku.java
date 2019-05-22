import java.io.*;

public class Sudoku{

	cell[][] board;

	public Sudoku()
	{
		board = new cell[9][9];

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				board[i][j] = new cell(0);
			}
		}
	}
	public Sudoku(BufferedReader reader) throws IOException, Exception
	{
		board = new cell[9][9];
		String line;
		int value;
		for(int i = 0; i < 9; i++)
		{
			line = reader.readLine();
			String[] tokens = line.split(" ");
			for(int j = 0; j < 9; j++)
			{
				value = Integer.parseInt(tokens[j]);
				board[i][j] = new cell(value);
			}
		}
	}

	public void solve()
		{
			//need to write
		}

	private boolean testCol(int row, int col)
		{
			boolean pass = true;
			for(int i = 0; i < 9; i++)
			{
				if(i != row)
				{
					if(board[i][col].getValue() == board[row][col].getValue() && board[i][col].getValue() != 0)
					{
						pass = false;
					}
				}
			}
			return pass;
		}

	private boolean testRow(int row, int col)
		{
			boolean pass = true;
			for(int i = 0; i < 9; i++)
			{
				if(i != col)
				{
					if(board[row][i].getValue() == board[row][col].getValue() && board[row][i].getValue() != 0)
					{
						pass = false;
					}
				}
			}
			return pass;
		}

	private boolean testBox(int row, int col)
		{
			//need to write
			return false;
		}

	public void print() {
		for (int x = 0; x < 9; x++) {
			if (x % 3 == 0) {
				for (int z = 0; z < 3; z++) {
					System.out.print(" ");
					for (int w = 0; w < 7; w++) {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			for (int y = 0; y < 9; y++) {
				if (y % 3 == 0) {
					System.out.print("| ");
				}
				if (board[x][y].getValue() < 0) {
					System.out.print("0 ");
				} else {
					System.out.print(board[x][y].getValue() + " ");
				}
			}
			System.out.print("|");
			System.out.println();
		}

		for (int x = 0; x < 3; x++) {
			System.out.print(" ");
			for (int y = 0; y < 7; y++) {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	private class cell
	{
		int value;
		boolean done;

		public cell(int value)
		{
			this.value = value;
			done = true; //cell will only be initialized with value when setting board, value is final
		}

		public void setValue(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return this.value;
		}

		public void setDone(boolean done)
		{
			this.done = done;
		}

		public boolean getDone()
		{
			return done;
		}
	}
}

