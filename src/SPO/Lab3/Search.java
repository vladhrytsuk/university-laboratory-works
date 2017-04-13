package SPO.Lab3;

public class Search {
	private String TW[] = {"if", "then", "else"};
	private String TD[] = {";", "=", "(", ")", "+", "-", "*", "/", "==", "<", ">"};
	private String variable[] = new String [256];
	private String constante[] = new String [256];
	private int state = 1;
	private int digit = 0;
	private int letter = 0;
	private int g = 0;
	private int t = 0;
	private String text;
	private String Lecsem[] = new String [256];
    
    public void CreateLecsem() {
    	System.out.println("Вывод лексем:");
    	for (int i = 0; i < Lecsem.length; i++) {
    		if (Lecsem[i] != null) {
    			System.out.println(Lecsem[i]);
    		}
		}
    }
    
    public void ShowTableTW() {
        System.out.println("Таблица TW:");
        for (int i = 0; i < TW.length; i++) {
			System.out.println("(1, " + (i+1) + ") -  " + TW[i]);
		}
    }
    
    public void ShowTableTD() {
        System.out.println("Таблица TD:");
        for (int i = 0; i < TD.length; i++) {
			System.out.println("(2, " + (i+1) + ") -  " + TD[i]);
		}
    }
    
    public void ShowTableVariable() {
        System.out.println("Таблица переменных:");
        for (int i = 0; i < variable.length; i++) {
        	if (variable[i] != null) {
		        System.out.println("(3, " + (i+1) + ") - " + variable[i]);
        	}
		}
    }

    public void ShowTableConstante() {
    	System.out.println("Таблица констант:");
        for (int i = 0; i < constante.length; i++) {
        	if (constante[i] != null) {
    			System.out.println("(4, " + (i+1) + ") - " + constante[i]);
        	}
    	}
    }
    
   	private Boolean SearchVariable (int position) {
    		boolean result = true;
    		int posIndex = 0;
    		
    		String str = text.substring(position, text.length());
    		for (int i = 0; i < str.length(); i++) {
        		if(str.charAt(i) == ' '){
        			posIndex = str.indexOf(' ');
        			i = str.length() - 1;
        		}
        		else if (str.charAt(i) == ';'){
        			posIndex = str.indexOf(';');
        			i = str.length() - 1;
        		}
        		else if (str.charAt(i) == ')'){
        			posIndex = str.indexOf(')');
        			i = str.length() - 1;
        		}
			}

	     	String attributeName = str.substring(0, posIndex);
	     	for (int i = 0; i < attributeName.length(); i++) {
	     		if(Character.isLetter(attributeName.toCharArray()[i]) || (str.charAt(i) == '-' && Character.isLetter(attributeName.toCharArray()[i+1]))) {
		     					variable[letter] = attributeName;
			    				Lecsem[t] = "(3, " + (letter+1) + ") ";
			    				t++;
	    	     				g += attributeName.length();
	    	     				letter++;
	    	     				break;
	     			}

		     		else if(Character.isDigit(attributeName.toCharArray()[i]) ||(str.charAt(i) == '-' && Character.isDigit(attributeName.toCharArray()[i+1]))) {
			     			constante[digit] = attributeName;
		    				Lecsem[t] = "(4, " + (digit+1) + ") ";
		    				t++;
		     				g += attributeName.length();
		     				digit++;
		     				break;
	     				}
		     		
	     		else {
	     			result = false;
	     			System.err.println("ERROR: Название переменной или константы заданно не верно!");
	     		}
			}
    	return result;
    }

