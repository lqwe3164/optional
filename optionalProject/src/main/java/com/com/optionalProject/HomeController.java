package com.com.optionalProject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("logger.info");
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.debug("logger.debug");
		logger.warn("logger.warn");
		logger.error("logger.error");
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(Locale locale, Model model) {
		String result = "�ȳ��ϼ���";
		Optional<String> opt = Optional.ofNullable(result);
		logger.info("opt111:"+opt);
		opt = Optional.of(result);
		logger.info("opt222:"+opt);
		
		 result = null;
		opt = Optional.ofNullable(result);  // Null�� ���  "Optional.empty"
		logger.info("opt3333:"+opt); 
		Optional<String> opt2 = Optional.of("opt2");
		opt2 = opt2.ofNullable(null);
		logger.info("null isPresent:"+opt2.isPresent()); 
		result="dd";
		logger.info("isPresent:"+opt2.isPresent()); 
		
		if("Optional.empty".equals(opt.toString())) {
			logger.warn("opt�� null�Դϴ�. ");
		}
		
		Optional<String> opt33 = Optional.ofNullable("�ڹ� Optional ��ü");
		if(opt33.isPresent()) {

			logger.info(opt33.get());

		}
		
//		[start] orElse 
//		Optional�� ��� �ִ� ��ü�� null�� ��쿡 ����� �� �ִ� ���� ��ȯ�ϴ� �޼����Դϴ�. 
		
//		Optional<String> opt44 = Optional.ofNullable("null");
		Optional<String> opt44 = Optional.ofNullable("�� �ƴմϴ�.");
		String str_opt44 = opt44.orElse("���Դϴ�.");
		logger.info("str_opt44 :"+str_opt44);
		
//		[end] orElse 
		
//		[start] orElseGet
//		orElse�� ����������, �ٸ� ���� �޼��带 ���ڷ� �ް� �Լ����� ��ȯ�� ���� ��ȯ�ϰ� �Ǿ� �ֽ��ϴ�.
		
//		Optional<String> opt5 = Optional.ofNullable(null);
//		String str_opt5 = opt5.orElseGet(elseGet());
//		logger.info("str_opt44 :"+str_opt5);
		
//		[end] orElseGet 

		
		
	}
	
//	private String elseGet() {
//		String str= "dd";
//		return str;
//	}
	
	
	
}
