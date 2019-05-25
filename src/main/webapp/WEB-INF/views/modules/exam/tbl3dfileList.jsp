<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>3DResource管理</title>
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
		
		window.onload = function() {
			var xl = document.getElementsByClassName("xl");
			for (i = 0; i < xl.length; i++) {
				xl[i].innerHTML = i + 1;
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/exam/tbl3dfile/">资源列表</a></li>
		<c:if test="${isAuth eq 1 }">
		<shiro:hasPermission name="exam:tbl3dfile:edit"><li><a href="${ctx}/exam/tbl3dfile/form">资源创建</a></li></shiro:hasPermission>
		</c:if>
	</ul>
	<form:form id="searchForm" modelAttribute="tbl3dfile" action="${ctx}/exam/tbl3dfile" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>资源名称：</label>
				<form:input path="mch" htmlEscape="false" maxlength="80" class="input-medium"/>
			</li>
			<li>
				<label>资源类型 ：</label>
				<form:select class="input-small" path="lx">
					<form:option value="" label="全部" />
					<form:options items="${fns:getDictList('3d_type')}" itemValue="value" itemLabel="label" htmlEscape="false" />
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
				<th>序号</th>
				<th>资源名称</th>
				<th>类型</th>
				<th>说明</th>
				<th>模型样图</th>
				<th>资源地址</th>
				<th>创建人</th>
				<th>创建日期</th>
				<c:if test="${isAuth eq 1 }">
				<shiro:hasPermission name="exam:tbl3dfile:edit"><th>操作</th></shiro:hasPermission>
				</c:if>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbl3dfile">
			<tr>
				<td class="xl" width="30"></td>
				<td><a href="${ctx}/exam/tbl3dfile/form?id=${tbl3dfile.id}">
					${tbl3dfile.mch}
				</a></td>
				<td width="50">
					${fns:getDictLabel(tbl3dfile.lx,'3d_type','无')}
				</td>
				<td>
					${tbl3dfile.shm}
				</td>
				<td>
					
					
					<img 
						src="${tbl3dfile.pic}" 
						style="max-width:100px;max-height:100px;_height:100px;border:0;padding:3px;"
					>
				</td>
				<td>
					<a href="${tbl3dfile.zydzh}" url="${tbl3dfile.zydzh}" target="_blank">资源下载</a>
				</td>
				<td>
					${tbl3dfile.createBy}
				</td>
				<td>
					<fmt:formatDate value="${tbl3dfile.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<c:if test="${isAuth eq 1 }">
				<shiro:hasPermission name="exam:tbl3dfile:edit"><td>
    				<%-- <a href="${ctx}/exam/tbl3dfile/form?id=${tbl3dfile.id}">修改</a> --%>
					<a href="${ctx}/exam/tbl3dfile/delete?id=${tbl3dfile.id}" onclick="return confirmx('确认要删除该资源吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>