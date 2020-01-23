package by.artezio.dto.user;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RegisterUserFormDto implements Serializable {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String urlBeforeRedirect;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String userName;


    public RegisterUserFormDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlBeforeRedirect() {
        return urlBeforeRedirect;
    }

    public void setUrlBeforeRedirect(String urlBeforeRedirect) {
        this.urlBeforeRedirect = urlBeforeRedirect;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
