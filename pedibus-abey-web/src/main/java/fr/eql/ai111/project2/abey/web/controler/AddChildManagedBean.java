package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.entity.*;
import fr.eql.ai111.project2.abey.web.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ManagedBean(name = "mbaddchild")
@ViewScoped
public class AddChildManagedBean implements Serializable {

    @ManagedProperty(value = "#{mbConnection.connectedUser}")
    private User connectedUser;

    private List<School> schools = new ArrayList<>();
    private List<SchoolLevel> schoolLevels = new ArrayList<>();

    @NotNull(message = "veuillez entrer un prénom")
    private String newNameChild;
    @NotNull (message = "veuillez entrer un nom")
    private String newFirstnameChild;
    @NotNull (message = "veuillez entrer une date de naissance")
    private Date newBirthDateChild;
    @NotNull (message = "veuillez renseigner une école")
    private School newSchool;
    @NotNull (message = "veuillez renseigner un niveau scolaire")
    private SchoolLevel newSchoolLevel;

    @EJB
    private SpaceBusiness spaceBusiness;

    @PostConstruct
    public void init() {
        fillSchools();
        fillSchoolLevels();
    }

//    public String registerChild () {
//        Child child = new Child(666, newFirstnameChild, newNameChild,
//                newBirthDateChild, 0, 0, 0);
//        return null;
//    }
//
//    public String registerSchooling () {
//        Schooling schooling = new Schooling(666, newSchool, newSchoolLevel, 1);
//        return null;
//    }




    public void superRegisterChild() {
        Child child = new Child(666, newFirstnameChild, newNameChild,
                newBirthDateChild, 1, 666, 0);
        Schooling schooling = new Schooling(666, newSchool, newSchoolLevel, 666);
        spaceBusiness.superRegisterChild(child, schooling, connectedUser);
    }

    public String getNewNameChild() {
        return newNameChild;
    }

    public void setNewNameChild(String newNameChild) {
        this.newNameChild = newNameChild;
    }

    public String getNewFirstnameChild() {
        return newFirstnameChild;
    }

    public void setNewFirstnameChild(String newFirstnameChild) {
        this.newFirstnameChild = newFirstnameChild;
    }

    public Date getNewBirthDateChild() {
        return newBirthDateChild;
    }

    public void setNewBirthDateChild(Date newBirthDateChild) {
        this.newBirthDateChild = newBirthDateChild;
    }

    public School getNewSchool() {
        return newSchool;
    }

    public void setNewSchool(School newSchool) {
        this.newSchool = newSchool;
    }

    public SchoolLevel getNewSchoolLevel() {
        return newSchoolLevel;
    }

    public void setNewSchoolLevel(SchoolLevel newSchoolLevel) {
        this.newSchoolLevel = newSchoolLevel;
    }

    public SpaceBusiness getSpaceBusiness() {
        return spaceBusiness;
    }

    public void setSpaceBusiness(SpaceBusiness spaceBusiness) {
        this.spaceBusiness = spaceBusiness;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public List<SchoolLevel> getSchoolLevels() {
        return schoolLevels;
    }

    public void setSchoolLevels(List<SchoolLevel> schoolLevels) {
        this.schoolLevels = schoolLevels;
    }

    public void fillSchools () {
        schools = Arrays.stream(School.values()).collect(Collectors.toList());
    }

    public void fillSchoolLevels () {
        schoolLevels = Arrays.stream(SchoolLevel.values()).collect(Collectors.toList());
    }

    public User getConnectedUser() {
        return connectedUser;
    }

    public void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }
}
