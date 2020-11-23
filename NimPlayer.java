/*COMP 90041 ProjB : MKOLLATHODI . 
 * 
 * Author :
 * 
 * Mohammed Ahsan Kollathodi
 * User id : MKOLLATHODI 
 * Student Id : 1048942
 * @ University of Melbourne .
 * 
 * 
 * 
 *
 * 
 * This the parent class to the child class Nimsys . 
 * 
 * 
 */


import java.io.Serializable;
import java.util.Scanner ; 

/*
 *
 * A Player as described by the NimPlayer class will have the following attributes : 
 * 
 * A username  .
 * A given name .
 * A family name .
 * Number of games played by the user.
 * Number of games won by the user.
 * 
 * The System allows players to be added . 
 * System allows players to be deleted or for their details to be edited. 
 * Players are directly able to edit the game statistics, and also are able to reset them.
 * 
 * 
 * There is an exit command to end the program which will terminate the program . 
 * 
 * An Interface Comparable is implemented in this class . 
 * 
 */


public abstract class NimPlayer implements Comparable< NimPlayer >, Serializable  {

	// The instance variables correspoding to the player attributes
	private static final long serialVersionUID = -4257423445755582269L;

	private  String username ; 
	private  String givenname ; 
	private  String familyname ; 

	private int numgamesplayed = 0; 
	private int numgameswon = 0 ;
	
	

	// Getter and setter methods for the player attributes 

	public  String getUsername() {
		return this.username;
	}
	public  void setUsername(String username) {
		this.username = username;
	}
	public  String getGivenname() {
		return this.givenname;
	}
	public  void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	public  String getFamilyname() {
		return familyname;
	}
	public  void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public int getNumgamesplayed() {
		return this.numgamesplayed;
	}
	public void setNumgamesplayed(int numgamesplayed) {
		this.numgamesplayed = numgamesplayed;
	}
	public int getNumgameswon() {
		return numgameswon;
	}
	public void setNumgameswon(int numgameswon) {
		this.numgameswon = numgameswon;
	}
	
	public float getWinningrate() {
				
		if(this.numgamesplayed == 0)
			return 0;
		else
			return (float)this.numgameswon/(float)this.numgamesplayed ;
	}
	
	@Override
	public int compareTo(NimPlayer nim) {
		
		//return Integer.valueOf((int)this.getWinningrate()).compareTo(Integer.valueOf((int)nim.getWinningrate()));
		if (Float.compare(this.getWinningrate(),nim.getWinningrate())!=0)
			return Float.compare(this.getWinningrate(),nim.getWinningrate());
		else
		{
			return nim.getUsername().compareTo(this.getUsername());
		}
			
			
		
	}
	
	//method1: to remove number of stones
    public abstract int removeStone(int currentStone, int upperboundstone);
	
}