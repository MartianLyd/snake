package com.kryocore.snake.crt.agent.dto;

import java.io.Serializable;

/**
 * Created by kryocore on 2018/10/01.
 */
public class SystemInfo implements Serializable{

    String name;//
    String ip_lan;//
    String ip;//
    String hasDesktop;//
    String sys_user_name;//
    String sys_version;//
    String sys_name;//
    String sys_release;//
    String mem_free;//
    String mem_usage;//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp_lan() {
        return ip_lan;
    }

    public void setIp_lan(String ip_lan) {
        this.ip_lan = ip_lan;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHasDesktop() {
        return hasDesktop;
    }

    public void setHasDesktop(String hasDesktop) {
        this.hasDesktop = hasDesktop;
    }

    public String getSys_user_name() {
        return sys_user_name;
    }

    public void setSys_user_name(String sys_user_name) {
        this.sys_user_name = sys_user_name;
    }

    public String getSys_version() {
        return sys_version;
    }

    public void setSys_version(String sys_version) {
        this.sys_version = sys_version;
    }

    public String getSys_name() {
        return sys_name;
    }

    public void setSys_name(String sys_name) {
        this.sys_name = sys_name;
    }

    public String getSys_release() {
        return sys_release;
    }

    public void setSys_release(String sys_release) {
        this.sys_release = sys_release;
    }

    public String getMem_free() {
        return mem_free;
    }

    public void setMem_free(String mem_free) {
        this.mem_free = mem_free;
    }

    public String getMem_usage() {
        return mem_usage;
    }

    public void setMem_usage(String mem_usage) {
        this.mem_usage = mem_usage;
    }


    @Override
    public String toString() {
        return "SystemInfo{" +
                "name='" + name + '\'' +
                ", ip_lan='" + ip_lan + '\'' +
                ", ip='" + ip + '\'' +
                ", hasDesktop='" + hasDesktop + '\'' +
                ", sys_user_name='" + sys_user_name + '\'' +
                ", sys_version='" + sys_version + '\'' +
                ", sys_name='" + sys_name + '\'' +
                ", sys_release='" + sys_release + '\'' +
                ", mem_free='" + mem_free + '\'' +
                ", mem_usage='" + mem_usage + '\'' +
                '}';
    }
}
