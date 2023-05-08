package cn.tedu.csmall.commons.restful;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JsonPage<T> implements Serializable {

    // 当前类时Page\PageInfo类的代替,也是需要既能保存分页数据,也能保存分页信息
    // 分页信息方面,Page\PageInfo分页信息属性很多,原则是声明我们能用到的
    // 分页信息其实主要是前端需要,我们后端代码只负责查询,我们先声明几个最基本的,以后有需要再添加
    @ApiModelProperty(value = "总页数",name="totalPages")
    private Integer totalPages;
    @ApiModelProperty(value = "总条数",name="totalCount")
    private Long totalCount;
    @ApiModelProperty(value = "页码",name="page")
    private Integer page;
    @ApiModelProperty(value = "每页条数",name="pageSize")
    private Integer pageSize;

    // JsonPage中保存分页数据对象
    @ApiModelProperty(value = "分页数据",name="list")
    private List<T> list;

    // 下面要编写一个方法,实现将PageInfo类型转换为JsonPage类型
    // 如果还需要别的转换方法(例如将SpringData分页中的Page类型转换成JsonPage),再另外编写即可
    public static <T> JsonPage<T> restPage(PageInfo<T> pageInfo){
        // 因为BeanUtils.copyProperties方法是为同名属性赋值的
        // 又因为JsonPage类和PageInfo类中的属性名基本都不同,所以我们使用手动编写代码赋值转换
        JsonPage<T> jsonPage=new JsonPage<>();
        jsonPage.setTotalCount(pageInfo.getTotal());
        jsonPage.setTotalPages(pageInfo.getPages());
        jsonPage.setPage(pageInfo.getPageNum());
        jsonPage.setPageSize(pageInfo.getPageSize());
        jsonPage.setList(pageInfo.getList());
        // 转换完成后返回jsonPage对象
        return jsonPage;

    }


}
