<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>$Title$</title>
  </head>
  <body>
  <table>
      <thead>
      <tr>
        <th>序号</th>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>职位</th>
        <th>领导</th>
        <th>工资</th>
        <th>入职日期</th>
        <th>部门</th>
        <th>操作</th>
      </tr>
      </thead>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>



    </tbody>

  </table>
  </body>
</html>
