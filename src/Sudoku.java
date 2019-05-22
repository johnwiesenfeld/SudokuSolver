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
				if(value > 0) {board[i][j].setDone(true);}
			}
		}
	}

	public boolean solve()
		{
			int row = 0;
			int col = 0;
			boolean safe;

			while(row < 9)
			{
				safe = true;
				if(!board[row][col].getDone())
				{
					board[row][col].setValue(board[row][col].getValue() + 1);
					if(board[row][col].getValue() > 9)
					{
						board[row][col].setValue(0);
						col--;
						if(col < 0)
						{
							row--;
							col = 8;
						}
						while(board[row][col].getDone())
						{
							col--;
							if(col < 0)
							{
								row--;
								col = 8;
							}
							if(row < 0)
							{
								return false;
							}
						}
						continue;
					}
					if(!(col < 0))
					{
						safe = testRow(row, col);
						if(safe) { safe = testCol(row,col); }
						if(safe) { safe = testBox(row, col); }
						if(safe)
						{
							col ++;
						}
					}
				} else {
					col++;
				}
				if(col > 8)
				{
					row++;
					col = 0;
				}
				if(col < 0)
				{
					row--;
					col = 8;
				}
				if(row < 0)
				{
					return false;
				}
			}
			return true;
		}

	public boolean testCol(int row, int col)
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

	public boolean testRow(int row, int col)
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

	public boolean testBox(int row, int col)
		{
			int  testRow = 6;
			int testCol = 6;
			boolean pass = true;
			if(row < 6) { testRow = 3; }
			if(row < 3) { testRow = 0; }
			if(col < 6) { testCol = 3; }
			if(col < 3) { testCol = 0; }

			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(testRow + i != row && testCol + j != col)
					{
						if(board[row][col].getValue() == board[testRow + i][testCol + j].getValue()
								&& board[testRow + i][testCol + j].getValue() != 0)
						{
							pass = false;
						}
					}
				}
			}
			return pass;
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
			done = false; //cell will only be initialized with value when setting board, value is final
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

