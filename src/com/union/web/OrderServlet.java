package com.union.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.union.model.Order;
import com.union.service.OrderService;
import com.union.service.OrderServiceImpl;
import com.union.service.ShopCartService;
import com.union.service.ShopCartServiceImpl;

public class OrderServlet extends HttpServlet {

	HttpServletRequest request = null;
	HttpServletResponse response = null;

	OrderService orderService = new OrderServiceImpl();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;

		String name = request.getPathInfo().substring(1);
		try {
			Method method = OrderServlet.class.getMethod(name, null);
			method.invoke(this, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commitOrder() {

		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		HttpSession session = request.getSession();

		session.setAttribute("username", "超哥");
		session.setAttribute("realname", "邵超");
		session.setAttribute("commitTime", "2016-12-23");
		session.setAttribute("address", "天府三街");
		session.setAttribute("status", "0");
		Order order = new Order(0, (String) session.getAttribute("username"),
				(String) session.getAttribute("realname"),
				(String) session.getAttribute("commitTime"),
				(String) session.getAttribute("address"),
				(String) session.getAttribute("status"));
		order.setGoodsId(goodsId);

		try {
			if (orderService.commitOrder(order)) {
				request.getRequestDispatcher("/success.jsp").forward(request,
						response);
			} else {
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
