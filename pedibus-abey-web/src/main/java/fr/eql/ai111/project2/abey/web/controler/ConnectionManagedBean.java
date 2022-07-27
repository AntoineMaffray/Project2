package fr.eql.ai111.project2.abey.web.controler;


import fr.eql.ai111.project2.abey.business.ConnectionBusiness;
import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.entity.User;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean(name = "mbConnection")
@SessionScoped
public class ConnectionManagedBean implements Serializable {

    private String login;
    private String password;
    private User connectedUser;


    @EJB
    private ConnectionBusiness connectionBusiness;


    public String connect() {
        String forward;
        connectedUser = connectionBusiness.authenticate(login, password);
        if (connectedUser != null) {
            forward = "/index.xhtml?faces-redirect=true";
        } else {
            FacesMessage facesMessage = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Identifiant et/ou mot de passe incorrect(s)",
                    "Identifiant et/ou mot de passe incorrect(s)"
            );
            FacesContext.getCurrentInstance().addMessage("connectionForm:inpLoginConnection", facesMessage);
            FacesContext.getCurrentInstance().addMessage("connectionForm:inpPasswordConnection", facesMessage);
            forward = "/connection.xhtml?faces-redirect=false";
        }
        return forward;
    }

    public boolean isConnected() {
        return connectedUser != null;
    }

    public void authorise() {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler)
                context.getApplication().getNavigationHandler();
        if (!isConnected()) {
            handler.performNavigation("/connection.xhtml?faces-redirect=true");
        }
    }

    public String disconnect() {
        HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(true);
        session.invalidate();
        login = "";
        password = "";
        connectedUser = null;
        return "/index.xhtml?faces-redirect=true";
    }


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User getConnectedUser() {
        return connectedUser;
    }
    public void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }
}
