/*
 * Copyright (C) 2015 Nisheeth Shah
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
package org.nisheeth.web.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nisheeth.ejb.entity.ModuleEntity;
import org.nisheeth.ejb.session.AbstractFacade;
import org.nisheeth.web.constant.ActionConstants;

/**
 *
 * @author Nisheeth Shah
 */
public class DataHelper {

    public void serveRequest(HttpServletRequest request, HttpServletResponse response) {
        int actionId = Integer.parseInt(request.getParameter("actionid"));
        EntityFacadeHelper entityFacadeHelper = new EntityFacadeHelper();
        AbstractFacade facade;
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            switch (actionId) {
                case 1: {
                    facade = entityFacadeHelper.lookupDataEJBEntityFacadeBean("DataEJBEntityFacade", "org.nisheeth.ejb.session.DataEJBEntityFacade");
                    response.setContentType("application/json");
                    out.write(facade.findRange(new int[]{0, 10}).toString());
                    break;
                }
                case ActionConstants.MODULE_ADD: {
                    facade = entityFacadeHelper.lookupDataEJBEntityFacadeBean("ModuleEntityFacade", "org.nisheeth.ejb.session.ModuleEntityFacade");
                    ModuleEntity moduleEntity = new ModuleEntity();
                    moduleEntity.setModuleName(request.getParameter("moduleName"));
                    moduleEntity.setModuleNameAbbr(request.getParameter("moduleAbbr"));
                    facade.create(moduleEntity);
                    out.write("success");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
