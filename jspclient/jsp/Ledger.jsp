<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="testsocket.ClienteMsj"%>
<%

ClienteMsj cli = new ClienteMsj(); //Se crea el cliente
String str = cli.startClient();
out.println(str);

%>	
