package ru.frolov;

import ru.frolov.ioc.Application;
import ru.frolov.ioc.ApplicationContext;
import ru.frolov.model.Room;
import ru.frolov.service.CoronaDesinfector;
import ru.frolov.service.Policeman;
import ru.frolov.service.PolicemanImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.frolov", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }
}
