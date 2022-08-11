package GenericLibrary;

import java.util.Random;

/**
 * This class contains all java specific generaic methods
 * @author sanjay
 *
 */
public class JavaLibrary {

	/**
	 * This method will generate random number for every execution
	 * @return
	 */
	public int getRandomNum() 
	{
		Random r=new Random();
		int ran = r.nextInt(2000);
		return ran;
	}
}
