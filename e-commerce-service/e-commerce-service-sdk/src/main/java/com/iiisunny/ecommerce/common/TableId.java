package com.iiisunny.ecommerce.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <h1>主键 ids</h1>
 * */
@ApiModel(description = "通用 id 对象")
public class TableId {

    @ApiModelProperty(value = "数据表记录主键")
    private List<Id> ids;

    public TableId() {
    }

    public TableId(List<Id> ids) {
        this.ids = ids;
    }

    public List<Id> getIds() {
        return ids;
    }

    public void setIds(List<Id> ids) {
        this.ids = ids;
    }

    @ApiModel(description = "数据表记录主键对象")
    public static class Id {

        @ApiModelProperty(value = "数据表记录主键")
        private Long id;

        public Id() {
        }

        public Id(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
