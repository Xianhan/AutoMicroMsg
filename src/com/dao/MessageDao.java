package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.bean.Message;
import com.db.DBAccess;

/**
 * 和message表相关的操作
 * @author Calvin
 *
 */
public class MessageDao {

	/**
	 * 根据查询条件查询消息列表
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(String command,String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			//通过sqlSession执行sql
			messageList = sqlSession.selectList("Message.queryMessageList",message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	/**
	 * 单条删除
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行sql
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行sql
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
	}
	
//	public static void main(String[] args) {
//		MessageDao messageDao = new MessageDao();
//		messageDao.queryMessageList("", "");
//		Map<String, Message> messageMap = new HashMap<String, Message>();
//		messageMap.put("key",new Message());
//		Logger log = null;
//		log.debug("adf");
//		log.warn(messageMap);
//		log.error(messageMap);
//		
//	}
//	public List<Message> queryMessageList(String command,String description) throws Exception{
//	Class.forName("com.mysql.jdbc.Driver");
//	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","123456");
//	StringBuilder sql = new StringBuilder("select id,command,description,content from message where 1=1");
//	List<String> paramList = new ArrayList<String>();
//	List<Message> messageList = new ArrayList<Message>();
//	if(command!=null &&!"".equals(command.trim())) {
//		sql.append(" and command=?");
//		paramList.add(command);
//	}
//	if(description!=null &&!"".equals(description.trim())) {
//		sql.append(" and description like '%' ? '%' ");
//		paramList.add(description);
//	}
//	
//	PreparedStatement statement = conn.prepareStatement(sql.toString());
//	for (int i = 0;i < paramList.size();i++) {
//		statement.setString(i+1,paramList.get(i));
//	}
//	ResultSet rs = statement.executeQuery();
//	while (rs.next()){
//		Message message = new Message();
//		messageList.add(message);
//		message.setId(rs.getString("id"));
//		message.setCommand(rs.getString("command"));
//		message.setDescription(rs.getString("description"));
//		message.setContent(rs.getString("content"));
//	}
//	return messageList;
//}
}
