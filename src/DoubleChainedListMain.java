
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
		l.deleteHead();
		l.deleteTail();
		System.out.println("After deleting head and tail:");
		l.printList();
		l.deleteElem(1);
		System.out.println("After deleting the element in the middle:");
		l.printList();
		/*l.addElem(60, 2);
		System.out.println("Length of the List before Delete: " + l.length());
		l.printList();
		l.swap(1, 2);
		System.out.println("After swapping 1 and 2:");
		l.printList();
		l.deleteElem(1); //delete Element with index = 1
		System.out.println("Length of the List after Delete: " + l.length());
		l.printList();*/
		
	}

}
