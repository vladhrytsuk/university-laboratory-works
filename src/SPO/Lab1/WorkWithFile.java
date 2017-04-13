package SPO.Lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WorkWithFile {
	private String file_path;
	
	public WorkWithFile (String file_path) {
		this.file_path = file_path;
	}
	
	public String read() throws IOException {
		File file_name = new File(file_path); // путь к файлу
		FileReader reader = new FileReader(file_name); // чтение данных с файла
		BufferedReader buffer = new BufferedReader(reader); // Буфер для инфы с файла
		
		StringBuilder sb = new StringBuilder();
		
		String str = "";

		while ((str = buffer.readLine()) != null){ //пока буфер полон выполняется добавление в информацию с файла с строку
				sb.append(str); // добавляем в наш объект sb информацию любого типа данных
			}
		reader.close(); // закрываем чтение данных с файла
		buffer.close(); // закрываем буффер хранения данных
				
		return sb.toString(); // преобразуем объект класса StringBuilder в строку и возвращем ее значение
	}
	
	public void info_file () {
		System.out.println("Путь к файлу: " + new File(file_path).getPath()); // путь к файлу
		System.out.println("Имя файла: " + new File(file_path).getName()); // вывод имени файла
	}
}

