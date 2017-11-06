/**
 * Created by Administrator on 2017/9/11.
 */
function tree_leaf_opera(tree_id,isdatatree,treename){
    //alert(tree_id);

    initListData(tree_id,isdatatree,treename);

}

function initListData(tree_id,isdatatree){

    $("#tree_id_4search").val(tree_id);//设置input值
    //val = $("#tree_id_4search").attr("value");//获取input值
    //alert(val);
    var paraMap={};
    paraMap['tree_id']=tree_id;
    paraMap['isdatatree']=isdatatree;
    paraMap['currentPage']=1;
    paraMap['pageSize']=20;
    var htmls='';//用于查询的div
    queryDataTabs(paraMap,function(data){
        if(paraMap['isdatatree']=='yes'){
            $("#istree").val('yes');//设置input值,说明是点击资源目录跳转过来的
            createAndLoadDatagrid(data);
        }else{
            $("#istree").val('no');//设置input值,说明是点击服务目录跳转过来的
            createAndLoadServicegrid(data);
        }

    });
}

function queryDataTabs(paraMap,callback){
    $.ajax({
        type:"POST",   //
        url:'datarsdir/gettreedata.do',
        async:false,
        data:JSON.stringify(paraMap),
        //dataType:"json",
        contentType:'application/json;charset=UTF-8',
        success:function(result){
            var s = result.data;
            //alert(s);
            callback(s);
            //window.location = rootPath+'/main.jsp';
        }//
    });
}

function queryCols(paraMap,callback){
    $.ajax({
        type:"POST",   //
        url:'datarsdir/getcols.do',
        async:false,
        data:JSON.stringify(paraMap),
        //dataType:"json",
        contentType:'application/json;charset=UTF-8',
        success:function(result){
            var s = result.data;
            //alert(s);
            callback(s);
            //window.location = rootPath+'/main.jsp';
        }//
    });
}

function createAndLoadDatagrid(temp){
    var htmlstr=' <form name="searchform" method="post" action="" id ="searchform">\n' +
        '                        <td width="70" height="100"><strong>表检索：</strong></td>\n' +
        '                        <td height="100">\n' +
        '                            表中文名:<input id="TAB_COMMENT_Q">&nbsp;&nbsp;&nbsp;\n' +
        '                            更新时间: <input id="TAB_UPDATE_TIME_Q" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width:110px">&nbsp;&nbsp;&nbsp;\n' +
        '                            注册时间: <input id="TAB_RG_TIME_Q" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width:110px">&nbsp;&nbsp;&nbsp;\n' +
        '                            <!--Language:\n' +
        '                            <select class="easyui-combobox" panelHeight="auto" style="width:100px">\n' +
        '                                <option value="java">Java</option>\n' +
        '                                <option value="c">C</option>\n' +
        '                                <option value="basic">Basic</option>\n' +
        '                                <option value="perl">Perl</option>\n' +
        '                                <option value="python">Python</option>\n' +
        '                            </select> -->\n' +
        '                            <a id="submit_search"  plain="true" onclick="doSearch()">查询</a>\n' +
        '                        </td>\n' +
        '                    </form>';
    $.parser.parse($("#tb").html(htmlstr));//重新渲染插入的html代码，要不然easyui 组件（如easyui-datebox）会失效


    $("#dg").datagrid({
        onClickRow: function (index, row) {  //easyui封装好的时间（被单机行的索引，被单击行的值）

            //需要传递的值
            var paraMap={};
            var colsdata;
            paraMap['TAB_NAME']=row.tab_name;
            queryCols(paraMap,function(data){
                colsdata=data;
            });

            $("#dlg_dg").datagrid({
                //pagination: true,
                striped: true,
                singleSelect: true,
                columns:[[
                    {field:'col_name',title:'字段名',width:200,align:'center'},
                    {field:'col_comment',title:'中文名',width:300,align:'center'},
                    {field:'data',title:'数据类型',width:150,align:'center'},
                    {field:'null_rate',title:'空值率%',width:150,align:'center'}
                ]]
                //
            });
            $("#dlg_dg").datagrid('loadData',colsdata);
            // $('#dlg').window({
            //     width:600,
            //     height:400,
            //     modal:true,
            //     closed:true
            // });
            $('#dlg').window('open');
        },
        pagination: true,
        rownumbers: true,
        striped: true,
        singleSelect: true,
        columns: [[
            {field: 'tab_name', title: '表名', width: 200, align: "center"},
            {field: 'tab_comment', title: '表中文名', width: 200, align: "center"},
            {field: 'tab_rows', title: '记录数', width: 90, align: "center"},
            {field: 'tab_source', title: '表来源', width: 200, align: "center"},
            {field: 'tab_group', title: '数据所属单位', width: 200, align: "center"},
            {field: 'tab_yw_time', title: '资源更新时间', width: 150, align: "center"},
            {field: 'tab_rg_time', title: '资源注册时间', width: 150, align: "center"},
            {field: 'tab_beizhu', title: '表注释', width: 180, align: "center"}
        ]]
    });
    //
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10 
        pageList: [5,10,15],//可以设置每页记录条数的列表 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        // onBeforeRefresh:function(){
        //     $(this).pagination('loading');
        //     alert('before refresh');
        //     $(this).pagination('loaded');
        // }
    });
    $("#dg").datagrid('loadData',temp);
}


