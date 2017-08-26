package com.sios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sios.dao.AddressDao;
import com.sios.helper.ModelVoHelper;
import com.sios.model.Address;
import com.sios.vo.AddressVo;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Override
	public boolean isAddressAdded(AddressVo addressVo) throws Exception {

		Address address = new Address();
		address.setPincode(addressVo.getPincode());
		address.setStreetName(addressVo.getStreetName());
		address.setCityName(addressVo.getCityName());
		address.setStateName(addressVo.getStateName());
		address.setCountryName(addressVo.getCountryName());
		return addressDao.isAddressAdded(address);
	}

	@Override
	public List<AddressVo> getAllAddresses() throws Exception {
		List<Address> addressList = addressDao.getAllAddresses();
		List<AddressVo> addressVoList = null;
		if (addressList != null && addressList.size() > 0) {
			addressVoList = new ArrayList<AddressVo>(addressList.size());
			for (Address address : addressList) {
				AddressVo addressVo = ModelVoHelper.addressModelToVo(address);
				addressVoList.add(addressVo);
			}
		}
		return addressVoList;
	}

	@Override
	public AddressVo getAddressByPincode(int pincode) throws Exception {

		Address address = addressDao.getAddressByPinCode(pincode);
		AddressVo addressVo = null;
		if (null != address) {
			addressVo = ModelVoHelper.addressModelToVo(address);
		}
		return addressVo;
	}

}
