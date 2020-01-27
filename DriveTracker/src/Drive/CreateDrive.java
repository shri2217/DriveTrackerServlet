package Drive;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CreateDrive
 */
@WebServlet("/CreateDrive")
public class CreateDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDrive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("in post");
		
		BufferedReader br=request.getReader();
		String s =br.readLine();
		System.out.println("Angular data="+s);
		
		CderivePojo p=(CderivePojo) ObjectMep.getObject(s,CderivePojo.class);
		
		Map<String,String> map = null;
		try
		{
			map=DaoLayer.saveData(p);
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		/*String responsedata = (String) ObjectMep.getJSONFromObject(map);
		
		response.getWriter().write(responsedata);
		
		response.flushBuffer();*/
	

	}

}
