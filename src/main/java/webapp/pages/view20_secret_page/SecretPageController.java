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
package webapp.pages.view20_secret_page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import webapp.def.PageDef;
import webapp.framework.Controller;
import webapp.framework.ControllerFactoryServlet;
import webapp.models.SecretInfo;
import webapp.pages.UserStayController;

/**
 * Controller Servlet class for displaying secret page <br>
 * 
 * @author Tom Misawa (riversun.org@gmail.com)
 *
 */
@SuppressWarnings("serial")
@WebServlet(name = "secret_page", urlPatterns = { PageDef.SERVLET_PATH_SECRET_PAGE })
public class SecretPageController extends ControllerFactoryServlet {

	@Override
	public Class<? extends Controller> mapController() {
		return SecretPageControllerImpl.class;
	}

	/**
	 * Controller impl class
	 * 
	 * @author Tom Misawa (riversun.org@gmail.com)
	 *
	 */
	public static class SecretPageControllerImpl extends UserStayController {
		private static final Log LOG = LogFactory.getLog(SecretPageControllerImpl.class);

		@Override
		public void doService() throws ServletException, IOException {

			// Example:Send content type as UTF-8 html
			setContentTypeTo_HTML_UTF8();

			// Example:Get query parameter as a string
			String query = asString("query");

			// Store data to the list object.
			final List<SecretInfo> secretInfoList = new ArrayList<SecretInfo>();

			for (int i = 0; i < 10; i++) {
				SecretInfo si = new SecretInfo();
				si.setSecretName("secret name-" + i);
				si.setSecretAddress("secret address-" + i);
				secretInfoList.add(si);
			}

			// Example:Put object into "request"
			requestScope("secretInfoList", secretInfoList);

			dispatch(PageDef.SECRET_PAGE_JSP);

		}

	}

}
