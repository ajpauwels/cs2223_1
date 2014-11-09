/*
 * Order - represents an order
 * @author Alexandre Pauwels
 * @author Ethan Coeytaux
 */
public class Order implements Comparable<Order> {
	private boolean isBuy;
	private int price;
	private int quantity;

	/*
	 * Constructor for Order
	 * @param String type - type of order
	 * @param int price - price of stock
	 * @param int quantity - number of stocks offered/desired
	 */
	public Order(String type, int price, int quantity) {
		this.isBuy = type.equals("buy") ? true : false;
		this.price = price;
		this.quantity = quantity;
	}

	/*
	 * @return if order is a buy order or not
	 */
	public boolean isBuy() {
		return isBuy;
	}

	/*
	 * @return price of stock
	 */
	public int getPrice() {
		return price;
	}

	/*
	 * @return quantity of stock
	 */
	public int getQuantity() {
		return quantity;
	}

	/*
	 * @param int sub - number of stocks to substract
	 */
	public void substractQuantity(int sub) {
		quantity -= sub;
	}

	/*
	 * @return String version of order info
	 */
	@Override
	public String toString() {
		return (isBuy ? "buy" : "sell") + ", " + price + ", " + quantity;
	}

	/*
	 * @return 1 if considered larger, -1 if smaller, 0 if equal
	 */
	@Override
	public int compareTo(Order other) {
		if (price < other.price) return (isBuy ? 1 : -1); //for sell orders, smaller is higher priority
		else if (price > other.price) return (isBuy ? -1 : 1);
		else return 0;
	}
}
