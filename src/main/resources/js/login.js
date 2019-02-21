var verifySmsCode01 = "";   // 服务密码验证cookie信息
var verifySmsCode02 = "";   // 短信验证cookie信息
var isCheckSmsCode = false;  //是否校验短信验证码
var isCheckPageCode = false; //是否校验图形验证码
var loginOperType = "2"; //默认服务密码登录
var passFlag = "2";   //服务密码登录 
var smsFlag = "0";    //短信验证码登录
var servicePwdId = "servicePwdId"; // 服务密码id
var smsId = "smsId"; //短信密码id
var pageCode = "pageCode"; // 图形验证码id
var  telnumId = "telnum"; //手机号码id
//function setLoginCookie(name,value,domain)
//{
//	var days = 30;
//	var exp = new Date(); 
//	exp.setTime(exp.getTime() + days*24*60*60*1000);
//	
//	
//	if (undefined != domain && "" != domain){
//		document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";domain:"+domain+";secure=true;path=/";
//	}else{
//		document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
//	}
//	
//}

function getCookieValue(name){
    var name = escape(name); //读cookie属性，这将返回文档的所有cookie
    var allcookies = document.cookie;//查找名为name的cookie的开始位置
    name += "=";
    var pos = allcookies.indexOf(name);//如果找到了具有该名字的cookie，那么提取并使用它的值
    if (pos != -1){                                     //如果pos值为-1则说明搜索"version="失败
        var start = pos + name.length;                  //cookie值开始的位置
        var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
        if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie
        var value = allcookies.substring(start,end);  //提取cookie的值
        return unescape(value);                           //对它解码
    }
    else return "";                                  //搜索失败，返回空字符串
}

//校验是否必须进行短信验证码校验
function needVerifyCode(telNum){
	
	if ("" != telNum && 0 != telNum.length && telNum.match(/^(((13[4-9]{1})|(15[0-2]{1})|(15[7-9]{1})|(18[7-8]{1})|182|183|184|147|178|198|148|144)+\d{8})$/)){
		
		// 如果浏览器登录过，则进行数据合法校验
		if (passFlag == loginOperType && "" != verifySmsCode01 || passFlag != loginOperType && "" != verifySmsCode02){
			$.ajaxDirect({
		        url: 'login/needVerifyCode',
		        param:"serialNumber="+telNum+"&loginType="+loginOperType, 
		        afterFn:function(data){
		        	if (data.needVerifyCode != "0"){ //首次验证不成功
		        		if (passFlag == loginOperType){ // 如果是服务密码登录
		        			$("#" + servicePwdId).css("display","block");
		        			$("#" + pageCode).css("display","none");
		        			$("#" + smsId).css("display","block");
		        			isCheckSmsCode = true; //设置需要校验服务密码
		        		}else{//如果是短信验证码登录
		        			$("#" + servicePwdId).css("display","none");
		        			$("#" + pageCode).css("display","none");
		        			$("#" + smsId).css("display","block");
		        			isCheckPageCode = false; // s设置需要校验图形
		        		}
		        	}else{
		        		if (passFlag == loginOperType){ // 如果是服务密码登录
		        			$("#" + servicePwdId).css("display","block");
		        			$("#" + pageCode).css("display","none");
		        			$("#" + smsId).css("display","none");
		        			isCheckSmsCode = false; //设置不需要校验服务密码
		        		}else{//如果是短信验证码登录
		        			$("#" + pageCode).css("display","none");
		        			$("#" + servicePwdId).css("display","none");
		        			$("#" + smsId).css("display","block");
		        			isCheckPageCode = false; //设置不需要校验图形
		        		}
		            }
		        }
			});
		}
	}
}

