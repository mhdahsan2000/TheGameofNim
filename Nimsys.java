/*COMP 90041 ProjB : MKOLLATHODI . 
 * 
 * 
 * . Java Application of the Nim Game . 
 * --------------------------------------
 * 
 * 
 * Author :
 * 
 * Name : Mohammed Ahsan Kollathodi 
 * User id : MKOLLATHODI
 * Student Id : 1048942
 * @ University of Melbourne .
 * 
 * 
 * ------------------------------------THE GAME OF NIM -----------------------------------
 * 
 * This game is to be played by two Players. The game nim of involves initially setting 
   a total number of stones and in each turn the user will remove certain number of stones. 
   The maximum number of stones that can be removed can be set by the user. 
 * 
 * In each turn the user will be asked to remove certain number of stones less than the 
   upper bound or the maximum limit set. 
 * 
 * The game ends when there are no more stones left and the player who removes the last stone would 
   lose while the other player will be the winner . 
 * 
 * 
 * The total number of stones and the upper bound (maximum number of stones that can be 
   removed in each turn ) can be set in the initial stage of the game.And these can be set 
   different for each game. 
 * 
 * ---------------------------------------------------------------------------------------
 */


import java.util.Scanner ;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays ;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 


public class Nimsys
{

	
	
 /*. 
  * 
  * 
  * VARIABLES AND METHODS INVOLVED : 
  * -----------------------------------------------------------------------------
  * 

  * 


  * The static variables Player1 and Player2 from the class NimPlayer 
    would correspond to two players playing the game. 
  * 
  * All of the variables are declared as static and they can be accessed anywhere 
    within the class.
    
    The Implementation involves the concept of Inheritance where NimPlayer is 
    the parent class and the child class is Nimsys as Nimsys extends 
    NimPlayer .
    
    Also the concept of encapsulation is partly implemented by setting the 
    variables as private and also by creating mutators and accessors ( getter and setter 
    methods ) .  
    
    The Implementation primarily involves Hash maps which would consist of a key and a value set . 

    
  * --------------------------------------------------------------------------------------------
  * */ 
	
	
	
 	private NimPlayer player ;

//	private static ArrayList <NimPlayer> players = new ArrayList <NimPlayer>() ; 
	Map<String, NimPlayer> players = new HashMap<String, NimPlayer>();
	static Scanner input ;
	private static NimGame ng = new NimGame();
 	
	public Nimsys()
	{
		readPlayerDetails();
	}
 	
	
	@SuppressWarnings("unchecked")
	private void readPlayerDetails() {
	      
	      try
	      {
	    	  
	    	  File f = new File("players.dat");
	    	  
	    	  if(!f.exists())
	    	  {
	    	    f.createNewFile();
	    	  }
	    	  else
	    	  {
	    	  
	    		  FileInputStream fis = new FileInputStream(f);
	         
	    		  ObjectInputStream ois = new ObjectInputStream(fis);
	         
	    		  
	    		  players = (HashMap<String, NimPlayer>) ois.readObject();
	         
	    		  ois.close();
	    		  fis.close();
	    	  }
	         
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         //return;
	      }catch(Exception c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         
	      }
		
		
	}


