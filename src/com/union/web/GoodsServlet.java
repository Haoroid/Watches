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
	GoodsService goodsService = new GoodsServiceImpl();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;

		String name = request.getPathInfo().substring(1);
		try {
			Method method = GoodsServlet.class.getMethod(name, null);
			method.invoke(this, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showAllGoods() {

		List<Goods> goodsList = goodsService.showAllGoods();

		request.setAttribute("goodsList", goodsList);

		try {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showGoods() {
		int id = Integer.parseInt(request.getParameter("id"));
		Goods goods = goodsService.selectGoods(id);
		if (goods != null) {
			request.setAttribute("goods", goods);
			try {
				request.getRequestDispatcher("/single.jsp").forward(request,
						response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void categoryGoods() {
		String tag = request.getParameter("tag");
		List<Goods> goodsList = goodsService.categoryGoods(tag);
		request.setAttribute("goodsList", goodsList);

		try {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
