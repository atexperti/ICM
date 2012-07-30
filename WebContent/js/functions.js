var user_unique_id = null;
if ($.cookie('user_unique_id') == null) {
	$.cookie('user_unique_id', '<%=request.getAttribute("userUniuqeId") %>', {
		expires : 600,
		path : '/'
	});
	user_unique_id = $.cookie('user_unique_id');
} else {
	user_unique_id = $.cookie('user_unique_id');
}
siteAnalytics();

jQuery("#submitLogin").live("click", function(e) {
	var username = $('#userName').val();
	var password = $('#password').val();
	$.ajax({
		url : contextpath + 'ajax/login',
		method : "POST",
		data : {
			"userName" : username,
			"password" : password
		},
		success : function(data) {
			if (data.user != undefined && data.user != null) {
				$("#deviceModel").val(data.user.deviceId);
			}
		}
	});
});
validateLogin = function(form) {

	if (form.userName.value.trim().length == 0) {
		alert(register.username.error);
		return false;
	} else if (form.password.value.trim().length == 0) {
		alert(register.password.error);
		return false;
	} else
		return true;
};

validateContactUs = function(form) {

	if (form.comment.value.trim().length == 0) {

		alert(contactus.comment.error);
		form.comment.focus();
		return false;
	} else if (form.mobile.value.trim().length == 0) {
		alert(contactus.name.error);
		form.mobile.focus();
		return false;
	}else if (form.land1num.value.trim().length == 0) {
		alert(contactus.mobile.error);
		form.mobile.focus();
		return false;
	}  else if (form.email) {
		if (form.email.value.trim().length == 0) {
			alert(contactus.email.error);
			return false;
		} else if (!isValidEmail(form.email.value.trim())) {
			alert(contactus.email.invalid.error);
			return false;
		}
	} else
		return true;

};

validateRegister = function(form) {

	if (form.userBean_msisdn.value.trim().length == 0) {
		alert(order.mobile.erron);
		return false;
	} else if (form.userBean_userName.value.trim().length == 0) {
		alert(register.username.error);
		return false;
	} else if (form.userBean_password.value.trim().length == 0) {
		alert(register.password.error);
		return false;
	} else if (form.capchaCode.value.trim().length == 0) {
		alert(register.captcha.error);
		return false;
	} else if (form.userBean_email) {
		if (form.userBean_email.value.trim().length == 0) {
			alert(register.email.error);
			return false;
		} else if (!isValidEmail(form.userBean_email.value.trim())) {
			alert(register.email.not.valid);
			return false;
		}
	} else
		return true;
};
isValid = function(key) {
	var arr = [];
	arr = key.split('');
	var validChars = "0123456789";
	var validChar = true;
	for (i = 0; i < arr.length; i++) {
		if (validChars.indexOf(arr[i]) == -1)
			validChar = false;
	}
	return validChar;
};

isValidEmail = function(key) {
	var x = key;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
		return false;
	}
	return true;
};

validateOrder = function(form) {

	if (form.msisdnFirst.value.trim().length == 0) {
		alert(order.mobile.erron);
		form.msisdnFirst.focus();
		return false;
	} else if (!isValid(form.msisdnFirst.value.trim())) {
		alert(order.mobile.check);
		form.msisdnFirst.focus();
		return false;
	} else if (!((form.msisdnFirst.value.trim().length == 10) || (form.msisdnFirst.value.trim().length == 12))) {
		alert(order.msisdn.count);
		form.msisdnFirst.focus();
		return false;
	}
	/*
	 * if (form.msisdnSecond.value.trim().length == 0 ) { alert("Please enter
	 * mobile number "); form.msisdnSecond.focus(); return false; } else if
	 * (isNaN(form.msisdnSecond.value.trim())) { alert("Please enter number
	 * only"); form.msisdnSecond.focus(); return false; } else
	 * if(form.msisdnSecond.value.trim().length != 10) { alert("Mobile number
	 * must contain 10 numbers "); form.msisdnSecond.focus(); return false; }
	 */
	if (form.capchaCode.value.trim().length == 0) {
		alert(register.captcha.error);
		form.capchaCode.focus();
		return false;
	}
	/*
	 * if (form.msisdnFirst.value.trim() != form.msisdnSecond.value.trim()) {
	 * alert("Please enter same phone numbers"); return false; }
	 */
	return true;
};

