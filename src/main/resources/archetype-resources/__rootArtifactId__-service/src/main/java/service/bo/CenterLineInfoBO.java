#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.bo;

import lombok.Data;

import java.util.Date;

/**
 * 分拨线路信息表
 * @TableName center_line_info
 */
@Data
public class CenterLineInfoBO {
    /**
     * id
     */
    private Long id;

    /**
     * 始发分拨编号
     */
    private String origCenterCode;

    /**
     * 始发分拨名称
     */
    private String origCenterName;

    /**
     * 目的分拨编号
     */
    private String destCenterCode;

    /**
     * 目的分拨名称
     */
    private String destCenterName;

    /**
     * 运输线路编号
     */
    private String lineName;

    /**
     * 运输线路名称
     */
    private String lineCode;

    /**
     * 分拨间公里数
     */
    private Integer km;

    /**
     * 运行时间
     */
    private Integer runTime;

    /**
     * 目的分拨省份编号
     */
    private String destProvinceCode;

    /**
     * 目的分拨省份名称
     */
    private String destProvinceName;

    /**
     * 目的分拨城市编号
     */
    private String destCityCode;

    /**
     * 目的分拨城市名称
     */
    private String destCityName;

    /**
     * 始发分拨省份编号
     */
    private String origProvinceCode;

    /**
     * 始发分拨省份名称
     */
    private String origProvinceName;

    /**
     * 始发分拨城市编号
     */
    private String origCityCode;

    /**
     * 始发分拨城市名称
     */
    private String origCityName;

    /**
     * 长短线类型编号
     */
    private Integer lineTypeCode;

    /**
     * 长短线类型编号
     */
    private String lineTypeName;

    /**
     * 创建网点编号
     */
    private String createSiteCode;

    /**
     * 创建网点名称
     */
    private String createSiteName;

    /**
     * 创建用户编号
     */
    private String createUserCode;

    /**
     * 创建用户名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 数据版本号
     */
    private Integer versionNo;

    /**
     * 修改用户编号
     */
    private String modifyUserCode;

    /**
     * 修改用户名称
     */
    private String modifyUserName;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改网点编号
     */
    private String modifySiteCode;

    /**
     * 修改网点名称
     */
    private String modifySiteName;
}