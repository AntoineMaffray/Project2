package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.entity.Role;
import fr.eql.ai111.project2.abey.entity.User;

import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParticipationManagedBean implements Serializable {

    @ManagedProperty(value = "#{mbConnection.connectedUser}")
    private User connectedUser;

    private List<Role> roles = new ArrayList<>();

    @NotNull(message = "veuillez choisir un Rôle")
    private String newRole;
}
