
public class Trading {
	
	public void main(String[] args) {
		String[] inputs = StdIn.readAllLines();
		for (String input : inputs) {
			createOrder(input);
		}
	}
	
	private Order createOrder(String input) {
		boolean isBuy;
		int price;
		int quantity;
		String[] split = input.split(" ");
		isBuy = (split[0].equals("buy") ? true : false);
		price = Integer.parseInt(split[1]);
		quantity = Integer.parseInt(split[2]);
		return (new Order(isBuy, price, quantity));
	}
	
	private boolean checkEquilibrium() {
		return false;
	}
}

