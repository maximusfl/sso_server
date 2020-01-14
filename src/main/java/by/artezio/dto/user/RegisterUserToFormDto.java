package by.artezio.dto.user;

public class RegisterUserToFormDto {
    private String name;
    private String password;
    private String urlBeforeRedirect;
    private String userName;
    private String email;

    public RegisterUserToFormDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
