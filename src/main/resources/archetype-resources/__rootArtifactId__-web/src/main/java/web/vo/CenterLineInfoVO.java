#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.vo;


import java.io.Serializable;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CenterLineInfoVO implements Serializable {
    @Schema(description="id")
    private Long id;
    @Schema(description="始发分拨编号")
    private String origCenterCode;
    @Schema(description="始发分拨名称")
    private String origCenterName;
    @Schema(description="目的分拨编号")
    private String destCenterCode;
    @Schema(description="目的分拨名称")
    private String destCenterName;
    @Schema(description="运输线路编号")
    private String lineName;
    @Schema(description="运输线路名称")
    private String lineCode;
    @Schema(description="分拨间公里数")
    private Integer km;
    @Schema(description="运行时间")
    private Integer runTime;
    @Schema(description="目的分拨省份编号")
    private String destProvinceCode;
    @Schema(description="目的分拨省份名称")
    private String destProvinceName;
    @Schema(description="目的分拨城市编号")
    private String destCityCode;
    @Schema(description="目的分拨城市名称")
    private String destCityName;
    @Schema(description="始发分拨省份编号")
    private String origProvinceCode;
    @Schema(description="始发分拨省份名称")
    private String origProvinceName;
    @Schema(description="始发分拨城市编号")
    private String origCityCode;
    @Schema(description="始发分拨城市名称")
    private String origCityName;
    @Schema(description="长短线类型编号")
    private Integer lineTypeCode;
    @Schema(description="长短线类型编号")
    private String lineTypeName;
    @Schema(description="创建网点编号")
    private String createSiteCode;
    @Schema(description="创建网点名称")
    private String createSiteName;
    @Schema(description="创建用户编号")
    private String createUserCode;
    @Schema(description="创建用户名称")
    private String createUserName;
    @Schema(description="创建时间")
    private Date createTime;
    @Schema(description="数据版本号")
    private Integer versionNo;
    @Schema(description="修改用户编号")
    private String modifyUserCode;
    @Schema(description="修改用户名称")
    private String modifyUserName;
    @Schema(description="修改时间")
    private Date modifyTime;
    @Schema(description="修改网点编号")
    private String modifySiteCode;
    @Schema(description="修改网点名称")
    private String modifySiteName;
}
