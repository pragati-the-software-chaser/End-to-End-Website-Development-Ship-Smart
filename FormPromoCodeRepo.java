package edu.msu.shipsmart.repo;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import edu.msu.shipsmart.domain.CustomerSignUp;
import edu.msu.shipsmart.domain.FormPromoCode;

@Repository
public interface FormPromoCodeRepo extends CrudRepository<FormPromoCode,String>{

}
