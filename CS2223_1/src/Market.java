import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Market {
	private PriorityQueue<Order> buyPQ;
	private PriorityQueue<Order> sellPQ;
	private Queue<String> transactions;
	
	public Market(String[] inputs) {
		buyPQ = new PriorityQueue<Order>();
		sellPQ = new PriorityQueue<Order>();
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
	}
	
	private boolean makeTrades() {
		if (buyPQ.size() == 0 || sellPQ.size() == 0) return false;
		
		Order maxBuy = buyPQ.peek();
		Order minSell = sellPQ.peek();
		if (maxBuy.getPrice() >= minSell.getPrice()) {
			int price = maxBuy.getPrice();
			int quantity = (maxBuy.getQuantity() < minSell.getQuantity() ? maxBuy.getQuantity() : minSell.getQuantity());
			maxBuy.substractQuantity(quantity);
			minSell.substractQuantity(quantity);
			if (maxBuy.getQuantity() == 0) buyPQ.remove();
			if (minSell.getQuantity() == 0) sellPQ.remove();
			transactions.add(price + " " + quantity);
			return true;
		} else return false;
	}
	
	public void printTransactions() {
		for (String output : transactions) {
			System.out.print("(" + output + "), ");
		}
	}
}
