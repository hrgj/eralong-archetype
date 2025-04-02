#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.manager.service;


import com.baomidou.mybatisplus.extension.service.IService;
import ${package}.dao.entity.CenterLineInfo;

/**
* @author Lenovo
* @description 针对表【center_line_info(分拨线路信息表)】的数据库操作Service
* @createDate 2025-03-28 16:32:51
*/
public interface CenterLineInfoManagerService extends IService<CenterLineInfo> {

}
