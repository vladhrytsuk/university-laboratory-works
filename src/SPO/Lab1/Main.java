package SPO.Lab1;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner( System.in );
		System.out.print("??????? ???? ? ?????: ");
		String pathFile = in.nextLine();
		
		WorkWithFile ob = new WorkWithFile(pathFile);
		System.out.println("\n?????????? ? ?????: ");
		ob.info_file();
		
		String fileContent = ob.read();
		System.out.println("\n?????????? ?????: " + fileContent);
		System.out.println();
		
		HashTable ht = new HashTable (fileContent);
		ht.Table();
		System.out.println();
		System.out.print("??????? ??????????? ??? ??????: ");
		String letter = in.nextLine();
		ht.Search(letter);
		in.close();
	}

}
















