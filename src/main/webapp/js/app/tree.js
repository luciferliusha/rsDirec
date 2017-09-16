/**
 * Created by Administrator on 2017/9/11.
 */
function tree_leaf_opera(tree_id,isdatatree,treename){

    initListData(tree_id,isdatatree,treename);

}

function initListData(tree_id,isdatatree){
    queryDataTabs(tree_id,isdatatree,1,20,function(data){
        if(isdatatree=='yes'){
            createAndLoadDatagrid(data);
        }else{
            createAndLoadServicegrid(data);
        }
    });
}

function queryDataTabs(tree_id,isdatatree,currentPage,pageSize,callback){
    var paraMap={};
    var redirec_url;
    paraMap['tree_id']=tree_id;
    paraMap['isdatatree']=isdatatree;
    paraMap['currentPage']=currentPage;
    paraMap['pageSize']=pageSize;

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

function createAndLoadDatagrid(temp){
    $("#dg").datagrid({
        pagination: true,
        rownumbers: true,
        striped: true,
        singleSelect: true,
        columns: [[

            {field: 'TAB_NAME', title: '表名', width: 200, align: "center"},
            {field: 'TAB_COMMENT', title: '表注释', width: 200, align: "center"},
            {field: 'TAB_ROWS', title: '记录数', width: 100, align: "center"},
            {field: 'TAB_RG_TIME', title: '资源注册时间', width: 100, align: "center"}
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