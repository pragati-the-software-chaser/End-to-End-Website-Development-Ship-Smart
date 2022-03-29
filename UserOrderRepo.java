package edu.msu.shipsmart.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.msu.shipsmart.domain.SignedUser;
import edu.msu.shipsmart.domain.UserOrder;


@Repository
public interface UserOrderRepo extends CrudRepository<UserOrder,Long>{
	
	List<UserOrder> findUserOrderByUserId(long userId); 
	

}
