
function createInitComponents(){
	//alert("hhh");
	initListData();
	//createDataGrid();
	/*
	初始化树
	 */
    $('#sjzy_tree').tree({
        onClick: function(node){
           //alert(node.text);  // alert node text property when clicked
        }
    });

    $('#sjfw_tree').tree({
        onClick: function(node){
            //alert(node.text);  // alert node text property when clicked
        }
    });
}

function initListData(){
	queryDataTabs("No",1,18,function(data){
		createDataGrid(data);
	});
}

function queryDataTabs(detailOrNot,currentPage,pageSize,callback){
	$.ajax({
		url: "main/selectDataTabs.do",
		type:"POST",
        async:false,
		dataType : "json",
		contentType:'application/json;charset=UTF-8',  
		data:JSON.stringify({"detailOrNot":detailOrNot,"currentPage":currentPage,"pageSize":pageSize}),
		success:function(result){
			var s = result.data;
			callback(s);
		}
	});
}

function createDataGrid(temp){
	$("#dg").datagrid({
        //view: detailview,//注意1  
        pagination: true,
        striped: true,
        singleSelect: true,
        columns: [[
            {field: 'rn', title: '序号', width: 100, align: "center"},
            {field: 'tab_name', title: '表名', width: 200, align: "center"},
            {field: 'tab_comment', title: '表注释', width: 200, align: "center"},
            {field: 'tab_rows', title: '记录数', width: 100, align: "center"}
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



