<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <!-- �ѱ� ó�� ������ ������  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
h1{background-color:pink}
</style>
<script>
//alert("����");
</script>


</head>
<body>
<h1> Jsp �����ϱ� </h1>


<%
//�ڹ��ڵ� ���� �� �ڹٹ����� 100% ����Ѵ�  
String name = "����"; //��������(������� �ݵ�� �ʱ�ȭ �ʿ��� )
int age = 12; //��������

System.out.println("�� ��� ��µǴ�?"); //�ֿܼ� ��µǴ� �� 

%>

<h3>

�̸� : <%= name %> <br>
���� : <%= age %>�� �Դϴ�.<p>

�޼ҵ� ȣ�� : <%=this.test("�������") %><br>

<%
	if(age>18){
		out.println(age+"���� �����Դϴ�. "); //�������� ����ϴ� �޼ҵ� 
	}else{
		out.println(age+"���� �̼������Դϴ�. ");  //������ ����ϴ� �޼ҵ� 
	}
%>

<%! 
 //�޼ҵ� ���� �Ǵ� �������� �����ϴ� ����
 public String test(String message){
	System.out.println("test() �޼ҵ� ȣ��Ǿ����ϴ�."); //�ܼ� ���
	return "�޼����� " + message ; 

	
}
 
%>


</h3>


</body>
</html>