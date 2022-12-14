package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.LoginBusiness;
import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.entity.Address;
import fr.eql.ai111.project2.abey.entity.Street;
import fr.eql.ai111.project2.abey.entity.User;
import fr.eql.ai111.project2.abey.web.util.DateUtils;
import javafx.stage.Window;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "mbLogin")
@ViewScoped
public class LoginManagedBean implements Serializable {

    @Size(min = 1, message = "Veuillez entrer un login")
    private String newLoginUser;
    @Size(min = 1, message = "veuillez entrer un mot de passe")
    private String newPasswordUser;
    @Size(min = 1, message = "veuillez entrer un prénom")
    private String newNameUser;
    @Size(min = 1, message = "veuillez entrer un nom")
    private String newFirstnameUser;
    @NotNull (message = "veuillez entrer une date de naissance")
    private Date newBirthDateUser;
    @Size(min = 1, message = "veuillez entrer un numéro de téléphone")
    private String newPhoneUser;
    @Size(min = 1, message = "veuillez entrer une adresse mail")
    private String newMailUser;
    @NotNull (message = "veuillez sélectionner une voie")
    private Street selectedStreet;
    @NotNull (message = "veuillez sélectionner un numéro de voie")
    private Address selectedAddress;

    private List<Street> streets;

    @EJB
    private SpaceBusiness spaceBusiness;
    @EJB
    private LoginBusiness loginBusiness;

    @PostConstruct
    public void init() {
        streets = findAllStreets();
    }

    public List<Street> findAllStreets() {
        return loginBusiness.findAllStreets();
    }

    public Street getStreetUpdatedWithAddresses (Street street) {
        if (street != null) {
            return loginBusiness.getStreetUpdatedWithAddresses(street);
        }
        return null;
    }

    public String registerUser() {
        User newUser = new User(0, newLoginUser, newPasswordUser, newNameUser,
                newFirstnameUser,newBirthDateUser, newPhoneUser, newMailUser,
                newBirthDateUser, selectedAddress.getIdAddress());
        spaceBusiness.registerUser(newUser);
        String forward;
        forward = "/popupCreatAccount.xhtml?faces-redirect=true";
        return forward;
    }



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

    public String fullDate (LocalDate date) {
        return DateUtils.fullDate(date);
    }

    public List<Street> getStreets() {
        return streets;
    }
    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
    public Street getSelectedStreet() {
        return selectedStreet;
    }
    public void setSelectedStreet(Street selectedStreet) {
        this.selectedStreet = selectedStreet;
    }
    public Address getSelectedAddress() {
        return selectedAddress;
    }
    public void setSelectedAddress(Address selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

}
