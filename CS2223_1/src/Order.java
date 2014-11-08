import java.util.Comparator;

public class Order implements Comparator {
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
	public int compare(Object order0, Object order1) {
		int toReturn = 0;
		return toReturn;
	}
}
