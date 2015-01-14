/*
 * Copyright (C) 2014 Nisheeth Shah
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.nisheeth.web.filter;

import java.io.IOException;
import java.util.Date;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nisheeth.ejb.entity.EventLogEntity;
import org.nisheeth.web.helper.JMSHelper;

/**
 *
 * @author Nisheeth Shah
 */
@WebFilter(urlPatterns = {"/controller*"})
public class RequestFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        EventLogEntity entity = new EventLogEntity();
        entity.setRequestURL(request.getRequestURL().toString());
        entity.setUserIP(request.getRemoteAddr());
        entity.setLogDate(new Date());
        System.out.println(request.getRemoteAddr());
        JMSHelper helper = new JMSHelper();
        try {
            helper.sendJMSMessageToEventMessage(entity);
        } catch (JMSException | NamingException ex) {
            ex.printStackTrace();
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
}
