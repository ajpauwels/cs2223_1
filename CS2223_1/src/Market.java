import java.util.LinkedList;
import java.util.PriorityQueue;
/*
 * Trading - class representing market, handling orders and checks if market is in equilibrium
 * @author Alexandre Pauwels
 * @author Ethan Coeytaux
 */
public class Market {
	private PriorityQueue<Order> buyPQ; //priority queue for buy orders
	private PriorityQueue<Order> sellPQ; //priority queue for sell orders
	private LinkedList<Order> orders; //keeps track of orders for final output
	private LinkedList<String> transactions; //keeps track of transactions for final output

	/*
	 * Constructor for Market class
	 * @param String[] inputs - all the orders to be processed still in String form
	 */
	public Market(String[] inputs) {
		buyPQ = new PriorityQueue<Order>();
		sellPQ = new PriorityQueue<Order>();
		orders = new LinkedList<Order>();
		transactions = new LinkedList<String>();
		run(inputs);
	}

	/*
	 * Runs the market model, creating orders and making the necessary trades between orders
	 * @param String[] inputs - all the orders to be processed still in String form
	 */
	public void run(String[] inputs) {
		for (String input : inputs) {
			createOrder(input);
			makeTrades();
		}
	}

	/*
	 * Creates an Order from a String input, extracting the data from the String
	 * @param input - String form of order
	 */
	private void createOrder(String input) {
		String[] orderArray = input.split("\\s+"); //splits from whitespace
		Order order = new Order(orderArray[0], Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
		if (order.isBuy()) { //adds order to appropriate PriorityQueue
			buyPQ.add(order);
		} else {
			sellPQ.add(order);
		}
		orders.add(order); //adds to order LinkedList for output
	}

	/*
	 * If a trade can be made, processes trade and updates orders in the PriorityQueues
	 * Called recursively, returns when no trades can be made
	 */
	private void makeTrades() {
		if (buyPQ.size() != 0 && sellPQ.size() != 0) {
			Order maxBuy = buyPQ.peek();
			Order minSell = sellPQ.peek();
			if (maxBuy.getPrice() >= minSell.getPrice()) {
				int price = minSell.getPrice();
				int quantity = (maxBuy.getQuantity() < minSell.getQuantity() ? maxBuy.getQuantity() : minSell.getQuantity());
				maxBuy.substractQuantity(quantity);
				minSell.substractQuantity(quantity);
				if (maxBuy.getQuantity() == 0) buyPQ.remove();
				if (minSell.getQuantity() == 0) sellPQ.remove();
				transactions.add(price + ", " + quantity);
				makeTrades();
			}
		}
	}

	/*
	 * Prints out output
	 */
	public void printTransactions() {
		boolean filled = false;
		String inputsOutput = "on input [";
		for (Order order : orders) {
			inputsOutput += "(" + order + "), ";
			filled = true;
		}
		inputsOutput = inputsOutput.substring(0, inputsOutput.length() - (filled ? 2 : 0)) + "]";
		filled = false;
		String transactionsOutput = "the sequence of sales is: [";
		for (String output : transactions) {
			transactionsOutput += "(" + output + "), ";
			filled = true;
		}
		transactionsOutput = transactionsOutput.substring(0, transactionsOutput.length() - (filled ? 2 : 0)) + "]";
		filled = false;
		String sellsOutput = "the outstanding sell orders are: [";
		for (Order order : sellPQ) {
			sellsOutput += "(" + order.getPrice() + ", " + order.getQuantity() + "), ";
			filled = true;
		}
		sellsOutput = sellsOutput.substring(0, sellsOutput.length() - (filled ? 2 : 0)) + "]";
		filled = false;
		String buysOutput = "the outstanding buy orders are: [";
		for (Order order : buyPQ) {
			buysOutput += "(" + order.getPrice() + ", " + order.getQuantity() + "), ";
			filled = true;
		}
		buysOutput = buysOutput.substring(0, buysOutput.length() - (filled ? 2 : 0)) + "]";
		System.out.println(inputsOutput);
		System.out.println(transactionsOutput);
		System.out.println(sellsOutput);
		System.out.println(buysOutput);
	}
}
