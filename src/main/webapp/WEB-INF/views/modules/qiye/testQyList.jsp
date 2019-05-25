<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>企业管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/qiye/testQy/">企业列表</a></li>
		<shiro:hasPermission name="qiye:testQy:edit"><li><a href="${ctx}/qiye/testQy/form">企业添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="testQy" action="${ctx}/qiye/testQy/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>唯一标识：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>企业名称：</label>
				<form:input path="qymch" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>注册资本：</label>
				<form:input path="zczb" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>注册时间：</label>
				<input name="beginZcshj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${testQy.beginZcshj}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endZcshj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${testQy.endZcshj}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>唯一标识</th>
				<th>企业名称</th>
				<th>重点企业</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="qiye:testQy:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="testQy">
			<tr>
				<td><a href="${ctx}/qiye/testQy/form?id=${testQy.id}">
					${testQy.id}
				</a></td>
				<td>
					${testQy.qymch}
				</td>
				<td>
					${fns:getDictLabel(testQy.zdqy, '', '')}
				</td>
				<td>
					<fmt:formatDate value="${testQy.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${testQy.remarks}
				</td>
				<shiro:hasPermission name="qiye:testQy:edit"><td>
    				<a href="${ctx}/qiye/testQy/form?id=${testQy.id}">修改</a>
					<a href="${ctx}/qiye/testQy/delete?id=${testQy.id}" onclick="return confirmx('确认要删除该企业吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>