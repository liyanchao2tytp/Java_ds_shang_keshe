package com.lyc.util;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.interfaces.*;
import java.util.*;

public class JWTUtil {
  private static String TOKEN = "token!@Lyc2tytp";

  /**
   * 生成token
   *
   * @param map 传入payload
   * @return 返回token
   */
  public static String getToken(Map<String, String> map) {
    Calendar instance = Calendar.getInstance();
    instance.add(Calendar.DATE, 7);   // 指定token 过期时间

    JWTCreator.Builder builder = JWT.create();
    map.forEach((k, v) -> {
      builder.withClaim(k, v);
    });
    builder.withExpiresAt(instance.getTime());
    return builder.sign(Algorithm.HMAC256(TOKEN)).toString();
  }

  /**
   * 获取token中的payload
   *
   * @param token
   * @return
   */
  public static DecodedJWT verify(String token) {
    return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
  }
}
