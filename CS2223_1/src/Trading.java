/*
 * Trading - program that takes in input and passes it to Market class
 * @author Alexandre Pauwels
 * @author Ethan Coeytaux
 */
public class Trading {

	public static void main(String[] args) {
		//String[] inputs = StdIn.readAllLines();
		String[] inputs = new String[6];
		inputs[0] = "buy 1 1";
		inputs[1] = "buy 10  10";
		inputs[2] = "buy       5 10";
		inputs[3] = "sell 1 1";
		inputs[4] = "sell 10   4";
		inputs[5] = "sell  5 6";
		Market market = new Market(inputs);
		market.printTransactions();
	}
}
