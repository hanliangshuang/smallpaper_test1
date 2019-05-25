<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>pxkshchj管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	function formPrint() {
            var newstr=document.getElementById('inputForm').innerHTML;
            var oldstr=document.body.innerHTML;
            document.body.innerHTML=newstr;
            window.print();
            document.body.innerHTML=oldstr;
        }
		
	</script>
</head>

<body>
	<ul class="nav nav-tabs">
		<%-- <li><a href="${ctx}/exam/tblPxkshchj/">返回pxkshchj列表</a></li> --%>
		<li class="active">
			<a href="${ctx}/exam/tblPxkshchj/chjxiangxi?id=${tblPxkshchj.id}">考试
				<shiro:hasPermission name="exam:tblPxkshchj:edit">${not empty tblPxkshchj.id?'详细步骤':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="exam:tblPxkshchj:edit">查看</shiro:lacksPermission>
			</a>
		</li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="tblPxkshchj" action="${ctx}/exam/tblPxkshchj/" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		
	<table border="1", align="center",valign="center">
	  	<tr> 
	 		<td colspan=4; style="width: 1000px;height: 40px;"><strong><center>培训考试成绩</center></strong></td>   
	  	</tr>
	 	<tr>
          <td style="width: 250px;height: 40px;"><strong><center>姓名：</center></strong></td>
          <td style="width: 250px;height: 40px;"><center>${tblPxkshchj.zhgxmxsh}</center></td>
          <td style="width: 250px;height: 40px;"><strong><center>考试时间：</center></strong></td>
          <td style="width: 250px;height: 40px;"><center><fmt:formatDate value="${tblPxkshchj.kshshj}" pattern="yyyy-MM-dd"/></center></td>
      	</tr>
	 	<tr>
          <td style="width: 250px;height: 40px;"><strong><center>考试编号：</center></strong></td>
          <td style="width: 250px;height: 40px;"><center>${tblPxkshchj.fkKshbh}</center></td>
          <td style="width: 250px;height: 40px;"><strong><center>成绩：</center></strong></td>
          <td style="width: 250px;height: 40px;"><center>${tblPxkshchj.kshchj}</center></td>
      	</tr>
	  	<tr> 
	 		<td colspan=4; style="width: 1000px;height: 40px;"><strong><center>操作过程记录</center></strong></td>   
	  	</tr>
	  	<tr> 
	 		<td colspan=4; style="width: 1000px;height: 300px;">${fn:replace(tblPxkshchj.czgc, '/', '<br>')}</td>   
	  	</tr>
	  </table>
	  <br/>
	  <br/>
		
		
		<div class="form-actions">
			<input id="ptnSubmit" class="btn btn-primary" type="submit" onclick="formPrint();"  value="打印"  />
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>