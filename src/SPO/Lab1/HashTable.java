package SPO.Lab1;

import java.util.ArrayList;
import java.util.Collections;

public class HashTable {
	private String strInfoFile;
	private String []arrayLetter;
	private int []index;
	private ArrayList<String> HashTableColl;
	
	public HashTable (String strInfoFile) {
		this.strInfoFile = strInfoFile;
	}

	public int[] CreateIndexHashTable () {
		arrayLetter = strInfoFile.split("[-_,.!'?\\s]+");
		index = new int [arrayLetter.length];
		HashTableColl = new ArrayList<String>();
		
		for (int i = 0; i < arrayLetter.length; i++) {
			arrayLetter[i] = arrayLetter[i].trim();
			index[i] = (int)arrayLetter[i].charAt(0) + (int)arrayLetter[i].charAt(1);

			for (int k = 0; k < i; k++) {
				if (index[k] == index[i]) {
					HashTableColl.add(arrayLetter[k]);
					HashTableColl.add(arrayLetter[i]);
					arrayLetter[k] = "$";
					arrayLetter[i] = "$";
					Collections.sort(HashTableColl);
					break;
				}
			}
		}
		return index;
	}
	
	public int[] Table () {
		arrayLetter = strInfoFile.split("[-_,.!'?\\s]+");
		index = new int [arrayLetter.length];
		HashTableColl = new ArrayList<String>();
		System.out.println("Вывод таблицы: ");
		for (int i = 0; i < arrayLetter.length; i++) {
			arrayLetter[i] = arrayLetter[i].trim();
			index[i] = (int)arrayLetter[i].charAt(0) + (int)arrayLetter[i].charAt(1);

			for (int k = 0; k < i; k++) {
				if (index[k] == index[i]) {
					HashTableColl.add(arrayLetter[k]);
					HashTableColl.add(arrayLetter[i]);
					arrayLetter[k] = "$";
					arrayLetter[i] = "$";
					Collections.sort(HashTableColl);
					break;
				}
			}
			System.out.println("Слово: " + arrayLetter[i] + ", с индексом: " + index[i]);
		}
		return index;
	}
	
	public void Search (String letter) {
		int id = (int) letter.charAt(0) + (int) letter.charAt(1);
		System.out.print("Индефикатор: " + letter + ", с индексом: " + id + "\n");

		for (int i = 0; i < CreateIndexHashTable().length; i++) {
			if (id == CreateIndexHashTable()[i]) {
				if (letter.compareTo(arrayLetter[i]) == 0) {
					System.out.println("Совпадение найденно!"); 
					break;
				}
				else if (HashTableColl.contains(letter) == true) {
					System.out.println("Совпадение найденно! Коллизия"); 
					break;
				}
			}
			
			if (i == CreateIndexHashTable().length - 1) {
				System.out.println("Совпадений не найдено!");
			}
		}
	}	
}
