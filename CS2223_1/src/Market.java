import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * Trading - class representing market, handling orders and checks if market is in equilibrium
 * @author Alexandre Pauwels
 * @author Ethan Coeytaux
 */
public class Market {
	private PriorityQueue<Order> buyPQ;
	private PriorityQueue<Order> sellPQ;
	private LinkedList<String> orders;
	private LinkedList<String> transactions;
	
	public Market(String[] inputs) {
		buyPQ = new PriorityQueue<Order>();
		sellPQ = new PriorityQueue<Order>();
		orders = new LinkedList<String>();
		transactions = new LinkedList<String>();
		run(inputs);
	}
	
	public void run(String[] inputs) {
		for (String input : inputs) {
			createOrder(input);
			while (makeTrades()) { }
		}
	}
	
	private void createOrder(String input) {
		String[] orderArray = input.split("\\s+");
		Order order = new Order(orderArray[0], Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
		if (order.isBuy()) {
			buyPQ.add(order);
		} else {
			sellPQ.add(order);
		}
		orders.add(order.getPrice() + ", " + order.getQuantity());
	}
	
	private boolean makeTrades() {
		if (buyPQ.size() == 0 || sellPQ.size() == 0) return false;
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
			return true;
		} else return false;
	}
	
	public void printTransactions() {
		boolean filled = false;
		String inputsOutput = "on input [";
		for (String output : orders) {
			inputsOutput += "(" + output + "), ";
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
