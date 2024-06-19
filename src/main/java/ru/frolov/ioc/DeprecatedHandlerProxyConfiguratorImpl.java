package ru.frolov.ioc;

import lombok.SneakyThrows;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfiguratorImpl implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object object, Class implClass) {

        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (implClass.getInterfaces().length == 0) {
                return Enhancer.create(implClass, (InvocationHandler) (proxy, method, args) -> getInvocationHandlerLogic(object, method, args));
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(object, method, args));
        } else {
            return object;
        }
    }

    @SneakyThrows
    private Object getInvocationHandlerLogic(Object object, Method method, Object[] objects) {
        System.out.println("*********** что ж ты делаешь урод!!!");
        return method.invoke(object, objects);
    }
}
