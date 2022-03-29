package edu.msu.shipsmart.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import edu.msu.shipsmart.domain.SignedUser;

@Repository
public interface SignedUserRepo extends CrudRepository<SignedUser,Long>{
	
	 SignedUser findSignedUserByEmail(String email); 

}

