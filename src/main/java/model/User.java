package model;


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

    private String username;

    private String address;

    private String phone_number;

    private String sex;

    private String password;

    private String nickname;


}
