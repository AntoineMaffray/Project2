package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.entity.User;
import fr.eql.ai111.project2.abey.web.util.DateUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@ManagedBean(name = "mbLogin")
@RequestScoped
public class LoginManagedBean implements Serializable {

    @NotNull (message = "veuillez entrer un login")
    private String newLoginUser;
    @NotNull (message = "veuillez entrer un mot de passe")
    private String newPasswordUser;
    @NotNull (message = "veuillez entrer un prénom")
    private String newNameUser;
    @NotNull (message = "veuillez entrer un nom")
    private String newFirstnameUser;
    @NotNull (message = "veuillez entrer une date de naissance")
    private Date newBirthDateUser;
    @NotNull (message = "veuillez entrer un numéro de téléphone")
    private String newPhoneUser;
    @NotNull (message = "veuillez entrer une adresse mail")
    private String newMailUser;
    @NotNull
    private Date newDateCreationAccountUser;

    @EJB
    private SpaceBusiness spaceBusiness;

    public String  registerUser() {
        User newUser = new User(666, newLoginUser, newPasswordUser, newNameUser, newFirstnameUser,newBirthDateUser, newPhoneUser, newMailUser, newBirthDateUser);
        spaceBusiness.registerUser(newUser);
        return null;
    }

//    public void resetSelectedCity() {
//        selectedCity = null;

//    }

    public String getNewLoginUser() {
        return newLoginUser;
    }
    public void setNewLoginUser(String newLoginUser) {
        this.newLoginUser = newLoginUser;
    }
    public String getNewPasswordUser() {
        return newPasswordUser;
    }
    public void setNewPasswordUser(String newPasswordUser) {
        this.newPasswordUser = newPasswordUser;
    }
    public String getNewNameUser() {
        return newNameUser;
    }
    public void setNewNameUser(String newNameUser) {
        this.newNameUser = newNameUser;
    }
    public String getNewFirstnameUser() {
        return newFirstnameUser;
    }
    public void setNewFirstnameUser(String newFirstnameUser) {
        this.newFirstnameUser = newFirstnameUser;
    }
    public Date getNewBirthDateUser() {
        return newBirthDateUser;
    }
    public void setNewBirthDateUser(Date newBirthDateUser) {
        this.newBirthDateUser = newBirthDateUser;
    }
    public String getNewPhoneUser() {
        return newPhoneUser;
    }
    public void setNewPhoneUser(String newPhoneUser) {
        this.newPhoneUser = newPhoneUser;
    }
    public String getNewMailUser() {
        return newMailUser;
    }
    public void setNewMailUser(String newMailUser) {
        this.newMailUser = newMailUser;
    }
    public Date getNewDateCreationAccountUser() {
        return newDateCreationAccountUser;
    }
    public void setNewDateCreationAccountUser(Date newDateCreationAccountUser) {
        this.newDateCreationAccountUser = newDateCreationAccountUser;
    }
    public String fullDate (LocalDate date) {
        return DateUtils.fullDate(date);
    }

}
