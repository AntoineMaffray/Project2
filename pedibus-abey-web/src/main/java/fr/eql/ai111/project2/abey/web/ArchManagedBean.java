package fr.eql.ai111.project2.abey.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "mbArch")
@RequestScoped
public class ArchManagedBean {

    public String navLinkStyle(String linkPageName) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String[] uriParts = request.getRequestURI().split("/");
        String currentPageName = uriParts[uriParts.length - 1];
        if (linkPageName.equals("index.xhtml") && currentPageName.equals("pedibus-abey-web")) {
            currentPageName = "index.xhtml";
        }
        return linkPageName.equals(currentPageName) ? "active-navlink" : "";
    }
}
