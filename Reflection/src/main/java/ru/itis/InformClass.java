package ru.itis;

import sun.reflect.Reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class InformClass {
    public void informationAboutClasses(Class aClass) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IOException {
        Field allFields[] = aClass.getDeclaredFields();
        System.out.println(">>>>>>>>>>>>>>>>>>>NameOfClass : " + aClass.getName().toString());
        System.out.println();
        System.out.println(">> Fields");
        for (Field field : allFields) {
            System.out.println(field.getType() + " " + field.getName());
        }
        System.out.println();
        Method allMethods[] = aClass.getMethods();
        System.out.println(">> Methods");
        for (Method method : allMethods) {
            System.out.println(method.getName());
        }
        System.out.println();
        Constructor[] allConstructors = aClass.getConstructors();
        System.out.println(">> Constructors");
        for (Constructor constructor : allConstructors) {
            System.out.println(constructor.getName());
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println(parameterTypes[i]);
            }
        }
        System.out.println();
        System.out.println("Which the constructor do you want to use?");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine()) - 1;
        Object[] objects = new Object[allConstructors[count].getParameterCount()];
        int parNum = allConstructors[count].getParameterCount();
        scanner.reset();
        String toIn;
        String toCast;

        for (int c = 0; c < parNum; c++) {
            String classType = allConstructors[count].getParameterTypes()[c].toString();
            toCast = classType.split(" ")[1].split("\\.")[classType.split(" ")[1].split("\\.").length - 1];
            System.out.println("Enter " + toCast);
            switch (toCast) {
                case "Integer":
                    objects[c] = Integer.parseInt(scanner.nextLine());
                    break;
                case "String":
                    objects[c] = scanner.nextLine();
                    break;
                case "BigDecimal":
                    objects[c] = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));
                    break;
                case "BigInteger":
                    objects[c] = BigInteger.valueOf(Long.parseLong(scanner.nextLine()));
                    break;
                case "Boolean":
                    objects[c] = Boolean.parseBoolean(scanner.nextLine());
                    break;
                case "Byte":
                    objects[c] = Byte.parseByte(scanner.nextLine());
                    break;
                case "Double":
                    objects[c] = Double.parseDouble(scanner.nextLine());
                    break;
                case "Float":
                    objects[c] = Float.parseFloat(scanner.nextLine());
                    break;
                case "Long":
                    objects[c] = Long.parseLong(scanner.nextLine());
                    break;
                case "Char":
                    objects[c] = (char) Byte.parseByte(scanner.nextLine());
                    break;
            }
        }
        try {
            Object a = allConstructors[count].newInstance(objects);
            System.out.println("Enter filename");
            String filename;
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream((filename = scanner.nextLine()) + ".bin"));
            System.out.println("Enter path for file");
            File whereTo = new File("C:\\Users\\Iljas\\Desktop\\inf\\class");
            File currentFileToPath = new File(filename);
            currentFileToPath.renameTo(new File(whereTo, filename));
            if (a instanceof Serializable) stream.writeObject(a);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
