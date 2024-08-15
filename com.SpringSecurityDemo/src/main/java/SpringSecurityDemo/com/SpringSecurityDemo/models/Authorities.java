package SpringSecurityDemo.com.SpringSecurityDemo.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="authorities")
public class Authorities 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  private String authorityName;
  
  @ManyToMany(mappedBy = "authorities")
  private Set<User> users;
}
