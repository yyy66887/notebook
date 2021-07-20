package cn.com.jspdi;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * Created by charmyyy on 2021/7/19.
 */
public class testShiro {
    public static void main(String[] args) {
        //1.创建安全管理器对象
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //2.给安全管理器设置realm
        defaultSecurityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        //设置安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //获取令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");

        subject.is
        try {
            System.out.println(subject.isAuthenticated());
            subject.login(token);
            System.out.println(subject.isAuthenticated());

        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            e.printStackTrace();
        }catch (UnknownAccountException e){
            System.out.println("无此用户");
            e.printStackTrace();
        }

    }
}