//初始化验证码(如果浏览器中无对应cookie信息，则展示对应数据)
function initCheckCode(){
	
	loginOperType = $('input:radio:checked').val(); //设置登录类型
	
	verifySmsCode01 = getCookieValue("verifySmsCode01");
	verifySmsCode02 = getCookieValue("verifySmsCode02");
	
	$("#passWordCheck").html("");
	$("#checkTelInfo").html("");
	$("#validateCheck").html("");
	
	if (passFlag == loginOperType){ // 如果是服务密码登录
		$("#" + servicePwdId).css("display","block");
		$("#" + pageCode).css("display","none");
		
		if (undefined == verifySmsCode01 || "" == verifySmsCode01){
			verifySmsCode01 = "";
			$("#" + smsId).css("display","block");
			
			isCheckSmsCode = true; //设置需要校验服务密码
		}else{
			var telNum = $("#" + telnumId).val();
			
			needVerifyCode(telNum);
		}
	}else{//如果是短信验证登陆
		$("#" + servicePwdId).css("display","none");
		$("#" + smsId).css("display","block");
		
		if (undefined == verifySmsCode02 || "" == verifySmsCode02){
			verifySmsCode02 = "";
			$("#" + pageCode).css("display","none");
			isCheckPageCode = false; // 设置需要校验图形
		}else{
			var telNum = $("#" + telnumId).val();
		
			needVerifyCode(telNum);
		}
	}
}


$(function(){
	var login_phoneId = getCookieValue("rememberNum");
	if(login_phoneId != '') {
		$('#telnum').val(login_phoneId);
	}
	$("body").keydown(function() {
	    if (event.keyCode == "13") {//keyCode=13是回车键
	        $('#subLogin').click();
	    }
	});

	
	$("input[type='radio']").bind('click',function(){
		loginOperType = $('input:radio:checked').val(); //设置登录类型
		
		//refreshValidate();
		
		initCheckCode();
	});
	
	initCheckCode();
	
	
});

function login(obj){
	
	var loginType = $('input:radio:checked').val();
	var telNum = $("#telnum").val();
	var password = "0";
	var smspass = "0";
	var goodsName = "";
	var validateCode = $("#validateCode").val();
	var loginOperType = "";
	if("" == loginType){
		alert("请选择服务类型!");
		return;
	}
	smspass = $("#smspass").val();
	
	if("0" == loginType){
		goodsName = "短信验证码登录";
		loginOperType = "1";
	}else{
		password = $("#password").val();
		password = strEnc(password,telNum.substring(0,8),telNum.substring(1,9),telNum.substring(3,11));
		goodsName = "服务密码登录";
		loginOperType = "0";
	}
		
	if (!checkPass() || !checkTel()){
		return;
	}
	
	$("#subLogin").html("登录中。。。");
	$("#subLogin").attr("disabled","true");
	
	/*
	var isAgree = "0";
	$('input[name="isAgree"]:checked').each(function(){ 
		isAgree = $(this).val();
	});
	if("on" != isAgree){
		alert("尊敬的用户,您未同意服务条款!");
		return;
	}*/
	var rememberTag =$("input[name='rememberTag']").is(":checked");
	$.ajaxDirect({
        url: 'login/SSOLogin',
        param:"REMEMBER_TAG="+rememberTag+"&SERIAL_NUMBER="+telNum+"&LOGIN_TYPE="+loginType+"&USER_PASSWD="+password+"&USER_PASSSMS="+smspass+"&VALIDATE_CODE="+validateCode+"&chanId=E003&operType=LOGIN&goodsName="+goodsName+"&loginType="+loginOperType, 
        afterFn:function(data){
        	if(data.RESULT != "0"){
        		$("#validateCheck").html(data.RESULTINFO);
        		$("#subLogin").html("登录");
        		$("#subLogin").removeAttr("disabled");
        		//refreshValidate();
        	}else{
        		var artifact = data.ARTIFACT;
    			var channelId = data.CHANNELID;
        		if("1" == obj){
        			var url = location.href;
        			
        			if (url=='' || url==undefined){
        				url = "http://www.hn.10086.cn/service/static/index.html";
        			}
        			
//        			location.href="https://login.10086.cn/AddUID.htm?channelID="+channelId+"&Artifact="+artifact+"&backUrl="+url+"&TransactionID="+ new Date().getTime();
        			location.href="https://login.10086.cn/AddUID.htm?channelID="+channelId+"&Artifact="+artifact+"&backUrl="+url+"&TransactionID="+ new Date().getTime();
            		//location.reload();
        		}else{
        			//window.location.href = "/index.html";
        			//history.back(-1);
        			
        			var url = document.referrer;
        			
        			if (url=='' || url==undefined){
        				url = "http://www.hn.10086.cn/service/static/index.html";
        			}
        			
//        			location.href="https://login.10086.cn/AddUID.htm?channelID="+channelId+"&Artifact="+artifact+"&backUrl="+document.referrer +"&TransactionID="+ new Date().getTime();
        			location.href="https://login.10086.cn/AddUID.htm?channelID="+channelId+"&Artifact="+artifact+"&backUrl="+url +"&TransactionID="+ new Date().getTime();
        		}
        	}
        }
     });
}

