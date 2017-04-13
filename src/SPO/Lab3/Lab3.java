package SPO.Lab3;
import java.io.IOException;
import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner( System.in );
		System.out.print("Введите путь к файлу: ");
		String pathFile = in.nextLine();
		
		WorkWithFile ob = new WorkWithFile(pathFile);
		System.out.println("\nИнформация о файле: ");
		ob.info_file();
		
		String fileContent = ob.read();
		System.out.println("\nСодержимое файла: " + fileContent);
		System.out.println();
		
		in.close();
		
		Search srh = new Search();
		srh.CheckDataInput(fileContent);
        srh.CreateLecsem();
        System.out.println("\n\t\t\tВывод таблиц:");
        srh.ShowTableTW();
        srh.ShowTableTD();
        srh.ShowTableVariable();
        srh.ShowTableConstante();
   }
}