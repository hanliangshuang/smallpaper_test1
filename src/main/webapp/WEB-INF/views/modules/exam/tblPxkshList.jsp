<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>pxksh管理</title>
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
		
		var idTmr;  
        function  getExplorer() {  
            var explorer = window.navigator.userAgent ;  
            //ie  
            if (explorer.indexOf("MSIE") >= 0) {  
                return 'ie';  
            }  
            //firefox  
            else if (explorer.indexOf("Firefox") >= 0) {  
                return 'Firefox';  
            }  
            //Chrome  
            else if(explorer.indexOf("Chrome") >= 0){  
                return 'Chrome';  
            }  
            //Opera  
            else if(explorer.indexOf("Opera") >= 0){  
                return 'Opera';  
            }  
            //Safari  
            else if(explorer.indexOf("Safari") >= 0){  
                return 'Safari';  
            }  
        }  
        function excelexport(tableid) {  
            if(getExplorer()=='ie')  
            {  
                var curTbl = document.getElementById(tableid);  
                var oXL = new ActiveXObject("Excel.Application");  
                var oWB = oXL.Workbooks.Add();  
                var xlsheet = oWB.Worksheets(1);  
                var sel = document.body.createTextRange();  
                sel.moveToElementText(curTbl);  
                sel.select();  
                sel.execCommand("Copy");  
                xlsheet.Paste();  
                oXL.Visible = true;  
  
                try {  
                    var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");  
                } catch (e) {  
                    print("Nested catch caught " + e);  
                } finally {  
                    oWB.SaveAs(fname);  
                    oWB.Close(savechanges = false);  
                    oXL.Quit();  
                    oXL = null;  
                    idTmr = window.setInterval("Cleanup();", 1);  
                }  
  
            }  
            else  
            {  
                tableToExcel(tableid)  
            }  
        }
        
        function Cleanup() {  
            window.clearInterval(idTmr);  
            CollectGarbage();  
        }  
        var tableToExcel = (function() {  
            var uri = 'data:application/vnd.ms-excel;base64,',  
                    template = '<html><head><meta charset="UTF-8"></head><body><table>{table}</table></body></html>',  
                    base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) },  
                    format = function(s, c) {  
                        return s.replace(/{(\w+)}/g,  
                                function(m, p) { return c[p]; }) }  
            return function(table, name) {  
                if (!table.nodeType) table = document.getElementById(table)  
                var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}  
                window.location.href = uri + base64(format(template, ctx))  
            }  
        })()
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/exam/tblPxksh/">考试批次列表</a></li>
		<shiro:hasPermission name="exam:tblPxksh:edit"><li><a href="${ctx}/exam/tblPxksh/form">考试批次添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tblPxksh" action="${ctx}/exam/tblPxksh/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>考试编号：</label>
				<form:input path="kshbh" htmlEscape="false" maxlength="16" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<!-- <th>id</th> -->
				<th>考试编号</th>
				<th>考试成绩</th>
				<th>考试总时长（分）</th>
				<th>操作失误扣分分值</th>
				<th>创建时间</th>
				<th>是否启用</th>
				<shiro:hasPermission name="exam:tblPxksh:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tblPxksh">
			<tr>
				<%-- <td><a href="${ctx}/exam/tblPxksh/form?id=${tblPxksh.id}">
					${tblPxksh.id}
				</a></td> --%>
				<td>
					${tblPxksh.kshbh}
				</td>
				<td>
					${tblPxksh.zfzh}
				</td>
				<td>
					${tblPxksh.czshch}
				</td>
				<td>
					${tblPxksh.kfzh}
				</td>
				<td>
					<fmt:formatDate value="${tblPxksh.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(tblPxksh.shfqy,'yes_no','无')}
				</td>
				<shiro:hasPermission name="exam:tblPxksh:edit"><td>
    				<a href="${ctx}/exam/tblPxksh/form?id=${tblPxksh.id}">修改</a>
    				
    				<c:if test="${tblPxksh.shfqy eq 1 }">
						<a href="${ctx}/exam/tblPxksh/delete?id=${tblPxksh.id}" onclick="return confirmx('确认要停用该考试吗？', this.href)"><font color="red">停用</font></a>
					</c:if>
					<c:if test="${tblPxksh.shfqy eq 0 }">
						<a href="${ctx}/exam/tblPxksh/delete?id=${tblPxksh.id}" onclick="return confirmx('确认要启用该考试吗？', this.href)"><font color="green">启用</font></a>
					</c:if>
					
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	<input class="btn btn-primary" type="button" onclick="excelexport('contentTable')" value="导出Excel">
</body>
</html>