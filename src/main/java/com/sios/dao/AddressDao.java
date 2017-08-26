package com.sios.dao;

import java.util.List;

import com.sios.model.Address;

public interface AddressDao {

	boolean isAddressAdded(Address address)throws Exception;
	List<Address> getAllAddresses()throws Exception;
	Address getAddressByPinCode(int pincode)throws Exception;
	

}
