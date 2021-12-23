package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	List<OrderItem> items = new ArrayList<>();
	Client client = new Client();
	
	public Order() {
		
	}
	

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getMoment() {
		return moment;
	}



	public void setMoment(Date moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public List<OrderItem> getItems() {
		return items;
	}
	
	

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total(){
		double total = 0;
		for(OrderItem o: items) {
			total += o.subTotal();
		}
		return total;
		
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: "+ sdf.format(moment) +"\n");
		sb.append("Order Status: "+ status + "\n");
		sb.append("Client: "+ client.getName() +" " + sdf1.format(client.getBirthDay()) + "-" + client.getEmail()+"\n");
		sb.append("Order items:\n");
		for(OrderItem item : items) {
			sb.append(item +"\n");
		}
		sb.append("Total price "+total());
		return sb.toString();
	}



}
