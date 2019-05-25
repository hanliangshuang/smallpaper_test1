<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>lianxi管理</title>
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
		
		function submitMethod(){	
			var Ncheck = 1;
			var re = /^[0-9]*[1-9][0-9]*$/;
			if($("#age").val()!=""){
				
				if (!re.test($("#age").val())) {
		        	var span=document.getElementById('agemsg');
					span.innerHTML="<font color='red'>请输入整数</font>";
					Ncheck = 0;
		        }else{
		        	var span=document.getElementById('agemsg');
					span.innerHTML="";
		        }
			}
				
				
				$.ajax({
					type : "post",
					dataType : "json",
					url : '${ctx}/mysss/ssss/validation?NAME='+$("#name").val()+'&ID='+$("#id").val(),
					beforeSend : function(XMLHttpRequest) {
					},
					success : function(data){
						
						if(data.flag==1){

							var span=document.getElementById('namemsg');
							span.innerHTML="<font color='red'>"+data.msg+"</font>";	
							Ncheck = 0;
							$("#name").focus();
						}
						
						if(Ncheck){
							$('#inputForm').submit();
						}

					}
				})
				
				
		}
		
		
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<%-- <li><a href="${ctx}/mysss/ssss/">lianxi列表</a></li>
		<li class="active"><a href="${ctx}/mysss/ssss/form?id=${ssss.id}">lianxi<shiro:hasPermission name="mysss:ssss:edit">${not empty ssss.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="mysss:ssss:edit">查看</shiro:lacksPermission></a></li>
		 --%>
		<li class="active">
			<a href="${ctx}/ip/techniqueEnergy/form?id=${ssss.id}">${not empty ssss.id?'编辑':'新增'}lianxi列表</a>
		</li>
		<li class="pull-right">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" onclick="submitMethod();" />
				<input id="btnCancel" class="btn btn-primary" type="button" value="返 回" onclick="window.location.href='${ctx}/mysss/ssss/'" />		
		</li>
	
	
	
	</ul>
	
	
	
	<br/>
	<form:form id="inputForm" modelAttribute="ssss" action="${ctx}/mysss/ssss/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">name：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
				<span id="namemsg"></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">age：</label>
			<div class="controls">
				<form:input path="age" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
				<span id="agemsg"></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">0 - nan 1-nv  moren 0：</label>
			<div class="controls">
				<form:select path="xb" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">bm：</label>
			<div class="controls">
			<c:if test="${not empty ssss.id}">
				<form:input path="bm" htmlEscape="false" maxlength="64" class="input-xlarge required" readonly="true"/>
			</c:if>
			<c:if test="${empty ssss.id}">
				<form:input path="bm" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
			</c:if>		
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="mysss:ssss:edit">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>