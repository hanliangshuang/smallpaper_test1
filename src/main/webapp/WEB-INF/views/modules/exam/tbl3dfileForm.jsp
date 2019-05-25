<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>3DResource管理</title>
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/exam/tbl3dfile/">资源列表</a></li>
		<li class="active"><a href="${ctx}/exam/tbl3dfile/form?id=${tbl3dfile.id}">资源<shiro:hasPermission name="exam:tbl3dfile:edit">${not empty tbl3dfile.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="exam:tbl3dfile:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tbl3dfile" action="${ctx}/exam/tbl3dfile/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">资源名称：${isAuth}</label>
			<div class="controls">
				<form:input path="mch" htmlEscape="false" maxlength="80" class="input-xlarge required"/>
				<span class="help-inline"><font color="red"></font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型：</label>
			<div class="controls">
				<%-- <form:input path="lx" htmlEscape="false" maxlength="20" class="input-xlarge required"/> --%>
				
				<form:select path="lx" class="input-xlarge required">
					<form:options items="${fns:getDictList('3d_type')}" itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
				
				<span class="help-inline"><font color="red"></font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简要说明：</label>
			<div class="controls">
				<form:input path="shm" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red"></font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片链接地址：</label>
			<div class="controls">
				<%-- <form:input path="pic" htmlEscape="false" maxlength="500" class="input-xlarge required"/> --%>
				
				<form:hidden id="pic" path="pic" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="pic" type="images" uploadPath="/pic" selectMultiple="false" maxWidth="100" maxHeight="100"/>
				
				<span class="help-inline"><font color="red">上传文件请使用英文名称，否则会有乱码显示</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资源地址：</label>
			<div class="controls">
				<%-- <form:input path="zydzh" htmlEscape="false" maxlength="500" class="input-xlarge required"/> --%>
				
				<form:hidden id="zydzh" path="zydzh" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="zydzh" type="files" uploadPath="/res" selectMultiple="false" maxWidth="100" maxHeight="100"/>
			
				
				<span class="help-inline"><font color="red">上传文件请使用英文名称，否则会有乱码显示</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="500" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="exam:tbl3dfile:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>