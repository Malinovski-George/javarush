package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией — выведи «[полный путь] — не папка» и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок — [количество папок в директории]
Всего файлов — [количество файлов в директории и поддиректориях]
Общий размер — [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.


Требования:
1. Метод main должен считывать путь к папке с консоли.
2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
3. На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории]".
4. На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
5. На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".
*/
public class Solution {

    public static int countFiles = 0;
    public static int countDir = -1;
    public static int totalSize = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path filePath = Paths.get(new BufferedReader(new InputStreamReader(System.in)).readLine());

        class SolutionInner extends SimpleFileVisitor<Path> {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countFiles++;
                totalSize += Files.size(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                countDir++;
                return FileVisitResult.CONTINUE;
            }
        }

        if (Files.isDirectory(filePath)) {
            Files.walkFileTree(filePath, new SolutionInner());
            System.out.println("Всего папок - " + countDir);
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + totalSize);

        } else System.out.println(filePath + " - не папка");
    }
}
