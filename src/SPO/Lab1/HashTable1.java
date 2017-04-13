package SPO.Lab1;

public class HashTable1 {
	private String str;
	private String []arrayString; //массив слов
	private String []arrayCollisio;// массив коллизий
	private int []index; // сумма кодов первой и второй буквы 
	private char []arrayWorld; // массив букв для каждого слова
	
	public HashTable1 (String str) {
		this.str = str;
	}
	
	public String[] getArrayCollisio () {
		return arrayCollisio;
	}
	
	public String[] getArrayString () {
		return arrayString;
	}
	
	public int[] CreateIndexFirstAndSecondWord () {
		arrayString = str.split("[-_,.!'?\\s]+"); // удаляем указанные символы с помощью регулярных выражений
		index = new int [256];
		for (int i = 0, n = 0; i < arrayString.length; i++, n++) {
			arrayString[n] = arrayString[n].trim(); // удаление пробелов с обеих строн строки
			arrayWorld = new char [256]; // задаем длинну массива букв равную каждому слову

			for (int j = 0; j < arrayString[n].length(); j++) {
				arrayWorld[j] = arrayString[n].charAt(j); // преобразуем каждое слово в char и разделяем на символы;
				index[i] = (int) arrayWorld[0] + (int) arrayWorld[1]; // составляем хэш-таблицу				
			}
			System.out.println("#" + (n+1) + "  " + arrayString[n]);
			//int n = (int)arrayString[0].charAt(0) + (int)arrayString[0].charAt(1);
			/*ПОИСК КОЛЛИЗИИ - START*/
			arrayCollisio = new String [10];
			for (int k = 0; k < i; k++) {
				if(index[i] == index[k]) { // сравниваем индексы если совпадают заменяет на &
					arrayCollisio[k] = arrayString[n]; // записываем в массив для коллизии
					arrayCollisio[k+1] = arrayString[n+1]; // записываем в массив для коллизии
					arrayString[k] = "&" + index[i];
					//--n;
					break;
				}
			}
			/*ПОИСК КОЛЛИЗИИ - END*/
		}
		return index;
	}

	
	public int[] SortHashTableMethodSampling (int []hashTable) {
	    for (int i = 0; i < hashTable.length - 1; i++) {
	    /* устанавливаем начальное значение минимального индекса */
	           int min = i;
		    /* находим индекс минимального элемента */
	    	    for (int j = i + 1; j < hashTable.length; j++) {
	    	    	if (hashTable[j] < hashTable[min]) {
	    	    		min = j;
	    	    	}
	    	    }
	        /* меняем значения местами */
		    int temp = hashTable[i];
		    hashTable[i] = hashTable[min];
		    hashTable[min] = temp;
	    }
		return hashTable;
	}
	
}
