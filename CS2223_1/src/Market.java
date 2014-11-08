import java.util.PriorityQueue;

public class Market {
	private PriorityQueue<Order> buyPQ;
	private PriorityQueue<Order> sellPQ;
	
	public Market() {
		buyPQ = new PriorityQueue<Order>();
		sellPQ = new PriorityQueue<Order>();
	}
	
	public void Run(String[] input) {
		
	}
	
	private boolean checkEquilibrium() {
		if (buyPQ == null || sellPQ == null) return false;
		return false;
	}
}
