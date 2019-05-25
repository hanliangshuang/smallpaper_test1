<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>考试成绩查询管理</title>
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
        
        window.onload = function() {
			var sequencer = document.getElementsByClassName("Sequence");
			for (var i = 0; i < sequencer.length; i++) {
				sequencer[i].innerHTML = i + 1;
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/exam/tblPxkshchj/">考试成绩查询列表</a></li>
		<%-- <shiro:hasPermission name="exam:tblPxkshchj:edit"><li><a href="${ctx}/exam/tblPxkshchj/form">考试成绩查询添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="tblPxkshchj" action="${ctx}/exam/tblPxkshchj/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>职工号：</label>
				<form:input path="fkZhgh" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>考试编号：</label>
				<form:input path="fkKshbh" htmlEscape="false" maxlength="16" class="input-medium"/>
			</li>

			<li><label>最后成绩：</label>
				<form:input path="kshchj" htmlEscape="false" maxlength="11" class="input-medium"/>
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
				<th>姓名</th>
				<th>职工编号</th>
				<th>单位</th>
				<th>岗位</th>
				
				<th>参加考试时间</th>
				<th>考试编号</th>
				<!-- <th>考试用时-分</th>
				<th>是否警铃提示</th>
				<th>碰杆次数</th>
				<th>倒杆次数</th>
				<th>出内圆次数</th>
				<th>出中圆次数</th>
				<th>出外圆次数</th>
				<th>是否多次停顿（超5次）</th> -->
				<th>考试地点</th>
				<th>最后成绩</th>
				<shiro:hasPermission name="exam:tblPxkshchj:edit"><th>详细</th></shiro:hasPermission>
				<%-- <shiro:hasPermission name="exam:tblPxkshchj:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tblPxkshchj">
			<tr>
				<td class="Sequence"></td>
				<%-- <td>
					${tblPxkshchj.id}
				</td> --%>
				<td>
					${tblPxkshchj.zhgxmxsh}
				</td>
				<td>
					${tblPxkshchj.fkZhgh}
				</td>
				<td>
					202
				</td>
				<td>
					${tblPxkshchj.zhgbmxsh}
				</td>
				
				<td>
					<fmt:formatDate value="${tblPxkshchj.kshshj}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tblPxkshchj.fkKshbh}
				</td>
				<%-- <td>
					${tblPxkshchj.ksysh}
				</td>
				<td>
					${tblPxkshchj.jl}
				</td>
				<td>
					${tblPxkshchj.pgcsh}
				</td>
				<td>
					${tblPxkshchj.dgcsh}
				</td>
				<td>
					${tblPxkshchj.chny}
				</td>
				<td>
					${tblPxkshchj.chzhy}
				</td>
				<td>
					${tblPxkshchj.chwy}
				</td>
				<td>
					${tblPxkshchj.shfdt}
				</td> --%>
				<td>
					车间
				</td>
				<td>
					${tblPxkshchj.kshchj}
				</td>
				<shiro:hasPermission name="exam:tblPxkshchj:edit"><td>
    				<a href="${ctx}/exam/tblPxkshchj/chjxiangxi?id=${tblPxkshchj.id}&zhg=${tblPxkshchj.fkZhgh}">详细步骤</a>
				</td></shiro:hasPermission>
				
				<%-- <shiro:hasPermission name="exam:tblPxkshchj:edit"><td>
    				<a href="${ctx}/exam/tblPxkshchj/form?id=${tblPxkshchj.id}">修改</a>
					<a href="${ctx}/exam/tblPxkshchj/delete?id=${tblPxkshchj.id}" onclick="return confirmx('确认要删除该考试成绩查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	<input class="btn btn-primary" type="button" onclick="excelexport('contentTable')" value="导出Excel">
</body>
</html>