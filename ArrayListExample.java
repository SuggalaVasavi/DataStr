package week3;

//A dynamically allocated array with generics
class MyGenericArray<E> {
private int size;     // number of elements
private Object[] elements;

public MyGenericArray() {  // constructor
 elements = new Object[10];  // allocate initial capacity of 10
 size = 0;
}

public void add(E e) {
 if (size < elements.length) {
    elements[size] = e;
 } else {
	   System.out.println("Array is full");

 }
 ++size;
}

public E get(int index) {
 if (index >= size)
    throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
 return (E)elements[index];
}

public int size() { return size; }
}
public class ArrayListExample {

	public static void main(String args[]) {
		// Creating an empty array list
		MyGenericArray<UserInfo> list = new MyGenericArray<UserInfo>();
UserInfo info1=new UserInfo();
info1.setLoginId("1");
info1.setPassword("abc");
info1.setFirstName("abc");
info1.setLastName("a");
info1.setCity("Chennai");
info1.setMobile("00000000");

		// Adding items to arrayList
		list.add(info1);
		


		// Retrieve elements from the arraylist


		System.out.println("Retrieving items in the list");
		for(int i=0;i<list.size();i++){
			UserInfo user=list.get(i);
		//for (UserInfo user:list) {
			System.out.println("ID: " + user.getLoginId());
			System.out.println("password: " + user.getPassword());
			System.out.println("FirstName: " + user.getFirstName());
			System.out.println("LastName: " + user.getLastName());
			System.out.println("City: " + user.getCity());
			System.out.println("Mobile: " + user.getMobile());
		}

	


		System.out.println("The size of the arraylist are: " + list.size());


	}
}