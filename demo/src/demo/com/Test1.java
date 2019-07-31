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
		//��ȡ��һ���ַ�����ֵ
		String str1=req.getParameter("str1");
		//��ȡ�ڶ����ַ�����ֵ
		String str2=req.getParameter("str2");
		
		//����һ������������ͬ�ĵ���
		List<String> sameArr=new ArrayList<String>();
		
		
		//���巵�ؽ��
		String result="";
		//1.�������ַ���ͨ���ո�ָ�������
		String[] str1Arr=str1.split(" ");
		String[] str2Arr=str2.split(" ");
		
		//2.ѭ���ж������ַ����Ƿ���ڵ������
		for (String string1 : str1Arr) {
			for (String string2 : str2Arr) {
				if(string1.equals(string2)){
					sameArr.add(string1);
				}
			}
		}
		
		//3.�ж����鳤���Ƿ����0,�������0�����ص�һ�������򷵻�null
		if(sameArr.size()>0){
			result=sameArr.get(0);
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
