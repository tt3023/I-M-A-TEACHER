package org.myteacher.servlets;

import org.apache.log4j.Logger;
import org.myteacher.client.HttpClients;
import org.myteacher.contants.Params;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by yh on 17-2-8.
 */
@WebServlet(name = "ServletNgnix")
public class ServletNgnix extends HttpServlet {
    private static final Logger Log = Logger.getLogger(ServletNgnix.class);
    private String result="";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //普通的IO流去读前段的数据
        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        StringBuffer sb = new StringBuffer("");
        String temp;
        while((temp = br.readLine()) != null){
            sb.append(temp);
        }
        String acceptJson = sb.toString();
        Log.debug("acceptJson is "+acceptJson);
        br.close();

        //准备请求的url
        String url = Params.NETTY_ADDRESS;
        String encoding = Params.JSON_ENCODING;

        Log.debug("url "+url+"encoding "+encoding);
        HttpClients httpClients=new HttpClients();

        try {
           result = httpClients.send(url,acceptJson,encoding);
        } catch (Exception e) {
            Log.error("system error is"+e);
        }

        PrintWriter pw = response.getWriter();
        pw.write(result);
        pw.flush();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
