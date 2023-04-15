package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
@AllArgsConstructor
public class SomeService {

    private final CustomerDatabaseRepository customerDatabaseRepository;
    private final OpinionDatabaseRepository opinionDatabaseRepository;
    private final ProducerDatabaseRepository producerDatabaseRepository;
    private final ProductDatabaseRepository productDatabaseRepository;
    private final PurchaseDatabaseRepository purchaseDatabaseRepository;

    public void callCustomer() {
        System.out.println("#findByEmail: " + customerDatabaseRepository.findByEmail("eshenfish1p@cyberchimps.com"));
        System.out.println("#findByCustomerId(): " + customerDatabaseRepository.findByCustomerId(45));
        System.out.println("#findByNameOrEmail(): " + customerDatabaseRepository.findByNameOrEmail("Friederike","fwretham1v@statcounter.com"));
        System.out.println("#finfByNameAndEmail(): " + customerDatabaseRepository.findByNameAndEmail("Dorris","dmcgettrick0@infoseek.cjp"));
        System.out.println("#findDistinctByEmail(): " + customerDatabaseRepository.findDistinctByEmail("dmcgettrick0@infoseek.cjp"));
    }

    public void callProduct() {

        BigDecimal price1 = BigDecimal.valueOf(14.85);
        BigDecimal price2 = BigDecimal.valueOf(15.54);

        System.out.println("###findByProductPriceGreaterThan: " + productDatabaseRepository.findByProductPriceGreaterThan(price2));
        System.out.println("###findByProductPriceLessThan(): " + productDatabaseRepository.findByProductPriceLessThan(price1));
        System.out.println("###findByProductPriceBetween(): " + productDatabaseRepository.findByProductPriceBetween(price1,price2));
        System.out.println("###findByProductNameContaining(): " + productDatabaseRepository.findByProductNameContaining("Beef - Bones"));
        System.out.println("###findByProductNameLike(): " + productDatabaseRepository.findByProductNameLike("Cream - 35%"));
    }

    public void callPurchase() {

        OffsetDateTime dateTime1 = OffsetDateTime.of(2016,5,29,0,0,0,0, ZoneOffset.UTC);
        OffsetDateTime dateTime2 = OffsetDateTime.of(2017,1,2,0,0,0,0, ZoneOffset.UTC);

        System.out.println("###findByDateTimeBetween():" + purchaseDatabaseRepository.findByDateTimeBetween(dateTime1,dateTime2));


    }
}
