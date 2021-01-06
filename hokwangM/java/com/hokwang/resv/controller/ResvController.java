package com.hokwang.resv.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hokwang.service.ResvService;
import com.hokwang.vo.Images;
import com.hokwang.vo.PaymentVO;
import com.hokwang.vo.Reservation;
import com.hokwang.vo.ResvSearch;

@Controller
public class ResvController {
	@Autowired
	ResvService resvSvc;

	// 페이지 이동
	@RequestMapping("/resve")
	public ModelAndView resvForm(Reservation resv) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reserve");
		return mav;
	}

	// 전체 예약 리스트 조회
	@ResponseBody
	@RequestMapping("/ajax/resvList")
	public List<Map<String, Object>> getResvList(ResvSearch vo) {
		System.out.println("vo :: "+vo.getKeyword());
		return resvSvc.getResvList(vo);
	}

	// 선택된 환자 예약/진료 이력 리스트 조회
	@ResponseBody
	@RequestMapping("/ajax/resvHstList")
	public List<Map<String, Object>> getResvHistList(Reservation vo) {
		return resvSvc.getResvHistList(vo);
	}

	// 선택된 환자 상세 정보
	@ResponseBody
	@RequestMapping("/ajax/ptInfo")
	public Map<String, Object> getPtInfo(Reservation vo) {
		return resvSvc.getPtInfo(vo);
	}

	// 선택된 환자 특이사항 정보
	@ResponseBody
	@RequestMapping("/ajax/uniqInfo")
	public Map<String, Object> getUniqInfo(Reservation vo) {
		return resvSvc.getUniqInfo(vo);
	}

	// 미수납/수납대기 리스트 조회
	@ResponseBody
	@RequestMapping("/ajax/nonPayList")
	public List<Map<String, Object>> getNonPayList(ResvSearch vo) {
		return resvSvc.getNonPayList(vo);
	}

	// 진료 사진 관리(등록)
	@ResponseBody
	@RequestMapping("/ajax/imgInsert")
	public int imgInsert(HttpServletRequest request, Images vo) throws IllegalStateException, IOException {
		System.out.println("imgInsert>>");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("imgInput");
		if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
			String path = request.getSession().getServletContext().getRealPath("/resources/img"); // 업로드할 경로
			// getOriginalFilename : 업로드 후 파일명
			multipartFile.transferTo(new File(path, multipartFile.getOriginalFilename()));
			vo.setImg_addr(multipartFile.getOriginalFilename());
			System.out.println("imgAddr : "+vo.getImg_addr());
		}
		return resvSvc.imgInsert(vo);
	}

	// 진료 사진 관리(삭제)
	@ResponseBody
	@RequestMapping("/ajax/imgDelete")
	public int imgDelete(@RequestParam("delArr[]") List<String> deleArr, Images vo) {
		System.out.println("imgDelete>>");
		int result = 0;
		for(String i : deleArr) {
			System.out.println("imgNo : "+i);
			vo.setImg_no(i);
			resvSvc.imgDelete(vo);
			result = 1;
		}
		
		return result;
	}
	
	// 진료 사진 관리(조회)
	@ResponseBody
	@RequestMapping("/ajax/imgList")
	public List<Map<String, Object>> getImgList(Images vo) {
		return resvSvc.getImgList(vo);
	}

	// 대기자 조회
	@ResponseBody
	@RequestMapping("/ajax/roomList")
	public List<Map<String, Object>> getRoomList() {
		return resvSvc.getRoomList();
	}

	// 수납 승인 결제 정보
	@ResponseBody
	@RequestMapping("/ajax/payInfo")
	public Map<String, Object> getPayInfo(PaymentVO vo) {
		return resvSvc.getPayInfo(vo);
	}

	// 수납 상태 수정(대기 -> 완료)
	@ResponseBody
	@RequestMapping("/ajax/payUpdate")
	public int payUpdate(PaymentVO vo) {
		return resvSvc.payUpdate(vo);
	}

	// 진료실 수정
	@ResponseBody
	@RequestMapping("/ajax/roomUpdate")
	public int roomUpdate(Reservation vo) {
		System.out.println("roomUpdate>>");
		return resvSvc.roomUpdate(vo);
	}
}
