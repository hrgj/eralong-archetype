#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package}.dao.entity.CenterLineInfo;
import ${package}.dao.mapper.CenterLineInfoMapper;
import ${package}.manager.service.CenterLineInfoManagerService;
import org.springframework.stereotype.Service;

@Service
public class CenterLineInfoManagerServiceImpl extends ServiceImpl<CenterLineInfoMapper, CenterLineInfo> implements CenterLineInfoManagerService {
}