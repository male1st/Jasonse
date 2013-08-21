package com.jason.se.simple.reflect;


public class Proxy {  
	/*  private static final String url = "http://www.proxycn.com/html_proxy/30fastproxy-1.html";  
    private static Map<String, String> ipMap = new HashMap<String, String>();  
    private static final String filePath = "D:/sts/workspace-sts-2.5.1_t1/sf3a/src/main/resources/proxy.properties";  
  
   public static Map<String, String> getProxyMap() {  
        String html = "";  
        boolean flag = true;  
        while (flag) {  
            try {  
                html = HttpclientUtil.get(url, null, "GB2312");  
                flag = false;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        Document doc = Jsoup.parse(html);  
        Elements trs = doc.select("tr[onDblClick]");  
        for (Element e : trs) {  
            String ip = e.attr("onDblClick").replaceAll("clip", "")  
                    .replaceAll("已拷贝到剪贴板!", "").replaceAll("alert", "")  
                    .replaceAll("'", "").replaceAll(";", "")  
                    .replaceAll("\\(", "").replaceAll("\\)", "");  
            String[] ipArray = ip.split(":");  
            ipMap.put(ipArray[0], ipArray[1]);  
        }  
        return ipMap;  
    }  
  
    public static void writeValidProxy() {  
        Map<String, String> ipMap = getProxyMap();  
        System.out.println("本次共获取到的:" + ipMap.size() + "个代理");  
        for (String ip : ipMap.keySet()) {  
            String port = ipMap.get(ip);  
            System.out.println("获取新的待检验的:" + ip + "=" + port);  
            boolean flag = HttpclientUtil.checkProxy(ip, port);  
            if (flag) {  
                System.out.println("写入有效:" + ip + "=" + port);  
                PropertiesUtil.writeProperties(filePath, ip, port);  
            } else {  
                System.out.println("移除失效:" + ip + "=" + port);  
                PropertiesUtil.removeProperties(filePath, ip);  
            }  
        }  
    }  
  
    public static Map<String, String> getValidProxyMap() {  
        return PropertiesUtil.readProperties(filePath);  
    }  
  
    public static void removeInvalidProxy() {  
        Map<String, String> ipMap = getValidProxyMap();  
        for (String ip : ipMap.keySet()) {  
            String port = ipMap.get(ip);  
            System.out.println("校验原有:" + ip + "=" + port);  
            boolean flag = HttpclientUtil.checkProxy(ip, port);  
            if (!flag) {  
                System.out.println("移除失效:" + ip + "=" + port);  
                PropertiesUtil.removeProperties(filePath, ip);  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        while (true) {  
            try {  
                removeInvalidProxy();  
                writeValidProxy();  
                Thread.sleep(1000 * 60 * 30);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  */
}  