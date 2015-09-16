package first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

	// Log4j의 Log 객체를 log라는 이름으로 생성.
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	/**
	 * 후처리기: controller → client
	 * 컨트롤러가 실행되고 난 후에 호출.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled()){
			log.debug("======================================           END          ======================================\n");
		}
	}

	/**
	 * 전처리기: client → controller
	 * 컨트롤러가 실행되기 전에 호출.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled()){
			log.debug("======================================          START         ======================================");
            log.debug(" Request URI \t:  " + request.getRequestURI());
		}
		
		return super.preHandle(request, response, handler);
	}
	
	
}
