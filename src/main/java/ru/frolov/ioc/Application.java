package ru.frolov.ioc;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packagesToScan, Map<Class, Class> ifc2ImpClass) {

        JavaConfig config = new JavaConfig(packagesToScan, ifc2ImpClass);

        ApplicationContext context = new ApplicationContext(config);

        ObjectFactory objectFactory = new ObjectFactory(context);

        context.setFactory(objectFactory);

        context.initSingletons();

        return context;
    }
}
