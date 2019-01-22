package ru.itis.project.reflex;

public interface ApplicationContext {
    <T> T getComponent(Class<T> componentClass);
}