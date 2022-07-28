package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.LoginBusiness;
import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.entity.Address;
import fr.eql.ai111.project2.abey.entity.Street;
import fr.eql.ai111.project2.abey.entity.User;
import fr.eql.ai111.project2.abey.web.util.DateUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "mbLogin")
@ViewScoped
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


    private List<Street> streets;
    private Street selectedStreet;
    @NotNull
    private Address selectedAddress;

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

    public void registerUser() {
        User newUser = new User(0, newLoginUser, newPasswordUser, newNameUser,
                newFirstnameUser,newBirthDateUser, newPhoneUser, newMailUser,
                newBirthDateUser, selectedAddress.getIdAddress());
        spaceBusiness.registerUser(newUser);
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
