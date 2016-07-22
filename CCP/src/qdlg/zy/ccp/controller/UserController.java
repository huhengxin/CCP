package qdlg.zy.ccp.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qdlg.zy.ccp.bean.TestBean;
import qdlg.zy.ccp.bean.User;
import qdlg.zy.ccp.dao.RegionDAO;
import qdlg.zy.ccp.dao.StatisticDAO;
import qdlg.zy.ccp.dao.UserDAO;
import qdlg.zy.ccp.utils.VCode;
/**
 * 用户  
 * @author Administrator
 *
 */   
@Controller
@RequestMapping("/user")
public class UserController {
	private final static Logger logger = LoggerFactory
			.getLogger(UserController.class);
	@Resource
	private UserDAO userDAO;
	
	@Resource
	private RegionDAO regionDAO;
	
	@Resource
	private StatisticDAO statisticDAO;
	/**
	 * 导向 注册页面
	 * @return
	 */
	@RequestMapping("/registUI")
	public String registerUI(){
		return "/register/regist";
	}
	/**
	 * 注册方法
	 * @param model 返回页面参数
	 * @param user 页面封装的参数
	 * @return 返回的页面
	 */
	@RequestMapping("/regist")
	public String regist(Model model, User user){
		if(user!=null){
			//新注册用户 状态正常
			user.setState(1);
			// 使用MD5摘要加密，（先导包，commons-codec.jar）
			String md5passw = DigestUtils.md5Hex(user.getPassw());
			user.setPassw(md5passw);
			//添加用户到数据库
			//userDAO.add(user);
			//回传
			model.addAttribute("user", user);
			model.addAttribute("province", regionDAO.queryByParentCode("0"));
			return "/register/basicinfor";
		}else{
			return "/error";
		}	
	}

	/**
	 * 注册查重
	 * @param loginName 用户输入的登录名
	 * @return true or false
	 */
	@RequestMapping("/checkReg")
	@ResponseBody
	public boolean checkReg(String loginName){
	    //查重
		User u=userDAO.checkUser(loginName);
		if(u==null){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 获取图形验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getCaptcha")
	public void getCaptcha(HttpServletRequest request,HttpServletResponse response){
		VCode vc=new VCode();
		BufferedImage img= vc.getImage();
		//将code放入session
		request.getSession().removeAttribute("vcode");
		request.getSession().setAttribute("vcode", vc.getCode());
		//回传
		try {
			ImageIO.write(img, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			logger.info("异常信息：",e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * 验证输入的验证码
	 * @param request
	 * @param vode
	 * @return
	 */
	@RequestMapping("/checkCaptcha")
	@ResponseBody
	public boolean checkCaptcha(HttpServletRequest request,String vcode){
		String code=(String) request.getSession().getAttribute("vcode");
		if(code.equals(vcode)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 注册第二步，添加基本信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/addBasicInfor")
	public String addBasicInfor(Model model,User user){
		//添加基本信息  更新用户表
		//userDAO.addBasicInfor(user);
		//String code=regionDAO.queryCodeByRegion(user.getLocation());
		//更新 省市注册人数统计表
		//statisticDAO.updateNum(code);
		//查询注册的所有人数
		model.addAttribute("userSum", statisticDAO.getSum());	
		return "/register/finished";
		
	}
}
