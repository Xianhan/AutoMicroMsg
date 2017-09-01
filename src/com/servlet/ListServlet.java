package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Message;
import com.service.QueryService;

/**
 * 列表页面初始化控制
 * @author Calvin
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//向页面传值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		QueryService listService = new QueryService();
		//System.out.println(messageList.toString());
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
}
