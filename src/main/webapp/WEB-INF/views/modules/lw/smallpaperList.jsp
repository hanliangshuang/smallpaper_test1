<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小论文管理</title>
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
		<li class="active"><a href="${ctx}/lw/smallpaper/">小论文列表</a></li>
		<shiro:hasPermission name="lw:smallpaper:edit"><li><a href="${ctx}/lw/smallpaper/form">小论文添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="smallpaper" action="${ctx}/lw/smallpaper/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="xm" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>学号：</label>
				<form:input path="xh" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>题标：</label>
				<form:input path="bt" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>收录类别：</label>
				<form:radiobuttons path="shllb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>所属单位：</label>
				<form:select path="sshdw" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>学号</th>
				<th>题标</th>
				<th>收录类别</th>
				<th>所属单位</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="lw:smallpaper:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="smallpaper">
			<tr>
				<td><a href="${ctx}/lw/smallpaper/form?id=${smallpaper.id}">
					${smallpaper.xm}
				</a></td>
				<td>
					${smallpaper.xh}
				</td>
				<td>
					${smallpaper.bt}
				</td>
				<td>
					${fns:getDictLabel(smallpaper.shllb, '', '')}
				</td>
				<td>
					${fns:getDictLabel(smallpaper.sshdw, '', '')}
				</td>
				<td>
					<fmt:formatDate value="${smallpaper.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${smallpaper.remarks}
				</td>
				<shiro:hasPermission name="lw:smallpaper:edit"><td>
    				<a href="${ctx}/lw/smallpaper/form?id=${smallpaper.id}">修改</a>
					<a href="${ctx}/lw/smallpaper/delete?id=${smallpaper.id}" onclick="return confirmx('确认要删除该小论文吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>