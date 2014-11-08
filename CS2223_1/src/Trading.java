
public class Trading {
	
	public static void main(String[] args) {
		String[] input = StdIn.readAllLines();
	}
	
	private Order createOrder(String input) {
		boolean isBuy;
		int price;
		int quantity;
		return new Order(isBuy, price, quantity);
	}
}
