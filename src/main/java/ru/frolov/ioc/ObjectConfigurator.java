package ru.frolov.ioc;

public interface ObjectConfigurator {
    void configure(Object object, ApplicationContext context);
}
