package edu.sjsu.directexchange.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sjsu.directexchange.model.Bank;

@Repository
public class BankDaoImpl implements BankDao {
	

	private EntityManager entityManager;
	
	
	@Autowired
	public BankDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Bank> getUserBank(int user_id,String country,String currency, int bank_type) {
		return  entityManager.createQuery("from Bank where user_id=:user_id and country=:country and primary_currency=:currency and bank_type=:bank_type")
				.setParameter("user_id", user_id).setParameter("country", country).setParameter("currency", currency).setParameter("bank_type", bank_type).getResultList();
	
	}

	@Override
	public void addBank(Bank bank) {
		entityManager.merge(bank);
	}

}
