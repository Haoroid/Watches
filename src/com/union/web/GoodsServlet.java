package com.union.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.union.model.Goods;
import com.union.service.GoodsService;
import com.union.service.GoodsServiceImpl;

public class GoodsServlet extends HttpServlet {

	HttpServletRequest request = null;
	 HttpServletResponse response = null;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	this.request = request;
	this.response = response;
	
	String name  = request.getPathInfo().substring(1);
	try {
		Method method = GoodsServlet.class.getMethod(name, null);
		method.invoke(this,null);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public void showAllGoods()
	{
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> goodsList = goodsService.showAllGoods();
		
		request.setAttribute("goodsList", goodsList);
		
		System.out.println(goodsList.size() + goodsList.get(0).getName());
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
