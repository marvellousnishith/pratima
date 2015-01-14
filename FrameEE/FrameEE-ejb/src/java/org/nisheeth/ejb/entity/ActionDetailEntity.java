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
package org.nisheeth.ejb.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Nisheeth Shah
 */
@Entity
public class ActionDetailEntity implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @ManyToOne
    private ModuleEntity moduleEntity;
    @ManyToOne
    private SubModuleEntity subModuleEntity;
    private Boolean listing;
    @ManyToOne
    private ActionTypeEntity actionTypeEntity;
    @ManyToOne
    private DataEJBEntity dataEJBEntity;
    @OneToOne
    private ResponseDetailEntity responseDetailEntity;
    @OneToMany
    private List<ResponseMessageDetailEntity> responseMessageDetailEntities;

    public DataEJBEntity getDataEJBEntity() {
        return dataEJBEntity;
    }

    public void setDataEJBEntity(DataEJBEntity dataEJBEntity) {
        this.dataEJBEntity = dataEJBEntity;
    }

    public ResponseDetailEntity getResponseDetailEntity() {
        return responseDetailEntity;
    }

    public void setResponseDetailEntity(ResponseDetailEntity responseDetailEntity) {
        this.responseDetailEntity = responseDetailEntity;
    }

    public ActionTypeEntity getActionTypeEntity() {
        return actionTypeEntity;
    }

    public void setActionTypeEntity(ActionTypeEntity actionTypeEntity) {
        this.actionTypeEntity = actionTypeEntity;
    }

    public List<ResponseMessageDetailEntity> getResponseMessageDetailEntities() {
        return responseMessageDetailEntities;
    }

    public void setResponseMessageDetailEntities(List<ResponseMessageDetailEntity> responseMessageDetailEntities) {
        this.responseMessageDetailEntities = responseMessageDetailEntities;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ModuleEntity getModuleEntity() {
        return moduleEntity;
    }

    public void setModuleEntity(ModuleEntity moduleEntity) {
        this.moduleEntity = moduleEntity;
    }

    public SubModuleEntity getSubModuleEntity() {
        return subModuleEntity;
    }

    public void setSubModuleEntity(SubModuleEntity subModuleEntity) {
        this.subModuleEntity = subModuleEntity;
    }

    public Boolean getListing() {
        return listing;
    }

    public void setListing(Boolean listing) {
        this.listing = listing;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ActionDetailEntity)) {
            return false;
        }
        ActionDetailEntity other = (ActionDetailEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.nisheeth.ejb.entity.ActionDetailEntity[ id=" + id + " ]";
    }

}