	public void CheckDataInput (String fileContent) {
		text = fileContent;
		char BufferStr[] = new char [fileContent.length()];
		
		for (int i = 0; i < fileContent.length(); i++) {
				BufferStr[i] = fileContent.toCharArray()[i];
		}
		    
		for (int i = 0; i < BufferStr.length; i++) {
		      switch (state) {
		    		case 1: 
		    			if (BufferStr[i] == 'i') {
		    				state = 2;
		    			}
		    			else state = 666;
		    			break;
		    		case 2:
		    			if (BufferStr[i] == 'f') {
		    				state = 3;
		    				Lecsem[t] = "(1, 1) ";
		    				t++;
		    			}
		    			else state = 666;
		    			break;
		    		case 3:
		    			if (BufferStr[i] == ' ') {
		    				state = 4;
		    			}
		    			else state = 666;
		    			break;
		    		case 4:
		    			if (BufferStr[i] == '(') {
		    				state = 5;
		    				Lecsem[t] = "(2, 3) ";
		    				t++;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 5:
		    			if(SearchVariable(i) == true) {
		    				state = 6;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 6:
		    			if (BufferStr[i] == ' ') {
		    				state = 7;
		    			}
		    			else state = 666;
		    			break;
		    		case 7:
		    			if ((BufferStr[i] == '=') || (BufferStr[i] == '<') || (BufferStr[i] == '>')) {
		    				state = 8;
		    				if (BufferStr[i] == '<') {
			    				Lecsem[t] = "(2, 10) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '>') {
			    				Lecsem[t] = "(2, 11) ";
			    				t++;
		    				}
		    			}
		    			else if (BufferStr[i] == '+' || BufferStr[i] == '-' || BufferStr[i] == '*' || BufferStr[i] == '/') {
		    				state = 36;
		    				g = i;
		    				if (BufferStr[i] == '+') {
			    				Lecsem[t] = "(2, 5) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '-') {
			    				Lecsem[t] = "(2, 6) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '*') {
			    				Lecsem[t] = "(2, 7) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '/') {
			    				Lecsem[t] = "(2, 8) ";
			    				t++;
		    				}
		    			}
		    			else state = 666;
		    			break;
		    		case 8:
		    			if (BufferStr[i] == '=') {
		    				state = 9;
		    				if (BufferStr[i-1] == '=' && BufferStr[i] == '='){
			    				Lecsem[t] = "(2, 9) ";
			    				t++;
		    				}
		    			}
		    			else if (BufferStr[i] == ' ') {
		    				state = 10;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 9:
		    			if (BufferStr[i] == ' ') {
		    				state = 10;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 10:
		    			if(SearchVariable(i) == true) {
		    				state = 11;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 11:
		    			if (BufferStr[i] == ')') {
		    				state = 12;
		    				Lecsem[t] = "(2, 4) ";
		    				t++;
		    			}
		    			else if (BufferStr[i] == ' ') {
		    				state = 38;
		    			}
		    			else state = 666;
		    			break;
		    		case 12:
		    			if (BufferStr[i] == ' ') {
		    				state = 13;
		    			}
		    			else state = 666;
		    			break;
		    		case 13:
		    			if (BufferStr[i] == 't') {
		    				state = 14;
		    			}
		    			else state = 666;
		    			break;
		    		case 14:
		    			if (BufferStr[i] == 'h') {
		    				state = 15;
		    			}
		    			else state = 666;
		    			break;
		    		case 15:
		    			if (BufferStr[i] == 'e') {
		    				state = 16;
		    			}
		    			else state = 666;
		    			break;
		    		case 16:
		    			if (BufferStr[i] == 'n') {
		    				state = 17;
		    				Lecsem[t] = "(1, 2) ";
		    				t++;
		    			}
		    			else state = 666;
		    			break;
		    		case 17:
		    			if (BufferStr[i] == ' ') {
		    				state = 18;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 18:
		    			if(SearchVariable(i) == true) {
		    				state = 19;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 19:
		    			if (BufferStr[i] == ' ') {
		    				state = 20;
		    			}
		    			else state = 666;
		    			break;
		    		case 20:
		    			if (BufferStr[i] == '=') {
		    				state = 21;
		    				Lecsem[t] = "(2, 2) ";
		    				t++;
		    			}
		    			else state = 666;
		    			break;
		    		case 21:
		    			if (BufferStr[i] == ' ') {
		    				state = 22;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 22:
		    			if(SearchVariable(i) == true) {
		    				state = 23;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 23:
		    			if (BufferStr[i] == ' ') {
		    				state = 24;
		    			}
		    			else if (BufferStr[i] == ';') {
		    				state = 35;
		    				Lecsem[t] = "(2, 1) ";
		    				t++;
		    			}
		    			else state = 666;
		    			break;
		    		case 24:
		    			if (BufferStr[i] == 'e') {
		    				state = 25;
		    			}
		    			else if (BufferStr[i] == '+' || BufferStr[i] == '-' || BufferStr[i] == '*' || BufferStr[i] == '/') {
		    				state = 41;
		    				if (BufferStr[i] == '+') {
			    				Lecsem[t] = "(2, 5) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '-') {
			    				Lecsem[t] = "(2, 6) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '*') {
			    				Lecsem[t] = "(2, 7) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '/') {
			    				Lecsem[t] = "(2, 8) ";
			    				t++;
		    				}
		    				
		    			}
		    			else state = 666;
		    			break;
		    		case 25:
		    			if (BufferStr[i] == 'l') {
		    				state = 26;
		    			}
		    			else state = 666;
		    			break;
		    		case 26:
		    			if (BufferStr[i] == 's') {
		    				state = 27;
		    			}
		    			else state = 666;
		    			break;
		    		case 27:
		    			if (BufferStr[i] == 'e') {
		    				state = 28;
		    				Lecsem[t] = "(1, 3) ";
		    				t++;
		    			}
		    			else state = 666;
		    			break;
		    		case 28:
		    			if (BufferStr[i] == ' ') {
		    				state = 29;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 29:
		    			if(SearchVariable(i) == true) {
		    				state = 30;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 30:
		    			if (BufferStr[i] == ' ') {
		    				state = 31;
		    			}
		    			else state = 666;
		    			break;
		    		case 31:
		    			if (BufferStr[i] == '=') {
		    				state = 32;
		    				Lecsem[t] = "(2, 2) ";
		    				t++;
		    			}
		    			else state = 666;
		    			break;
		    		case 32:
		    			if (BufferStr[i] == ' ') {
		    				state = 33;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 33:
		    			if(SearchVariable(i) == true) {
		    				state = 34;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 34:
		    			if ((BufferStr[i] == ';' || BufferStr[i+1] == '\n')) {
		    				state = 1;
		    				Lecsem[t] = "(2, 1) ";
		    				t++;
		    			}
		    			else if (BufferStr[i] == ';') {
		    				i = BufferStr.length - 1;
		    				state = 35;
		    				Lecsem[t] = "(2, 1) ";
		    				t++;
		    			}
		    			else if (BufferStr[i] == ' ') {
		    				state = 43;
		    			}
		    			else state = 666;
		    			break;
		    		case 35:
		    			if (BufferStr[i] == 'i') {
		    				state = 2;
		    			}
		    			else if (i == BufferStr.length - 1) {
		    				break;
		    			}
		    			else state = 666;
		    			break;
		    		case 36:
		    			if (BufferStr[i] == ' ') {
		    				state = 37;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 37:
		    			if(SearchVariable(i) == true) {
		    				state = 6;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 38:
		    			if (BufferStr[i] == '+' || BufferStr[i] == '-' || BufferStr[i] == '*' || BufferStr[i] == '/') {
		    				state = 39;
		    				if (BufferStr[i] == '+') {
			    				Lecsem[t] = "(2, 5) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '-') {
			    				Lecsem[t] = "(2, 6) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '*') {
			    				Lecsem[t] = "(2, 7) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '/') {
			    				Lecsem[t] = "(2, 8) ";
			    				t++;
		    				}
		    			}
		    			else state = 666;
		    			break;
		    		case 39:
		    			if (BufferStr[i] == ' ') {
		    				state = 40;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 40:
		    			if(SearchVariable(i) == true) {
		    				state = 11;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 41:
		    			if (BufferStr[i] == ' ') {
		    				state = 42;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 42:
		    			if(SearchVariable(i) == true) {
		    				state = 23;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 43:
		    			if (BufferStr[i] == '+' || BufferStr[i] == '-' || BufferStr[i] == '*' || BufferStr[i] == '/') {
		    				state = 44;
		    				if (BufferStr[i] == '+') {
			    				Lecsem[t] = "(2, 5) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '-') {
			    				Lecsem[t] = "(2, 6) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '*') {
			    				Lecsem[t] = "(2, 7) ";
			    				t++;
		    				}
		    				else if (BufferStr[i] == '/') {
			    				Lecsem[t] = "(2, 8) ";
			    				t++;
		    				}
		    			}
		    			else state = 666;
		    			break;
		    		case 44:
		    			if (BufferStr[i] == ' ') {
		    				state = 45;
		    				g = i;
		    			}
		    			else state = 666;
		    			break;
		    		case 45:
		    			if(SearchVariable(i) == true) {
		    				state = 34;
		    				i = g;
		    			}
		    			else state = 666;
		    			break;
		    		case 666: 
		    			System.err.println("ERROR: Текст программы написан не верно!"); 
		    			break; 	
		    		default: 
		    			break;
		        }
			}
	}
}