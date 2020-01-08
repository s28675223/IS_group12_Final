

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		
		
		//�W����O�s�W��
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		
		String keyword = request.getParameter("keyword");
		
		HashMap<String, String> query = google.query();
		
		String[][] s = new String[query.size()][2];
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		}
		//�U���O�s�W��
		
		 
		
		 int[] counts = new int[s.length];
		  for(int i = 0 ; i < s.length; i++) {
		   String[] a = s[i];
		   System.out.println(s[i][0]);
		   WordCounter counter = new WordCounter(a[1]);
		   int count = counter.countKeyword(keyword);
		   System.out.println(counter.getContent());
		   count += counter.countKeyword("�ګ�") * -50;
		   count += counter.countKeyword("Mobile01") * -5;
		   count += counter.countKeyword("����") * -100;
		   count += counter.countKeyword("Pchome")*-2 ;
		   count += counter.countKeyword("�}�c")*-2 ;
		   count += counter.countKeyword("�߱o")*-5 ;
		   counts[i] = count;
		  }
		  
		
		 int min = -1;
		  for(int i=0; i<counts.length; i++) {
		   for(int j = i; j < counts.length; j++) {
		    if(min == -1)
		     min = j;
		    else if(counts[j] < counts[min])
		     min = j;
		   }
		   int temp = counts[i];
		   counts[i] = counts[min];
		   counts[min] = temp;
		   String[] tp = s[i];
		   s[i] = s[min];
		   s[min] = tp;
		   min = -1;
		  }
		/*for(int i = 0 ; i < counts.length; i++) {
			System.out.println(s[i][0]);
			System.out.println(counts[i]);
		}
		*/
		//�W���O��ͭ�print�X��
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
