#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.controller;

import ${groupId}.base.page.BasePageBO;
import ${groupId}.base.page.BasePageVO;
import ${package}.service.bo.CenterLineInfoBO;
import ${package}.service.param.CenterLineInfoQuery;
import ${package}.service.upload.CenterLineInfoService;
import ${package}.web.convert.CenterLineInfoVOConvert;
import ${package}.web.request.CenterLineInfoRequest;
import ${package}.web.vo.CenterLineInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/centerLine")
@Tag(name = "车线上传数据记录")
public class CenterLineInfoController {

    private final CenterLineInfoService centerLineInfoService;
    private final CenterLineInfoVOConvert centerLineInfoVOConvert;
    public CenterLineInfoController(CenterLineInfoService centerLineInfoService, CenterLineInfoVOConvert centerLineInfoVOConvert) {
        this.centerLineInfoService = centerLineInfoService;
        this.centerLineInfoVOConvert = centerLineInfoVOConvert;
    }
    @PostMapping("/list")
    @Operation(summary = "车线数据列表")
    public BasePageVO<CenterLineInfoVO> getCenterLineInfos(@RequestBody CenterLineInfoRequest request) {
        CenterLineInfoQuery query = centerLineInfoVOConvert.centerLineInfoQuery(request);

        BasePageBO<CenterLineInfoBO> boBasePageBO = centerLineInfoService.getCenterLineInfos(query);

        return centerLineInfoVOConvert.convertToBasePageVO(boBasePageBO);
    }
}
