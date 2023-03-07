/**
 * Activity.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 01-Mar-2023 17:46
 */

package de.javabegin.hibernatetest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

// класс актиности пользователя
@Entity
@Table(name = "activity")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Activity {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "id", nullable = false)
   private Long id;

   //@Column(name = "email", nullable = false, length = -1)
   //@Type(type = "org.hibernate.type.NumericBooleanType")
   @Basic
   @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
   private boolean activated;

   //@Column(name = "userpassword")
   @Column(updatable = false)
   private String uuid;

   //@Column(name = "username", nullable = false, length = -1)
   //private String username;


   @OneToOne
   @MapsId
   @JoinColumn(name = "user_id", referencedColumnName = "id")
   private User user;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Activity activity = (Activity) o;
      return id.equals(activity.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }


}

