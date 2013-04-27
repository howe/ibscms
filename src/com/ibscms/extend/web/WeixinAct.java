package com.ibscms.extend.web;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibscms.extend.Tool.EncoderHelper;

@Controller
public class WeixinAct {

	private static String TOKEN = "46f5e58a3ce31a2ebe502957ff4e8dad";
	/*
	 * 文字消息
	 */
	private static final String RESPONSE_TXT = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Content><![CDATA[%s]]></Content><FuncFlag>0</FuncFlag></xml>";
	/*
	 * 图文消息
	 */
	private static final String RESPONSE_IMAGE_TXT = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles><item><Title><![CDATA[%s]]></Title> <Description><![CDATA[%s]]></Description><PicUrl><![CDATA[%s]]></PicUrl><Url><![CDATA[%s]]></Url></item></Articles><FuncFlag>1</FuncFlag></xml>";

    @RequestMapping(value = "/weixin/verify.jspx", method = RequestMethod.GET)
    public String weixin(HttpServletRequest request, ModelMap model) {


    	String timestamp = request.getParameter("timestamp");
    	String signature = request.getParameter("signature");
    	String nonce = request.getParameter("nonce");
    	String echostr = request.getParameter("echostr");
		String[] array = {TOKEN, timestamp, nonce};
		Arrays.sort(array);
		String tmp = Arrays.toString(array);

		tmp = tmp.substring(1, tmp.length() - 1);
		tmp = tmp.replaceAll(",", "");
		tmp = tmp.replaceAll("\\s*", "");

		tmp = EncoderHelper.encode("SHA1", tmp);

		// System.out.println("signature1:" + signature);
		// System.out.println("signature2:" + tmp);

		if (tmp.equals(signature)) {
			// System.out.println("ok~~~" + echostr);
			return echostr;
		}
        return "";

    }

}
