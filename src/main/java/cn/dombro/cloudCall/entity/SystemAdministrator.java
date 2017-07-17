package cn.dombro.cloudCall.entity;

public class SystemAdministrator {
    private Integer saId;

    private String username;

    private String password;

    private Long phoneNumber;

    public Integer getSaId() {
        return saId;
    }

    public void setSaId(Integer saId) {
        this.saId = saId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}