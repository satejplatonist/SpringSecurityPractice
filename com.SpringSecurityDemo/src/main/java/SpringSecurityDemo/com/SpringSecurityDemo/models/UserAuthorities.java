package SpringSecurityDemo.com.SpringSecurityDemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "userauthorities")
public class UserAuthorities 
{
  @Id
  private long userId;
  private long authorityId;
}
