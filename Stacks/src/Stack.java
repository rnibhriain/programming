import java.util.ArrayList;

public class Stack {
	
	ArrayList <Object> list = new ArrayList<Object>();
	
	void push (Object object) {
		list.add(object);
	}
	
	Object pop () {
		if (list.isEmpty()) {
			System.out.println("empty");
			Object object = "";
			return object;
		}
		else {
			Object object = list.get(list.size()-1);
			list.remove(list.size()-1);
			return object;
		}
	}
	
	Object peek () {
		if (list.isEmpty()) {
			return -1;
		}
		else {
			return list.get(list.size()-1);
		}	
	}
	
	int search (Object element) {
		if (list.isEmpty()) {
			return -1;
		}
		else { 
			for (int count = 0; count < list.size(); count++) {
				if (list.get(count) == element) {
					return count+1;
				}
			}
			return -1;
		}
	}
	
	void move (Object element) {
		int location = search(element);
		if (location != -1) {
			list.remove(location);
			list.add(element);
		}
		
	}
	
}
