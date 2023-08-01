package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.service.GuestbookService;
import com.ict.model.vo.GuestbookVO;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	public GuestbookService getGuestbookService() {
		return guestbookService;
	}

	public void setGuestbookService(GuestbookService guestbookService) {
		this.guestbookService = guestbookService;
	}



	@GetMapping("/guestbook_list.do")
	public ModelAndView getGuestbookList() {
		ModelAndView mv = new ModelAndView("guestbook/guestbookList");
		List<GuestbookVO> list = guestbookService.guestbookList();
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/guestbook_write.do")
	public ModelAndView writeGuestbook() {
		return new ModelAndView("guestbook/write");	
	}
	
	@PostMapping(value = "/guestbook_writeOK.do")
	public ModelAndView writeOkGuestbook(GuestbookVO gvo) {
		ModelAndView mv = new ModelAndView("redirect:/guestbook_list.do");
		int result = guestbookService.addGuestbook(gvo);
		// 여기에 그림도 같이 넣어서 보내줘야함
		return mv;
		
	}
	
	@GetMapping("/guestbook_onelist.do")
	public ModelAndView getOneList(GuestbookVO gvo) {
		ModelAndView mv = new ModelAndView("guestbook/oneList");
		//guestbookService.getGuestbookOneList();
		return null;
		
	}
	
}
