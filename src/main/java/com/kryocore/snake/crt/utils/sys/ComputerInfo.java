package com.kryocore.snake.crt.utils.sys;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class ComputerInfo {

    /**
     * /**
     * 限制创建实例
     */
    private ComputerInfo() {

    }

    public static String execute(String command) {
        // 执行命令
        StringBuilder sb = new StringBuilder();
        try {
            Process process = runtime.exec(command);

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            for (String line = null; (line = bufReader.readLine()) != null; ) {
                sb.append(line);
            }

            process.destroy();
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String getUser() {
        return System.getProperty("user.name");
    }

    public static String getOSInfo() {
        return ComputerInfo.execute("uname -a");
    }

    public static String getOSVersion() {
        return System.getProperty("os.version");
    }

    public static String getOSName() {
        return System.getProperty("os.name");
    }

    private static Runtime runtime = Runtime.getRuntime();

    public static String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(osInfo());
        sb.append(diskInfo());
        return sb.toString();
    }

    public static String OSname() {
        return System.getProperty("os.name");
    }

    public static String OSversion() {
        return System.getProperty("os.version");
    }

    public static String OsArch() {
        return System.getProperty("os.arch");
    }

    public static long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }

    public static long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static String getFreeMemory() {
        long freeMemory = runtime.freeMemory();
        return Formatter.convertToStringRepresentation(freeMemory);
    }

    public static String getAllocatedMemory() {
        long allocatedMemory = runtime.totalMemory();
        return Formatter.convertToStringRepresentation(allocatedMemory);
    }

    public static String getMaxMemory() {
        long maxMemory = runtime.maxMemory();
        return Formatter.convertToStringRepresentation(maxMemory);
    }

    public static String osInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("OS: ");
        sb.append(OSname());
        sb.append(" ");
        sb.append(",Version: ");
        sb.append(OSversion());
        sb.append(" ");
        sb.append(": ");
        sb.append(OsArch());
        sb.append(" ");
        sb.append(",Available processors (cores): ");
        sb.append(runtime.availableProcessors());
        sb.append(" ");
        return sb.toString();
    }

    public static String diskInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
        StringBuilder sb = new StringBuilder();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            sb.append("File system root: ");
            sb.append(root.getAbsolutePath());
            sb.append(" ");
            sb.append(",Total space (bytes): ");
            sb.append(Formatter.convertToStringRepresentation(root.getTotalSpace()));
            sb.append(" ");
            sb.append(",Free space (bytes): ");
            sb.append(Formatter.convertToStringRepresentation(root.getFreeSpace()));
            sb.append(" ");
            sb.append(",Usable space (bytes): ");
            sb.append(Formatter.convertToStringRepresentation(root.getUsableSpace()));
        }

        return sb.toString();
    }

    public static boolean hasDesktop() {
        String home = System.getProperty("user.home");
        File file = new File(home + "/Desktop");
        return file.exists();
    }

    public static String getHostname() {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hostname;
    }

    public static String getIpv4() {

        String addr = null;
        Enumeration allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (java.net.SocketException e) {
            e.printStackTrace();
        }

        while (allNetInterfaces.hasMoreElements()) {

            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();

            System.out.println(netInterface.getName());

            Enumeration addresses = netInterface.getInetAddresses();

            while (netInterface.getName().equals("en0") && addresses.hasMoreElements()) {
                InetAddress ip = (InetAddress) addresses.nextElement();
                if ( ip != null && ip instanceof Inet4Address) {
                    if (ip.getHostAddress().equals("127.0.0.1")) {
                        continue;
                    }
                    System.out.println("IP = " + ip.getHostAddress());

                    addr = ip.getHostAddress();

                    return addr;
                }
            }

        }

        System.out.println("网络无连接！");

        return addr;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(getOSVersion());
        System.out.println(getOSName());
        System.out.println(getUser());

        System.out.println(diskInfo());
        System.out.println(osInfo());
//        System.out.println(MemInfo());

        System.out.println(getFreeMemory());

        System.out.println(getAllocatedMemory());

        System.out.println(getMaxMemory());

        System.out.println(hasDesktop());

        System.out.println(getHostname());

        System.out.println(info());

        System.out.println(getIpv4());
    }

}