function createAndLoadServicegrid(temp){
    var htmlstr=' <form name="searchform" method="post" action="" id ="searchform">\n' +
        '\n' +
        '                                            <strong>服务检索：</strong>\n' +
        '                                                   服务名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="SERVICE_NAME_Q" style="width:170px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>\n' +
        '                                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;服务所属单位:&nbsp;&nbsp;&nbsp;<input id="SERVICE_DEPT_Q" style="width:170px">&nbsp;&nbsp;&nbsp;<br/><br/>\n' +
        '\n' +
        '\n' +
        '                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;服务所属分类:&nbsp;&nbsp;&nbsp;<input id="SERVICE_GROUP_Q" style="width:170px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>\n' +
        '                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="SERVICE_RG_TIME_Q" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width:170px">&nbsp;&nbsp;&nbsp;\n' +
        '                                                &nbsp;&nbsp;&nbsp;&nbsp;<a id="submit_search"  plain="true" onclick="doSearch()">查询</a>\n' +
        '\n' +
        '                                        </form>';
    $.parser.parse($("#tb").html(htmlstr));//重新渲染插入的html代码，要不然easyui 组件（如easyui-datebox）会失效




    $("#dg").datagrid({
        onClickRow: function (index, row) {  //easyui封装好的时间（被单机行的索引，被单击行的值）

            //需要传递的值
            var url=row.service_gettype;
            window.open (url,'客运班线webservice服务','height=500,width=600')
            //alert(url);
            // $.ajax({
            //     type: "POST",
            //     url: url,
            //     dataType: "jsonp",
            //     success: function (msg) {
            //         alert($(msg).text());
            //         $("#websdiv").textContent($(msg).text());
            //     },
            //     error: function(e){
            //         alert("failed");
            //     }
            // });

            //$('#dlg').window('open');
        },
        pagination: true,
        striped: true,
        singleSelect: true,
        columns: [[
            {field: 'rn', title: '序号', width: 100, align: "center"},
            {field: 'service_dept', title: '服务所属单位', width: 200, align: "center"},
            {field: 'service_group', title: '服务所属分类', width: 200, align: "center"},
            {field: 'service_name', title: '服务名称', width: 100, align: "center"},
            {field: 'service_gettype', title: '服务接口', width: 100, align: "center"},
            {field: 'service_description', title: '服务说明', width: 100, align: "center"},
            {field: 'service_rg_time', title: '服务注册时间', width: 100, align: "center"}

        ]]
        //
    });
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10 
        pageList: [5,10,15],//可以设置每页记录条数的列表 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        // onBeforeRefresh:function(){
        //     $(this).pagination('loading');
        //     alert('before refresh');
        //     $(this).pagination('loaded');
        // }
    });
    $("#dg").datagrid('loadData',temp);
}

function doSearch(){
    var paraMap={};
    paraMap['tree_id']=$("#tree_id_4search").attr("value");//获取input值;
    paraMap['isdatatree']=$("#istree").attr("value");//获取input值;
    paraMap['currentPage']=1;
    paraMap['pageSize']=20;

    if(paraMap['isdatatree']=='yes'){
        paraMap['TAB_COMMENT_Q']=$("#TAB_COMMENT_Q").attr("value");//获取input值;
        paraMap['TAB_UPDATE_TIME_Q']=$('#TAB_UPDATE_TIME_Q').datebox('getValue');//获取input值;
        paraMap['TAB_RG_TIME_Q']=$('#TAB_RG_TIME_Q').datebox('getValue');//获取input值;
    }else{
        paraMap['SERVICE_NAME_Q']=$("#SERVICE_NAME_Q").attr("value");//获取input值;
        paraMap['SERVICE_DEPT_Q']=$("#SERVICE_DEPT_Q").attr("value");//获取input值;
        paraMap['SERVICE_GROUP_Q']=$("#SERVICE_GROUP_Q").attr("value");//获取input值;
        paraMap['SERVICE_RG_TIME_Q']=$('#SERVICE_RG_TIME_Q').datebox('getValue');//获取input值;
        //alert($("#SERVICE_RG_TIME_Q").datebox('getValue'));
    }

    //alert($("#TAB_COMMENT_Q").attr("value"));
    queryDataTabs(paraMap,function(data){
        if(paraMap['isdatatree']=='yes'){
            $("#istree").val('yes');//设置input值,说明是点击资源目录跳转过来的
            createAndLoadDatagrid(data);
        }else{
            $("#istree").val('no');//设置input值,说明是点击服务目录跳转过来的
            //alert($("#SERVICE_GROUP_Q").attr("value"));
            createAndLoadServicegrid(data);
        }
    });

}

function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}