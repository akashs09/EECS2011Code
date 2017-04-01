import java.io.FileNotFoundException;

public class MessageAssembler {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		{
			DLL myDLL = new DLL();
			DLL x = new DLL();
			myDLL.readAndAssemble("/Users/akashsharma/Documents/mystery.txt");
//			myDLL.readAndAssemble("src/mystery.txt");

//			x.header = myDLL.header;
//			
//			for(int i =0; i < myDLL.size; i++) {
//				System.out.println(x.header.getNextNode().getPacketContent());
//				x.header = x.header.getNextNode();	
//			}
			myDLL.printContent(myDLL);			
//			System.out.println(myDLL);
			
//			myDLL.printContent();
		}
	}
}

		
		// TODO Auto-generated catch block
	

