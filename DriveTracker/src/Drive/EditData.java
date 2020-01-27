package Drive;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditData
 */
@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   /* public EditData() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("in edit");
		BufferedReader br=request.getReader();
		String s =br.readLine();
		System.out.println("Angular data="+s);
		
		CderivePojo c = (CderivePojo) ObjectMep.getObject(s, CderivePojo.class);
		try {
			saveData1(c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Map<String, String> saveData1(CderivePojo c) throws ClassNotFoundException, SQLException {
		System.out.println("in edit query method");

		Connection con = DaoLayer.getConnection();
		
		PreparedStatement ps = con.prepareStatement("update createdrive set company=?,resource=?, exp=?,ctc=?,position=?, criteria=?,ecriteria=?, followp=?,bond=? where id=?;");
		
		int id= c.getId();
		String company = c.getCompanyname();
		int resource = c.getResource();
		int exp= c.getExp();
		int ctc=c.getCtc();
		int criteria= c.getJoining();
		int bond= c.getBond();
		int position= c.getPosition();
		int ecriteria = c.getEducation();
		Date followp = c.getFollowup();

        System.out.println("set values");  		
				
        ps.setObject(1, company);
		ps.setObject(2, resource);
		ps.setObject(3, exp);
		ps.setObject(4, ctc);
		ps.setObject(5, position);
		ps.setObject(6, criteria);
		ps.setObject(7, ecriteria);
		ps.setObject(8, followp);
		ps.setObject(9, bond);
		ps.setObject(10, id);
		
		
		
		/*System.out.println("cname="+cname);
		System.out.println("exp="+exp);
		System.out.println("ctc="+ctc);
		System.out.println("jc="+jc);
		System.out.println("bond="+bond);
		System.out.println("position="+position);
		System.out.println("ec="+ec);
		System.out.println("followup="+followup);
		System.out.println("cid="+cid);*/
		
		
		
		System.out.println("before"); 
		int status=1;
		try
		{
			
		
		status = ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		System.out.println("Status="+status);
		
		Map<String, String> map = new HashMap<>();

		if (status == 1) 
		{
			map.put("msg", "done");
		}
		else
		{
			map.put("msg", "Sorry.Eroor occur.");
		}
		return map;
}

}
