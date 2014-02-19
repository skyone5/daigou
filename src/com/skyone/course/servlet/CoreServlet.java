package com.skyone.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skyone.course.util.SignUtil;

/**
 * ������������
 *
 * @author ybk
 * @date 2014-2-19
 */

public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreServlet() {
        super();
    }

	/**
	 * ȷ����������΢�ŷ�����
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ΢�ż���ǩ��
		String signature = request.getParameter("signature");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		// ����ַ���
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		
		// ͨ������signature��������м��飬��Ч��ɹ���ԭ������echostr����ʾ���ӳɹ��������ʾʧ��
		if(SignUtil.checkSignature(signature, timestamp, nonce))
			out.print(echostr);
		
		out.close();
		out = null;
	}

	/**
	 * ����΢�ŷ��������ص���Ϣ
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��Ϣ�Ľ��ա�������Ӧ
	}

}
