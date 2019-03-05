<%--
  Created by IntelliJ IDEA.
  User: chezhenqi
  Date: 2019/3/2
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    String importMsg = "";
    if (request.getSession().getAttribute("msg") != null) {
        importMsg = request.getSession().getAttribute("msg").toString();
    }
    request.getSession().setAttribute("msg", "");
%>
<head>
    <title>批量导入客户</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<div><font color="bule">批量导入客户</font></div>
<form action="customer/batchimport" method="post" enctype="multipart/form-data" onsubmit="return check();">
    <div style="margin: 30px;"><input id="excel_file" type="file" name="filename" accept="xlsx" size="80"/>
        <input id="excel_button" type="submit" value="导入Excel"/></div>
    <font id="importMsg" color="red"><%=importMsg%>
    </font><input type="hidden"/>
</form>
<div>
    <a target="_blank" href="views/table.jsp">跳转页面到表格页面</a>
</div>
</body>
<script type="text/javascript">
    function check() {
        var excel_file = $("#excel_file").val();
        if (excel_file == "" || excel_file.length == 0) {
            alert("请选择文件路径！");
            return false;
        } else {
            return true;
        }
    }

    $(document).ready(function () {
        var msg = "";
        if ($("#importMsg").text() != null) {
            msg = $("#importMsg").text();
        }
        if (msg != "") {
            alert(msg);
        }
    });
</script>
</html>
