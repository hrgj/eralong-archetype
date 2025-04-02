#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.request;

import ${groupId}.base.page.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CenterLineInfoRequest extends BaseQuery {

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
}
