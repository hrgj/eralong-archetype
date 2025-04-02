#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${package}.dao.entity.CenterLineInfo;

/**
* @author Lenovo
* @description 针对表【center_line_info(分拨线路信息表)】的数据库操作Mapper
* @createDate 2025-03-28 16:07:07
* @Entity ${package}.dao.entity.CenterLineInfo
*/
public interface CenterLineInfoMapper extends BaseMapper<CenterLineInfo> {

    int deleteByPrimaryKey(Long id);

    int insert(CenterLineInfo record);

    int insertSelective(CenterLineInfo record);

    CenterLineInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CenterLineInfo record);

    int updateByPrimaryKey(CenterLineInfo record);

}
