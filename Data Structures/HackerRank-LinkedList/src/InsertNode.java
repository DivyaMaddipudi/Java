
public class InsertNode {

	Node head;
	static class Node{
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
			
		}
	}
	
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	public void insertAfter(int new_data, Node prev_node) {
		
		if(prev_node == null) {
			System.out.println("Previous node can't be null");
			return;
		}
		
		Node new_node = new Node(new_data);
		
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		
	}

	public void append(int new_data) {
		
		Node new_node = new Node(new_data);
		
		if(head == null) {
			head = new Node(new_data);
			return;
		}
		new_node.next = null;
		
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		return;
	}
	
	public void printLit() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		InsertNode list = new InsertNode();
		
		list.append(10);
		list.push(30);
		list.push(15);
		list.append(25);
		
		list.insertAfter(23, list.head.next.next);
		
		list.printLit();
		//Node second = new Node(10);
		
	}

}
