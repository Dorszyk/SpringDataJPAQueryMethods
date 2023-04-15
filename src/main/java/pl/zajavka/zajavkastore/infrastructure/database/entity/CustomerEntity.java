package pl.zajavka.zajavkastore.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "customerId")
@ToString(of = {"customerId", "userName", "email"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(
                name = "CustomerEntity.findAllCustomers",
                query = "FROM CustomerEntity"
        ),
        @NamedQuery(
                name = "CustomerEntity.findCustomerByEmail",
                query = "FROM CustomerEntity WHERE email =?1"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "CustomerEntity.findAllCustomersNamedNativeQueries",
                query = "SELECT  * FROM  customer",
                resultClass = CustomerEntity.class),
        @NamedNativeQuery(
                name = "CustomerEntity.findCustomerByEmailNameNativeQueries",
                query = "SELECT * FROM  customer where email = ?1",
                resultClass = CustomerEntity.class
        )
})
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id", unique = true, nullable = false)
    private Integer customerId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerEntity")
    private Set<PurchaseEntity> purchaseEntities;

}
