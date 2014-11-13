/**
 * Trading - program that takes in input and passes it to Market class
 * @author Alexandre Pauwels
 * @author Ethan Coeytaux
 */
public class Trading {

	/**
	 * Creates and runs market model
	 * @param String[] args - list of orders to process
	 */
	public static void main(String[] args) {
		String[] inputs = StdIn.readAllLines();
		Market market = new Market(inputs);
		market.printTransactions();
	}
}
