package SPO.Lab3;
import java.io.IOException;
import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner( System.in );
		System.out.print("������� ���� � �����: ");
		String pathFile = in.nextLine();
		
		WorkWithFile ob = new WorkWithFile(pathFile);
		System.out.println("\n���������� � �����: ");
		ob.info_file();
		
		String fileContent = ob.read();
		System.out.println("\n���������� �����: " + fileContent);
		System.out.println();
		
		in.close();
		
		Search srh = new Search();
		srh.CheckDataInput(fileContent);
        srh.CreateLecsem();
        System.out.println("\n\t\t\t����� ������:");
        srh.ShowTableTW();
        srh.ShowTableTD();
        srh.ShowTableVariable();
        srh.ShowTableConstante();
   }
}