#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.upload;

import ${groupId}.base.page.BasePageBO;
import ${package}.service.bo.CenterLineInfoBO;
import ${package}.service.param.CenterLineInfoQuery;

/**
* @author Lenovo
* @description 针对表【center_line_info(分拨线路信息表)】的数据库操作Service
* @createDate 2025-03-28 16:47:20
*/
public interface CenterLineInfoService  {

    BasePageBO<CenterLineInfoBO> getCenterLineInfos(CenterLineInfoQuery query);
}
