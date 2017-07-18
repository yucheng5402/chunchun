<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<form action="<c:if test="${empty emp}">emp/save.action</c:if><c:if test="${not empty emp}">emp/update.action</c:if>" method="post">
        <%--<div>--%>
            <%--<label>员工编号</label>--%>
            <%--<input type="text" name="emp.empno" value="${emp.empno}">--%>
        <%--</div>--%>
        <div>
        <label>员工姓名</label>
        <input type="text" name="emp.ename" value="${emp.ename}">
    </div>
    <div>
        <label>职位</label>
        <input type="text" name="emp.job" value="${emp.job}">
    </div>
    <div>
        <label>领导</label>
        <select name="emp.mgr">
            <option value="">请选择</option>
            <c:forEach items="${list}" var="e" varStatus="status">
                <option value="${e.empno}" <c:if test="${e.empno eq emp.mgr}">selected</c:if>>${e.ename}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>入职日期</label>
        <input type="date" name="emp.hiredate" value="<fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd"/>">
    </div>
    <div>
        <label>薪资</label>
        <input type="text" name="emp.sal" value="${emp.sal}">
    </div>

    <div>
        <label>部门</label>
        <select name="emp.dept.deptno" id="dept">
            <option value="">请选择</option>
        </select>
    </div>
    <input type="submit" value="保存">

    <script src="js/jquery.min.js"></script>
    <script>
        $.get("dept/listAjax.action",{},function(result){
            $.each(result,function (index,data) {
                $("#dept").append("<option value='"+data.deptno+"'>" + data.dname +"</option>");
            })
//            $("#dept").val($(emp.dept.deptno));
            $("#dept").find("option[value='${emp.dept.deptno}']").attr("selected",true);
        },"json")
    </script>
</form>
</body>
</html>