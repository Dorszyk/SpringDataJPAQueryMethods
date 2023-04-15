package pl.zajavka.zajavkastore.infrastructure.database.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.PurchaseEntity;


import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface PurchaseDatabaseRepository extends JpaRepository<PurchaseEntity, Integer> {

    List<PurchaseEntity> findByDateTimeBetween(OffsetDateTime dateTime, OffsetDateTime dateTime2);


}
