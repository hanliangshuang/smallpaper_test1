<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>czlx管理</title>
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
		<li class="active"><a href="${ctx}/exam/tblCzlx/">czlx列表</a></li>
		<shiro:hasPermission name="exam:tblCzlx:edit"><li><a href="${ctx}/exam/tblCzlx/form">czlx添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tblCzlx" action="${ctx}/exam/tblCzlx/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>操作类型 0-练习 1-考试：</label>
				<form:input path="czlb" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>id</th>
				<th>外键，关联对应职工表tbl_ZhG.</th>
				<th>考试编号</th>
				<th>操作类型 0-练习 1-考试</th>
				<th>进入操作练习的开始时间，格式为&ldquo;年-月-日 时-分-秒&rdquo;</th>
				<th>在操作练习中停留的总时长，单位为分</th>
				<th>在操作练习中进行的所有操作的记录；格式 &ldquo;时-分-秒 操作内容 / 时-分-秒 操作内容&rdquo;；</th>
				<shiro:hasPermission name="exam:tblCzlx:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tblCzlx">
			<tr>
				<td><a href="${ctx}/exam/tblCzlx/form?id=${tblCzlx.id}">
					${tblCzlx.id}
				</a></td>
				<td>
					${tblCzlx.fkZhgh}
				</td>
				<td>
					${tblCzlx.fkkshbh}
				</td>
				<td>
					${tblCzlx.czlb}
				</td>
				<td>
					<fmt:formatDate value="${tblCzlx.czshj}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tblCzlx.czshch}
				</td>
				<td>
					${tblCzlx.czgch}
				</td>
				<shiro:hasPermission name="exam:tblCzlx:edit"><td>
    				<a href="${ctx}/exam/tblCzlx/form?id=${tblCzlx.id}">修改</a>
					<a href="${ctx}/exam/tblCzlx/delete?id=${tblCzlx.id}" onclick="return confirmx('确认要删除该czlx吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>