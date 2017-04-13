package SPO.Lab1;

public class HashTable1 {
	private String str;
	private String []arrayString; //������ ����
	private String []arrayCollisio;// ������ ��������
	private int []index; // ����� ����� ������ � ������ ����� 
	private char []arrayWorld; // ������ ���� ��� ������� �����
	
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
		arrayString = str.split("[-_,.!'?\\s]+"); // ������� ��������� ������� � ������� ���������� ���������
		index = new int [256];
		for (int i = 0, n = 0; i < arrayString.length; i++, n++) {
			arrayString[n] = arrayString[n].trim(); // �������� �������� � ����� ����� ������
			arrayWorld = new char [256]; // ������ ������ ������� ���� ������ ������� �����

			for (int j = 0; j < arrayString[n].length(); j++) {
				arrayWorld[j] = arrayString[n].charAt(j); // ����������� ������ ����� � char � ��������� �� �������;
				index[i] = (int) arrayWorld[0] + (int) arrayWorld[1]; // ���������� ���-�������				
			}
			System.out.println("#" + (n+1) + "  " + arrayString[n]);
			//int n = (int)arrayString[0].charAt(0) + (int)arrayString[0].charAt(1);
			/*����� �������� - START*/
			arrayCollisio = new String [10];
			for (int k = 0; k < i; k++) {
				if(index[i] == index[k]) { // ���������� ������� ���� ��������� �������� �� &
					arrayCollisio[k] = arrayString[n]; // ���������� � ������ ��� ��������
					arrayCollisio[k+1] = arrayString[n+1]; // ���������� � ������ ��� ��������
					arrayString[k] = "&" + index[i];
					//--n;
					break;
				}
			}
			/*����� �������� - END*/
		}
		return index;
	}

	
	public int[] SortHashTableMethodSampling (int []hashTable) {
	    for (int i = 0; i < hashTable.length - 1; i++) {
	    /* ������������� ��������� �������� ������������ ������� */
	           int min = i;
		    /* ������� ������ ������������ �������� */
	    	    for (int j = i + 1; j < hashTable.length; j++) {
	    	    	if (hashTable[j] < hashTable[min]) {
	    	    		min = j;
	    	    	}
	    	    }
	        /* ������ �������� ������� */
		    int temp = hashTable[i];
		    hashTable[i] = hashTable[min];
		    hashTable[min] = temp;
	    }
		return hashTable;
	}
	
}
