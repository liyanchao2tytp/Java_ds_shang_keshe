package com.dz.interceptor;

import com.auth0.jwt.exceptions.*;
import com.fasterxml.jackson.databind.*;
import com.dz.util.*;
import java.util.*;
import javax.servlet.http.*;
import org.springframework.web.servlet.*;

public class JWTInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    Map<String, Object> map = new HashMap<>();
    String token = request.getHeader("token");
    try {
      JWTUtil.verify(token); // 校验令牌
      return true;
    } catch (SignatureVerificationException e) {
      e.printStackTrace();
      map.put("msg", "无效签名");
    } catch (TokenExpiredException e) {
      e.printStackTrace();
      map.put("msg", "token过期");
    } catch (AlgorithmMismatchException e) {
      e.printStackTrace();
      map.put("msg", "token算法不一致");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("msg", "token无效");
    }
    map.put("state", false);

    String json = new ObjectMapper().writeValueAsString(map);
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().println(json);

    return false;

  }
}
