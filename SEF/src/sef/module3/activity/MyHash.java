package sef.module3.activity;

public class MyHash {
	
	private static final int SIZE = 16;
	private Element table[] = new Element[SIZE];
	
	private int count = 0;
	
	
	class Element{
		final String key;
		String value;
		Element next;
		
		Element(String key, String value){
			this.key = key;
			this.value = value;
		}
		
		public String getValue(){
			return value;
		}
		
		public void setValue(String value){
			this.value = value;
		}
		
		public String getKey(){
			return key;
		}	
		
	}
	
	public MyHash.Element get(String key){
		int hash = key.hashCode() % SIZE;
		Element el = table[hash];
			if (el.key.equals(key)) {
				return el;
			}
		return null;
	}
	
	public void put(String key, String value){
		
		if(count < SIZE){
			int hash = key.hashCode() % SIZE;
			Element newEl = new Element(key, value);
			
			Element el = table[hash];		
			if (el != null){ //if place in hash table is busy
				if (el.key.equals(key)){//if under the busy place is stored the same key, value is overwritten
					el.value = value;
				} else {
					
					
				}			
			} else { //place element in empty place if hash table
				//Element newEl = new Element(key, value);
				//table[hash] = newEl;
			}
			table[hash] = newEl;
			count = count+1;
		} else {
			System.out.println("Not possible to insert an element");
		}
		
		
	}
	
	public static void main(String[] args){
		MyHash myHash = new MyHash();
		
		myHash.put("Aaa","Bbbb");
		myHash.put("Ccc","Dddd");
		myHash.put("Eeee","Ffff");
		myHash.put("Gggg","Bbbb");
		
		Element el = myHash.get("Aaa");
		System.out.println(el.getValue());
		
		myHash.put("Aaa","Mmmm");
		el = myHash.get("Aaa");
		System.out.println(el.getValue());
		
		
	}
	

}
