
public class Trading {
	
	/*
	 * The main function simply takes in the buy/sell orders, feeds them to Market,
	 * and then prints the transactions which occurred.
	 * @param args
	 */
	public void main(String[] args) {
		String[] inputs = StdIn.readAllLines();
		Market market = new Market(inputs);
		market.printTransactions();
	}
}

