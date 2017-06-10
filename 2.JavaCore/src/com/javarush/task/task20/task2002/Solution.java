package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("/home/saneok777/Yandex.Disk/file_for_test");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User a = new User();
            a.setFirstName("Ivan");
            a.setLastName("Ivanov");
            a.setBirthDate(new Date());  // вот только что родился
            a.setMale(true);
            a.setCountry(User.Country.RUSSIA);
            // После инициализации объект сохраняется в файл
            javaRush.save(outputStream);
            outputStream.flush();

            // Загрузка нового объекта в loadedObject
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));  //неясно зачем сдесь надо что-то сравнивать и куда девать результат
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (users != null) { // Выполнять если список не пустой

                PrintWriter writer = new PrintWriter(outputStream);
                for (User a : users) {
                    // Добавляем данные пользователя в строку через пробел
                    String line = a.getFirstName() + " " + a.getLastName() + " " + a.getBirthDate().getTime();
                    if (a.isMale())
                        line += " " + "М";
                    else
                        line += " " + "Ж";
                    line += a.getCountry().getDisplayedName();
                    writer.println(line); // Записываем получившуюся строку в файл
                }
                writer.flush();  // Сохраняем изменения в файле

            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;  // Считываем данные каждого пользователя в отдельную строку line
            while ((line = reader.readLine()) != null)
            {
                String[] s = line.split(" ");
                User user = new User();
                user.setFirstName(s[0]);
                user.setLastName(s[1]);
                user.setBirthDate(new Date(Long.parseLong(s[2])));
                if (s[3].equals("М"))
                    user.setMale(true);
                else
                    user.setMale(false);
                if (s[4].equals(User.Country.RUSSIA))
                    user.setCountry(User.Country.RUSSIA);
                else if (s[4].equals(User.Country.UKRAINE))
                    user.setCountry(User.Country.UKRAINE);
                else
                    user.setCountry(User.Country.OTHER);
                users.add(user);
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
