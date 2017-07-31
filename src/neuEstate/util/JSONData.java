package neuEstate.util;

import com.google.gson.Gson;
import neuEstate.po.account.RespPageParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RuiPeng on 2017/7/31.
 * 用于和easyui进行ajax交互
 */
public class JSONData {
    public static String readJSONData(HttpServletRequest request) {
        StringBuffer json = new StringBuffer();
        String lineString = null;
        try {
            BufferedReader reader = request.getReader();
            while ((lineString = reader.readLine()) != null) {
                json.append(lineString);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }

    public static void writeJSONData(HttpServletResponse response, RespPageParam respPageParam, Integer successNum) {
        try {
            Gson gson = new Gson();
            if (successNum == null) {
                String json = gson.toJson(respPageParam);
                PrintWriter out = response.getWriter();
                out.write(json);
            } else {     //插入用户，仅返回成功数量
                String json = gson.toJson(successNum);
                PrintWriter out = response.getWriter();
                out.write(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
