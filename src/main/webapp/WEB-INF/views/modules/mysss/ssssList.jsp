<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>lianxi管理</title>
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
		<li class="active"><a href="${ctx}/mysss/ssss/">lianxi列表</a></li>
		<shiro:hasPermission name="mysss:ssss:edit"><li><a href="${ctx}/mysss/ssss/form">lianxi添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ssss" action="${ctx}/mysss/ssss/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>name：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>age：</label>
				<form:input path="age" htmlEscape="false" maxlength="3" class="input-medium"/>
			</li>
			<li><label>0 - nan 1-nv  moren 0：</label>
				<form:select path="xb" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>bm：</label>
				<form:input path="bm" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>name</th>
				<th>age</th>
				<th>0 - nan 1-nv  moren 0</th>
				<th>bm</th>
				<th>update_date</th>
				<th>remarks</th>
				<shiro:hasPermission name="mysss:ssss:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ssss">
			<tr>
				<td><a href="${ctx}/mysss/ssss/form?id=${ssss.id}">
					${ssss.name}
				</a></td>
				<td>
					${ssss.age}
				</td>
				<td>
					${fns:getDictLabel(ssss.xb, 'sex', '')}
				</td>
				<td>
					${ssss.bm}
				</td>
				<td>
					<fmt:formatDate value="${ssss.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${ssss.remarks}
				</td>
				<shiro:hasPermission name="mysss:ssss:edit"><td>
    				<a href="${ctx}/mysss/ssss/form?id=${ssss.id}">修改</a>
					<a href="${ctx}/mysss/ssss/delete?id=${ssss.id}" onclick="return confirmx('确认要删除该lianxi吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>