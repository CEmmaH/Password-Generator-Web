package generator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/s01")
public class JavaServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Map<CRITERIA,Boolean> map = new HashMap<CRITERIA, Boolean>();
		map.put(CRITERIA.LOWERCASE, req.getParameter("lowercase")!=null);
		map.put(CRITERIA.UPPERCASE, req.getParameter("uppercase")!=null);
		map.put(CRITERIA.NUMBER, req.getParameter("number")!=null);
		map.put(CRITERIA.SYMBOL, req.getParameter("symbol")!=null);

		String length = req.getParameter("length");
		
//		System.out.println("length = "+ length);
//		if(map!=null) {
//			for(Map.Entry<CRITERIA, Boolean> entry: map.entrySet()) {
//				System.out.println("name = "+entry.getKey());
//				System.out.println("value = "+entry.getValue());
//			}
//		}
		Generator gtor = new Generator(Integer.parseInt(length),map);
		String password = gtor.generatePassword();
		
		req.setAttribute("password", password);
		req.getRequestDispatcher("index.jsp").forward(req, resp);


		
	}
}
