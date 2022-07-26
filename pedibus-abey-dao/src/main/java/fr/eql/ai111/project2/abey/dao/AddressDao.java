package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.Address;
import fr.eql.ai111.project2.abey.entity.Street;

import java.util.List;

public interface AddressDao {

    List<Address> findByStreet (Street street);

}
