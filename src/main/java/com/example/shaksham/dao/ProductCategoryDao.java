package com.example.shaksham.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.shaksham.model.Category;

//import com.example.EcomHandcrafting.model.Category;

@Repository
public class ProductCategoryDao {
	
	@Autowired
	JdbcTemplate template;
	
	public List<Category> getAll() {
		List<Category> shg = new ArrayList<Category>();
		String sql = "select * from category ;";
		shg = template.query(sql,BeanPropertyRowMapper.newInstance(Category.class));
		return shg;
}
	 /*Adding an item into database table*/
    public int addCategory(int catId,String catName,String catType){
        String query = "insert into category(catId,catName,catType) values (?,?,?)";
        return template.update(query,catId,catName,catType);
	
}
    public int deleteCategory(int catId)
	{
	    Category p = new Category(); 
        p.setCatId(catId);
		String sql = "delete from category where catId = ?;";
		return template.update(sql, new Object[] {p.getCatId()});
	      
	      
	}
   // public int update(cId cid){    
     //   String sql="update Emp99 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";    
      //  return template.update(sql);    
       
    public int updateCheck(int catId)
    {
    	String sql="select catId where catId= ? ";
    	return template.update(sql,catId);
    	
    }
public int update(int catId, String catName, String catType){
	
    String SQL = "update category set catName = ?, set catType = ?, where catId = ?";
   return template.update(SQL, new Object[] {catId, catName, catType});
    
}
}