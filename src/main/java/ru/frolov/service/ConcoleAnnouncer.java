package ru.frolov.service;

import ru.frolov.ioc.InjectByType;
import ru.frolov.ioc.Lazy;
import ru.frolov.ioc.Singleton;

@Lazy
@Singleton
public class ConcoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
