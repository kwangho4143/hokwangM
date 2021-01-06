package com.hokwang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokwang.dao.ResvMapper;
import com.hokwang.service.ResvService;
import com.hokwang.vo.Images;
import com.hokwang.vo.PaymentVO;
import com.hokwang.vo.Reservation;
import com.hokwang.vo.ResvSearch;

@Service
public class ResvServiceImpl implements ResvService {

	@Autowired
	ResvMapper resvDao;

	@Override
	public List<Map<String, Object>> getResvList(ResvSearch vo) {
		return resvDao.getResvList(vo);
	}

	@Override
	public List<Map<String, Object>> getResvHistList(Reservation vo) {
		return resvDao.getResvHistList(vo);
	}

	@Override
	public Map<String, Object> getPtInfo(Reservation vo) {
		return resvDao.getPtInfo(vo);
	}

	@Override
	public Map<String, Object> getUniqInfo(Reservation vo) {
		return resvDao.getUniqInfo(vo);
	}

	@Override
	public List<Map<String, Object>> getNonPayList(ResvSearch vo) {
		return resvDao.getNonPayList(vo);
	}

	@Override
	public int imgInsert(Images vo) {
		return resvDao.imgInsert(vo);
	}

	@Override
	public List<Map<String, Object>> getImgList(Images vo) {
		return resvDao.getImgList(vo);
	}

	@Override
	public int imgDelete(Images vo) {
		return resvDao.imgDelete(vo);
	}

	@Override
	public List<Map<String, Object>> getRoomList() {
		return resvDao.getRoomList();
	}

	@Override
	public Map<String, Object> getPayInfo(PaymentVO vo) {
		return resvDao.getPayInfo(vo);
	}

	@Override
	public int payUpdate(PaymentVO vo) {
		return resvDao.payUpdate(vo);
	}

	@Override
	public int roomUpdate(Reservation vo) {
		return resvDao.roomUpdate(vo);
	}
}
