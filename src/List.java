
public class List {
	public Elem head;
	public Elem tail;
	
	//Constructor creates a head element with the value of the head element
	public List(int valOfHead) {
		this.head = new Elem(valOfHead);
		this.tail = head;
	}
	public int length() {
		int length = 1;
		Elem currentElem = head;
		while (currentElem != tail) {
			length++;
			currentElem = currentElem.nextAddress;
		}
		return length;
	}
	private Elem getElemByIndex(int index) {
		Elem currentElem = head;
		int counter = 0;
		while (index != counter) {
			currentElem = currentElem.nextAddress;
			counter++;
			if (currentElem == null) {
				System.out.println("No Element with Index: " + index + " exists!");
				return null;
			}
		}
		return currentElem;
	}
	private int getIndexByElem(Elem e) {
		int index = 0;
		Elem currentElem = head;
		while (currentElem != e) {
			index++;
			currentElem = currentElem.nextAddress;
		}
		return index;
	}
	public void addElem(int val, int index) {
		if (index < 0) {
			System.out.println("Positive index (0 included) expected!");
			return;
		}
		if (index > length()) {
			System.out.println("Index out of Bounds!");
			return;
		}
		//if the Element is added at the back, it becomes the new tail
		Elem addElem = new Elem(val);
		if (index == length()) {
			tail.nextAddress = addElem;
			addElem.lastAddress = tail;
			tail = addElem;
			return;
		}
		//if the Element is added at the front, it becomes the new head
		if (index == getIndexByElem(head)) {
			head.lastAddress = addElem;
			addElem.nextAddress = head;
			head = addElem;
			return;
		}
		//else the address of the element before and after have to point to the added element
		Elem nextElem = getElemByIndex(index);
		Elem lastElem = getElemByIndex(index - 1);
		addElem.lastAddress = lastElem;
		addElem.nextAddress = nextElem;
		nextElem.lastAddress = addElem;
		lastElem.nextAddress = addElem;
	}
	public void addHead(int val) {
		addElem(val, getIndexByElem(head));
	}
	public void addTail(int val) {
		addElem(val, length());
	}
	public void deleteElem(int index) {
		if (index < 0) {
			System.out.println("Positive index (0 included) expected!");
			return;
		}
		if (index >= length()) {
			System.out.println("Index out of Bounds!");
			return;
		}
		//if the head is to be deleted, the next element simply becomes the new head
		if (index == getIndexByElem(head)) { 
			head = head.nextAddress;
			return;
		}
		//if the tail is to be deleted, the last element simply becomes the new tail
		if (index == getIndexByElem(tail)) {
			tail = tail.lastAddress;
			return;
		}
		//else the address of the element before and after have to be changed
		Elem deleteElem = getElemByIndex(index);
		Elem lastElem = deleteElem.lastAddress;
		Elem nextElem = deleteElem.nextAddress;
		lastElem.nextAddress = nextElem;
		nextElem.lastAddress = lastElem;
		//no pointer shows to deleteElem anymore => Garbage-Collector
	}
	public void deleteHead() {
		deleteElem(getIndexByElem(head));
	}
	public void deleteTail() {
		deleteElem(getIndexByElem(tail));
	}
	public void swap(int index1, int index2) {
		if (index1 == index2) {
			System.out.println("Nothing to swap here!");
			return;
		}
		if (index1 > index2) { //index1 must be < index2
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}
		Elem e1 = getElemByIndex(index1);
		Elem e2 = getElemByIndex(index2);
		if (e1 == null || e2 == null) {
			System.out.println("Index out of Bounds!");
			return;
		}
		if (e1 == head) {
			head = e2;
		}
		if (e2 == tail) {
			tail = e1;
		}
		if (e1.nextAddress == e2) { //right next to each other
			e1.nextAddress = e2.nextAddress;
			e2.lastAddress = e1.lastAddress;
			
			if (e1.nextAddress != null) {
				e1.nextAddress.lastAddress = e1;
			}
			if (e2.lastAddress != null) {
				e2.lastAddress.nextAddress = e2;
			}
			
			e2.nextAddress = e1;
			e1.lastAddress = e2;
		} else {
			Elem l = e2.lastAddress;
			Elem n = e2.nextAddress;
			
			e2.lastAddress = e1.lastAddress;
			e2.nextAddress = e1.nextAddress;
			
			e1.lastAddress = l;
			e1.nextAddress = n;
			
			if (e2.nextAddress != null) {
				e2.nextAddress.lastAddress = e2;
			}
			if (e2.lastAddress != null) {
				e2.lastAddress.nextAddress = e2;
			}
			
			if (e1.nextAddress != null) {
				e1.nextAddress.lastAddress = e1;
			}
			if (e1.lastAddress != null) {
				e1.lastAddress.nextAddress = e1;
			}
		}
	}
	public void debugPrintList() {
		Elem currentElem = head;
		System.out.println("\tElement\t\t|\tAddress\t\t|\tValue\t\t|\tLast Address\t|\tNext Address");
		System.out.println("------------------------+-----------------------+-----------------------+-----------------------+------------------------");
		for (int i = 1; i <= length(); i++) {
			System.out.print("\t"+i + ". Element\t|  ");
			System.out.print(currentElem);
			System.out.print("\t|\t");
			System.out.print(currentElem.val);
			System.out.print("\t\t|  ");
			System.out.print(currentElem.lastAddress);
			if (currentElem.lastAddress == null) {
				System.out.print("\t\t");
			}
			System.out.print("\t|  ");
			System.out.println(currentElem.nextAddress);
			currentElem = currentElem.nextAddress;
		}
		System.out.println();
	}
	public void printList() {
		Elem currentElem = head;
		System.out.println("\tElement\t\t|\tValue");
		System.out.println("------------------------+-----------------------");
		for (int i = 1; i <= length(); i++) {
			System.out.print("\t"+i + ". Element\t|\t  ");
			System.out.println(currentElem.val);
			currentElem = currentElem.nextAddress;
		}
		System.out.println();
	}
}
