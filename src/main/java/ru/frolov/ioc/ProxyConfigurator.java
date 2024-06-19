package ru.frolov.ioc;

public interface ProxyConfigurator {

    Object replaceWithProxyIfNeeded(Object object, Class implClass);
}
