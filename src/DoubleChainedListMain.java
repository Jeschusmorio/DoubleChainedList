
public class DoubleChainedListMain {

	public static void main(String[] args) {
		List l = new List(10);
		l.addElem(30);
		l.addElem(50);
		l.addElem(60);
		System.out.println("Length of the List before Delete: " + l.length());
		l.printList();
		l.swap(1, 2);
		System.out.println("After swapping 1 and 2:");
		l.printList();
		l.deleteElem(1); //delete Element with index = 1
		System.out.println("Length of the List after Delete: " + l.length());
		l.printList();
		
	}

}
