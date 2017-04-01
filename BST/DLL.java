import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DLL {
	
	//------------Nested Node Class------------------------
	public static class DLLNode{
		
		private int packetID;
		private String packetContent;
		private DLLNode prev;
		private DLLNode next;
		
		//constructor
		public DLLNode(int packetID, String packetContent, DLLNode prev, DLLNode next){
			this.packetID = packetID;
			this.packetContent = packetContent;
			this.prev = prev;
			this.next = next;
		} 
		
		public int getPacketID() {
			return this.packetID;
		}
		
		public String getPacketContent(){
			return this.packetContent;
		}
		
		public DLLNode getNextNode() {
			return this.next;
		}
		 
		public DLLNode getPrevNode(){
			return this.prev;
		}
		public  void setNextNode(DLLNode n){
			next = n;
		}
		public void setPrevNode(DLLNode p){
			prev = p;
		}
	}
//----------------------------------------------------
	
	public String[] newLine;
	public DLLNode header;
	public DLLNode trailer;
	public int size;
	public int packetInt;
	public String packetMsg;
	public DLL d;
	
	public DLL(){  //id,content,prev,next
		header = new DLLNode(-1,null,null,null);
		trailer = new DLLNode(-1, null, header, null);
		header.setNextNode(trailer);
//		head = null;
//		tail = null;
	
		size = 0;
	}
	public void readAndAssemble(String filename) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filename)); //read file
		DLL d = new DLL();
		
		while(sc.hasNextLine()) 
		{
			newLine = sc.nextLine().split("\t"); // makes an array ["0","It"]
			packetInt=Integer.parseInt(newLine[0]);
			packetMsg = newLine[1];
			DLLNode curr = new DLLNode(packetInt,packetMsg,null, null);	
			
			
			//very first element added here
			if(isEmpty()) {
				addFirst(curr.getPacketID(), curr.getPacketContent());
			}
			
			else if((size==1) && (curr.getPacketID() < header.getNextNode().getPacketID())){
					addFirst(curr.getPacketID(), curr.getPacketContent());
				
			}
			else if ((size==1) && (curr.getPacketID() > header.getNextNode().getPacketID())){
					addLast(curr.getPacketID(), curr.getPacketContent());
				}
			
			
			
			else
			{
				for(DLLNode temp = header.getNextNode(); temp.getPacketID() != -1; temp = temp.getNextNode() ) {
					if ((curr.getPacketID() < temp.getPacketID())) {
						addFirst(curr.getPacketID(), curr.getPacketContent());
						break;
					}
					if ((curr.getPacketID() > temp.getPacketID()) && (curr.getPacketID() < temp.getNextNode().getPacketID())) {
						addBetween(curr.getPacketID(), curr.getPacketContent(), temp, temp.getNextNode());
						break;
					}
					if ((temp.getNextNode() == trailer) && (curr.getPacketID() > temp.getPacketID())) {
						addLast(curr.getPacketID(), curr.getPacketContent());
						break;
					}
					}
				}
			
		
		}
	}
	
//	public void printContent(){
//		for (DLLNode cursor = head; cursor.getNextNode() != null; cursor = cursor.next) {
//			System.out.println(cursor.getPacketContent());
//		}
//		
//	}
	
	public DLLNode next(){
		this.header = header.getNextNode();
		return header;
	}
	
	public Integer size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String first() {
		if(isEmpty()) return null;
		return header.getNextNode().getPacketContent();
	}
	public String last() {
		if(isEmpty()) return null;
		return trailer.getPrevNode().getPacketContent();
	}
	public void addBetween(int id, String content, DLLNode predecessor, DLLNode sucessor) {
		DLLNode newest = new DLLNode(id,content,predecessor, sucessor);
		predecessor.setNextNode(newest);
		sucessor.setPrevNode(newest);
		size++;
	}
	public void addFirst(int id, String content) {
		addBetween(id,content,header,header.getNextNode());
	}
	public void addLast(int id, String content) {
		addBetween(id,content, trailer.getPrevNode(), trailer);
		
	}
//	public void printContent() {
//		for (DLLNode cursor = header; cursor.getNextNode() != null; cursor = cursor.next) {
//			System.out.println(d.header.getNextNode().getPacketContent());
//			
//		}
//	
//	}
	public void printContent(DLL x) {
		size = x.size;
		for(int i =0; i < size; i++) {
			System.out.println(x.header.getNextNode().getPacketContent());
			x.header = x.header.getNextNode();	
		}
			
		}

}

