/**
 * UserData.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 08-Feb-2023 23:28
 */

package de.javabegin.hibernatetest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_data")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false)
    private Long id;

    //@Column(name = "email", nullable = false, length = -1)
    private String email;

    @Column(name = "userpassword")
    private String password;

    //@Column(name = "username", nullable = false, length = -1)
    private String username;

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Task> tasks;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Category> categories;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Priority> priorities;
//
//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
//    public Activity activity;
//
//    // optional = false: говорим хибернейту, что это поле, стат точно не налл с той стороны + @MapsId,
//    //таким образом достигает ленивой инициализации для one-to-one
//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
//    public Stat stat;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
//    @JoinTable(name ="user_role",
//                joinColumns = @JoinColumn(name = "user_id"),
//                inverseJoinColumns = @JoinColumn(name = "role_id"))






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return username;
    }
}
