package com.weddingasia.ToDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.weddingasia.ToDo.db.DbConnection;

public class todoService {

	 

	public void addtask(todoBean bean) {
		Connection con = DbConnection.getConnection();
		String sql = "insert into todo(taskName, isDone, createdAt, doneAt) values(?,?,?,?)";
		
			PreparedStatement pst = null;	
			
			
			LocalDate date = LocalDate.now();
			String sdate = String.valueOf(date);
			
		try {
			
			pst = con.prepareStatement(sql);
			
			//taskId is set to auto_increment
			//pst.setInt(1, bean.getTaskId());
			
			pst.setString(1, bean.getTaskName());
			pst.setString(2, bean.isDone());
			
			pst.setString(3, sdate);
			if(bean.isDone().equalsIgnoreCase("yes")){
			pst.setString(4, sdate);
			}
			else{
				pst.setString(4, "not yet");
			}
			pst.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<todoBean> getAllTask(){
		Connection con = DbConnection.getConnection();
		List<todoBean> list = new ArrayList<>();
		todoBean bean = null;
		String sql = "select * from todo";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				bean = new todoBean();
				bean.setTaskId(rs.getInt(1));
				bean.setTaskName(rs.getString(2));
				bean.setDone(rs.getString(3));
				bean.setCreatedAt(rs.getString(4));
				bean.setDoneAt(rs.getString(5));
				list.add(bean);
				
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return list;
	}

	public void editTask(todoBean bean) {
		Connection con = DbConnection.getConnection();
		
		
		
		String sql = "update todo set taskName=?, isDone=?,"
				+ " createdAt=?, doneAt=? where taskId=?";
		LocalDate date = LocalDate.now();
		String sdate = String.valueOf(date);
		try {
			if(bean.isDone().equalsIgnoreCase("yes")){
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, bean.getTaskName());
			pst.setString(2, bean.isDone());
			pst.setString(3, bean.getCreatedAt());
			pst.setString(4, sdate);
			pst.setInt(5, bean.getTaskId());
			pst.executeUpdate();
			}
			else{
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, bean.getTaskName());
				pst.setString(2, bean.isDone());
				pst.setString(3, bean.getCreatedAt());
				pst.setString(4, bean.getDoneAt());
				pst.setInt(5, bean.getTaskId());
				pst.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
