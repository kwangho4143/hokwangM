package com.hokwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Test;



public class ApiExplorer {
	@Test
	public void apiTest() throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/msupCmpnMeftInfoService/getMajorCmpnNmCdList"); /*URL*/
        urlBuilder.append("?ServiceKey=" + URLEncoder.encode("9WNgCMAquzZlWmN4n%2Fn2noX%2FYPGO6FK5FMU8Jh0XgryTTRUlglPOn14fxnTwaL8CMtu2%2FEy3kglKLsnuxRCNgQ%3D%3D","UTF-8")); /*Service Key*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
       // conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }

}
