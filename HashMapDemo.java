package week3;

import java.util.Set;

class HashMap<K, V> {

	private Entry<K,V>[] table;   //Array of Entry.
	private int capacity= 4;  //Initial capacity of HashMap

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K,V> next;

		public Entry(K key, V value, Entry<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}



	public HashMap(){
		table = new Entry[capacity];
	}
	public void put(K newKey, V data){
		if(newKey==null)
			return;    //does not allow to store null.

		//calculate hash of key.
		int hash=hash(newKey);
		//create new entry.
		Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);

		//if table location does not contain any entry, store entry there.
		if(table[hash] == null){
			table[hash] = newEntry;
		}else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];

			while(current != null){ //we have reached last entry of bucket.
				if(current.key.equals(newKey)){
					if(previous==null){  //node has to be insert on first of bucket.
						newEntry.next=current.next;
						table[hash]=newEntry;
						return;
					}
					else{
						newEntry.next=current.next;
						previous.next=newEntry;
						return;
					}
				}
				previous=current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}


	public V get(K key){
		int hash = hash(key);
		if(table[hash] == null){
			return null;
		}else{
			Entry<K,V> temp = table[hash];
			while(temp!= null){
				if(temp.key.equals(key))
					return temp.value;
				temp = temp.next; //return value corresponding to key.
			}
			return null;   //returns null if key is not found.
		}
	}



	public boolean remove(K deleteKey){

		int hash=hash(deleteKey);

		if(table[hash] == null){
			return false;
		}else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];

			while(current != null){ //we have reached last entry node.
				if(current.key.equals(deleteKey)){
					if(previous==null){  //delete first entry node.
						table[hash]=table[hash].next;
						return true;
					}
					else{
						previous.next=current.next;
						return true;
					}
				}
				previous=current;
				current = current.next;
			}
			return false;
		}

	}



	public void display(){

		for(int i=0;i<capacity;i++){
			if(table[i]!=null){
				Entry<K, V> entry=table[i];
				while(entry!=null){
					System.out.print("{"+entry.key+"="+entry.value+"}" +" \n");
					entry=entry.next;
				}
			}
		}

	}

	private int hash(K key){
		return Math.abs(key.hashCode()) % capacity;
	}

}
public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String,UserInfo> map = new HashMap<String,UserInfo>();
		UserInfo info1=new UserInfo();
		info1.setLoginId("1");
		info1.setPassword("abc");
		info1.setFirstName("abc");
		info1.setLastName("a");
		info1.setCity("Chennai");
		info1.setMobile("00000000");
		map.put("1",info1);
	    UserInfo user=map.get("1");
	    System.out.println("Id:"+user.getLoginId());
	    System.out.println("password:"+user.getPassword());
	    System.out.println("firstname:"+user.getFirstName());
	    System.out.println("lastname:"+user.getLastName());
	    System.out.println("mobileno:"+user.getMobile());
	    System.out.println("city:"+user.getCity());
	    
	}
}
	    