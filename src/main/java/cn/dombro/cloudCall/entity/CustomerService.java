package cn.dombro.cloudCall.entity;

public class CustomerService {
    private Integer csId;

    private String username;

    private String password;

    private String name;

    private String idNumber;

    private Long phoneNumber;

    private String email;

    private String account;

    private Integer balance;

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public CustomerService(Integer csId, String username, String password, String name,
                           String idNumber, Long phoneNumber, String email, String account, Integer balance) {
        this.csId = csId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
        this.balance = balance;
    }

    public CustomerService() {
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "csId=" + csId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", balance=" + balance +
                '}';
    }
}