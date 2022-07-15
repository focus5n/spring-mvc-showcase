package org.springframework.samples.mvc.mapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("ALL")
@RestController
public class MappingController {

	// ** RequestHeaders
	// Accept : text/plain, */*; q=0.01
	// X-CSRF-TOKEN : 950c78ef-8ea9-46d3-9e82-e47aa37a2ef6
	// X-Requested-With : XMLHttpRequest

	// ** ResponseHeaders
	// connection : keep-alive
	// contenth-length : 15 (공백, 특수문자 포함)
	// content-type : text/plain;charset=ISO-8859-1 (default)
	// date : Fri, 15 Jul 2022 15:04:00 GMT (아마도 sysdate)
	// keep-alive : timeout=60 (유지시간 아닐까?)

	// ** EntityHeaders
	// content-type
	// content-encoding

	// * text/plain
	// text: 텍스트를 포함하는 모든 문서
	// plain: html, css, js가 아님

	// * CSRF: Cross-site request forgery
	// 사용자의 의도와는 관계없이 사이트에 대한 공격을 가함
	// X-CSRF-TOKEN
	// CSRF 공격(사이트간 요청 위조)을 방지하기 위해서 CSRF Token을 헤더에 담아서 보냄

	// * X-Requested-With
	// 해당 요청이 Ajax라는 걸 의미함. (커스텀 헤더, 표준x)
	// jQuery, protoType을 포함한 대부분의 JS 라이브러리에서 Ajax 요청을 보낼 때 헤더에 이 값을 설정함.
	// 여기서 접두사 X는 표준이 아님을 나타냄.

	// * XMLHttpRequest (XHR)
	// XHR 객체는 서버와 상호작용할 때 사용함.
	// XHR 객체를 사용하면 새로고침 없이 URL에서 데이터를 가져올 수 있음.
	// 사용자의 작업을 방해하지 않고 페이지의 일부를 업데이트할 수 있음.
	// Ajax 프로그래밍에 많이 사용됨.
	// 이름에 XML이 들어가지만 XML을 포함한 모든 데이터를 가져올 수 있음.

	// * Asynchronous JavaScript + XML (Ajax)
	// 비동기적 자바스크립트 접근법
	// HTML 또는 XHTML, CSS, JavaScript, DOM, XML, XSLT, 그리고 제일 중요한 XMLHttpRequest 객체를
	// 비롯해 기존의 여러 기술을 사용하는 "새로운" 접근법.
	// 웹 어플리케이션은 전체 페이지를 새로 고칠 필요 없이 사용자 인터페이스에 빠르고 점진적인 업데이트를 적용가능.

	// * keep-alive
	// 연결에 대한 타임아웃(time/s), 요청 최대 개수 설정(max=number)

	// * connection
	// 현재의 전송이 완료된 후 네트워크 접속을 유지할지 말지를 제어.
	// keep-alive면, 연결은 지속되고 끊기지 않으며, 동일한 서버에 대한 후속 요청을 수행.
	// Connection 와 Keep-Alive 같은 연결-지정(Connection-specific) 헤더 필드들은 HTTP/2.에서
	// 금지되었습니다.
	// close: 클라이언트 혹은 서버가 연결을 닫으려고 하는 것
	@GetMapping("/mapping/path")
	public String byPath() {
		return "Mapped by path!";
	}

	@GetMapping("/mapping/path/*")
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@GetMapping("/mapping/method")
	public String byMethod() {
		return "Mapped by path + method";
	}

	@GetMapping(path = "/mapping/parameter", params = "foo")
	public String byParameter() {
		return "Mapped by path + method + presence of query parameter!";
	}

	@GetMapping(path = "/mapping/parameter", params = "!foo")
	public String byParameterNegation() {
		return "Mapped by path + method + not presence of query parameter!";
	}

	@GetMapping(path = "/mapping/header", headers = "FooHeader=foo")
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@GetMapping(path = "/mapping/header", headers = "!FooHeader")
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}

	@PostMapping(path = "/mapping/consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}

	@GetMapping(path = "/mapping/produces", produces = MediaType.APPLICATION_JSON_VALUE)
	public JavaBean byProducesJson() {
		return new JavaBean();
	}

	@GetMapping(path = "/mapping/produces", produces = MediaType.APPLICATION_XML_VALUE)
	public JavaBean byProducesXml() {
		return new JavaBean();
	}

}
