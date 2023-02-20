Разбор задач: исключения
Простой калькулятор
Пользователь вводит одну строку, в которой должно быть записано простое арифметическое выражение вида "a <операция> b", где a и b - какие-то действительные числа, а операция - один из символов "+", "-", "*", "/". Ваша задача - выполнить вычисление, если это возможно. Гарантируется, что в введённой строке ровно 2 пробела (значение пробел значение пробел значение) В результате работы могут произойти различные ошибки. Их нужно обработать следующим образом: 
•	Если одно из чисел не является числом, то вывести на экран "Error! Not number"
•	Если вместо знака операции было введено любое другое значение, то выведите "Operation Error!"  
•	Если произошла попытка деления на ноль, то выведите на экран "Error! Division by zero"
Обрабатывать исключения необходимо в указанном выше порядке.
Продолжите работу над проектом. Добавьте возможность считывания одной строчки из файла input.txt.
Теперь, помимо считывания строки из файла, добавьте возможность записи ответа в файл output.txt.
Теперь в файле input.txt лежит не одна, а неизвестное количество строк. Ваша задача - сформировать файл output.txt, в котором для каждой строчки будет лежать ответ вида: "<исходная строка> = <ответ к этой строке>". 

Пример:
35 + 5
35 - 5
35 / 5
35 / 0
35 * 5
35 ? 5
35 / 0
35 + 5
40 * 80
1 + 1f
25t + 14
25t + 14y

35 + 5 = 40.0
35 - 5 = 30.0
35 / 5 = 7.0
35 / 0 = Error! Division by zero
35 * 5 = 175.0
35 ? 5 = Operation Error!
35 / 0 = Error! Division by zero
35 + 5 = 40.0
40 * 80 = 3200.0
1 + 1f = Error! Not number
25t + 14 = Error! Not number
25t + 14y = Error! Not number

import java.io.*;
import java.util.Scanner;

class Example {
    public static void main(String[] args) throws Exception { // для генерации исключения
            // создание файла
            File file = new File("input.txt"); // файл для ввода, в случае нахождения файла в не каталога, прописывается весь путь к файлу
            //file.createNewFile(); // создание нового пустого файла, необязательно если создаешь файл вручную
            Scanner sc = new Scanner(file); // считывание информации напрямую с файла

            File output = new File("output.txt"); // файл для вывода ответа калькулятора
            //file.createNewFile(); // создание нового пустого файла, необязательно если создаешь файл вручную

            // String s = ""; // для записи символов в строку (FileReader,FileInputStream)
        /* символьный поток, предпочтительней (работа с символами и строками)
            // запись в файл, при необходимости этот блок комментируем, чтобы делать изменения в самом файле
            FileWriter writer = new FileWriter(file); // создание объекта, с указанием места записи
            writer.write("15 + 8"); // запись в файл
            writer.flush(); // очистка модуля записи от любого элемента
            writer.close(); // закрытие модуля записи
            // чтение из файла, обрабатываются потоки символов Unicode
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

        PrintWriter out = new PrintWriter (output); // класс направляет все выходные данные в указанный файл.

            // действия калькулятора
        while (sc.hasNextLine()) { // добавляем когда нужно считать несколько строк
            try { // проверяемый блок, ставим тут чтобы каждый раз проверялась новая строка
                String s = sc.nextLine(); // перезаписываем строку
                String[] words = s.split(" "); // разбиваем строку на подстроки, добавили
                int a,b;
                try {
                    Integer.parseInt(words[0]); // преобразуем строку к примитивному типу int
                    Integer.parseInt(words[2]); // преобразуем строку к примитивному типу int
                } catch (NumberFormatException ec) {
                    out.println (s + " = Error! Not number");
                    throw new Exception(s + " = Error! Not number\n");
                }

                a = Integer.parseInt(words[0]); // преобразуем строку к примитивному типу int
                b = Integer.parseInt(words[2]); // преобразуем строку к примитивному типу int
                if (!words[1].equals("+") && !words[1].equals("-") && !words[1].equals("/") && !words[1].equals("*")) {
                    out.println(s + " = Operation Error!"); // выводим данные в файл
                    throw new Exception(s + " = Operation Error!\n");
                } // генерируем исключение вручную
                if (words[1].equals("/") && b == 0) {
                    out.println(s + " = Error! Division by zero"); // выводим данные в файл
                    throw new ArithmeticException(s + " = Error! Division by zero\n");
                } // генерируем исключение вручную
                switch (words[1]) { // выполняем операцию
                    case ("+"):
                        System.out.println(s + " = " + (double) (a + b)); // переводим результат в формат double
                        out.println(s + " = " + (double) (a + b)); // выводим данные в файл
                        break;
                    case ("-"):
                        System.out.println(s + " = " + (double) (a - b)); // переводим результат в формат double
                        out.println(s + " = " + (double) (a - b)); // выводим данные в файл
                        break;
                    case ("/"):
                        System.out.println(s + " = " + (double) a / b); // переводим результат в формат double
                        out.println(s + " = " + (double) (a / b)); // выводим данные в файл
                        break;
                    case ("*"):
                        System.out.println(s + " = " + (double) a * b); // переводим результат в формат double
                        out.println(s + " = " + (double) (a * b)); // выводим данные в файл
                        break;
                }
            }
            // перехватываем исключения
            catch (NumberFormatException e) { // Недопустимое преобразование строки в числовой формат
                System.out.print(e.getMessage());
            } catch (ArithmeticException e) { // Арифметическая ошибка, такая как деление на 0
                System.out.print(e.getMessage());
            } catch (Exception e) { // Если вместо знака операции было введено любое другое значение,
                System.out.print(e.getMessage());
            }

        }
        out.close(); // чтобы отображались все записи out.println обязательно в конце закрываем поток
        sc.close(); // закрываем поток
    }
}
