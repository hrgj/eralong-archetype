#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.param;

import ${groupId}.base.page.BaseQuery;
import lombok.Data;

@Data
public class CenterLineInfoQuery extends BaseQuery {

    private String origCenterCode;
    private String origCenterName;
    private String destCenterCode;
    private String destCenterName;
    private String lineName;
    private String lineCode;
}
