package edu.msu.shipsmart.repo;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import edu.msu.shipsmart.domain.CustomerSignUp;

@Repository
public interface CustomerSignUpRepo extends CrudRepository<CustomerSignUp,String>{

}
