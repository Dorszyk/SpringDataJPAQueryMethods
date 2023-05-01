package pl.zajavka.zajavkastore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.zajavka.zajavkastore.business.NamedNativeQueries;
import pl.zajavka.zajavkastore.business.NamedQueryService;
import pl.zajavka.zajavkastore.business.QueryByExampleService;
import pl.zajavka.zajavkastore.business.SomeService;
import pl.zajavka.zajavkastore.infrastructure.configuration.ApplicationConfiguration;

public class ZajavkaStoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        SomeService someService = context.getBean(SomeService.class);
        NamedQueryService namedQueryService =context.getBean(NamedQueryService.class);
        NamedNativeQueries namedNativeQueries = context.getBean(NamedNativeQueries.class);
        QueryByExampleService queryByExampleService = context.getBean(QueryByExampleService.class);
        someService.callCustomer();
        someService.callProduct();
        someService.callPurchase();
        namedQueryService.queryService();
        namedNativeQueries.queryNativeService();
        queryByExampleService.queryByExample();
    }
}
