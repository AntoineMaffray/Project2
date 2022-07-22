package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class User implements Serializable {

    private int idUser;
    private String loginUser;
    private String passwordUser;
    private String nameUser;
    private String firstnameUser;
    private Date birthDateUser;
    private String phoneUser;
    private String mailUser;
    private Date dateCreationAccountUser;

    public User(int idUser, String loginUser, String passwordUser, String nameUser, String firstnameUser, Date birthDateUser, String phoneUser, String mailUser, Date dateCreationAccountUser) {
        this.idUser = idUser;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.nameUser = nameUser;
        this.firstnameUser = firstnameUser;
        this.birthDateUser = birthDateUser;
        this.phoneUser = phoneUser;
        this.mailUser = mailUser;
        this.dateCreationAccountUser = dateCreationAccountUser;
    }

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getLoginUser() {
        return loginUser;
    }
    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
    public String getPasswordUser() {
        return passwordUser;
    }
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
    public String getNameUser() {
        return nameUser;
    }
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    public String getFirstnameUser() {
        return firstnameUser;
    }
    public void setFirstnameUser(String firstnameUser) {
        this.firstnameUser = firstnameUser;
    }
    public Date getBirthDateUser() {
        return birthDateUser;
    }
    public void setBirthDateUser(Date birthDateUser) {
        this.birthDateUser = birthDateUser;
    }
    public String getPhoneUser() {
        return phoneUser;
    }
    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }
    public String getMailUser() {
        return mailUser;
    }
    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }
    public Date getDateCreationAccountUser() {
        return dateCreationAccountUser;
    }
    public void setDateCreationAccountUser(Date dateCreationAccountUser) {
        this.dateCreationAccountUser = dateCreationAccountUser;
    }

}
