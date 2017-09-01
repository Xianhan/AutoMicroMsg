package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.MessageDao;

/**
 * 维护相关业务功能
 * 
 * @author Calvin
 *
 */
public class MaintainService {
	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}

	/**
	 * 多条删除
	 */
	public void deleteBatch(String[] ids) {
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		for(String id:ids){
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
}
