/*
 * 
 * Display linked list elements and length of the list.
 * 
 */
public class SinglyLinkedList {
	
	Node head;
	
	static class Node {
		private int data;
		private Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void printList() {
		int count = 0;
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			count ++;
			current = current.next;
		}
		System.out.println();
		System.out.println("length is: " + count);
	}
	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.head = new Node(10);
		Node second = new Node(45);
		Node third = new Node(20);
		Node fourth = new Node(35);
		
		
		linkedList.head.next = second;
		second.next = third;
		third.next = fourth;
		
		linkedList.printList();
		}
}
