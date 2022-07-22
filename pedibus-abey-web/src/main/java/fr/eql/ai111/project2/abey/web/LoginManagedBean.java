package fr.eql.ai111.project2.abey.web;

import fr.eql.ai111.project2.abey.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.time.LocalDate;

@ManagedBean(name = "mbLogin")
@RequestScoped
public class LoginManagedBean implements Serializable {

    private String loginUser;
    private String passwordUser;
    private String nameUser;
    private String firstnameUser;
    private LocalDate birthDateUser;
    private String phoneUser;
    private String mailUser;
    private LocalDate dateCreationAccountUser;
    private User user;


}
