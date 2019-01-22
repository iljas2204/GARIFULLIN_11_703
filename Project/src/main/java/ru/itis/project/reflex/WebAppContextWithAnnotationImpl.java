package ru.itis.project.reflex;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebAppContextWithAnnotationImpl implements ApplicationContext {

    public WebAppContextWithAnnotationImpl(String... packages) {
        analyzePackages(packages);
    }

    public void init() {
        instantiate();
    }

    private Map<Class, Object> instances = new HashMap<>();
    private List<Class> classComponents = new ArrayList<>();

    public <T> T getComponent(Class<T> componentClass) {
        return (T) instances.get(componentClass);
    }

    public void analyzePackages(String... basePackages) {
// пробекаем по всем переданным пакетам
        for (String basePackage : basePackages) {

            String path = basePackage.replace('.', '/');

            try {
//
                ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                URL resource = classLoader.getResource(path);

                if (resource == null) {
                    throw new IOException();
                }

// массив всех файлов в переданном пакете
                File[] components = new File(resource.toURI()).listFiles();

                if (components == null) {
                    throw new IOException();
                }

// пробегаем по всем полученным из пакета файлам , проверяем что это класс файлы и добавляем в список компонентов
                for (File classFile : components) {
                    String fileName = classFile.getName();

                    if (!fileName.endsWith(".class")) {
                        continue;
                    }
// получаем .class file по названию класса, вставляем его в лист всех компонетов
                    String className = fileName.substring(0, fileName.lastIndexOf("."));
                    Class classObject = Class.forName(basePackage + "." + className);

                    classComponents.add(classObject);
                }

            } catch (IOException e) {
                System.err.println("Package " + basePackage + " not found.");
            } catch (URISyntaxException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void instantiate() {
// для всех компонентов получаем инстанс по конструктору, и добавляем в мапу (
        for (Class classObject : classComponents) {
            try {
                Object componentInstance = instantiateByConstructor(classObject);
                instances.put(componentInstance.getClass(), componentInstance);
            } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                    InvocationTargetException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    private Object instantiateByConstructor(Class dependency) throws IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchMethodException, ClassNotFoundException {
// если в мапе есть такой класс, то возвращаем его реализацию
        if (instances.containsKey(dependency)) {
            return instances.get(dependency);
        }

// если интерфейс, то ищем реализацию по конструктору (метод вернет)
        if (dependency.isInterface()) {
            Object implementationInstance = instantiateByConstructor(findImplementation(dependency));
            instances.put(dependency, implementationInstance);
            return implementationInstance;
        }

        for (Constructor constructor : dependency.getConstructors()) {

            if (constructor.getParameterCount() == 0) {
                continue;
            }

            List<Object> constructorDependencies = new ArrayList<>();

            for (Class type : constructor.getParameterTypes()) {
                Object instance = instantiateByConstructor(type);
                constructorDependencies.add(instance);

                if (instance == null) {
                    continue;
                }

                instances.put(instance.getClass(), instance);
            }

            Object instance = constructor.newInstance(constructorDependencies.toArray());
            instances.put(instance.getClass(), instance);

            return instance;
        }
        return dependency.getConstructor().newInstance();
    }

    private Class findImplementation(Class interfaceClass) throws ClassNotFoundException {

// проходим по все компонентам и ищем импл. интрефейса
        for (Class classComponent : classComponents) {

            if (classComponent.equals(interfaceClass)) {
                continue;
            }
// При использовании isAssignableFrom() класс classComponent во время компиляции может быть динамическим и изменяться во время выполнения.
            if (interfaceClass.isAssignableFrom(classComponent)) {
                return classComponent;
            }
        }
        throw new ClassNotFoundException("No implementation of " + interfaceClass);
    }

    // что бы могли добавить DataSource
    public <T> void addDependency(Class dependency, T instance) {
        instances.put(dependency, instance);
    }

    public void showComponents() {
        System.err.println("----Component----" + space("----Component----") + "----Implementation----");
        instances.forEach((k, v) -> System.err.println(k.getSimpleName() + space(k.getSimpleName()) + v));
        System.err.println("\n");
    }

// private String getSetterName(Field field) {
// String fieldName = field.getName();
// return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
// }

    private String space(String e) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 40 - e.length(); i++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

}