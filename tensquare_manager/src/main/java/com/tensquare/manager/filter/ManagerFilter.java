package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.tensquare.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 优先级   数字越大  优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否开启该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("Zuul过滤器");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }

        String s = request.getRequestURL().toString();
        //如果是登录页面
        if (s.indexOf("/admin/login") > 0) {
            System.out.println("登录页面: " + s);
            return null;
        }

        //获取头信息
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(authorization) && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null) {
                if ("admin".equals(claims.get("role"))) {
                    currentContext.addZuulRequestHeader("Authorization",authorization);
                    System.out.println("token验证通过,添加头信息" + authorization);
                    return null;
                }
            }
        }
        //终止运行
        currentContext.setSendZuulResponse(false);
        //http状态码
        currentContext.setResponseStatusCode(401);
        //返回消息
        currentContext.setResponseBody("无权访问");
        //设置对应的编码格式
        currentContext.getResponse().setContentType("text/html;charset=UTF-8");
        return null;
    }
}
