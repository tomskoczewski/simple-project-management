package pl.github.se.user;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "SE_USERS")
public class SqlUser {

    public static SqlUser fromUser(User source) {
        var result = new SqlUser();

        result.id = source.getId();
        result.username = source.getUsername();
        result.password = source.getPassword();
        result.mail = source.getMail();
        result.description = source.getDescription();
        result.userType = source.getUserType();

        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String username;
    private String password;
    private String mail;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    public SqlUser() {
    }

    public User toUser() {
        var result = new User();

        result.setId(id);
        result.setUsername(username);
        result.setPassword(password);
        result.setMail(mail);
        result.setDescription(description);
        result.setUserType(userType);

        return result;
    }

}
