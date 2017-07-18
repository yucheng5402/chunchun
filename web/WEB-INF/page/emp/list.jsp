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
<div>
    <form>
       员工姓名:<input type="text" name="ename" value="${ename}">
       开始日期：<input type="date" name="startTime" value="<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd"/>">
        结束日期：<input type="date" name="endTime" value="<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>">
        <input type="submit" value="查询">
        <input type="button" id="reset" value="重置">
        <a href="emp/add.action">新增页面</a>
    </form>
</div>
<table border="1">
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
    <c:forEach items="${pager.list}" var="emp" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${emp.empno}</td>
        <td>${emp.ename}</td>
        <td>${emp.job}</td>
        <td>${emp.mgr}</td>
        <td>${emp.sal}</td>
        <td>${emp.hiredate}</td>
        <td>${emp.dept.dname}</td>
        <td><a href="emp/edit.action?empno=${emp.empno}">修改</a>||<a href="javascript:void(0)" onclick="del(${emp.empno})" >删除</a></td>
    </tr>
    </c:forEach>
    </tbody>


    <tfoot>
        <tr>
            <td colspan="9">
                <a href="emp/list.action?pager.pageNumber=1&ename=${ename}&startTime=<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd"/>&endTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>">首页</a>
                <a href="emp/list.action?pager.pageNumber=${pager.pageNumber-1}&ename=${ename}&startTime=<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd"/>&endTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>">上一页</a>
                <a href="emp/list.action?pager.pageNumber=${pager.pageNumber+1}&ename=${ename}&startTime=<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd"/>&endTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>">下一页</a>
                <a href="emp/list.action?pager.pageNumber=${pager.totalPage}&ename=${ename}&startTime=<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd"/>&endTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>">尾页</a>
                总共${pager.pageNumber}/${pager.totalPage}页,一共${pager.totalRows}条
            </td>
        </tr>
    </tfoot>

</table>
</body>
<script src="js/jquery.min.js"></script>
<script>
    $("#reset").bind("click", function () {
        $("input[name='ename']").val('');
        $("input[name='startTime']").val('');
        $("input[name='endTime']").val('');
    })

    var  del = function (id) {
        var  state = confirm("是否删除?");
        if(state){
            $.post("emp/del.action",{"empno":id},function (result) {
                if (result.flag) {
                    alert("result.msg");
                    window.location.reload();//重载页面
                }
            },"json")
        }
    }




 /*   $("#add").bind("click",function () {
        $.get("emp/add.action",{},function (result) {

        },"json")
    })
*/
</script>
</html>