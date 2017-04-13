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
		File file_name = new File(file_path); // ���� � �����
		FileReader reader = new FileReader(file_name); // ������ ������ � �����
		BufferedReader buffer = new BufferedReader(reader); // ����� ��� ���� � �����
		
		StringBuilder sb = new StringBuilder();
		
		String str = "";

		while ((str = buffer.readLine()) != null){ //���� ����� ����� ����������� ���������� � ���������� � ����� � ������
				sb.append(str); // ��������� � ��� ������ sb ���������� ������ ���� ������
			}
		reader.close(); // ��������� ������ ������ � �����
		buffer.close(); // ��������� ������ �������� ������
				
		return sb.toString(); // ����������� ������ ������ StringBuilder � ������ � ��������� �� ��������
	}
	
	public void info_file () {
		System.out.println("���� � �����: " + new File(file_path).getPath()); // ���� � �����
		System.out.println("��� �����: " + new File(file_path).getName()); // ����� ����� �����
	}
}