function deviceSelected(val) {
	/*
	 * if (val.deviceMake.value==-1){ alert("Please select your device brand");
	 * return false; } if (val.deviceModelId.value==-1){ alert("Please select
	 * your device type"); return false; }
	 */
	return true;
}
deviceConfirm = function(form) {
	if (form.deviceMake.value == -1) {
		alert(device.brand.error);
		return false;
	}
	if (form.deviceId.value == -1) {
		alert(device.type.error);
		return false;
	}
	return true;
};
function loadDeviceModels(val, selectboxId) {

	/*
	 * if(val==-1){ //alert("Please select your device brand"); return false; }
	 */
	$.ajax({
		url : contextpath + '/ajax/devicemodels',
		method : "POST",
		data : {
			"deviceMake" : val
		},
		success : function(data) {

			if (data.deviceModels != undefined && data.deviceModels != null) {
				$("#" + selectboxId + "").empty();
				$("#" + selectboxId + "")
						.append(
								'<option value="-1" >' + device.type.text
										+ '</option>');
				$.each(data.deviceModels, function(key, value) {
					$("#" + selectboxId + "").append(
							'<option value="' + key + '" >' + value
									+ '</option>');
				});
			}
		}
	});
}
function siteAnalytics() {

	$.ajax({
		url : contextpath + '/ajax/analytics',
		method : "POST",
		data : {

			"pageName" : page_name,
			"pageId" : page_id,
			"sessionId" : session_id,
			"remoteIp" : remote_ip,
			"msisdn" : msisdn,
			"userAgent" : user_agent,
			"userUniuqeId" : user_unique_id
		},
		success : function(data) {

		}
	});
}
changeDevice = function(val) {

	$("#deviceForm").submit();
};
checkSerachKey = function(f) {

	if (f.searchWord.value.trim().length == 0) {
		alert(search.key.error);
		f.searchWord.focus();
		return false;
	} else if (f.searchWord.value.trim().length < 2) {
		alert(search.key.min.error);
		f.searchWord.focus();
		return false;
	} else if (f.searchWord.value.trim() == 'Enter Keyword (s)') {
		alert(search.key.error);
		f.searchWord.focus();
		return false;
	} else if (f.searchWord.value.trim() == 'Ingresa una palabra (s)') {
		alert(search.key.error);
		f.searchWord.focus();
		return false;
	}

	return true;
};
backToSearch = function(searchkey) {
	$("#searchForm input[value='searchWord']").val(searchkey);
	$("#searchForm").submit();
};
/**
 * Callback function that displays the content. Gets called every time the user
 * clicks on a pagination link.
 * 
 * @param {int}page_index
 *            New Page index
 * @param {jQuery}
 *            jq the container with the pagination links as a jQuery object
 */
function pageselectCallback(page_index, jq) {

	// Get number of elements per pagionation page
	var items_per_page = 8;
	var max_elem = Math.min((page_index + 1) * items_per_page, itemCount);
	// Iterate through a selection of the content and build an HTML string
	$('div[id^="itemNum"]').css("display", "none");

	for ( var i = page_index * items_per_page; i < max_elem; i++) {
		$('#itemNum' + i).css("display", "block");
	}
	// Prevent click eventpropagation
	return false;
}

function getOptionsFromForm() {
	var opt = {
		callback : pageselectCallback
	};

	// Number of items per page
	opt["items_per_page"] = 8;
	// Number of pagination links shown
	opt["num_display_entries"] = 4;
	// Number of start and end points
	opt["num_edge_entries"] = 1;
	// Previous label
	opt["prev_text"] = "Prev";
	// Next label
	opt["next_text"] = "Next";

	// Avoid html injections in this demo
	var htmlspecialchars = {
		"&" : "&amp;",
		"<" : "&lt;",
		">" : "&gt;",
		'"' : "&quot;"
	};
	$.each(htmlspecialchars, function(k, v) {
		opt.prev_text = opt.prev_text.replace(k, v);
		opt.next_text = opt.next_text.replace(k, v);
	});

	return opt;
};
$.i18n.properties({
	name : 'global',
	path : contextpath + '/properties/',
	mode : 'both',
	language : locale,
	callback : function() {
		/*
		 * We specified mode: 'both' so translated values will be available as
		 * JS vars/functions and as a map
		 * 
		 * Accessing a simple value through the map
		 * jQuery.i18n.prop('msg_hello'); Accessing a value with placeholders
		 * through the map jQuery.i18n.prop('msg_complex', ['John']);
		 * 
		 * Accessing a simple value through a JS variable alert(msg_hello +' '+
		 * msg_world); Accessing a value with placeholders through a JS function
		 * alert(msg_complex('John'));
		 */
	}
});

String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g, "");
};
String.prototype.ltrim = function() {
	return this.replace(/^\s+/, "");
};
String.prototype.rtrim = function() {
	return this.replace(/\s+$/, "");
};
// This adds 'placeholder' to the items listed in the jQuery .support object.
jQuery(function() {
	jQuery.support.placeholder = false;
	test = document.createElement('input');
	if ('placeholder' in test)
		jQuery.support.placeholder = true;
});
// This adds placeholder support to browsers that wouldn't otherwise support it.
$(function() {
	if (!$.support.placeholder) {
		var active = document.activeElement;
		$(':text').focus(
				function() {
					if ($(this).attr('placeholder') != ''
							&& $(this).val() == $(this).attr('placeholder')) {
						$(this).val('').removeClass('hasPlaceholder');
					}
				}).blur(
				function() {
					if ($(this).attr('placeholder') != ''
							&& ($(this).val() == '' || $(this).val() == $(this)
									.attr('placeholder'))) {
						$(this).val($(this).attr('placeholder')).addClass(
								'hasPlaceholder');
					}
				});
		$(':text').blur();
		$(active).focus();
		$('form:eq(0)').submit(function() {
			$(':text.hasPlaceholder').val('');
		});
	}
});
