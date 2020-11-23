import java.io.Serializable;

public class NimHumanPlayer extends NimPlayer implements Serializable  {
	
	private static final long serialVersionUID = -7491827543585751582L;

	public  int removeStone(int currentStone, int upperboundstone)
	{
		
		return Integer.parseInt(Nimsys.input.nextLine()) ;
	}

}
