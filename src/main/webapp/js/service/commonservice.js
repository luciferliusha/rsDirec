function queryGoods(code,callback){
	$.ajax({
		url: rootPath+"/goods.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

function querySumGoods(callback){
	$.ajax({
		url: rootPath+"/sumgoods.do",
		type:"GET",
		dataType : "json",
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

function queryPassengers(code,callback){
	$.ajax({
		url: rootPath+"/passengers.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

function queryRoadConserve(code,callback){
	$.ajax({
		url: rootPath+"/roadconserve.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

// 公路大修项目投资
function queryRoadDxTz(code,callback){
	$.ajax({
		url: rootPath+"/roadDxTz.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}


//普通公路改造项目投资
function queryCommonRoadJs(code,callback){
	$.ajax({
		url: rootPath+"/commonRoadJs.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

//客货运输从业人员统计
function queryRoadTrafficKhPersonnel(code,callback){
	$.ajax({
		url: rootPath+"/roadtraffic/khpersonnel.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

//综合运输量统计
function queryTrafficCounts(code,callback){
	$.ajax({
		url: rootPath+"/roadtraffic/trafficcount.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}


//营运车辆综合统计
function queryTrafficCars(code,callback){
	$.ajax({
		url: rootPath+"/roadtraffic/trafficcars.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

//客货运从业人员综合统计
function queryJobHolders(code,callback){
	$.ajax({
		url: rootPath+"/roadtraffic/jobholders.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

//治超人员统计
function queryOverload(code,callback){
	$.ajax({
		url: rootPath+"/overload/managers.do",
		type:"GET",
		dataType : "json",
		data:{
			"code":code
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}

//全省出入口交通量统计
function queryPrivinceOd(sfzbm,callback){
	$.ajax({
		url: rootPath+"/highway/privinceod.do",
		type:"GET",
		dataType : "json",
		data:{
			"sfzbm":sfzbm
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
	
			if (result.returnFlag == 1) {
				var data = result.data;
				callback(data);
			} else {
				alert('查询结果为空');
			}
		}
		
	});
}


function gis_queryCity(callback){
	$.ajax({
		url: gisPath,
		type:"GET",
		dataType : "jsonp",
		jsonp: "dataCallback",   
		data:{
			"taskName":"search",
			"layerName":encodeURIComponent(encodeURIComponent("GISGEO.地区市政府P")),
			"where":encodeURIComponent(encodeURIComponent(" code like '610%' "))
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
			var arr = result.features;
			var citys = new Array();
			
			for(var i in arr){
				var city = new Object();
				city.name = arr[i].attributes.NAME;
				city.code = arr[i].attributes.CODE;
				city.py = arr[i].attributes.NAME_PY;
				var point = arr[i].geometry.replace("POINT (","").replace(")","").split(" ");
				city.x = point[0];
				city.y = point[1];
				citys.push(city);
			}
			callback(citys);
		},
		error:function(a){
			var s = a;
		}
		
	});
}

// 查询全部收费站
function gis_querySfz(callback){
	$.ajax({
		url: gisPath,
		type:"GET",
		dataType : "jsonp",
		jsonp: "dataCallback",   
		data:{
			"taskName":"search",
			"layerName":encodeURIComponent(encodeURIComponent("GIS_SFZ"))
		},
		success:function(result){
			if (result == null) {
				alert('没有查询结果');
				return;
			}
			var arr = result.features;
			var sfzs = new Array();
			
			for(var i in arr){
				var sfz = new Object();
				sfz.name = arr[i].attributes.SFZMC;
				sfz.code = arr[i].attributes.SFZBM;
				sfz.lxbm = arr[i].attributes.LXBM;
				sfz.lxmc = arr[i].attributes.LXMC;
				sfz.zh = arr[i].attributes.ZH;
				sfz.city = arr[i].attributes.XZQHBM;
				var point = arr[i].geometry.replace("POINT (","").replace(")","").split(" ");
				sfz.x = point[0];
				sfz.y = point[1];
				sfzs.push(sfz);
			}
			callback(sfzs);
		},
		error:function(a){
			var s = a;
		}
		
	});
}

