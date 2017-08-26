package com.sios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sios.model.Address;

@Component
public class AddressDaoImpl implements AddressDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean isAddressAdded(Address address) throws Exception {
		boolean flg = false;
		Session session = null;
		try
		{
			 session= sessionFactory.openSession();
			Transaction transaction= session.beginTransaction();
			session.save(address);
			transaction.commit();
			flg = true;
			 
		}catch(Exception e)
		{
			flg = false;
		}
		
		finally{
			if(session!=null)
			{
				session.close();
			}
		}
		return flg;
	}

	@Override
	public List<Address> getAllAddresses() throws Exception {
		Session session = null;
		List<Address> addresses =null;
		
		try
		{
			session=sessionFactory.openSession();
			Query query=session.createQuery("from Address");
			addresses=query.list();
		}
		finally
		{
			if(null!=session)
			{
				session.close();
			}
		}
		return addresses;
	}

	@Override
	public Address getAddressByPinCode(int pincode) throws Exception {
		Session session= null;
		Address address = null;
		
		try{
			session =sessionFactory.openSession();
			Query query=session.createQuery("from Address address where address.pincode =:pincode");
					query.setParameter("pincode", pincode);
					List<?> list=query.list();
					if(list!=null && list.size()>0)
					{
						address =(Address)list.get(0);
					}
		}
		finally
		{
			if(null!=session)
			{
				session.close();
			}
		}
		return address;
	}
	

}
