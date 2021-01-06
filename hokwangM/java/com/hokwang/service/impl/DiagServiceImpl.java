package com.hokwang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokwang.dao.DiagMapper;
import com.hokwang.service.DiagService;
import com.hokwang.vo.BabyVO;
import com.hokwang.vo.BodyVO;
import com.hokwang.vo.DiagnosisVO;
import com.hokwang.vo.DiesSearch;
import com.hokwang.vo.DiseaseVO;
import com.hokwang.vo.MedicineVO;
import com.hokwang.vo.PrescriptionVO;
import com.hokwang.vo.Reservation;
import com.hokwang.vo.ResvSearch;

@Service
public class DiagServiceImpl implements DiagService{

	@Autowired
	DiagMapper service;
	
	@Override
	public Map<String, Object> getInfoList(Reservation vo) {
		return service.getInfoList(vo);
	}

	@Override
	public List<Map<String, Object>> getResvList(ResvSearch vo) {

		return service.getResvList(vo);
	}

	@Override
	public List<DiagnosisVO> getResvHistList(BabyVO vo) {
		return service.getResvHistList(vo);
	}

	@Override
	public Map<String, Object> getUniqInfo(Reservation vo) {
		return service.getUniqInfo(vo);
	}

	@Override
	public BodyVO getBodyList(BodyVO vo) {
		return service.getBodyList(vo);
	}

	@Override
	public DiagnosisVO getDiagDetail(DiagnosisVO vo) {

		return service.getDiagDetail(vo);
	}

	@Override
	public List<Map<String, Object>> getDiagDetail2(DiagnosisVO vo) {

		return service.getDiagDetail2(vo);
	}

	@Override
	public List<Map<String, Object>> getMedicine(PrescriptionVO vo) {
		
		return service.getMedicine(vo);
	}

	@Override
	public Map<String, Object> getDisease(DiesSearch vo) {
	
		return service.getDisease(vo);
	}

	@Override
	public Map<String, Object> schMedicine(DiesSearch vo) {
		
		return service.schMedicine(vo);
	}

	@Override
	public List<Map<String, Object>> getMedineList(MedicineVO vo) {
		
		return service.getMedineList(vo);
	}

}
