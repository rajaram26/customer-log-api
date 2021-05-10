package customer.log.repositary;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import customer.log.model.CustomerLog;

public interface CustomerRepo extends CrudRepository<CustomerLog,String>{

	@Query(value="SELECT * FROM customerlog WHERE date=?1",nativeQuery=true)
	ArrayList<CustomerLog> findByDate(String date);

 
}
