#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.upload.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${groupId}.base.page.BasePageBO;
import ${package}.dao.entity.CenterLineInfo;
import ${package}.manager.service.CenterLineInfoManagerService;
import ${package}.service.bo.CenterLineInfoBO;
import ${package}.service.convert.CenterLineInfoConvert;
import ${package}.service.param.CenterLineInfoQuery;
import ${package}.service.upload.CenterLineInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CenterLineInfoServiceImpl implements CenterLineInfoService {

    private final CenterLineInfoManagerService centerLineInfoManagerService;
    private final CenterLineInfoConvert centerLineInfoConvert;

    public CenterLineInfoServiceImpl(CenterLineInfoManagerService centerLineInfoManagerService, CenterLineInfoConvert centerLineInfoConvert) {
        this.centerLineInfoManagerService = centerLineInfoManagerService;
        this.centerLineInfoConvert = centerLineInfoConvert;

    }

    @Override
    public BasePageBO<CenterLineInfoBO> getCenterLineInfos(CenterLineInfoQuery query) {

        Page<CenterLineInfo> page = centerLineInfoManagerService.page(new Page<>(query.getCurrentPage(), query.getPageSize()), Wrappers.<CenterLineInfo>lambdaQuery()
                .like(query.getOrigCenterCode() != null, CenterLineInfo::getOrigCenterCode, query.getOrigCenterCode())
                .like(query.getOrigCenterName() != null, CenterLineInfo::getOrigCenterName, query.getOrigCenterName())
                .like(query.getDestCenterCode() != null, CenterLineInfo::getDestCenterCode, query.getDestCenterCode())
                .like(query.getDestCenterName() != null, CenterLineInfo::getDestCenterName, query.getDestCenterName())
                .like(query.getLineCode() != null, CenterLineInfo::getLineCode, query.getLineCode())
                .like(query.getLineName() != null, CenterLineInfo::getLineName, query.getLineName())
        );
        BasePageBO<CenterLineInfoBO> boBasePageBO = new BasePageBO<>();
        boBasePageBO.setTotalPage((int) page.getPages());
        boBasePageBO.setTotal((int) page.getTotal());
        boBasePageBO.setCurrentPage(query.getCurrentPage());
        boBasePageBO.setPageSize(query.getPageSize());

        boBasePageBO.setData(centerLineInfoConvert.convertBOList(page.getRecords()));
        return boBasePageBO;
    }
}