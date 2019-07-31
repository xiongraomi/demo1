<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
   pageContext.setAttribute("basePath",basePath);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test1</title>
<script type="text/javascript"  src="../jquery/jquery-1.7.2.js"></script>
</head>
<body>
<div style="height: 400px;width: 400px">
<p>1.编程实现功能:功能是求出字符 s 与字符串t的第二公共单词(这里，假设两个字符串均由英字母和空格字符组成);若找到这样的公共单词，函数返回该单词，否则，函数返回NULL，如果有多个满足要求，则返回第一个单词。<br>&nbsp;&nbsp;例如:若 s=“This is C programming text”，t=“This is a text for Cprogramming”，则函数返回“this”。</p>
请输入第一个字符串：<input type="text" name="str1" id="str1"><br>
请输入第二个字符串：<input type="text" name="str2" id="str2">
<input type="button" name="button" value="提交" onclick="submit1()">  
<p style="display: none" id="text">第一个相同的单词是：</p><p id="sameWord" style="display: none"></p>
<p>2.某些整数能分解成若干个连续整数的和的形式，例如:<br>15 = 1 + 2+3+4+5<br>15 = 4 + 5 + 6<br>15 = 7 + 8<br>某些整数不能分解为连续整数的和，<br> &nbsp;&nbsp;例如:16 输入: 一个整数N(N <= 10000)输出:整数N对应的所有分解组合，按照每个分解中的最小整数从小到大输出，每个分解占一行 ，每个数字之间有一个空格(每行最后保留一个空格);如果没有任何分解组合，则输出NONE</p>
请输入一个正整数：<input type="text" id="num">
<input type="button" id="submit2" value="提交" onclick="submit2()">
<div id="sumlist" > </div>
</div>
</body>

<!--type="text/javascript" 里面是js语言  -->
<script type="text/javascript">
function submit1(){
	var str1= $("#str1").val();
	var str2= $("#str2").val();
	$.ajax({
      url:"${basePath}/Test1.do",
      data : {"str1":str1,"str2":str2},
      type : "POST",
      dataType:"json", 
     // contentType: "application/json",
      success : function(data) {
    	$("#text").show();
    	$("#sameWord").show();
    	if(data==""){
    		data="null";
    	}
         $("#sameWord").html(data);
        },
       error:function(XMLHttpRequest, textStatus, errorThrown){
       alert(errorThrown);
            }
    });  
}

function submit2(){
	var num= $("#num").val();
	$.ajax({
      url:"${basePath}/Test2.do",
      data : {"num":num},
      type : "POST",
      dataType:"json", 
      //contentType: "application/json",
      success : function(data) {
    	  $("#sumlist").empty();
    	  for(var i in data){
    		  var sum=num+"=";
    		  for(var j=data[i].split("-")[0];j<=data[i].split("-")[1];j++){
    			  sum+=j+" +";
    		  }
    		  sum= sum.substring(0, sum.length-1);
    		  $("#sumlist").append("<p>"+sum+"</p>"); 
    		  }
        },
       error:function(XMLHttpRequest, textStatus, errorThrown){
       alert(errorThrown);
            }
    });  
}

</script>
</html>