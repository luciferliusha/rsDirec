
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



function    adddata(){

    // var data_dept=$("input[name='data_dept']").val();
    var data_dept= $("#data_dept").val();
    var data_group=$("#data_group").val();
    var data_name=$("#data_name").val();
    var data_gettype=$("#data_gettype").val();

    if((data_dept==null||$.trim(data_dept)=='')){
        alert("资源所属单位不能为空！");
        return;
    }else if((data_group==null||$.trim(data_group)=='')){
        alert("资源所属分类不能为空！");
        return;
    }else if((data_name==null||$.trim(data_name)=='')){
        alert("资源名称不能为空！");
        return;
    }else if((data_gettype==null||$.trim(data_gettype)=='')){
        alert("资源获取方式不能为空！");
        return;
    }

    //alert(data_dept);
    var paraMap={};//存放查询数据的参数
    paraMap["data_dept"] = data_dept;
    paraMap["data_group"] = data_group;
    paraMap["data_name"] = data_name;
    paraMap["data_gettype"] = data_gettype;

    $.ajax({
        type:"POST",   //http请求方式
        url:'datarsdir/adddata.do',
        async:false,
        data:JSON.stringify(paraMap), //发送给服务器的参数  ,JSON.stringify将json对象转换成json字符串，否则后台bean接收不到,报400,415错误
        //dataType:"json",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
        contentType:'application/json;charset=UTF-8',
        success:function(result){
            var s = result.data;
            alert("添加数据资源成功");
            window.location = rootPath+'/main.jsp';
        }//定义交互完成,并且服务器正确返回数据时调用回调函数
    });

}

function    addservice(){

    var service_dept=$("#service_dept").val();
    var service_group=$("#service_group").val();
    var service_name=$("#service_name").val();
    var service_gettype=$("#service_gettype").val();
    var service_description=$("#service_description").val();

    if((service_dept==null||$.trim(service_dept)=='')){
        alert("服务所属单位不能为空！");
        return;
    }else if((service_group==null||$.trim(service_group)=='')){
        alert("服务所属分类不能为空！");
        return;
    }else if((service_name==null||$.trim(service_name)=='')){
        alert("服务名称不能为空！");
        return;
    }else if((service_gettype==null||$.trim(service_gettype)=='')){
        alert("服务接口不能为空！");
        return;
    }else if((service_description==null||$.trim(service_description)=='')){
        alert("服务说明不能为空！");
        return;
    }

    //alert(data_gettype);
    var paraMap={};//存放查询数据的参数
    paraMap["service_dept"] = service_dept;
    paraMap["service_group"] = service_group;
    paraMap["service_name"] = service_name;
    paraMap["service_gettype"] = service_gettype;
    paraMap["service_description"] = service_description;

    $.ajax({
        type:"POST",   //http请求方式
        url:'datarsdir/addservice.do',
        async:false,
        data:JSON.stringify(paraMap), //发送给服务器的参数  ,JSON.stringify将json对象转换成json字符串，否则后台bean接收不到,报400,415错误
        //dataType:"json",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
        contentType:'application/json;charset=UTF-8',
        success:function(result){
            var s = result.data;
            alert("发布服务成功");
            window.location = rootPath+'/main.jsp';
        }//定义交互完成,并且服务器正确返回数据时调用回调函数
    });

}

function loadTableByDept(){//根据部门及数据源信息获取表

    var data_gettype=$("#data_gettype").val();//格式为jdbc:oracle:thin:@127.0.0.1:1521:dbname;username;password
    var splitstr=data_gettype.split(';');
    var db_url;
    var db_username;
    var db_password;
    //alert(db_url+"-"+db_username+"-"+db_password+deptid);
        db_url=splitstr[0];
        db_username=splitstr[1];
        db_password=splitstr[2];

    var paraMap={};//存放查询数据的参数
    paraMap["data_dept"] =$('#data_dept').combobox('getValue');
    paraMap["db_url"] = db_url;
    paraMap["db_username"] = db_username;
    paraMap["db_password"] = db_password;

    $.ajax({
        type:"POST",   //http请求方式
        url:'datarsdir/loadTableByDept.do',
        async:true,
        data:JSON.stringify(paraMap), //发送给服务器的参数  ,JSON.stringify将json对象转换成json字符串，否则后台bean接收不到,报400,415错误
        //dataType:"json",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
        contentType:'application/json;charset=UTF-8',
        success:function(result){//填充“资源名称”下拉框
            var data =result.data;
            // $.each(result.data, function(i,val){
            //     //这里的"text","id"和html中对应
            //     data.push({ "text": val.tb_name, "id": val.tb_comments });
            // })
            $("#transSite").combobox("loadData", data);
        }//定义交互完成,并且服务器正确返回数据时调用回调函数
    });
}
