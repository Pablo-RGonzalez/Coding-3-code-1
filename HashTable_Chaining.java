package pack;

public class HashTable_Chaining extends HashTable {
	public Chain[] Table;
	
	public int Size;
	
	public HashTable_Chaining(int Size) {
		this.Size = Size;
		this.Table = new Chain[Size];
		for(int i = 0; i < Size; i++) {
			this.Table[i] = new Chain();
		}
	}
	
	private int Hashing(int key) {
		//use modular for the hashing
		int result = key % this.Size;
		return result;
}
	@Override
	public void HashInsert(int key, int value) {
		// look for the Index based on the Key
		int index = Hashing(key);
		Chain target = Table[index];
		// look on the chain to find the node with the key
		Node targetNode = target.SearchNodeByKey(key);
		if(targetNode != null) {
			targetNode.Value = value;
		}else {
			target.InsertNode(key, value);
		}
	}

	@Override
	public boolean HashSearch(int key) {
		// look for the index based on the key
		int index = Hashing(key);
		Chain target = Table[index];
		// look on the chain/linked list search for the key
		return target.SearchByKey(key);
	}
	@Override
	public void HashDelete(int key) {
		int index = Hashing(key);
		
		Chain target = Table[index];
		target.DeleteNodeByKey(key);
	}
	//toString Method and do HashDelete ^
	
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < this.Size; i++) {
			output += "[" + i + "]: " + this.Table[i].toString() + "\n";
		}
		return output;
	}
	
}
