package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService gs;
	
	//리스트폼
	@RequestMapping(value = "/addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		List<GuestbookVo> gb = gs.exeList();
		
		model.addAttribute("gb", gb);
		
		return "addList";
	}
	
	//등록
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute GuestbookVo gv) {
		
		gs.exeWrite(gv);
		
		return "redirect:/addlist";
	}
	
	//삭제폼
	@RequestMapping(value = "/deleteform", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		
		return "deleteForm";
	}
	
	//삭제
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo gv) {
		
		gs.exeDelete(gv);
		
		return "redirect:/addlist";
	}
	
}
