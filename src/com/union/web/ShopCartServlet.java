package com.union.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.union.model.Goods;
import com.union.model.ShopCart;
import com.union.service.GoodsService;
import com.union.service.GoodsServiceImpl;
import com.union.service.ShopCartService;
import com.union.service.ShopCartServiceImpl;

public class ShopCartServlet extends HttpServlet {

	HttpServletRequest request = null;
	HttpServletResponse response = null;
	ShopCartService shopCartService = new ShopCartServiceImpl();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;

		String name = request.getPathInfo().substring(1);
		try {
			Method method = ShopCartServlet.class.getMethod(name, null);
			method.invoke(this, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addShopCart() {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		String userIdStr = (String) session.getAttribute("userId");
		ShopCart shopCart = new ShopCart();
		shopCart.setGoodsId(goodsId);
		shopCart.setName(name);
		GoodsService goodsService = new GoodsServiceImpl();
		Goods goods = goodsService.selectGoods(goodsId);
		shopCart.setPrice(goods.getPrice());
		if (userIdStr == null) {
			shopCart.setUserId(0);
		} else {
			shopCart.setUserId(Integer.parseInt(userIdStr));
		}
 		shopCartService.addShopCart(shopCart);
//		try {
//			request.getRequestDispatcher("/shopCart/showAllShopCart").forward(request,
//					response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		showAllShopCart();
	}

	public void showAllShopCart() {

		List<ShopCart> shopCartList = shopCartService.showAllShopCart();

		request.setAttribute("shopCartList", shopCartList);

		try {
			request.getRequestDispatcher("/checkout.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	// public void showGoods()
	// {
	// int id = Integer.parseInt(request.getParameter("id"));
	// Goods goods = goodsService.selectGoods(id);
	// if(goods!=null)
	// {
	// request.setAttribute("goods", goods);
	// try {
	// request.getRequestDispatcher("/single.jsp").forward(request, response);
	// } catch (ServletException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// }
}
