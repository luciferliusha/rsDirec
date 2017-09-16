/**
 * JS自有对象添加方法
 * @param a
 * @param len
 * @return
 */

Math.toFixed = function(a,len){
	var tempNum = 0;
    var s,temp;
    var s1 = a+"";
    var start = s1.indexOf(".");
    
    //截取小数点后,0之后的数字，判断是否大于5，如果大于5这入为1

   if(s1.substr(start+len+1,1)>=5)
    tempNum=1;

    //计算10的len次方,把原数字扩大它要保留的小数位数的倍数
  var temp = Math.pow(10,len);
    //求最接近this * temp的最小数字
    //floor() 方法执行的是向下取整计算，它返回的是小于或等于函数参数，并且与之最接近的整数
    s = Math.floor(a * temp) + tempNum;
    return s/temp;
	
}

Math.toFormatString = function(a,c){
	var s = a;
	switch(c){
		case '%':
		{
			s = Math.round(a*100)+"%"
			break;
		}
	}
	return s;
}



function getValiNumber(sk){
	if(sk==null || sk==undefined || sk==""){
		sk = 0;
	}
	return sk;
}

