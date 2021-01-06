package com.hokwang.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hokwang.service.EmployeeService;
import com.hokwang.vo.EmployeeVO;
import com.hokwang.vo.MessageVO;
import com.hokwang.vo.TempmessageVO;

@Controller
public class MypageController {
	@Autowired
	EmployeeService dao;

	// 페이지이동
	@RequestMapping("/mypage") // .do 같은거
	public ModelAndView MypageForm(EmployeeVO empvo, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage");
		return mav;
	}

	// 등록페이지로 이동
	@GetMapping("/MypageInsert")
	public String MypageInsertForm() {
		return "user/insert";
	}

	@ResponseBody
	@RequestMapping("/ajax/getCountMsg")
	public int getCountMsg(Model model, EmployeeVO vo) {
		return dao.getCountMsg(vo);
	}

	@ResponseBody
	@RequestMapping("/ajax/showNotReadMsg")
	public List<MessageVO> showNotReadMsg(Model model, EmployeeVO vo) {
		return dao.showNotReadMsg(vo);
	}

	@ResponseBody
	@RequestMapping("/ajax/updateInf")
	public void updateInf(Model model, EmployeeVO vo) {
		System.out.println(vo);
		dao.updateInf(vo);
	}

	@ResponseBody
	@RequestMapping("/ajax/getTotalMsg")
	public List<MessageVO> getTotalMsg(Model model, EmployeeVO vo) {
		return dao.getTotalMsg(vo);
	}

	@ResponseBody
	@RequestMapping("/ajax/noReadTotalMsg")
	public List<MessageVO> noReadTotalMsg(Model model, EmployeeVO vo) {
		return dao.noReadTotalMsg(vo);
	}

	@ResponseBody
	@RequestMapping("/ajax/AllCntMsg")
	public Map<String, Object> AllCntMsg(Model model, EmployeeVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noread", dao.getCountMsg(vo));
		map.put("total", dao.getTotalCountMsg(vo));
		map.put("temp", dao.tempCountMsg(vo));
		map.put("send", dao.sendCountMsg(vo));
		map.put("empInf", dao.selectEmpInf(vo));
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/ajax/sendMsgInf")
	public boolean sendMsgInf(Model model, MessageVO vo) {
		dao.sendMsgInf(vo);
		return true;
	}
	
	@ResponseBody
	@RequestMapping("/ajax/tempMsgInf")
	public boolean tempMsgInf(Model model, TempmessageVO vo) {
		dao.tempMsgInf(vo);
		return true;
	}
	
	@ResponseBody
	@RequestMapping("/ajax/checkTemp")
	public TempmessageVO checkTemp(Model model, TempmessageVO vo) {
		TempmessageVO resultvo = new TempmessageVO();
		vo = dao.checkTemp(vo);
		if(vo != null) {
			return resultvo;			
		}
		else {
			return dao.checkTemp(vo);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
