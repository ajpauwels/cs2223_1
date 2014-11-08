import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Market {
	private PriorityQueue<Order> buyPQ;
	private PriorityQueue<Order> sellPQ;
	private Queue<Order> transactions;
	
	public Market(String[] inputs) {
		buyPQ = new PriorityQueue<Order>();
		sellPQ = new PriorityQueue<Order>();
		transactions = new LinkedList<Order>();
	}
	
	private boolean checkEquilibrium() {
		if (buyPQ == null || sellPQ == null) return false;
		if (buyPQ.size() == 0 || sellPQ.size() == 0) return true;
		else if (sellPQ.peek().getPrice() > buyPQ.peek().getPrice()) return true;
		else return false;
	}
}
