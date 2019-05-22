import java.io.*;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		boolean exit = false;
		while(!exit)
		{
			switch(menu())
			{
				case 1:
					Sudoku board = getSudoku();
					if(board != null)
					{
						System.out.println("\nUnsolved:");
						board.print();
						System.out.println("\nSolved:");
						board.solve();
					}
					break;

				case 2:
					//Sudoku board = fillSudoku();
					//solve
					break;

				case 3:
					help();
					break;

				case 4:
					System.out.println("Exiting Program");
					exit = true;
					break;

				default:
					help();
					break;
			}
		}
	}

	private static int menu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to choose one of the following:\n" +
				"1) Load Puzzle from file\n" +
				"2) Enter Puzzle manually\n" +
				"3) Help\n" +
				"4) Quit\n");
		prompt();
		int input = -1;
		try{
			input = sc.nextInt();
		} catch(Exception ex)
		{
			System.out.print(ex + "Problem with input\n");
		}
		if(input < 1 || input > 4) { input = -1; }
		return input;
	}

	private static void help()
	{
		System.out.println("\nHELP MENU:" +
				"\nSudoku Solver\n" + "by John Wiesenfeld\n");
		System.out.println("Enter a number key and press enter to make selections from the menu.");
		System.out.println("\nFormat of input file:\n" +
									"must be of .txt file, containing only integers, separated by spaces.\n" +
									"For example:\n\n" +
									"0 1 0 0 0 2 0 0 0\n" +
									"0 0 0 9 8 0 0 7 0\n" +
									"8 0 4 6 7 0 0 9 0\n" +
									"0 7 1 0 6 0 9 0 0\n" +
									"2 0 0 0 9 0 0 0 4\n" +
									"0 0 9 0 1 0 5 8 0\n" +
									"0 2 0 0 4 6 8 0 9\n" +
									"0 8 0 0 2 9 0 0 0\n" +
									"0 0 0 8 0 0 0 5 0\n");

	}
	private static Sudoku getSudoku()
	{
		Scanner userInput = new Scanner(System.in);
		Sudoku board = null;
		System.out.println("Enter Name of Input File");
		prompt();
		String fileName = userInput.next();
		try
		{
			FileReader reader = new FileReader(fileName);
			board = new Sudoku(new BufferedReader(reader));
			reader.close();
		}
		catch (FileNotFoundException fne)
		{
			System.out.println();
			System.out.println(fne.toString());
			System.out.println();
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.toString());
			System.out.println("Exiting Program");
			System.exit(0);
		}
		catch(Exception ex)
		{
			System.out.println();
			System.out.print(ex.toString());
			System.out.println(" (Problem with file format)\n");
			}
		return board;
	}
	private static void prompt() { System.out.print(">"); }
}