import java.io.*;
import java.util.Scanner;

class Example {
    public static void main(String[] args) throws IOException  { // для генерации исключения
            String s = ""; // для записи символов в строку
            // создание файла
            File file = new File("input.txt"); // в случае нахождения файла в не каталога, прописывается весь путь к файлу
            file.createNewFile(); // создание нового пустого файла
            Scanner sc = new Scanner(file); // считывание информации напрямую с файла

            /* символьный поток, предпочтительней (работа с символами и строками)
            // запись в файл, при необходимости этот блок комментируем, чтобы делать изменения в самом файле
            FileWriter writer = new FileWriter(file); // создание объекта, с указанием места записи
            writer.write("15 + 8"); // запись в файл
            writer.flush(); // очистка модуля записи от любого элемента, иначе будет ошибка
            writer.close(); // закрытие модуля записи
            // чтение из файла, обрабатываются потоки символов Unicode, cимвольный поток
        try (FileReader reader = new FileReader("input.txt")) // Поток ввода, который выполняет чтение из файла
            {
                int c;
                while((c=reader.read())!=-1){ // при каждом вызове метод read () читает символ из потока ввода и возвращает его в виде целочисленного значения. Он возвращает -1 при попытке чтения в конце потока. Может сгенерировать исключениеIOException.
                            s+=(char)c;
                }
            }
            // перехватываем исключение
        catch(IOException e){
                System.out.println("Ошибкa ввода-вывода: " + e);
            }
            Scanner sc = new Scanner(s); // передаем информацию
            */

            /*
            // байтовый поток, работа с байтами и двоичными и двоичными объектами
            // запись в файл, при необходимости этот блок комментируем, чтобы делать изменения в самом файле
            FileOutputStream writer = new FileOutputStream(file); // создание объекта, с указанием места записи
            String str = "11 + 19";
            byte [] buf = str.getBytes(); // переводим в байтовый массив
            writer.write(buf); // запись в файл
            writer.flush(); // очистка модуля записи от любого элемента, иначе будет ошибка
            writer.close(); // закрытие модуля записи

            // чтение из файла, обрабатываются потоки байтов
            try  (FileInputStream reader = new FileInputStream ("input.txt")) {
                int size = -1;
                while ((size = reader.read()) != -1) { // считываем информацию из потока, пока не достигнем конца
                    s += (char) size;
                }
                reader.close(); // закрываем поток чтобы не использовать ресурсы
            }
            // перехватываем исключение
            catch(IOException e){
                System.out.println("Ошибкa ввода-вывода: " + e);
            }

            Scanner sc = new Scanner(s); // передаем информацию
            */

             /*
             Scanner sc = new Scanner(System.in); // считывание данных с консоли, для первого задания
             String s = sc.nextLine(); // считываем строку
             sc.close(); // закрываем поток
             String s = "123 - 34r"; // проверка 1+
             String s = "123 8 0"; // проверка 2+
             String s = "123 / 0"; // проверка 3+
             */

            // действия калькулятора
        try { // проверяемый блок
            String[] words = sc.nextLine().split(" "); // разбиваем строку на подстроки, добавили
            double a = Double.parseDouble(words[0]); // преобразуем строку к примитивному типу double
            double b = Double.parseDouble(words[2]); // преобразуем строку к примитивному типу double
            if (!words[1].equals("+") && !words[1].equals("-") && !words[1].equals("/") && !words[1].equals("*")) throw new Exception(); // генерируем исключение вручную
            if (words[1].equals("/") && b == 0) throw new ArithmeticException(); // генерируем исключение вручную
            switch (words[1]) { // выполняем операцию
                case ("+"):
                    System.out.print(a + b);
                    break;
                case ("-"):
                    System.out.print(a - b);
                    break;
                case ("/"):
                    System.out.print(a / b);
                    break;
                case ("*"):
                    System.out.print(a * b);
                    break;
            }
        }
        // перехватываем исключения
        catch (NumberFormatException e) { // Недопустимое преобразование строки в числовой формат
            System.out.print("Error! Not number");
        }
        catch (ArithmeticException e) { // Арифметическая ошибка, такая как деление на 0
            System.out.print("Error! Division by zero");
        }
        catch(Exception e){ // Если вместо знака операции было введено любое другое значение,
            System.out.print("Operation Error!");
        }
    }
}
