<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div id="friend">
    	<div class="friend_t"><img src="images/friend_ico.gif" /></div>
        <div class="friend_list">
        	<ul>
            	<li><a href="#">中国政府网</a></li>
                <li><a href="#">中国政府网</a></li>
                <li><a href="#">中国政府网</a></li>
                <li><a href="#">中国政府网</a></li>
                <li><a href="#">中国政府网</a></li>
                <li><a href="#">中国政府网</a></li>
                <li><a href="#">中国政府网</a></li>
            </ul>
        </div>
    </div>
    <div id="footer">
    	<p>24小时客户服务热线：010-68988888  <a href="#">&nbsp;&nbsp;常见问题解答</a>&nbsp;&nbsp;  新闻热线：010-627488880</p>
        <p>文明办网文明上网举报电话：010-62748888 &nbsp;&nbsp;举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
        <p class="copyright">Copyright @ 1999-2009 News China gov. All Right Reserver</p>
      	<p>新闻中国版权所有</p>
    </div>
    
<div id="loginpages" style="z-index:99999;">
    <div id="smallpage">
        <div id="loginlogo">
            <div style="float:left;" class="loginee">
                <span id="ids">登录</span>
            </div>
            <div style="float:right;">
                <a href="javascript:hidenloginpage()">
                <img style="width:24px; height:24px;" src="images/close_delete_2.png" />
                </a>
            </div>
        </div>
        <hr style="border:1px solid #A6C9E1;width:100%" />
        <form id="loginForm" name="loginForm" action="users.action" method="post">
        	<input type="hidden" name="op" value="login"/>
            <dl>
                <div style="height:17px; overflow:hidden"></div>
                <dd>
                    <span class="titles">用户名：</span>
                    <input type="text" name="uname"	id="uname" onblur="checkloginuname()" /><span id="unamep">请输入昵称或邮箱</span>
                </dd>
                <br />
                <div style="height:17px; overflow:hidden"></div>
                <dd>
                    <span class="titles">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
                    <input type="password" name="pwd" id="pwd" onblur="checkloginpwd()" /><span id="pwdp">请输入您的密码</span>
                </dd>
            </dl>
            <div style="margin-left:70px; margin-bottom:10px;">
                <img alt="登录" src="images/loginss.png" onClick="userlogin()" style="margin-top:10px;float:left"/>
                <span style="margin-left:30px;float:left;margin-top:25px;">如果没有账号 <a href="javascript:showzc()">免费注册</a></span>
            </div>
        </form>
    </div>
</div>
<div id="zcpages">
    <div id="zcsmallpage">
        <div id="loginlogos">
            <div style="float:left;">
                <p id="ids">注册</p>
            </div>
            <div style="float:right;">
                <a href="javascript:hidenzcpage()"><img
                    style="width:25px; height:25px;" src="images/close_delete_2.png" />
                </a>
            </div>
        </div>
        <hr style="border:1px solid #A6C9E1;width:100%" />
        <form id="regForm" name="regForm" action="users.action" method="post">
        	<input type="hidden" name="op" value="reg"/>
            <dl>
                <div style="height:17px; overflow:hidden"></div>
                <label class="labelInfo" for="uname">用户名称：</label>
                <input type="text" name="uname" id="zcuname" onblur="checkzcuname()" />
                <p id="zcunamep">请输入您的昵称或注册邮箱(至少6位)</p>
                <label class="labelInfo" for="pwd">输入密码：</label>
                <input type="password" name="pwd" id="zcpwd" onblur="checkzcpwd()" />
                <p id="zcpwdp">请输入您的登录密码(至少6位)</p>
                <label class="labelInfo" for="pwdagain">重复密码：</label>
                <input type="password" name="pwdagain" id="zcpwdagain" onblur="checkzcpwdagain()" />
                <p id="zcpwdtwop">请重复输入您的登录密码(至少6位)</p>
                <label class="labelInfo" for="zcemail">输入邮箱：</label>
                <input type="text" name="email" id="zcemail" onblur="checkzcemail()" />
                <p id="zcemailp">请输入您的邮箱地址</p>
                <label class="labelInfo" for="zccode">验证码：</label>
                <input type="text" name="zccode" id="zccode" onblur="checkzccode()" style="font-size:14px; width:100px" />
                &nbsp;&nbsp;&nbsp;&nbsp;
                <img src="valiCodeImg.jsp" onclick="changeVilidateCode(this)" border="0" title="点击图片刷新验证码" size="10" />
                <p id="zccodep">请输入验证码</p>
            </dl>
            <div style="margin-left:30px;">
                <img alt="注册" src="images/zcss.png" onClick="userzc()" style="float:left"/>
                <span style="margin-left:20px;float:left;margin-top:15px;">如果已经有账号 <a href="javascript:showlogin()">马上登录</a></span> 
            </div>
        </form>
    </div>
</div> 
</body>
</html>
