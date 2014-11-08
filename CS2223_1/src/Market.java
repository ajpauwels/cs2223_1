import java.util.PriorityQueue;

public class Market {
	private PriorityQueue<Order> buyPQ;
	private PriorityQueue<Order> sellPQ;
	
	public Market(String[] inputs) {
		buyPQ = new PriorityQueue<Order>();
		sellPQ = new PriorityQueue<Order>();
		for (String input : inputs) {
			String[] orderArray = input.split("\\s+");
			Order order = new Order(orderArray[0], Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
			
			if (order.isBuy()) {
				buyPQ.add(order);
			} else {
				sellPQ.add(order);
			}
		}
	}
	
	public void run(String[] input) {
		
	}
	
	private boolean checkEquilibrium() {
		if (buyPQ == null || sellPQ == null) return false;
		return false;
	}
	
	public void printTransactions() {
		System.out.println("Nothing for now");
	}
}
