package com.sios.services;

import java.util.List;

import com.sios.vo.AddressVo;

public interface AddressService {

	boolean isAddressAdded(AddressVo addressVo) throws Exception;

	List<AddressVo> getAllAddresses() throws Exception;

	AddressVo getAddressByPincode(int pincode) throws Exception;

}
