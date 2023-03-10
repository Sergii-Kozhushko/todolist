/**
 * Role.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 01-Mar-2023 21:18
 */

package de.javabegin.hibernatetest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role_data")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Role {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "id", nullable = false)
   private Integer id;

   private String name;

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "user_role",
           joinColumns = @JoinColumn(name = "role_id"),
           inverseJoinColumns = @JoinColumn(name = "user_id"))
   private Set<User> users;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Role role = (Role) o;
      return id.equals(role.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}
