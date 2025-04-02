#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.convert;

import ${groupId}.base.page.BasePageBO;
import ${groupId}.base.page.BasePageVO;
import ${package}.service.bo.CenterLineInfoBO;
import ${package}.service.param.CenterLineInfoQuery;
import ${package}.web.request.CenterLineInfoRequest;
import ${package}.web.vo.CenterLineInfoVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CenterLineInfoVOConvert {
    CenterLineInfoQuery centerLineInfoQuery(CenterLineInfoRequest centerLineInfoRequest);

    BasePageVO<CenterLineInfoVO> convertToBasePageVO(BasePageBO<CenterLineInfoBO> boBasePageBO);
}
