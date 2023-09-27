package sogaeron.gym.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name="user_id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="sex")
    private String sex;

    @Column(name="password")
    private String password;
    @Column(name="nickname")
    private String nickname;


}
