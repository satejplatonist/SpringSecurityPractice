package SpringSecurityDemo.com.SpringSecurityDemo.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   private String name;
   
   private String password;
   
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "userauthorities",
      joinColumns = @JoinColumn(name="userId"),
      inverseJoinColumns = @JoinColumn(name="authorityId"))
   private Set<Authorities> authorities;
}
