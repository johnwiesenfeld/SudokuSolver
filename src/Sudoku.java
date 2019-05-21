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
				board[i][j] = new cell();
			}
		}
	}
	public Sudoku(BufferedReader reader) throws IOException, Exception
	{
		
	}

	public void print()
	{
		for(int x = 0; x < 3; x++)
		{
			System.out.print(" ");
			for(int y = 0; y < 7; y++)
			{
				System.out.print("-");
			}
		}
		System.out.println();

		for(int z = 0; z < 12; z ++)
		{
			if((z+1)%4 == 0)
			{
				for(int w = 0; w < 3; w++)
				{
					System.out.print(" ");
					for (int y = 0; y < 7; y++) {
						System.out.print("-");
					}
				}
			} else{
				for (int x = 0; x < 3; x++) {

					System.out.print("|");
					for (int y = 0; y < 3; y++) {
						System.out.print(" ");
						if (board[x][y].getValue() < 0)
						{
							System.out.print("X");
						} else {
							System.out.print(board[x][y].getValue());
						}
					}
					System.out.print(" ");
				}
				System.out.print("|");
			}
			System.out.println();
		}

	}

	private class cell
	{
		int value;
		boolean done;

		public cell()
		{
			value = -1;
			done = false;
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

