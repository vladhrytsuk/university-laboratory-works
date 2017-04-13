package SSP.LabWork3.uliana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class Task1 {

    public static void main(String[] args) throws FileNotFoundException {
		/*
        * Создаём объект класса Scanner.
        *
        * Для работы с потоком ввода необходимо создать объект класса Scanner,
        * при создании указав, с каким потоком ввода он будет связан.
        * Работаем с файлом, значит, нужно создать экземпляр класса File,
        * передав в параметры конструктора, путь к файлу.
        */
		Scanner file = new Scanner(new File("./src/University/SSP/LabWork3/uliana/task1.txt"));

		/*
		* Создаем коллекцию типа ArrayList котораая будет хранить тип данных String.
		* Она нужна для того, чтобы в будущем записать в нее данные с файла.
		*/
		ArrayList<String> contentInFile = new ArrayList<>();
		/*
		* Создаем карту типа ключ-значение, где ключом тип данных Integer, а значение
		* коллекция ArrayList котораая будет хранить тип данных String. Это карта нужна нам,
		* для того, чтобы в будущем записать в ключ - количество букв в слове, а в значение
		* записать слова которые будут содержать это количество букв. И в итоге мы получим нужную
		* нам таблицу по заданию.
		*/
		Map<Integer, ArrayList<String>> countOfWord = new HashMap<>();
		/*
		* Создаем коллекцию типа ArrayList котораая будет хранить тип данных String.
		* Она нужна для того, чтобы в будущем записать в нее слова с определенным количеством букв.
		*/
		ArrayList<String> listOfWords;

		/*
		* С помощью метода hasNext(), проверяющий остались ли в потоке ввода какие-то символы.
		* Если остались записываем в наш ArrayList<String> contentInFile данные, с помощью метода add()
		* передавая по параметрам метода file.next(). Метод next() считываем строку до первого пробела.
		* После того как нашли строку записываем ее в contentInFile.
		*/
		while(file.hasNext()) {
			contentInFile.add(file.next());
		}

		/*Закрываем поток ввода с файла*/
		file.close();

		/*
		* В данном цикле мы проверяем содержимое нашего файла.
		* Мы берем каждое слово из коллекции contentInFile, и записываем в переменную word,
		* после этого в переменную countOfLettersInWord записываем кол-во букв нашего слова.
		*
		* Далее проверяем нашу карту (будущую таблицу), содержит ли карта ключ у которого значение равно
		* countOfLettersInWord, если такого нет, значит мы сначала выделяем память для наше коллеции, потом
		* записываем наше слово в коллекцию listOfWords, с помощью метода add() в параметры передаем наше слово
		* word, затем добавляем в нашу таблицу countOfWord с помощью метода put() ключ countOfLettersInWord, который
		* является колечиством букв в слове, и в значение наш ArrayList с нашими словами.
		*
		* Если в нашей таблицы, уже существует ключ со значением которое содержит countOfLettersInWord, это проверяется
		* с помощью метода containsKey(), то мы добавлем в этой паре ключ-значение, в значение новое слово. Для того, чтобы
		* получить наш ArrayList в котором содержатся уже слова с определённым колиствам букв, используется метод get()
		* по параметрам которого мы передаем countOfLettersInWord, чтобы найти нужную нам пару ключ-значение, мы ищим по ключу.
		* */
		for(String word: contentInFile) {
			int countOfLettersInWord = word.length();

			if(countOfWord.containsKey(countOfLettersInWord)){
				listOfWords = countOfWord.get(countOfLettersInWord);
				listOfWords.add(word);
			} else {
				listOfWords = new ArrayList<>();
				listOfWords.add(word);
				countOfWord.put(countOfLettersInWord, listOfWords);
			}

		}

		/*
		* Для того, чтобы вывести нашу таблиуцу используется интерфейс Itterator, он используется для того,
		* чтобы возвратить нашу пару "ключ-значение", из нашей карты Map<Integer, ArrayList<String>> countOfWord.
		*/
		Iterator it = countOfWord.entrySet().iterator();

		/*
		* С помощью цикла while мы проверяем, есть ли следующий элемент, и не достигнут ли конец коллекции.
		* Далее мы получем нашу пару "ключ-значение" в переменную pair с помощью метода next(). C помощью метода next()
		* можно получить следующий элемент. После получение пары, просто выводим ее в стандартный поток вывода.
		*
		* С помощью pair.getKey() мы получем ключ нашей пары (ключ указывает какое количество букв содержит слово),
		* а с помощью pair.getValue() мы получаем значение, которое содержит ArrayList в котором хранится список наших слов.
		*/
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " буквенные слова: " + pair.getValue());
		}
		
    }
}

