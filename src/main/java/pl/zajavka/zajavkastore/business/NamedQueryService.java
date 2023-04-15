package pl.zajavka.zajavkastore.business;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NamedQueryService {

    private final CustomerDatabaseRepository customerDatabaseRepository;

    public void queryService(){
        List<CustomerEntity> allCustomer = customerDatabaseRepository.findAllCustomers();
        System.out.printf("###All: " + allCustomer);

        CustomerEntity customerByEmail = customerDatabaseRepository.findCustomerByEmail("gcrawcour8@bbc.couk");
        System.out.printf("###CustomerByEmail : " + customerByEmail);
    }

}
