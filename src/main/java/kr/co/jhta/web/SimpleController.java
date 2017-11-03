package kr.co.jhta.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class SimpleController {

	@RequestMapping("/home.do")
	// HandlerMapping이 @RequestMapping에 있는 요청을 읽어 현재의 controller와 연결지어 
	// dispatcher servlet에게 요청에 대해 어떤 controller로 이동할지 알려준다
	// 반환값이 String이면 이동할 페이지라고 인식
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/users.do")
	// model객체를 매개변수로 받아 전달할 값을 저장하고 jsp에 전송 가능
	// model에 담은걸 request.setAttribute로 옮겨준다
	public String getUsers(Model model) {
		
		model.addAttribute("title", "영업부 사원리스트");
		model.addAttribute("data", "2017년 10월 기준");
		model.addAttribute("users", Arrays.asList("홍길동", "김유신", "강감찬"));
		//List<Users> currentUserList = userService.getCurrentUsers();
		//model.addAttribute("users", currentUserList);
		
		return "userlist.jsp";
	}
	
	// 옛날방식
	@RequestMapping("/about.do")
	public ModelAndView about() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("quest1", "화장실은 어디인가요?");
		mav.addObject("quest2", "비상계단은 어디에 있나요?");
		mav.addObject("quest3", "구급약품은 어디에 있나요?");
		
		mav.setViewName("about.jsp");
		
		return mav;
	}
}
