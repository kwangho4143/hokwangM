package com.hokwang.service;

import java.util.List;
import java.util.Map;

import com.hokwang.vo.BabyVO;
import com.hokwang.vo.BodyVO;
import com.hokwang.vo.DiagnosisVO;
import com.hokwang.vo.PrescriptionVO;
public interface PatientService {
	public List<BabyVO> allpatientList(BabyVO vo);//전체환자 리스트
	public List<DiagnosisVO> diagnosisRecord(BabyVO vo);//진료기록
	public Map<String,Object> patientInfo(BabyVO vo);//환자상세정보
	
	public List<Map<String,Object>> mediName(PrescriptionVO vo);//상세진료 약이름내역
	public Map<String,Object> diagDetail1(DiagnosisVO vo);//상세진료1
	public Map<String,Object> diagDetail2(DiagnosisVO vo);//상세진료2
	
	public List<BodyVO> bodyInfo(BodyVO vo);//체중신장차트
}
