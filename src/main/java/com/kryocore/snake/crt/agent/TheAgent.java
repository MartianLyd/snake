package com.kryocore.snake.crt.agent;

import com.kryocore.snake.crt.agent.dto.SystemInfo;
import com.kryocore.snake.crt.utils.sys.ComputerInfo;


/**
 * Created by lvshimin on 2017/7/13.
 */
public class TheAgent {


    public static final String TAG = "TheAgent";

    Long agentId;

    public Long getAgentId() {
        return agentId;
    }

    private static TheAgent ourInstance = new TheAgent();

    public static TheAgent getInstance() {
        return ourInstance;
    }

    private TheAgent() {

    }

    /**
     * 获取系统信息
     *
     * @return
     */
    public SystemInfo getSystemInfo() {
        SystemInfo info = new SystemInfo();

        info.setIp_lan(ComputerInfo.getIpv4());

        String user = ComputerInfo.getUser();
        String hostname = ComputerInfo.getHostname();

        info.setName(user + "@" + hostname);

        info.setHasDesktop(String.valueOf(ComputerInfo.hasDesktop()));

        info.setMem_free(ComputerInfo.getFreeMemory());

        info.setMem_usage(ComputerInfo.getAllocatedMemory());

        info.setSys_name(hostname);

        info.setSys_version(ComputerInfo.getOSVersion());

        info.setSys_release(ComputerInfo.osInfo());

        info.setSys_user_name(user);

        return info;
    }

    String json = "{\"payload\":{\"agentId\":5,\"rules\":[{\"id\":130,\"sourceId\":2,\"sourceName\":\"今日头条\",\"agentId\":5,\"agentIp\":\"10.0.0.21\",\"taskInterval\":120000},{\"id\":135,\"sourceId\":8,\"sourceName\":\"搜狐新闻\",\"agentId\":5,\"agentIp\":\"10.0.0.21\",\"taskInterval\":120000},{\"id\":138,\"sourceId\":1,\"sourceName\":\"微信公众号\",\"agentId\":5,\"agentIp\":\"10.0.0.21\",\"taskInterval\":900000},{\"id\":144,\"sourceId\":16,\"sourceName\":\"Zaker\",\"agentId\":5,\"agentIp\":\"10.0.0.21\",\"taskInterval\":120000},{\"id\":146,\"sourceId\":15,\"sourceName\":\"中国青年报\",\"agentId\":5,\"agentIp\":\"10.0.0.21\",\"taskInterval\":1800000},{\"id\":147,\"sourceId\":18,\"sourceName\":\"中国经济网\",\"agentId\":5,\"agentIp\":\"10.0.0.21\",\"taskInterval\":1800000},{\"id\":160,\"sourceId\":30,\"sourceName\":\"新快报\",\"agentId\":5,\"agentIp\":\"10.0.0.21\",\"taskInterval\":900000}]},\"success\":true,\"msg\":null,\"code\":-1,\"timestamp\":1500689926}";

    /**
     * 注册
     * @param agentTask
     */
    public void register2master(AgentTask agentTask) {
        agentTask.execute();
    }
}
