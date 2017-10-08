<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String basePath = request.getScheme() + "://" + request.getServerName() +":"+ request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script language="javascript" type="text/javascript" src="<%=basePath %>js/datePicker/WdatePicker.js"></script>

<form id="insForm" action="car/updateInsuranceInfo" style="border:none;" method="post" > <!-- onsubmit="return checkIns();" -->
    <input name="carNo" type="hidden" value="${car.carNo}"/>
    <table>
        <tr>
            <td>交强险投保公司：<input id="insCorp" name="insCorp" type="text" value="${car.insCorp}"></td>
            <td>交强险保单号：<input id="insNo" name="insNo" type="text" value="${car.insNo}"></td>
            <td>交强险被保险人：<input id="insInsured" name="insInsured" type="text" value="${car.insInsured}"></td>
            <td>交强险到期日期：<input id="insExpire" name="insExpire" type="text" value="${car.insExpire}" class="Wdate" onClick="WdatePicker({skin:'whyGreen'})"></td>
            <td align="center"><input type="button" value="更新交强险信息" onclick="checkIns();"/></td>
        </tr>
    </table>
</form>
</body>
</html>

