/**
 * 前台register页 JS文件
 * 
 * 创建时间：2016年11月9日 21:29:57
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','pace.min','modernizr.2.8','jquery.scrollUp.min','scrollup','bootstrap.min','dropdownlist','exitdialog.lib'],function (){
	createAgeComboBoxBindingSource($("#chooseAge"));

    var gender = DropDownList.create({
        select: $('#selectGender'),
        attrs: {
            column: 3,
            width: 550
        }
    });

    var age = DropDownList.create({
        select: $('#chooseAge'),
        attrs: {
            column: 5,
            width: 550
        }
    });
    
    //表单提交事件
    $("#registerForm").submit(function (){
		var flag;
		if (!ckAge()) {
			flag = false;
		}
		
		if (!ckGender()) {
			flag = false;
		}
		
		if (!ckPwdEqualsRePwd()) {
			flag = false;
		}
		return flag;
	});
	
	//验证性别
	function ckGender(){
		var $gender = $("select[name*='user.UGender']").next("div[class*='mod-dropdownlist']").children("a").children("span").children("nobr");
		if ($gender.text() == "--选择您的性别--") {
			$gender.parent("span").parent("a").css({"border-color":"red","border-width":"1px"});
			return false;
		}
		$gender.parent("span").parent("a").css({"border-color":"rgb(170,170,170)","border-width":"1px"});
		return true;
	}
	
	//验证年龄
	function ckAge(){
		var $age = $("select[name*='user.UAge']").next("div[class*='mod-dropdownlist']").children("a").children("span").children("nobr");
		if ($age.text() == "--选择您的年龄--") {
			$age.parent("span").parent("a").css({"border-color":"red","border-width":"1px"});
			return false;
		}
		$age.parent("span").parent("a").css({"border-color":"rgb(170,170,170)","border-width":"1px"});
		return true;
	}
	
	//验证密码和确认密码的一致性
	function ckPwdEqualsRePwd(){
		var pwd = $("#pwd").val();
		var repwd = $("#repwd").val();
		
		if (pwd !== repwd) {
			$("#pwd").css("border-color","red");
			$("#repwd").css("border-color","red");
			return false;
		}
		return true;
	}
});

function createAgeComboBoxBindingSource(controlId) {
    for (var i = 5; i <= 100; i++) {
        controlId.append("<option value='" + i + "'>" + i + "</option>");
    }
}