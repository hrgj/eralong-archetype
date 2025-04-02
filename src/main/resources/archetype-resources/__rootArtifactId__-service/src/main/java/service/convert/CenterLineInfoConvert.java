#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.convert;


import ${package}.dao.entity.CenterLineInfo;
import ${package}.service.bo.CenterLineInfoBO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CenterLineInfoConvert {
    List<CenterLineInfoBO> convertBOList(List<CenterLineInfo> centerLineInfos);
}