function refreshValidate(){
	$("#validateImg").attr("src","/service/ics/servlet/ImageServlet?random="+Math.random());
}

function checkTel(){
	var telNum = $("#telnum").val();
	var validateCode = $("#validateCode").val();
	
	if("" == telNum || 0 == telNum.length){
		$("#checkTelInfo").html("请输入电话号码!");
		return false;
	}
	if (!telNum.match(/^(((13[4-9]{1})|(15[0-2]{1})|(15[7-9]{1})|(18[7-8]{1})|182|183|184|147|178|198|148|144)+\d{8})$/)) { 
		$("#checkTelInfo").html("请输入正确的移动号码!");
		return false;
	}

	if(isCheckPageCode && loginOperType != "2" && (""==validateCode || 4!=validateCode.length)){
		$("#validateCheck").html("请输入正确的图形验证码!");
		return false;
	}
	
	$("#checkTelInfo,#validateCheck").html("");
	
	needVerifyCode(telNum);
	
	return true;
}

function checkPass(){
	var loginType = $('input:radio:checked').val();
	var password = "0";
	var smspass = "0";
	
	smspass = $("#smspass").val();
	
	if("0" == loginType){
		
		if(0 == smspass.length || "" == smspass){
			$("#passWordCheck").html("请输入短信验证码!");
			return false;
		}

		if(6 != smspass.length){
			$("#passWordCheck").html("请输入正确的短信验证码!");
			return false;
		}
		
		$("#passWordCheck").html("");
		
		if (isCheckPageCode){// 如果需要校验图形验证码
			var validateCode = $("#validateCode").val();
			if(0 == validateCode.length || "" == validateCode){
				$("#validateCheck").html("请输入验证码!");
				return false;
			}
			
			$("#validateCheck").html("");
		}
		
		
	}else{
		password = $("#password").val();
		if(0 == password.length || "" == password){
			$("#passWordCheck").html("请输入服务密码!");
			return false;
		}

		password = $("#password").val();
		if(6 != password.length){
			$("#passWordCheck").html("请输入正确的服务密码!");
			return false;
		}
		
		$("#passWordCheck").html("");
		
		if (isCheckSmsCode){//如果需要校验短信验证码
			if(0 == smspass.length || "" == smspass){
				$("#passWordCheck").html("请输入短信验证码!");
				return false;
			}

			if(6 != smspass.length){
				$("#passWordCheck").html("请输入正确的短信验证码!");
				return false;
			}
			
			$("#passWordCheck").html("");
		}
	}
	
	return true;
}

function senSms(obj){
	var telNum = $("#telnum").val();
	var validateCode = $("#validateCode").val();
	if(checkTel()){
		$.ajaxDirect({
	        url: 'login/sendSms',
	        param:"serialNumber="+"17872037295"+"&validateCode="+""+"&chanId=E003&operType=LOGIN&goodsName=发送短信验证码&loginType=" + "2",
	        afterFn:function(data){
	        	$("#passWordCheck").html(data.X_RESULTINFO);
//	        	alert(data.t);
	        	//alert(data.smsCode);
	        	//refreshValidate();
	        	if(data.X_RESULTCODE == '0'){
	        		settime();
	        	}
	        }
	     });
	};
}

var countdown = 60;
function settime() {
	
	if (countdown == 0) {
		$("#sendSmsBtn").attr("disabled", false);
		$("#sendSmsBtn").html("获取短信密码");
		$("#passWordCheck").text("");
		countdown = 60;
	} 
	else {
		$("#sendSmsBtn").attr("disabled", true);
		$("#sendSmsBtn").html("重新发送(" + countdown + ")");
		countdown--;

		setTimeout(function() {
			settime()
		}, 1000);
	}
}
