/*COMP 90041 ProjB : MKOLLATHODI . 
 * 
 * Author :
 * 
 * Mohammed Ahsan Kollathodi
 * User id : MKOLLATHODI 
 * Student Id : 1048942
 * @ University of Melbourne .

The NimGame Class 

 */


import java.util.Scanner ; 

public class NimGame
{
	 
	private boolean run = true ; 
	private  int counter=0 ;  	
 	private String currentPlayer = ""; 
 	private NimPlayer currPlayerObj;

 		
 	// This is the startGame method which would initiate the play within the users . 

	public void startGame (int initialstonenumber, int upperboundstone, NimPlayer Player1, NimPlayer Player2, Scanner input) throws IndexOutOfBoundsException
	{
			boolean playagain = true ; 
				
			int currentstone = initialstonenumber;
			counter = 0;
			currPlayerObj =  Player1;
			currentPlayer= Player1.getGivenname(); 
			run = true;
			Player1.setNumgamesplayed(Player1.getNumgamesplayed()+1);
			Player2.setNumgamesplayed(Player2.getNumgamesplayed()+1);
			
			
			while (run)
			{
																
				try
				{
					System.out.print(currentstone+" stones left:");
					
					for(int i=0; i<currentstone; i++)
						System.out.print(" *");
					
					System.out.println();
					
					System.out.println(currentPlayer+"'s turn - remove how many?");
					
					int userstoneremoval = currPlayerObj.removeStone(currentstone, upperboundstone);
					
					
					//int userstoneremoval = Integer.parseInt(input.nextLine()) ;
					
																	
					if ( userstoneremoval == 0 || userstoneremoval > currentstone || userstoneremoval > upperboundstone  )
					{
						System.out.println("");
						
						if(upperboundstone > currentstone)
						{
							throw new Exception("Invalid move. You must remove between 1 and "+currentstone+" stones.");
						}
						else
						{
							throw new Exception("Invalid move. You must remove between 1 and "+upperboundstone+" stones.");
							
						}
						
						
					}
					else
					{
						counter++;
						switchPlayer(Player1, Player2) ;
						currentstone = currentstone -  userstoneremoval;
	
						System.out.println("");
						
						if (currentstone <= 0)
						{
							
							System.out.println("Game Over\n"+currPlayerObj.getGivenname()+" "+currPlayerObj.getFamilyname()+" wins!");
							
							currPlayerObj.setNumgameswon( currPlayerObj.getNumgameswon() + 1 );
													
							run = false;
						}
					}
					
				}catch(NumberFormatException index)
				{
					System.out.println("Invalid move. You must remove between 1 and "+upperboundstone+" stones.");
					System.out.println("");
					
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println("");
					
				}
			}
 		
		 	
	}
		

		// The switch player function is used to switch the turns among the players .
		
	public void switchPlayer(NimPlayer Player1, NimPlayer Player2)
	{
		if (counter%2 == 0)
		{	
			currentPlayer = Player1.getGivenname();
			currPlayerObj =  Player1;
		}
		else
		{
			currentPlayer = Player2.getGivenname();
			currPlayerObj =  Player2;
		}
	}
			
}
	
	

