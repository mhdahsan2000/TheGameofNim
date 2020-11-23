import java.io.Serializable;

public class NimAIPlayer extends NimPlayer implements Serializable {
	
	private static final long serialVersionUID = 4257423445755582269L;
	
	public  int removeStone(int currentStone,int upperboundstone) 
	{
		int stoneToRemove = 1; 
		
		int originalStone = currentStone;
		
		int maxVal = (currentStone-1)/(upperboundstone+1);      //the maximum value 
		
		for(int j = 0; j <= maxVal; j++)
		{
			
		    int leftStone = j * (upperboundstone+1)+1;       // the number of left stones = j*(upper bound+)+1
		    
		    int stoneRemoved = currentStone-leftStone;       // the number of stone removed
		    
			if((stoneRemoved) <= upperboundstone){             // if the number of stone removed is less than upper bound
				currentStone = leftStone;                    
				stoneToRemove = stoneRemoved;
				break;                                       // Break loop
			}
		}
		
		if (currentStone == originalStone)
		{            			
			return 1;                            // just remove one stone
		}  
		
		
		return stoneToRemove;       
		
		
	}

}
