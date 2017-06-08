/**
 * jquery 라이브러리의 일부 기능 구현
 */

function mlec(val) {
	
	// val이 만약 function 이라면 window.onload에 callback 등록
	if (typeof(val) == "function") {
		window.onload = val;
		return;
	}
	
	var ch = val.charAt(0);
	var elements;
	switch(ch) {
	case "#":
		elements = document.querySelector(val);
		break;
	case "<" :
		elements = document.createElement(val.substring(1,val.length-1));
		break;
	default:
		elements = document.querySelectorAll(val);
		break;
	}
	elements.attr = function(name, value) {
		// 만약, name이 object라면
		// 객체 안의 key와 value 값을 꺼내서 속성 설정해야 함
		
		console.dir(this);
		
		if (typeof(name) == "object") {
			// 배열인 경우
			if (this.length){
				for (var i = 0; i < this.length; i++) {
					for (var key in name) {
						this[i].setAttribute(key, name[key]);
					}
				}
			}// 배열이 아닌경우
			else {
				for (var key in name) {
					this.setAttribute(key, name[key]);
				}
			}
			return this;
		}
		// 객체가 아닌 경우
		else {
			// 배열인 경우
			if (this.length){
				
				if (value != undefined){
					for (var i = 0; i < this.length; i++) {
						this[i].setAttribute(name, value);
					}
					return this;
				}
				return this[0].getAttribute(name);
			}// 배열이 아닌경우
			else {
				if (value != undefined) {
					this.setAttribute(name,value);
					return this;
				}
				return this.getAttribute(name);
			}
			
		}
		
	};
	
	elements.html = function(html) {
		
		if (this.length){
			
			if (html != undefined){
				for (var i = 0; i < this.length; i++) {
					this[i].innerHTML = html;
				}
				return this;
			}
			return this[0].innerHTML;
		}// 배열이 아닌경우
		else {
			if (html != undefined) {
				this.innerHTML = html;
				return this;
			}
			return this.innerHTML;
		}
		
		
	};
	
	elements.text = function(text) {
		
		if (this.length){
			
			if (text != undefined){
				for (var i = 0; i < this.length; i++) {
					this[i].innerText = text;
				}
				return this;
			}
			return this[0].innerText;
		}// 배열이 아닌경우
		else {
			if (text != undefined) {
				this.innerText = text;
				return this;
			}
			return this.innerText;
		}
		
		
	};

	/*
	 *  $("#test").val("aaa");
	 *  $("#test").val();
	 */
	elements.val = function(value) {
		
		if (this.length){
			
			if (value != undefined){
				for (var i = 0; i < this.length; i++) {
					this[i].value = value;
				}
				return this;
			}
			return this[0].value;
		}// 배열이 아닌경우
		else {
			if (value != undefined) {
				this.value = value;
				return this;
			}
			return this.value;
		}
		
		
	};
	
	elements.remove = function() {
		
		if (this.length){
			for (var i = 0; i < this.length; i++) {
				this[i].parentNode.removeChild(this[i]);
			}
			
		}// 배열이 아닌경우
		else {
			this.parentNode.removeChild(this);
		}
		
		
	};
	
	elements.focus = function() {
		if (this.length) {
			this[0].focus();
		}
		else {
			this.focus();
		}
		return this;
	};
	
	elements.select = function() {
		if (this.length) {
			this[0].select();
		}
		else {
			this.select();
		}
		return this;
	};
	
	elements.prop = function(name, value) {
		
		if (this.length){
			for (var i = 0; i < this.length; i++) {
				this[i][name] = value;
			}
			return this;
		}// 배열이 아닌경우
		else {
				this[name] = value;
				return this;
		}
	};
	
	// 이벤트 설정
	elements.on = function(eventType, callback) {
		if (this.length){
			for (var i = 0; i < this.length; i++) {
				this[i].addEventListener(eventType, callback);
			}
		}// 배열이 아닌경우
		else {
				this.addEventListener(eventType, callback);
		}
		return this;
	};
	
	elements.click = function(callback) {
		return this.on("click", callback);
		
	}
	
	return elements;
}

var $ = mlec;