import java.io.IOException;
import java.util.ArrayList;


public class testgzreader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GZReader gzr = new GZReader();//("Support/DataFiles/FT911/FT911_1.gz");
		ArrayList<PDocument> docs= null ;
		try {
			 docs = gzr.parse("Support/DataFiles/");
			 
		} catch (IOException e) {
			System.out.println("Document not found " );
			e.printStackTrace();
			System.exit(-1);
		}
		
		for (PDocument s: docs){
			System.out.println("-->  " + s);
		}
		gzr.printStats();
	}

}
