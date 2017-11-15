package com.cg.assessment.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jboss.logging.Logger;

import com.cg.assessment.bean.AssessmentDetails;
import com.cg.assessment.dbutil.DBUtil;
import com.cg.assessment.exception.AssessmentException;


/*
*********************************************************************
 * File                	 	: AssessmentDaoImpl.java
 * Author Name          	: Keshav Mishra
 * Desc                	 	: Database implementation layer
 * Version            	 	: 1.0
 * Last Modified Date   	: 11-Oct-2017
 * Change Description   	: To store and retrieve database
*********************************************************************
*/
public class AssessmentDaoImpl implements IAssessmentDao{
int id=0;
int res=0;
	Connection con=null;
	Logger logger=Logger.getLogger(com.cg.assessment.dao.AssessmentDaoImpl.class);
	
	
/*
*********************************************************************
* Module Name         	: getID()
* Input Parameters     	: void
* Return Type         	: ArrayList<Integer>
* Author              	: Keshav Mishra
* Creation Date      	: 11-Oct-2017
* Description        	: To fetch the trainee ids from database
 *********************************************************************
*/	
	public ArrayList<Integer> getID() throws AssessmentException {
		ArrayList<Integer> li=new ArrayList<Integer>();
		try {
			con=DBUtil.getConnection();
			String sql="select trainee_id from trainees";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				id=rs.getInt(1);
				li.add(id);
				
			}
			logger.info("ID fetched successfully!");
			System.out.println(li);
			
		} catch (IOException e) {
			logger.error("IOException raised! "+e.getMessage());
			throw new AssessmentException(e.getMessage());
			
		} catch (SQLException e) {
			logger.error("SQLException raised! "+e.getMessage());
			throw new AssessmentException(e.getMessage());
		}
		
		
		
		return li;
	}

	
	/*
	*********************************************************************
	* Module Name         	: addDetails()
	* Input Parameters     	: bean2
	* Return Type         	: int
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To add details to the database
	 *********************************************************************
	*/	
	
	public int addDetails(AssessmentDetails bean2) throws AssessmentException  {
	
		try {
			con=DBUtil.getConnection();
			String sql="insert into assessmentscore values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, bean2.getTraineeId());
			ps.setString(2, bean2.getModuleName());
			ps.setInt(3, bean2.getMpt());
			ps.setInt(4, bean2.getMtt());
			ps.setInt(5, bean2.getAssignment());
			ps.setInt(5, bean2.getAssignment());
			ps.setInt(6, bean2.getTotalMarks());
			ps.setInt(7, bean2.getGrade());
			res=ps.executeUpdate();
			
			logger.info(res+" Row inserted successfully!");
			
		} catch (IOException e) {
			logger.error("IOException raised! "+e.getMessage());
			throw new AssessmentException(e.getMessage());
		} catch (SQLException e) {
			logger.error("SQLException raised! "+e.getMessage());
			throw new AssessmentException(e.getMessage());
		}
		
		
		return res;
	}

}
