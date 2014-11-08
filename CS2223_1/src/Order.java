
import java.util.Comparator;

public class Order implements Comparator<Order> {
	private boolean isBuy;
	private int price;
	private int quantity;
	
	public Order(boolean isBuy, int price, int quantity) {
		this.isBuy = isBuy;
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

	@Override
	public int compare(Order order0, Order order1) {
		int toReturn = 0;
		if (order0.price > order1.price) toReturn = 1;
		//else if (order0.price > order1.price)
		return toReturn;
	}
}
