package demo.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet(description = "Test1", urlPatterns = { "/Test1.do" })
public class Test1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取第一个字符串的值
		String str1=req.getParameter("str1");
		//获取第二个字符串的值
		String str2=req.getParameter("str2");
		
		//定义一个数组存放有相同的单词
		List<String> sameArr=new ArrayList<String>();
		
		
		//定义返回结果
		String result="";
		//1.将两个字符串通过空格分隔成数组
		String[] str1Arr=str1.split(" ");
		String[] str2Arr=str2.split(" ");
		
		//2.循环判断两个字符串是否存在单词相等
		for (String string1 : str1Arr) {
			for (String string2 : str2Arr) {
				if(string1.equals(string2)){
					sameArr.add(string1);
				}
			}
		}
		
		//3.判断数组长度是否大于0,如果大于0，返回第一个，否则返回null
		if(sameArr.size()>0){
			result=sameArr.get(0);
		}
		Gson gson = new Gson();
		String json = gson.toJson(result);
		//4.返回结果
		resp.setContentType("text/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
	    PrintWriter out = resp.getWriter();
	    out.println(json);
	    out.flush();
	    out.close();
	}

}
