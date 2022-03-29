package edu.msu.shipsmart.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.msu.shipsmart.domain.SignedUser;
import edu.msu.shipsmart.domain.TrackingOrder;


@Repository
public interface TrackingOrderRepo extends CrudRepository<TrackingOrder,Long>{
	
	List<TrackingOrder> findTrackingOrderByTracking(String tracking); 
	List<TrackingOrder> findTrackingOrderByOrderId(long orderId); 

}
