package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Car;

@Repository
@Transactional
public class CarDAO {
	
	@Autowired
    private EntityManager entityManager;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    NamedParameterJdbcTemplate template;
    
    public CarDAO(NamedParameterJdbcTemplate template) {  
        this.template = template;
        }
    
    @SuppressWarnings("unchecked")
	public List<Car> findCars() {
	    try {
	        String sql = "Select e from " + Car.class.getName() + " e ";

	        Query query = entityManager.createQuery(sql, Car.class);

	        return query.getResultList();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
    
    @SuppressWarnings("unchecked")
	public List<Car> findCarsfilter(Long max,Long min) {
	    try {
	        String sql = "Select e from " + Car.class.getName() + " e where e.price between :min and :max";

	        Query query = entityManager.createQuery(sql, Car.class);
	        query.setParameter("max", max);
	        query.setParameter("min",min);

	        return query.getResultList();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
    
    public String addCar(Car data) {
		data.setUid(UUID.randomUUID().toString());
		final String sql = "insert into cars (company,dop,price,seats,regno,model,color,engine"
				+ ",uid) VALUES (:company,:dop,:price,:seats,:regno,:model,:color,:engine"
				+ ",:uid)";
		
		Map<String,Object> map=new HashMap<>();  
 		map.put("company", data.getCompany());
 		map.put("dop", data.getDop());
 		map.put("price", data.getPrice());
 		map.put("seats", data.getSeats());
 		map.put("regno", data.getRegno());
 		map.put("model", data.getModel());
 		map.put("color", data.getColor());
 		map.put("engine", data.getEngine());
 		map.put("uid", data.getUid());
		
		template.execute(sql,map,new PreparedStatementCallback<Object>() {  
		    @Override  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException {  
		        return ps.executeUpdate();  
		    }  
		});	
		
		return data.getUid();

	}
    
    public String update(Car data) {
		final String sql = "update cars set company = :company, dop=:dop,price=:price,seats=:seats,regno=:regno,"
				+ "model=:model,color=:color,engine=:engine where uid = :uid";
		
		Map<String,Object> map=new HashMap<>();  
 		map.put("company", data.getCompany());
 		map.put("dop", data.getDop());
 		map.put("price", data.getPrice());
 		map.put("seats", data.getSeats());
 		map.put("regno", data.getRegno());
 		map.put("model", data.getModel());
 		map.put("color", data.getColor());
 		map.put("engine", data.getEngine());
 		map.put("uid", data.getUid());
		
		template.execute(sql,map,new PreparedStatementCallback<Object>() {  
		    @Override  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException {  
		        return ps.executeUpdate();  
		    }  
		});	
		
		return data.getUid();

	}
    
	public String deletecar(String uid) {
	    	
	
	 		final String sql1 ="delete from cars WHERE uid= :uid";
	 		Map<String,Object> map=new HashMap<>();  
	 		map.put("uid", uid);
	
	 		
	 		template.execute(sql1,map,new PreparedStatementCallback<Object>() {  
	 		    @Override  
	 		    public Object doInPreparedStatement(PreparedStatement ps)  
	 		            throws SQLException {  
	 		        return ps.executeUpdate();  
	 		    }  
	 		});
	 		return "success";
	    }

}
