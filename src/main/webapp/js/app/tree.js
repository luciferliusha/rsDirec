/**
 * Created by Administrator on 2017/9/11.
 */
function tree_leaf_opera(tree_id,isdatatree,treename){

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
    $("#dg").datagrid({
        view: detailview,
        detailFormatter:function(index,row){
            return '<div style="padding:2px;position:relative;"><table class="ddv"></table></div>';
        },
        onExpandRow: function(index,row){
            var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');
            var paraMap={};
            var colsdata;
            paraMap['TAB_NAME']=row.TAB_NAME;
            queryCols(paraMap,function(data){
                colsdata=data;
            });
            ddv.datagrid({
                data:colsdata,
                fitColumns:true,
                singleSelect:true,
                rownumbers:true,
                loadMsg:'',
                height:'auto',
                columns:[[
                    {field:'COL_NAME',title:'字段名',width:20,align:'center'},
                    {field:'COL_COMMENT',title:'中文名',width:20,align:'center'},
                    {field:'DATA',title:'数据类型',width:10,align:'center'},
                    {field:'NULL_RATE',title:'空值率',width:7,align:'center'}
                ]],
                onResize:function(){
                    $('#dg').datagrid('fixDetailRowHeight',index);
                },
                onLoadSuccess:function(){
                    setTimeout(function(){
                        $('#dg').datagrid('fixDetailRowHeight',index);
                    },0);
                }
            });

            $('#dg').datagrid('fixDetailRowHeight',index);
        },
        pagination: true,
        rownumbers: true,
        striped: true,
        singleSelect: true,
        columns: [[
            {field: 'TAB_NAME', title: '表名', width: 200, align: "center"},
            {field: 'TAB_COMMENT', title: '表中文名', width: 200, align: "center"},
            {field: 'TAB_ROWS', title: '记录数', width: 150, align: "center"},
            {field: 'TAB_UPDATE_TIME', title: '资源更新时间', width: 150, align: "center"},
            {field: 'TAB_RG_TIME', title: '资源注册时间', width: 150, align: "center"},
            {field: 'BEIZHU', title: '表注释', width: 180, align: "center"}
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
    $("#dg").datagrid({
        pagination: true,
        striped: true,
        singleSelect: true,
        columns: [[
            {field: 'rn', title: '序号', width: 100, align: "center"},
            {field: 'SERVICE_DEPT', title: '服务所属单位', width: 200, align: "center"},
            {field: 'SERVICE_GROUP', title: '服务所属分类', width: 200, align: "center"},
            {field: 'SERVICE_NAME', title: '服务名称', width: 100, align: "center"},
            {field: 'SERVICE_GETTYPE', title: '服务接口', width: 100, align: "center"},
            {field: 'SERVICE_DESCRIPTION', title: '服务说明', width: 100, align: "center"},
            {field: 'SERVICE_RG_TIME', title: '服务注册时间', width: 100, align: "center"}

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
    paraMap['TAB_COMMENT_Q']=$("#TAB_COMMENT_Q").attr("value");//获取input值;
    paraMap['TAB_UPDATE_TIME_Q']=$('#TAB_UPDATE_TIME_Q').datebox('getValue');//获取input值;
    paraMap['TAB_RG_TIME_Q']=$('#TAB_RG_TIME_Q').datebox('getValue');//获取input值;
    paraMap['currentPage']=1;
    paraMap['pageSize']=20;
    //alert($("#TAB_COMMENT_Q").attr("value"));
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