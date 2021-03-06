/*  "java-webapp-foundation"(https://github.com/riversun/java-webapp-foundation)
 * 
 *  Easy to develop a micro Web Apps and Web APIs with JSP/Servlet
 * 
 *  Copyright (c) 2006-2017 Tom Misawa, riversun.org@gmail.com
 *  
 *  Permission is hereby granted, free of charge, to any person obtaining a
 *  copy of this software and associated documentation files (the "Software"),
 *  to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  and/or sell copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following conditions:
 *  
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 *  DEALINGS IN THE SOFTWARE.
 *  
 */
package webapp.pages;

import webapp.def.ServiceDef;
import webapp.framework.WebAppBaseController;
import webapp.pages.view01_login.LoginInfo;

/**
 * Base of controller class to manage user's login
 * 
 * @author Tom Misawa (riversun.org@gmail.com)
 *
 */
public abstract class UserStayController extends WebAppBaseController {

	/**
	 * Returns userInfo of logged-in user
	 * 
	 * @return
	 */
	public LoginInfo getUserInfo() {

		final LoginInfo loginInfo =
				(LoginInfo) session.getAttribute(ServiceDef.SESSION_KEY_LOGIN_INFO);

		return loginInfo;
	}

	/**
	 * Returns is user already logged-in
	 * 
	 * @return
	 */
	public boolean isUserLoggedIn() {
		return getUserId() != null;
	}

	/**
	 * Returns logged-in user's userId
	 * 
	 * @return
	 */
	public String getUserId() {

		LoginInfo userInfo = getUserInfo();
		if (userInfo != null) {
			return userInfo.userId;
		} else {
			return null;
		}

	}

	protected String getRawUserName() {

		LoginInfo userInfo = getUserInfo();
		if (userInfo != null) {
			return userInfo.userName;
		} else {
			return null;
		}

	}
}
