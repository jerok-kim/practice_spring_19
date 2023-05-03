## [최주호] 스프링 강의 - 세션과 쿠키

### Session, Cookie

클라이언트의 요청에 대한 응답을 반환하기 전에 세션을 생성하고 클라이언트에게 세션 ID를 제공한다.

클라이언트는 이 세션 ID를 사용하여 다음 요청에서 서버에 대한 자신의 식별자로 사용한다.

세션은 기본적으로 서버 메모리에 저장되며, 필요한 경우 외부 저장소에 저장할 수 있습니다.

반면 쿠키는 클라이언트 측에서 상태를 유지한다.

서버는 요청에 대한 응답에서 쿠키를 생성하고 클라이언트에게 제공한다.

클라이언트는 이 쿠키를 저장하고, 다음 요청에서 해당 쿠키를 서버에게 전달하여 자신을 식별한다.

세션과 쿠키는 모두 상태를 유지하는 데 사용된다.

그러나 세션은 보안성이 높으며, 클라이언트에 대한 정보를 서버 측에서 유지하기 때문에 쿠키보다 더 많은 정보를 저장할 수 있다.

반면 쿠키는 클라이언트 측에서 저장되기 때문에, 서버에서 세션을 생성하는 것보다 더 빠르고 간단하다.

스프링 부트에서는 세션과 쿠키 모두를 사용할 수 있다.

세션은 `HttpSession` 객체를 사용하여 관리하고, 쿠키는 `javax.servlet.http.Cookie` 클래스를 사용하여 생성 및 관리할 수 있다.

세션은 모든 유저가 공유하는 메모리 영역이기 때문에 IoC 컨테이너에서 의존성 주입을 할 수도 있고, `DispatcherServlet`에서 메서드 파라메터로 직접 의존성 주입 받을 수 도 있다.

### JSessionID

`JSESSIONID`는 웹 애플리케이션에서 세션을 구분하는 데 사용되는 식별자이다.

`JSESSIONID`는 클라이언트가 서버에 최초 요청을 보낼 때, 서버에서 생성되며, 서버에서 유지되는 세션 ID이다.

클라이언트는 `JSESSIONID`를 쿠키 형태로 저장하고, 이후 요청에서는 `JSESSIONID`를 서버에게 전달하여 해당 클라이언트의 세션을 식별한다.

`JSESSIONID`는 Java Servlet 스펙에 정의된 이름으로, Java 웹 어플리케이션 서버인 Tomcat, Jetty 등에서 기본적으로 사용된다.

`JSESSIONID`는 클라이언트와 서버 간의 통신에서 중요한 역할을 한다.

예를 들어, 사용자가 로그인하면 서버는 사용자를 구분하기 위해 `JSESSIONID`를 생성하고, 이후의 모든 요청에서 이 세션 ID를 사용하여 사용자의 상태를 유지한다.

`JSESSIONID`는 기본적으로 쿠키를 사용하여 클라이언트에 저장된다.

만약 클라이언트가 쿠키를 지원하지 않는 경우에는 URL 리다이렉션을 통해 `JSESSIONID`를 전달한다.

이러한 경우에는 URL 뒤에 `JSESSIONID`를 추가하여 전달한다.

`JSESSIONID`는 기본적으로 안전하지 않은 형태로 전달된다.

따라서 HTTPS 프로토콜을 사용하거나, `JSESSIONID`를 암호화하거나, `JSESSIONID`를 포함한 쿠키를 `HttpOnly` 속성을 설정하여 XSS 공격으로부터 보호할 필요가 있다.

### CORS

CORS(Cross-Origin Resource Sharing)는 웹 브라우저에서 실행되는 스크립트가 다른 도메인의 리소스에 접
근할 때 적용되는 보안 정책이다.

일반적으로, 웹 브라우저는 보안상의 이유로 자바스크립트에서 다른 도메인의 리소스에 접근하는 것을 허용하지 않는다.

이를 Same-Origin Policy라고 부른다.

CORS 정책은 이러한 Same-Origin Policy를 우회할 수 있는 방법을 제공한다.

서버 측에서는 리소스에 대한 요청 헤더에 허용할 도메인을 명시하여, 해당 도메인에서의 요청에 한해 리소스 접근을 허용할 수 있다.

CORS 정책은 다음과 같은 방식으로 동작한다.

1. 브라우저에서 웹 페이지가 로드되면, 자바스크립트에서 다른 도메인의 리소스를 요청한다.
2. 서버는 요청 헤더에 Origin이 포함된 요청을 받는다.
3. 서버는 해당 Origin이 허용된 도메인인지 확인한다.
4. 허용된 도메인일 경우, 서버는 응답 헤더에 Access-Control-Allow-Origin을 포함하여, 해당 도메인에서의 요청에 한해 리소스 접근을 허용한다.
5. 브라우저는 Access-Control-Allow-Origin 헤더를 확인하고, 허용된 도메인에서의 요청에 한해 리소스에
   접근한다.

CORS 정책은 보안상의 이유로 브라우저에서 실행되는 스크립트에만 적용되며, 서버 간 통신에는 적용되지 않는다.

따라서, 서버 간 API 호출 등에서는 다른 방법으로 보안을 구성해야 한다.

### XSS 공격

### CSRF 토큰

### 인증 서버 실습

### 쿠키 실습
