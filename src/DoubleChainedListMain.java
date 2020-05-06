
public class DoubleChainedListMain {

	public static void main(String[] args) {
		List l = new List(10);
		l.printList();
		l.addTail(30);
		l.addHead(20);
		System.out.println("After adding another head and tail:");
		l.printList();
		l.addElem(50, 1);
		l.addElem(60, 3);
		System.out.println("After adding two elements inbetween:");
		l.printList();
		l.swap(4, 1);
		System.out.println("After swapping 2. Element and tail:");
		l.printList();
		System.out.println("Length of the List before Delete: " + l.length());
		l.deleteHead();
		l.deleteTail();
		System.out.println("After deleting head and tail:");
		l.printList();
		System.out.println("Length of the List after Delete: " + l.length());
		l.deleteElem(1);
		System.out.println("After deleting the element in the middle:");
		l.printList();
		l.swap(0, 1);
		System.out.println("After swapping head and tail:");
		l.printList();
	}

}
