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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Nisheeth Shah
 */
@Entity
public class DatagridEntity implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private ActionDetailEntity actionDetailEntity;
    private Boolean showManageCOlumn;
    private Boolean showCheckBox;
    private Boolean draggable;
    private Boolean sortable;
    @ManyToOne
    private ActionDetailEntity addActionDetailEntity;
    @ManyToOne
    private ActionDetailEntity updateActionDetailEntity;
    @ManyToOne
    private ActionDetailEntity deleteActionDetailEntity;
    @OneToMany
    private List<DatagridColumnEntity> dataGridColumnEntities;

    public Boolean getDraggable() {
        return draggable;
    }

    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }

    public List<DatagridColumnEntity> getDataGridColumnEntities() {
        return dataGridColumnEntities;
    }

    public void setDataGridColumnEntities(List<DatagridColumnEntity> dataGridColumnEntities) {
        this.dataGridColumnEntities = dataGridColumnEntities;
    }

    public Boolean getSortable() {
        return sortable;
    }

    public void setSortable(Boolean sortable) {
        this.sortable = sortable;
    }

    public ActionDetailEntity getActionDetailEntity() {
        return actionDetailEntity;
    }

    public void setActionDetailEntity(ActionDetailEntity actionDetailEntity) {
        this.actionDetailEntity = actionDetailEntity;
    }

    public Boolean getShowManageCOlumn() {
        return showManageCOlumn;
    }

    public void setShowManageCOlumn(Boolean showManageCOlumn) {
        this.showManageCOlumn = showManageCOlumn;
    }

    public Boolean getShowCheckBox() {
        return showCheckBox;
    }

    public void setShowCheckBox(Boolean showCheckBox) {
        this.showCheckBox = showCheckBox;
    }

    public ActionDetailEntity getAddActionDetailEntity() {
        return addActionDetailEntity;
    }

    public void setAddActionDetailEntity(ActionDetailEntity addActionDetailEntity) {
        this.addActionDetailEntity = addActionDetailEntity;
    }

    public ActionDetailEntity getUpdateActionDetailEntity() {
        return updateActionDetailEntity;
    }

    public void setUpdateActionDetailEntity(ActionDetailEntity updateActionDetailEntity) {
        this.updateActionDetailEntity = updateActionDetailEntity;
    }

    public ActionDetailEntity getDeleteActionDetailEntity() {
        return deleteActionDetailEntity;
    }

    public void setDeleteActionDetailEntity(ActionDetailEntity deleteActionDetailEntity) {
        this.deleteActionDetailEntity = deleteActionDetailEntity;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DatagridEntity)) {
            return false;
        }
        DatagridEntity other = (DatagridEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.nisheeth.ejb.entity.DatagridEntity[ id=" + id + " ]";
    }

}
