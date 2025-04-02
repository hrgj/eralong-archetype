#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.model;


import java.time.LocalDateTime;

public class InstallMysql {
    private Long id;
    private String serverName;
    private String ipAddress;
    private String mysqlVersion;
    private String installPath;
    private String port;
    private String rootPassword;
    private LocalDateTime installDate;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
