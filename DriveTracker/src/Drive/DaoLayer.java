package Drive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DaoLayer {
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drive_tracker","root","root");
		return con;
	}
	
public static Map<String,String> saveData(CderivePojo p) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnection();
		
		PreparedStatement ps= con.prepareStatement("insert into createdrive(company,resource,exp,ctc,position,criteria,ecriteria,followp,bond) values(?,?,?,?,?,?,?,?,?)");
		
		String company = p.getCompanyname();
		int resource = p.getResource();
		int exp= p.getExp();
		int ctc=p.getCtc();
		int criteria= p.getJoining();
		int bond= p.getBond();
		int position= p.getPosition();
		int ecriteria = p.getEducation();
		Date followp = p.getFollowup();
		System.out.println(followp);
		
		ps.setObject(1, company);
		ps.setObject(2, resource);
		ps.setObject(3, exp);
		ps.setObject(4, ctc);
		ps.setObject(5, position);
		ps.setObject(6, criteria);
		ps.setObject(7, ecriteria);
		ps.setObject(8, followp);
		ps.setObject(9, bond);
		
		int status=ps.executeUpdate();
		
		Map<String,String> map = new HashMap<>();
		
		if(status == 1)
		{
			map.put("msg", "done");
		}
		else
		{
			map.put("msg", "Error");
		}
		return map;
		
}

public static ArrayList<CderivePojo> getData() throws ClassNotFoundException, SQLException{
	
	Connection con=getConnection();
	
	PreparedStatement ps = con.prepareStatement("select * from createdrive;");
	
	ResultSet rs = ps.executeQuery();
	
	ArrayList<CderivePojo> list = new ArrayList<>();
	
	while(rs.next())
	{
		CderivePojo cp= new CderivePojo();
		
		cp.setId(rs.getInt(1));
		cp.setCompanyname(rs.getString(2));
		cp.setResource(rs.getInt(3));
		cp.setExp(rs.getInt(4));
		cp.setCtc(rs.getInt(5));
		cp.setPosition(rs.getInt(6));
		cp.setJoining(rs.getInt(7));
		cp.setEducation(rs.getInt(8));
		cp.setFollowup(rs.getDate(9));
		cp.setBond(rs.getInt(10));
		
		list.add(cp);
	}
	
	return list;
}

}
