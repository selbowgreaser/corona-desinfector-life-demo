package ru.frolov.ioc;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfiguratorImpl implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object object, ApplicationContext context) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object o = context.getObject(field.getType());
                field.set(object, o);
            }
        }
    }
}
