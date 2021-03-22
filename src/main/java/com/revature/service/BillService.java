package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Bill;
import com.revature.repository.BillRepository;

@Service(value="billService")
public class BillService {

	private BillRepository billRepository;
	
	@Autowired
	public void setBillRepository(BillRepository billRepository) {
		this.billRepository = billRepository;
	}
	public List<Bill> getAllBills(){
		return this.billRepository.findAll();
	}
//	public List<Bill> getAllByPatient(int userId){
//		return this.billRepository.findAllByUser(userId);
//	}
	public void createNewBill(Bill bill) {
		this.billRepository.save(bill);
	}
}