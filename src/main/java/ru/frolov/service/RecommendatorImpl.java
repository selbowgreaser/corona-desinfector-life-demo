package ru.frolov.service;

import ru.frolov.ioc.InjectProperty;
import ru.frolov.ioc.Singleton;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created!");
    }

    @Override
    public void recommend() {
        System.out.println("to protect from covid-2019, drink " + alcohol);
    }
}
