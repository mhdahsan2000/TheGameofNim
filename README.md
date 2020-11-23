# TheGameofNim
The Game of Nim in Java 

Nim is a Game of Stratergy.
How the game works : 
• The game begins with a number of objects (e.g., stones placed on a table).
• Each player takes turns removing stones from the table.
• On each turn, a player must remove at least one stone. In addition, there is an upper bound on the
number of stones that can be removed in a single turn. For example, if this upper bound is 3, a
player has the choice of removing 1, 2 or 3 stones on each turn.
• The game ends when there are no more stones remaining. The player who removes the last stone,
loses. The remaining player wins.
• Both the initial number of stones, and the upper bound on the number that can be removed, can be
varied from game to game, and must be chosen before a game commences.

Nimsys.java would contain the main execution file or it contains the min method to managethe playing process.
NimAIPlayer.java would contain the AI Component so the player can play against an AI(Computer)!

A player, as described by the NimPlayer class, would have the following information associated with
it:
• A username
• A given name
• A family name
• Number of games played
• Number of games won
Functionalities : 
- Adding a new player with an existing user name 
- Removing a player with a non-exisiting username 
- Resetting the statistics of a player with a non-existing username 
- Displaying a player with a non-existing username 
- Starting a game where atleast one of the player's username do not exist. 
- Removing the stone that is out of range. 


The only difference between a human player and an AI player is in the way that they make a move.
Instead of prompting for a move to be entered via standard input, the AI player hooses their
own move, based on the state of the game. Thus, the only difference between a human player and an AI
player should be in the method used to make a move.


Put all of the files in a single folder and run Nimsys.java 
