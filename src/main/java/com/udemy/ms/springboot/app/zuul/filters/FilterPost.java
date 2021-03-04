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
//public class FilterPost extends ZuulFilter {
//
//	private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
//	
//	@Override
//	public boolean shouldFilter() {
//		return true;
//	}
//
//	@Override
//	public Object run() throws ZuulException {
//		log.info("Ejecucion de filtro POST");
//		RequestContext context = RequestContext.getCurrentContext();
//		HttpServletRequest request = context.getRequest();
//		Long tiempoInicio = (Long)request.getAttribute("tiempoInicio");
//		Long tiempoFin = System.currentTimeMillis();
//		Long tiempoTranscurrido = tiempoFin - tiempoInicio;
//		log.info(String.format("Tiempo de ejecucion en segundos: %s seg.", tiempoTranscurrido.doubleValue()/1000.00));
//		log.info(String.format("Tiempo transcurrido en milisegundos: %s miliseg.", tiempoTranscurrido));
//		return null;
//	}
//
//	@Override
//	public String filterType() {
//		return "post";
//	}
//
//	@Override
//	public int filterOrder() {
//		return 1;
//	}
//
//}
