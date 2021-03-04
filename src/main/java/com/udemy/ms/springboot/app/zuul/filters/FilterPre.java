//package com.udemy.ms.springboot.app.zuul.filters;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//
//@Component
//public class FilterPre extends ZuulFilter {
//
//	private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
//	
//	@Override
//	public boolean shouldFilter() {
//		// Se implementa alguna logica para decidir en que momentos se ejecuta el filter, true ejecuata filter.
//		return true;
//	}
//
//	@Override
//	public Object run() throws ZuulException {
//		RequestContext context = RequestContext.getCurrentContext();
//		HttpServletRequest request = context.getRequest();
//		log.info(String.format("%s request a %s", request.getMethod(), request.getRequestURL().toString()));
//		long tiempoInicio = System.currentTimeMillis();
//		request.setAttribute("tiempoInicio", tiempoInicio);
//		return null;
//	}
//
//	@Override
//	public String filterType() {
//		return "pre";
//	}
//
//	@Override
//	public int filterOrder() {
//		return 1;
//	}
//
//}