	public static void main (String[] args)
	{
	
		Nimsys obj = new Nimsys() ; 
		
		
		System.out.print("Welcome to Nim\n");
		
		boolean gameStart = false; 
		
		input = new Scanner(System.in);
		
		while(!gameStart)
		{
			obj.displayMessage("");
		
			try
			{
			
				System.out.print("$");
				
				String inputStr = input.nextLine();		
				
				String [] inputcommand = inputStr.split(" ");
				
				// According to the user input the corresponding method is invoked .	
			
					if (inputcommand[0].equals("addplayer"))
					{
							obj.addPlayer(inputcommand[1]) ;
						
					}
					else if (inputcommand[0].equals("addaiplayer"))
					{
							obj.addAIPlayer(inputcommand[1]) ;
						
					}
					
					else if (inputcommand[0].equals("removeplayer"))
					{
						if (inputcommand.length > 1)
						{
			
							obj.removePlayer(inputcommand[1]) ;
						}
						else
							obj.removePlayer("") ;
										
					}
					else if (inputcommand[0].equals("editplayer"))
					{
			
							obj.editPlayer(inputcommand[1]) ;		
							
					}
					else if (inputcommand[0].equals("resetstats"))
					{
			
						if (inputcommand.length > 1)
						{
							
							obj.resetStats(inputcommand[1]) ;
						}
						else
							obj.resetStats("") ;
							
					}
					else if (inputcommand[0].equals("displayplayer"))
					{
			
						if (inputcommand.length > 1)
						{
							
							obj.displayPlayer(inputcommand[1]) ;
						}
						else
							obj.displayPlayer(""); 
					
							
					}								
					else if (inputcommand[0].equals("rankings"))
					{
			
						if (inputcommand.length > 1)
						{
			
							obj.rankings(inputcommand[1]) ;
						}
						else
							obj.rankings("desc") ;
							
					}
					else if(inputcommand[0].equals("startgame"))
					{
						if( obj.checkUsers(inputcommand[1]) )
						{
							String playerInfo[] = inputcommand[1].split(",");
							
							
								obj.showPlayers(Integer.parseInt(playerInfo[0]), Integer.parseInt(playerInfo[1]), (NimPlayer) obj.players.get( playerInfo[2] ), (NimPlayer) obj.players.get( playerInfo[3] ));
															
								ng.startGame(Integer.parseInt(playerInfo[0]), Integer.parseInt(playerInfo[1]), (NimPlayer) obj.players.get( playerInfo[2] ), (NimPlayer) obj.players.get( playerInfo[3] ), input);
							
						}
						
					}
					else if(inputcommand[0].equals("exit"))
					{					
						System.out.println();
						
						obj.storePlayerDetails(obj.players);
						
						System.exit(0);
					}
					else
					{
						throw new IOException(inputcommand[0]);
					}
				
			}
			catch(IOException io)
			{
				obj.displayMessage("'"+io.getMessage()+"' is not a valid command.");
				System.out.println("");
			}
			catch(IndexOutOfBoundsException index)
			{
				obj.displayMessage("Incorrect number of arguments supplied to command");
				System.out.println("");
			}
			catch(NumberFormatException  index)
			{
				obj.displayMessage("Invalid arguments supplied to command.");
				System.out.println("");
			}
						
		}
		
	}
	
	private void storePlayerDetails(Map<String, NimPlayer> players2)  {

		try
		{
			FileOutputStream fs =
                new FileOutputStream("players.dat");
		
             ObjectOutputStream os = new ObjectOutputStream(fs);
             
             os.writeObject(players2);
             
             os.close();
             fs.close();
             
		} catch(Exception e)
		{
			//System.out.println("error --"+e.toString());
		}
		
	}

	public void showPlayers(int initialCount, int maxRemoval, NimPlayer player1, NimPlayer player2)
	{
		displayMessage("");
		
		displayMessage("Initial stone count: "+initialCount);
		displayMessage("Maximum stone removal: "+maxRemoval);
		displayMessage("Player 1: "+ player1.getGivenname() + " "+player1.getFamilyname());
		displayMessage("Player 2: "+ player2.getGivenname() +" "+player2.getFamilyname() );
		
		displayMessage("");
				
	}
	
	public boolean checkUsers(String playerDetails) throws IndexOutOfBoundsException
	{
		String playerInfo[] = playerDetails.split(",");
				
		//if( playerInfo.length >= 3 )
		{
		
			if (players.containsKey(playerInfo[2]) && players.containsKey(playerInfo[3]))
			{
								
				return true;
			}
			else
			{
				displayMessage("One of the players does not exist.");			
			}
			
		}			
		
		return false;
	}
		
	public void displayMessage(String message)
	{		
		System.out.println(message);
	}
	
	// Method to add players to the game 

	public void addPlayer(String playerDetails) throws IndexOutOfBoundsException
	{
		
		String playerInfo[] = playerDetails.split(",");
		
		//if (playerInfo.length == 3)
		{
			if(	players.containsKey(playerInfo[0]))
			{

				displayMessage("The player already exists.") ;
			}
			else
			{

				player = new NimHumanPlayer() ; 

				player.setUsername(playerInfo[0]);
				player.setFamilyname(playerInfo[1]);
				player.setGivenname(playerInfo[2]);
				
				players.put( playerInfo[0], player );

			}
		}
	
	}
	
	public void addAIPlayer(String playerDetails) throws IndexOutOfBoundsException
	{
		
		String playerInfo[] = playerDetails.split(",");
		
		//if (playerInfo.length == 3)
		{
			if(	players.containsKey(playerInfo[0]))
			{

				displayMessage("The player already exists.") ;
			}
			else
			{

				player = new NimAIPlayer() ; 

				player.setUsername(playerInfo[0]);
				player.setFamilyname(playerInfo[1]);
				player.setGivenname(playerInfo[2]);
				
				players.put( playerInfo[0], player );

			}
		}
	
	}

	

	
	// Method to remove players from the game 
	
