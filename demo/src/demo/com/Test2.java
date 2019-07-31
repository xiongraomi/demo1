package demo.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet(description = "Test2", urlPatterns = { "/Test2.do" })
public class Test2  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
	 //count��¼��ַ���������start�������ֵ���ʼֵ��end�ǽ���ֵ  
	    int count = 0,sum=0,start,end;
	    //��¼���ؽ��
	   List<String> result=new ArrayList<String>();
        for(int i=1;i<=num/2;i++){  
            start=i;  
            sum=0;  
            end=0;  
            for(int j=start;j<=num;j++){  
                if((sum+j)<num){  
                    sum+=j;        
                }  
                else if(sum+j==num){   //ȡ������Ҫ���������  
                    end=j;  
                    result.add(start+"-"+end);
                    count++;  
                      
                }  
                else{  
                    break;  
                }  
            }  
              
        } 
        Gson gson = new Gson();
		String json = gson.toJson(result);
    	//4.���ؽ��
		resp.setContentType("text/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
	    PrintWriter out = resp.getWriter();
	    out.println(json);
	    out.flush();
	    out.close();
    }  
		
}
