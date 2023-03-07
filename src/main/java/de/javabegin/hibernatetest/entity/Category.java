/**
 * Category.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 26-Feb-2023 20:21
 */

package de.javabegin.hibernatetest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category {
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private Long id;

   private String title;

   @Column(name = "completed_count", updatable = false)
   private Long completed_count;

   @Column(name = "uncompleted_count", updatable = false)
   private Long uncompleted_count;

   @ManyToOne
   @JoinColumn(name = "user_id", referencedColumnName = "id") // форейн кей. По каким ключам связаны эти 2 объекта
   private User user;


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Category category = (Category) o;
      return id.equals(category.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public String toString() {
      return "Category{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", completed_count=" + completed_count +
              ", uncompleted_count=" + uncompleted_count +
              ", user=" + user +
              '}';
   }
}