	public void removePlayer(String removeinput) throws IndexOutOfBoundsException
	{

		
		if (removeinput.equals(""))
		{

			displayMessage("Are you sure you want to remove all players? (y/n)");
			
			String answer = input.nextLine () ; 

			if (answer.equals("y"))
			{
			
				players.clear() ; 

			}  
			
		}
		else
		{			
			
			String removeInfo[] = removeinput.split(",");
	
			
			if(removeInfo.length > 0)
			{
			
				if (players.containsKey(removeInfo[0]))
				{
	
					players.remove( removeInfo[0] );
	
				}
				else
				{
	
					displayMessage("The player does not exist.");
	
				}
			}			
		}
		
	
		
	}
	

	// Method to display players in the game 

	public void displayPlayer(String displayinput)
	{
		
		if (!displayinput.equals(""))
		{
	
			if (players.containsKey(displayinput))
			{

				player = players.get( displayinput );
				displayMessage( player.getUsername()+","+player.getGivenname()+","+player.getFamilyname()+","+player.getNumgamesplayed()+" games,"+player.getNumgameswon()+" wins" );	
			
			}
			else
			{

				displayMessage("The player does not exist.");

			}

		}
		else
		{
								
			Set<String> setKeys = players.keySet();
			
			String[] array = setKeys.toArray(new String[setKeys.size()]);
			Arrays.sort(array);
			
			for(String key : array)
			{
				
				player = players.get( key );
				displayMessage( player.getUsername()+","+player.getGivenname()+","+player.getFamilyname()+","+player.getNumgamesplayed()+" games,"+player.getNumgameswon()+" wins" );
							
			}				
			  									
		}
		
	}	
	

	// Method to edit players already existing in the game. If no players exist the corresponding output message is printed .
	public void editPlayer(String editinput) throws IndexOutOfBoundsException
	{
		
		//if (!editinput.equals(""))
		{
		
			String editInfo[] = editinput.split(",");
				
			
				if (players.containsKey(editInfo[0]))
				{
	
					//players.remove( editInfo[0] );
					player = players.get( editInfo[0] );
						
					//if(editInfo.length > 1)
					player.setFamilyname( editInfo[1] );
					
					//if(editInfo.length > 2)
					player.setGivenname( editInfo[2] );
					
					players.put(editInfo[0], player);
					
				}
				else
				{
	
					displayMessage("The player does not exist.");
	
				}
			}			
		
		
	}
	
	
	// Method to reset the stats associated with a player 

	public void resetStats(String resetstats)
	{
		
		if (!resetstats.equals(""))
		{
	
			if (players.containsKey(resetstats))
			{
	
				player = players.get( resetstats );
										
				player.setNumgamesplayed(0);					
				player.setNumgameswon(0);
				
				players.put(resetstats, player);
				
			}
			else
			{
				displayMessage("The player does not exist.");
	
			}
						
		}
		else
		{
			
			displayMessage("Are you sure you want to reset all player statistics? (y/n)");
			
			String answer = input.nextLine () ; 

			if (answer.equals("y"))
			{
			
				Set<String> setKeys = players.keySet();
				
				for(String key : setKeys)
				{
					
					player = players.get( key );
					
					player.setNumgamesplayed(0);					
					player.setNumgameswon(0);
					
					players.put(key, player);
					
				}				
			}  				
		}	
	}	
	
	
	public void rankings(String order)
	{
		int count = 0 ; 
		Collection<NimPlayer> palyerValues =  players.values();
		
		List <NimPlayer> list = new ArrayList<NimPlayer>(palyerValues);
				
		if(order.equals("desc"))
		{
			Collections.sort(list, Collections.reverseOrder());
		}
		else
		{
			Collections.sort(list);
		}
		
		for(NimPlayer nimObj : list)
		{ 
			count++ ; 

			if(count > 10){

				break ; 
			}

			  String winRate = Math.round(nimObj.getWinningrate() *100) + "%";
			  System.out.printf( "%-4s %s %02d %s %s %s", winRate, "|" , nimObj.getNumgamesplayed(), "games", "|",  nimObj.getGivenname()+" "+nimObj.getFamilyname() );
			  System.out.println();
		}	
			
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	


