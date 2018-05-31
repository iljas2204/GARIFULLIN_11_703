package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    @Parameter(names = "-classFolder")
    private String classFolder = "";

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    public void run() throws IOException, URISyntaxException {
        InformClass informClass = new InformClass();
        URL url = new URL("file:\\" + classFolder + "\\");
        URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());
        Files
                .list(Paths.get(url.toURI().normalize()))
                .forEach(file -> {
                    try {
                        PackageName packageName = new PackageName();
                        Class aClass = loader.loadClass( packageName.packageName(classFolder, file.getFileName().toString()) + file.getFileName().toString().replaceAll(".class" , ""));
                        informClass.informationAboutClasses(aClass);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
