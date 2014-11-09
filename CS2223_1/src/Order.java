
import java.util.Comparator;

public class Order implements Comparator<Order> {
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

	@Override
	public int compare(Order order0, Order order1) {
		if (order0.price > order1.price) return (isBuy ? 1 : -1);
		else if (order0.price < order1.price) return (isBuy ? -1 : 1);
		else return 0;
	}
}
