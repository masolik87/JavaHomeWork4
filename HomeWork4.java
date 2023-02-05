/*
1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
4.Отсортировать по возрасту используя дополнительный список индексов.
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class HomeWork4 {

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        FileReader fileReader = null;

       try {
            fileWriter = new FileWriter("db.sql");
            fileWriter.append("Бруев " + "Д. " + "М. " + "36 " + "мужской " + "\n");
            fileWriter.append("Макаров " + "К. " + "Н. " + "31 " + "мужской " + "\n");
            fileWriter.append("Вервест " + "М. " + "А. " + "35 " + "женский "+ "\n");
            fileWriter.append("Машкова " + "Е. " + "А. " + "39 " + "женский "+ "\n");
            fileWriter.append("Мигачёв " + "А. " + "В. " + "36 " + "мужской "+ "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Reader reader = new FileReader("db.sql");
            String text = "";
            while (reader.ready()) {
                text += (char) reader.read();
            }
            String[] parts = text.split("\n");
            System.out.println(Arrays.toString(parts));
            System.out.println(text);

            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> lastname = new ArrayList<>();
            ArrayList<String> fatname = new ArrayList<>();
            ArrayList<Integer> age = new ArrayList<>();
            ArrayList<String> sex = new ArrayList<>();
            for (int i = 0; i < parts.length; i++) {
                String[] tmp = parts[i].split(" ");
                lastname.add(tmp[0]);
                name.add(tmp[1]);
                fatname.add(tmp[2]);
                age.add(Integer.parseInt(tmp[3]));
                sex.add(tmp[4]);
            }
            System.out.println(lastname);
            System.out.println(fatname);
            System.out.println(age);
            System.out.println(sex);
            Collections.sort(age);
            System.out.println(age);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
