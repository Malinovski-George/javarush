package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/


public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        File rootDir = new File(root);
        stack.push(rootDir);
        while (!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isDirectory()) {
                for (File f : child.listFiles()) {
                    stack.push(f);
                }
            } else if (child.isFile()) {
                fileList.add(child.getAbsolutePath());
            }
        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
        //  List<String> fileList = getFileTree("src/main/resources/level31/lesson02/home02");
        List<String> fileList = getFileTree("C:\\Users\\Gia\\IdeaProjects\\JavaRushTasks\\4.JavaCollections\\src\\com\\");
        for (String s : fileList) {
            System.out.println(s);
        }
    }
}

