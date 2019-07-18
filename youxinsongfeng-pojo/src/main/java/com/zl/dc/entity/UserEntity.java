package com.zl.dc.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/5 16:18
 * @Description:
 */
@Entity
@Table(name = "user", schema = "db_youxinsongfeng")
public class UserEntity {
    @Id
    @Column(name = "userId")
    private int userId;
    @Column(name = "username")
    private String username;
    @Column(name = "image")
    private String image;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "cityid")
    private Integer cityid;
    @Column(name = "address")
    private String address;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "STATUS")
    private String state;
    @Column(name = "Household_Name")
    private String householdName;
    @Column(name = "Opening_Bank")
    private String OpeningBank;
    @Column(name="Bank_account")
    private String BankAccount;
    @Transient
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(username, that.username) &&
                Objects.equals(image, that.image) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cityid, that.cityid) &&
                Objects.equals(address, that.address) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(state, that.state) &&
                Objects.equals(householdName, that.householdName) &&
                Objects.equals(OpeningBank, that.OpeningBank) &&
                Objects.equals(BankAccount, that.BankAccount) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, image, password, phone, email, cityid, address, nickname, state, householdName, OpeningBank, BankAccount, code);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", image='" + image + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cityid=" + cityid +
                ", address='" + address + '\'' +
                ", nickname='" + nickname + '\'' +
                ", state='" + state + '\'' +
                ", householdName='" + householdName + '\'' +
                ", OpeningBank='" + OpeningBank + '\'' +
                ", BankAccount='" + BankAccount + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getOpeningBank() {
        return OpeningBank;
    }

    public void setOpeningBank(String openingBank) {
        OpeningBank = openingBank;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(String bankAccount) {
        BankAccount = bankAccount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
