
import java.util.Comparator;

public class Order implements Comparable<Order> {
	private boolean isBuy;
	private int price;
	private int quantity;
	
	public Order(String type, int price, int quantity) {
		this.isBuy = type.equals("buy") ? true : false;
		this.price = price;
		this.quantity = quantity;
	}
	
	public boolean isBuy() {
		return isBuy;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void substractQuantity(int sub) {
		quantity -= sub;
	}
	
	public String toString() {
		return (isBuy ? "buy" : "sell") + ", " + price + ", " + quantity;
	}
	
	@Override
	public int compareTo(Order other) {
		if (price < other.price) return (isBuy ? 1 : -1);
		else if (price > other.price) return (isBuy ? -1 : 1);
		else return 0;
	}
}
