/**
 * Stat.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 01-Mar-2023 20:37
 */

package de.javabegin.hibernatetest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "stat")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Stat {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "id", nullable = false)
   private Long id;



   //@Column(name = "userpassword")
   @Column(name = "completed_total", updatable = false)
   private Long completedTotal;
   @Column(name = "uncompleted_total", updatable = false)
   private Long uncompletedTotal;


   //@Column(name = "username", nullable = false, length = -1)
   //private String username;


   @OneToOne
   @MapsId
   @JoinColumn(name = "user_id", referencedColumnName = "id")
   private User user;

   @Override
   public String toString() {
      return "Stat{" +
              "id=" + id +
              ", completedTotal=" + completedTotal +
              ", uncompletedTotal=" + uncompletedTotal +
              ", user=" + user +
              '}';
   }
}
