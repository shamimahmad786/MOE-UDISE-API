package com.moe.udise.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Component;



@Component
public class NativeRepository {
	@Autowired 
	QueryResult queryResult;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	  public QueryResult executeQueries(String queryData){        
	     System.out.println("queryData--->"+queryData);
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
	        List<Object> columnList=new ArrayList<Object>();
	        List<Object> columnDataType=new ArrayList<Object>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(queryData);
	        SqlRowSet rs = jdbcTemplate.queryForRowSet(queryData);
	        SqlRowSetMetaData rsmd = rs.getMetaData();
	        int columnNo = rsmd.getColumnCount();
	        for ( int i = 1; i <= columnNo; i++ )
	        {
	         columnList.add(rsmd.getColumnLabel(i));
	         columnDataType.add(rsmd.getColumnTypeName(i));
	        }
	        queryResult.setColumnName(columnList);
	        queryResult.setRowValue(rows);
	        queryResult.setColumnDataType(columnDataType);
			return queryResult;
	    }
}
